package com.ps.UsersPanel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    // redirect to list
    @RequestMapping("/")
    public String redirect(){
        return "redirect:user/list";
    }
}
