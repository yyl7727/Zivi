package com.yyl.Zivi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {
    @GetMapping("/Login")
    public String Login(){
        return "Login";
    }
}
