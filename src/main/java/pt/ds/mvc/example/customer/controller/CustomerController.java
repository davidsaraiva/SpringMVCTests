package pt.ds.mvc.example.customer.controller;

import javax.validation.Valid;

import org.slf4j.MDC;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import pt.ds.mvc.example.customer.model.Customer;
import pt.ds.mvc.example.student.model.Student;

import static pt.ds.mvc.example.core.config.AppConstants.customerView;
import static pt.ds.mvc.example.core.config.AppConstants.studentView;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initbinder ... to convert input Strings
    // remove leading and trailing whitespaces
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return customerView("customer-form");
    }

    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {
        // If has errors return to the same page
        if (bindingResult.hasErrors()) {
            return customerView("customer-form");
        }

        log.info("CustomerLog: " + customer);
        return customerView("customer-confirmation");

    }
}
