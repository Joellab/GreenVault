package com.hongmai.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author JiaweiWang
 * @date 2021/9/4
 * @description
 */
@Controller
public class ViewController {
    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "index";
    }
}
