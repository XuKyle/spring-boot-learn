package com.kylexu.springbootlocallock.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.kylexu.springbootlocallock.annotation.LocalLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 本地缓存
 */
@Aspect
@Configuration
public class LockMethodInterceptor {
    private static final Cache<String, Object> CACHE =
            CacheBuilder.newBuilder()
                    .maximumSize(10000)
                    .expireAfterWrite(5, TimeUnit.SECONDS)
                    .build();

    @Around("execution(public * *(..)) && @annotation(com.kylexu.springbootlocallock.annotation.LocalLock)")
    public Object intercepter(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = getKey(localLock.key(), joinPoint.getArgs());

        System.out.println("lock cache -> " + key);

        if (!StringUtils.isEmpty(key)) {
            if (CACHE.getIfPresent(key) != null) {
                throw new RuntimeException("请勿重复提交");
            }
            CACHE.put(key, key);
        }

        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException("服务器异常");
        }

    }

    /**
     * key 的生成策略,如果想灵活可以写成接口与实现类的方式（TODO 后续讲解）
     *
     * @param keyExpress 表达式
     * @param args       参数
     * @return 生成的key
     */
    private String getKey(String keyExpress, Object[] args) {
        System.out.println(Arrays.toString(args));
        for (int i = 0; i < args.length; i++) {
            keyExpress = keyExpress.replace("arg[" + i + "]", args[i].toString());
        }
        System.out.println("keyExpress : " + keyExpress);
        return keyExpress;
    }
}
