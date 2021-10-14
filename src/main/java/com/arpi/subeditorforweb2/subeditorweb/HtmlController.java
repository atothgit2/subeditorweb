package com.arpi.subeditorforweb2.subeditorweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HtmlController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getTestPage() {
        return "test.html";
    }
}