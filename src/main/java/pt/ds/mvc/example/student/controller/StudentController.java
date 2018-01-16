package pt.ds.mvc.example.student.controller;

import java.util.Map;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import pt.ds.mvc.example.core.config.AppConstants;
import pt.ds.mvc.example.student.model.Student;

import static pt.ds.mvc.example.core.config.AppConstants.studentView;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        // add the country options to the model
        model.addAttribute("theCountryOptions", countryOptions);
        return studentView("student-form");
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        log.info("StudentLog: " + student);
        return studentView("student-confirmation");
    }

}
