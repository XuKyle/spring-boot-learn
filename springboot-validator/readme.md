### 1.普通验证

JSR-303 注解

注解 |	说明
--- | ---
@NotNull |	限制必须不为null
@NotEmpty |	验证注解的元素值不为 null 且不为空（字符串长度不为0、集合大小不为0）
@NotBlank |	验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格
@Pattern(value) |	限制必须符合指定的正则表达式
@Size(max,min) |	限制字符长度必须在 min 到 max 之间（也可以用在集合上）
@Email |	验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
@Max(value) |	限制必须为一个不大于指定值的数字
@Min(value) |	限制必须为一个不小于指定值的数字
@DecimalMax(value)	| 限制必须为一个不大于指定值的数字
@DecimalMin(value)	| 限制必须为一个不小于指定值的数字
@Null |	限制只能为null（很少用）
@AssertFalse |	限制必须为false （很少用）
@AssertTrue	| 限制必须为true （很少用）
@Past |	限制必须是一个过去的日期
@Future	| 限制必须是一个将来的日期
@Digits(integer,fraction)	| 限制必须为一个小数，且整数部分的位数不能超过 integer，小数部分的位数不能超过 fraction （很少用）

@Validated | 开启数据有效性校验，添加在类上即为验证方法，添加在方法参数中即为验证参数对象。（添加在方法上无效）

### ConstraintValidator 接口并且编写自己的数据验证注解

#### 2.自定义注解
注解上标注了 @Constraint 注解，它的作用就是指定一个具体的校验器类

- message： 验证失败提示的消息内容
- groups： 为约束指定验证组（非常不错的一个功能，下一章介绍）
- payload： 不太清楚（欢迎留言交流）


DateTimeValidator 实现 ConstraintValidator 接口，实现接口后需要实现它里面的 initialize： 与 isValid： 方法。
- initialize： 主要用于初始化，它可以获得当前注解的所有属性
- isValid： 进行约束验证的主体方法，其中 value 就是验证参数的具体实例，context 代表约束执行的上下文环境。 

### 3.分组验证 

groups 属性的作用就让 @Validated 注解只验证与自身 value 属性相匹配的字段，可多个，只要满足就会去纳入验证范围；
我们都知道针对新增的数据我们并不需要验证 ID 是否存在，
我们只在做修改操作的时候需要用到，因此这里将 ID 字段归纳到 Groups.Update.class 中去，
而其它字段是不论新增还是修改都需要用到所以归纳到 Groups.Default.class 中…

