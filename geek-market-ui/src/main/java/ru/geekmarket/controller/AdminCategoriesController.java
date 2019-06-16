package ru.geekmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekmarket.persist.repo.CategoryRepository;

@Controller
public class AdminCategoriesController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public AdminCategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/admin/categories")
    public String adminCategoriesPage(Model model) {
        model.addAttribute("activePage", "Categories");
        model.addAttribute("categories", categoryRepository.getAllCategoryRepr());
        return "admin/categories";
    }

    @GetMapping("/admin/category/{id}/edit")
    public String adminEditCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Categories");
        return "admin/categories";
    }

    @GetMapping("/admin/category/{id}/delete")
    public String adminDeleteCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("activePage", "Categories");
        return "admin/categories";
    }
}
