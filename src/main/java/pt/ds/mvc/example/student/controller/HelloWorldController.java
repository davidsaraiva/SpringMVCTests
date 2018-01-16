package pt.ds.mvc.example.student.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static pt.ds.mvc.example.core.config.AppConstants.studentView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm() {
        return studentView("helloworld-form");
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm() {
        return studentView("helloworld");
    }

    @RequestMapping(value = "/processFormVersionTwo", method = RequestMethod.POST)
    public String letsShoutDude(HttpServletRequest request, Model model) {

        String studentName = request.getParameter("studentName");
        studentName = "YO! " + studentName.toUpperCase();

        model.addAttribute("message", studentName);

        return studentView("helloworld");
    }

    @RequestMapping(value = "/processFormVersionThree", method = RequestMethod.POST)
    public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model) {

        model.addAttribute("message", "Hey My Friend! " + studentName.toUpperCase());

        return studentView("helloworld");
    }

}
