package com.example.lms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lms.bean.User;
import com.example.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/invalidSession")
    String invalidSession() {
        return "invalidSession";
    }

    @Autowired
    UserService userService;

    @GetMapping("users")
    public String index(@RequestParam(value = "p", defaultValue = "1") Integer p, Model model) {
        Page<User> page = userService.page(new Page<>(p, 3));
        model.addAttribute("page", page);
        return "users";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Long id, @RequestParam(value = "p", defaultValue = "1") Integer p, RedirectAttributes redirectAttributes) {
        userService.removeById(id);
        redirectAttributes.addAttribute("p", p);
        return "redirect:/users";
    }
}
