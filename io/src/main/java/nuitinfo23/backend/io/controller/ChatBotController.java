package nuitinfo23.backend.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nuitinfo23.backend.io.chatbot.Main;


@RestController
@RequestMapping("/chatbot")
public class ChatBotController {
    @Autowired
    private Main main;
    @PostMapping("path")
    public String postMethodName(@RequestBody String message) {
        main.init();
        main.dataparser.setBuffer(message);

        main.mainbot.setBuffer(main.dataparser.detect());
        return main.mainbot.getOutput(main.mainbot.keywordToState());
    }
    
    }


