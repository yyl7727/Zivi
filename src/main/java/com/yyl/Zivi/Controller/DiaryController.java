package com.yyl.Zivi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiaryController {
    @GetMapping("/Editor")
    public String initEditor(){
        return "Editor";
    }
}
