
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Data;
@Data
@Controller
public class ShinkansenController {

    @GetMapping("/")
    public String showForm() {
        return "index";  // templates/index.html
    }

 
}
