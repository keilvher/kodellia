package com.lvher.kodellia.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultPageController {
    @GetMapping({"","/","/index"})
    public String index(){
        return "index";
    }
}
