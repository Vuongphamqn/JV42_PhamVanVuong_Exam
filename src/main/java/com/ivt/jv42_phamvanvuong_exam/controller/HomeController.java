/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivt.jv42_phamvanvuong_exam.controller;

import com.ivt.jv42_phamvanvuong_exam.entities.NewsEntity;
import com.ivt.jv42_phamvanvuong_exam.service.CategoryService;
import com.ivt.jv42_phamvanvuong_exam.service.NewsService;
import com.ivt.jv42_phamvanvuong_exam.service.StaffService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrator
 */
@Controller
public class HomeController {
    @Autowired
    private NewsService newsService;
    
    @Autowired
    private StaffService staffService;

    @Autowired
    private CategoryService categoryService;

    //Bat Validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "message", required = false) String message) {
        model.addAttribute("newss", newsService.getnewss());
        model.addAttribute("type", type);
        model.addAttribute("message", message);
        return "home";
    }

    @RequestMapping("/add-news")
    public String addNews(Model model) {
        model.addAttribute("news", new NewsEntity());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("staffs", staffService.getStaffs());
        model.addAttribute("action", "add");

        return "news";
    }
//
    @RequestMapping("/edit/{id}")
    public String editNews(Model model,
            @PathVariable("id") int id) {

        model.addAttribute("news", newsService.findNewsById(id));
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("staffs", staffService.getStaffs());
        model.addAttribute("action", "edit");

        return "news";
    }
//
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(Model model,
            @Valid @ModelAttribute("news") NewsEntity news,
            BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("news", news);
            model.addAttribute("categories", categoryService.getCategories());
            if (news.getId() > 0) {
                model.addAttribute("action", "edit");
            } else {
                model.addAttribute("action", "add");
            }
            return "news";
        } else {
//            StaffEntity staff = new StaffEntity();
//            staff.setStaffName(news.getStaff().getStaffName());
//            staffService.save(staff);
//            news.getStaff().set
            newsService.save(news);
            return "redirect:/home";
        }
    }
//
    @RequestMapping("/delete/{id}")
    public String deleteNews(Model model,
            @PathVariable("id") int id) {
        if (newsService.deleteNews(id)) {
            return "redirect:/home?type=error&message=Delete News Id: " + id + " Fail!!!";
        } else {
            return "redirect:/home?type=success&message=Delete News Id: " + id + " success!!!";
        }
    }
//
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchNews(Model model,
//            @RequestParam("strSearch") String strSearch
            @ModelAttribute("strSearch") String strSearch
    ) {
        List<NewsEntity> newss = (List)newsService.searchNews(strSearch);
        model.addAttribute("newss", newss);
        model.addAttribute("action", "search");
        return "home";
    }
}
