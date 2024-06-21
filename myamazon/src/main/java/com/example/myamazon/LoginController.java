package com.example.myamazon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String index(HttpSession session) {
        // Set a value in the session;
        session.setAttribute("myValue", "Hello, HttpSession!");

        return "index";
    }

    @GetMapping("/retrieve")
    public String retrieve(HttpSession session, Model model) {

        // Retrieve a value from the session
        String value = (String) session.getAttribute("myValue");
        model.addAttribute("value", value);

        return "retrieve";
    }

    @GetMapping("/test")
    public String listUsers(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);
        return "user-list";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login-form";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, HttpSession session) {
        User foundUser = userRepository.findByNameAndPassword(user.getName(), user.getPassword());

        if (foundUser != null) {
            session.setAttribute("user", user.getName());
            return "redirect:/products";
        } else {
            return "redirect:/login";
        }

    }

}
