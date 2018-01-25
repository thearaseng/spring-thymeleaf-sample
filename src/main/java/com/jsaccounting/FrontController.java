package com.jsaccounting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    @RequestMapping("/")
    public String index() {
        return getFullViewName("index");
    }

    @RequestMapping("/about-us")
    public String aboutUs() {
        return getFullViewName("about-us");
    }

    // consider move it to abstract class
    private String getFullViewName(String viewName){
        return "front/".concat(viewName);
    }

}
