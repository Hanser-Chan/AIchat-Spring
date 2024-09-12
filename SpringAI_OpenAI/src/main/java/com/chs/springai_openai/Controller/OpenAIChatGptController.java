package com.chs.springai_openai.Controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class OpenAIChatGptController
{
    //创建OpenAI聊天对象
    @Resource
    private OpenAiChatModel  chatModel;


    @RequestMapping("/ai/chatgpt")
    public String chatgptDemo(@RequestParam("message") String message)
    {
        String call = chatModel.call(message);
        System.out.println(call);
        return call;
    }

    @RequestMapping(value = "/ai/stream",produces = "text/html;charset=utf-8")
    public Flux<String>  flux(@RequestParam("message")String message)
    {

        Flux<String> stream = chatModel.stream(message);
//        System.out.println(stream);
        return stream;
    }







}
