package com.example.demo.web;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.Sales;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SalesService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @Autowired
    private ProductService service;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SalesService salesService;

    @RequestMapping("/")
    public String viewHomePage(Model model, String keyword) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        List<User> listUsers = userRepository.listAll();
        model.addAttribute("listUsers", listUsers);

        List<Customer> listCustomers = customerService.listAll();
        model.addAttribute("listCustomers", listCustomers);

        List<Customer> listCertainCustomers = customerService.getCertainCustomers();
        model.addAttribute("listCertainCustomers", listCertainCustomers);

        List<Sales> listSales = salesService.listAll();
        model.addAttribute("listSales", listSales);

        if(keyword != null){
            model.addAttribute("sales", salesService.findBySalesRepresentativeName(keyword));
        }else {
            model.addAttribute("sales",salesService.listAll());
        }

        List<Sales> listCertainSales = salesService.getCertainSales();
        model.addAttribute("listCertainSales", listCertainSales);

        return "index";
    }

    @RequestMapping("/newProduct")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }
    @RequestMapping("/newUser")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveSalesRepresentative(user);
        return "redirect:/";
    }
    @RequestMapping("/newCustomer")
    public String showNewCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }

    @RequestMapping("/editProduct/{id}")
    public ModelAndView showNewProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/";
    }
    @RequestMapping("/editUser/{id}")
    public ModelAndView showNewUserForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_user");

        User user = userService.get(id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {

        userService.delete(id);

        return "redirect:/";
    }
    @RequestMapping("/editCustomer/{id}")
    public ModelAndView showNewCustomerForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_customer");

        Customer customer = customerService.get(id);
        mav.addObject("customer", customer);

        return mav;
    }

    @RequestMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.delete(id);

        return "redirect:/";
    }
    @RequestMapping("/newSales")
    public String showNewSalesForm(Model model) {
        Sales sales = new Sales();
        model.addAttribute("sales", sales);
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        List<Customer> listCertainCustomers = customerService.getCertainCustomers();
        model.addAttribute("listCertainCustomers", listCertainCustomers);
        return "new_sales";
    }

    @RequestMapping(value = "/saveSales", method = RequestMethod.POST)
    public String saveSales(@ModelAttribute("sales") Sales sales) {
        salesService.save(sales);
        return "redirect:/";
    }
    @RequestMapping("/editSales/{id}")
    public ModelAndView showNewSalesForm(@PathVariable(name = "id") Long id,Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        List<Customer> listCertainCustomers = customerService.getCertainCustomers();
        model.addAttribute("listCertainCustomers", listCertainCustomers);
        ModelAndView mav = new ModelAndView("edit_sales");

        Sales sales = salesService.get(id);
        mav.addObject("sales", sales);

        return mav;
    }

    @RequestMapping("/deleteSales/{id}")
    public String deleteSales(@PathVariable(name = "id") Long id) {
        salesService.delete(id);

        return "redirect:/";
    }

}
