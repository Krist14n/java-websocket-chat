package com.example.springbootchatproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@Controller
public class ChatController {

    /**
     * Login Page
     */
    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    /**
     * Chatroom Page
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam String username, HttpServletRequest request) throws UnknownHostException {
        ModelAndView modelAndView = new ModelAndView("chat");
        modelAndView.addObject("username", username);
        return modelAndView;
    }

}
