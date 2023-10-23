package com.register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.register.models.Customer;
import com.register.services.CustomerService;

@Controller
public class CustomerController {
   
	@Autowired
	CustomerService customerService;
	
	@GetMapping("")
	public String GetAllCustomers(Model model) {
	    model.addAttribute("allcustlist", customerService.GetAllCustomers());
	    return "index";
		}
		
         @GetMapping("/addnew")
		public String AddCustomer(Model model) {
			Customer customer= new Customer();
			model.addAttribute("customer", customer);
			return "newcustomer";
		}
		
         @PostMapping("/save")
		 public String saveEmployee(@ModelAttribute("customer")Customer customer) {
			customerService.save(customer);
	        return "redirect:/";
	    }
         
         @GetMapping("/updateemployee/{id}")
         public String updateForm(@PathVariable(value = "id") int id, Model model) {
        	 Customer customer= customerService.updateCustomer(id);
        	 model.addAttribute("customer", customer);
        	 return "update";
         }
         
        @GetMapping("/deleteemployee/{id}") 
        public String deleteCustomerById(@PathVariable int id)
        {
        customerService.deleteCustomerById(id);
        return "redirect:/";
        }
				
}
