package org.example.websocketexample;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) {
        message.setTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return message;
    }
}