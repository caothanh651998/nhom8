package com.git.controller;

import java.util.List;

import javax.validation.Valid;

import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.git.model.Employee;
import com.git.service.service;

@Controller
public class index {

	@Autowired
	service service;
	
	@GetMapping("/employee")
	public String getAll(Model model) {
		
		model.addAttribute("employee", service.getAll());
		return "index";
	}
	
	@RequestMapping("/employee/add")
	public String add(Model model) {
		model.addAttribute("employee", new Employee());
		return "form";
	}
	
	@RequestMapping("/employee/save")
	public String save(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
		service.save(employee);
		redirect.addFlashAttribute("success", "thanh cong");
		return "redirect:/employee";
	}
	
	@RequestMapping("/employee/{id}/edit")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("employee", service.edit(id));
		return "form";
	}
	
	@RequestMapping("/employee/{id}/del")
	public String delete(@PathVariable int id , RedirectAttributes redirect) {
		service.del(id);
		redirect.addFlashAttribute("success", "Xoa thanh cong");
		return "redirect:/employee";
	}
	
	@RequestMapping("/employee/search")
	public String search(@RequestParam(required=false,name="name") String name, @RequestParam(required=false, name="email") String email , Model model) {
		if (StringUtils.isEmpty(name) && StringUtils.isEmpty(email)) {
			return "redirect:/employee";
		}
		model.addAttribute("employee",service.search(name, email));
		return "index";
	}
	
}
