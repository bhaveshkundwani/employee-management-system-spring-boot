package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.dto.ConfirmationForm;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	
	/*
     * Home page
     */
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("confirmationForm", new ConfirmationForm());

        return "index";
    }
    
    /*
     * Create employee
     */
    @PostMapping("/create")
    public String createEmployee(@ModelAttribute Employee employee) {

        employeeService.createEmployee(employee);

        return "redirect:/";
    }

    /*
     * Update employee
     */
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {

        employeeService.updateEmployee(employee);

        return "redirect:/";
    }
    
    /*
     * Delete single employee
     */
    @PostMapping("/remove")
    public String removeEmployee(@RequestParam("id") String employeeId) {

        employeeService.deleteEmployee(employeeId);

        return "redirect:/";
    }

    /*
     * Delete all employees
     */
    @PostMapping("/remove/all")
    public String removeAllEmployees(@ModelAttribute ConfirmationForm confirmationForm) {

        if ("Yes".equalsIgnoreCase(confirmationForm.getConfirmation())) {
            employeeService.deleteAllEmployees();
        }

        return "redirect:/";
    }
}
