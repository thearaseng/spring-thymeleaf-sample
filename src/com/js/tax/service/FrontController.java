package com.js.tax.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    @RequestMapping("/")
    public String indexPage() {
        return "home";
    }

}
