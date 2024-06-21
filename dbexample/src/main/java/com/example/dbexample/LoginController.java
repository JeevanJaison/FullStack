package com.example.dbexample;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/")
    public String index(HttpSession session) {
        session.setAttribute("myvalue", "Hello, HttpSession!");
        session.setAttribute("ss223", "HttpSession: 2024");
        return "index";
    }

    @GetMapping("/check")
    public String retrieve(HttpSession session, Model model) {
        String value = (String) session.getAttribute("myvalue");
        String newValue = (String) session.getAttribute("ss223");
        model.addAttribute("value", value);
        model.addAttribute("ss223", newValue);
        return "checkvalue";
    }
}
