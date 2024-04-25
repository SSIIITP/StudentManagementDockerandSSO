package com.studentmanagement.StudentManagementDockerandSSO.Controller;

import com.studentmanagement.StudentManagementDockerandSSO.Model.Student;
import com.studentmanagement.StudentManagementDockerandSSO.Service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StuController{
    @Autowired
    private StuService stuService;

    @GetMapping("/")
    public String index(Model m) {
        List<Student> stu = stuService.getAllEmp();
        m.addAttribute("stu", stu);
        return "index";
    }

    @GetMapping("/addstu")
    public String addemp() {

        return "add_stu";
    }

    @PostMapping("/register")
    public String addEmp(@ModelAttribute Student stu, HttpSession session) {
        System.out.println(stu);
       stuService.addemp(stu);
        session.setAttribute("msg", "Student added successfully");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Student stu = stuService.getEmpById(id);
        m.addAttribute("stu", stu);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Student stu, HttpSession session) {
        stuService.addemp(stu);
        session.setAttribute("msg", "Student updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpSession session) {
        stuService.deleteEmpById(id);
        session.setAttribute("msg", "Student deleted successfully");
        return "redirect:/";
    }
}