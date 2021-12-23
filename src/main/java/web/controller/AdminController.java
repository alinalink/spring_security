package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("roles", roleService.allRoles());
        model.addAttribute("user", new User());
        return "user-create";
    }

    @PostMapping
    public String newUserForm(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles") String [] nameRoles) {
        user.setRoles(roleService.getSetOfRoles(nameRoles));
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/update")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("roles",roleService.allRoles());
        model.addAttribute("user", userService.getById(id));
        return "user-update";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles") String [] nameRoles,
                             @PathVariable(value = "id") long id) {
        user.setRoles(roleService.getSetOfRoles(nameRoles));
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping(value = "user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user";
    }
}
