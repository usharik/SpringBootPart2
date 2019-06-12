package ru.geekmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekmarket.persist.model.User;
import ru.geekmarket.persist.repo.RoleRepository;
import ru.geekmarket.service.model.SystemUser;
import ru.geekmarket.service.UserService;

import javax.validation.Valid;

@Controller
public class AdminController {

    private final RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public AdminController(RoleRepository roleRepository,
                           @Lazy UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String adminIndexPage(Model model) {
        model.addAttribute("activePage", "None");
        return "admin/index";
    }

    @GetMapping("/admin/users")
    public String adminUsersPage(Model model) {
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @GetMapping("/admin/user/{id}/edit")
    public String adminEditUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit");
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user_form";
    }

    @GetMapping("/admin/user/create")
    public String adminCreateUser(Model model) {
        model.addAttribute("create");
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user_form";
    }

    @PostMapping("/admin/user")
    public String adminUpsertUser(@Valid SystemUser user, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()) {
            return "admin/user_form";
        }

        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/roles")
    public String adminRolesPage(Model model) {
        model.addAttribute("activePage", "Roles");
        return "admin/index";
    }

    @GetMapping("/admin/categories")
    public String adminCategoriesPage(Model model) {
        model.addAttribute("activePage", "Categories");
        return "admin/index";
    }

    @GetMapping("/admin/products")
    public String adminProductsPage(Model model) {
        model.addAttribute("activePage", "Products");
        return "admin/index";
    }
}
