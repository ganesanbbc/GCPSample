package com.cts.ms.wo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class UIController extends WebMvcConfigurerAdapter {


    public static final String INDEX_PAGE = "index";
    public static final String ROOT = "/";

    @GetMapping(ROOT)
    public String loadIndexPage() {
        return INDEX_PAGE;
    }

}
