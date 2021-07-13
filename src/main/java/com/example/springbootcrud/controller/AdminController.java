package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.User;
import com.example.springbootcrud.service.RoleService;
import com.example.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
//public class AdminComtroller {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/admin")
//    public String getAllUsers(ModelMap model) {
//        model.addAttribute("listUsers", userService.getAllUsers());
//        model.addAttribute("allRoles", userService.getAllRoles());
//        model.addAttribute("newUser", new User());
//        return "admin";
//    }
//
//    @PostMapping("/editUser/{id}")
//    public String editUser(ModelMap model, @PathVariable Long id) {
//        model.addAttribute("user", userService.getUserById(id));
//        model.addAttribute("allRoles", userService.getAllRoles());
//        return "editUser";
//    }
//
//    @PostMapping("/editUser")
//    public String edit(@ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/createUser")
//    public String addUser(@ModelAttribute("user") User user) {
//        userService.createUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/deleteUser/{id}")
//    public String deleteUserById(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }
//}
@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("authorizedUser", userDetails);
        model.addAttribute("newUser", new User());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User newUser) {
        userService.createUser(newUser);
        return "redirect:/admin";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User editUser) {
        userService.updateUser(editUser);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUser(user);
        return "redirect:/admin";
    }
}
