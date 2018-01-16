package pt.ds.mvc.example.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static pt.ds.mvc.example.core.config.AppConstants.coreView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage() {
        return coreView("main-menu");
    }

}
