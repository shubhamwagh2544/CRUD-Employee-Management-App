package com.emp.mgmt.controller;

import com.emp.mgmt.entities.Employee;
import com.emp.mgmt.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String home(Model m) {
        List<Employee> emp = this.empService.getAllEmp();
        m.addAttribute("emp", emp);
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmp() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee, HttpSession session) {
        System.out.println(employee);
        this.empService.addEmp(employee);
        session.setAttribute("msg", "Employee Added Successfully..");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee employee = this.empService.getEmpById(id);
        m.addAttribute("emp", employee);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee employee, HttpSession session) {
        this.empService.addEmp(employee);
        session.setAttribute("msg", "Employee data updated successfully..");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session) {
        this.empService.deleteEmpById(id);
        session.setAttribute("emp", "Employee data deleted successfully..");
        return "redirect:/";
    }

}
