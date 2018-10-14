package com.kylexu.springbootwebsocket.websocket;

import com.kylexu.springbootwebsocket.utils.WebSocketUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static com.kylexu.springbootwebsocket.utils.WebSocketUtils.LIVING_SESSIONS_CACHE;

//@ServerEndpoint 中的内容就是 WebSocket 协议的地址，其实仔细看会发现与 @RequestMapping 也是异曲同工的…
//
//        HTTP 协议：http://localhost:8080/path
//        WebSocket 协议：ws://localhost:8080/path
@RestController
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {
    private static final Logger log = LoggerFactory.getLogger(ChatRoomServerEndpoint.class);

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        LIVING_SESSIONS_CACHE.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        log.info(message);
        WebSocketUtils.sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        log.info(message);
        WebSocketUtils.sendMessageAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        LIVING_SESSIONS_CACHE.remove(username);
        WebSocketUtils.sendMessageAll("用户[" + username + "] 已经离开聊天室了！");

        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }


    @GetMapping("/chat-room/{sender}/to/{receive}")
    public void onMessage(@PathVariable("sender") String sender, @PathVariable("receive") String receive, String message) {
        WebSocketUtils.sendMessage(LIVING_SESSIONS_CACHE.get(receive),
                "[" + sender + "]" + "-> [" + receive + "] : " + message
        );
    }
}
