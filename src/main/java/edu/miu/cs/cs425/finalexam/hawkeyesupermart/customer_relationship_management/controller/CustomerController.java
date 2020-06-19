package edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.controller;

import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.model.Customer;
import edu.miu.cs.cs425.finalexam.hawkeyesupermart.customer_relationship_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
     private CustomerService customerService;

    @GetMapping("/customer")
    public String getAllCustomersSorted(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute(customerList);
        model.addAttribute("customerListSize" , customerList.size());
        return "customersList";
    }
    @GetMapping("/addCustomer")
    public String getCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addStudent(@Valid @ModelAttribute("customer") Customer customer , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors());
            model.addAttribute("customer", customer);
            model.addAttribute("date", LocalDate.now());
            return "/addCustomer";

        }
        customerService.saveCustomer(customer);
        return "redirect:customer";
    }

    @GetMapping("/primeCustomer")
    public ModelAndView getPrimeCustomers() {
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customers = customerService.getAllPrimeCustomers();
        customers.sort(Comparator.comparing(Customer::getFullName));
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customerLength", customerService.getAllCustomers().size());
        modelAndView.setViewName("primeCustomersList");
        return modelAndView;
    }



}
