package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProductController {

  @Autowired
  private ProductRepositories productRepository;

  @GetMapping("/")
  public String viewHomePage(Model model) {
    List<Product> products = productRepository.findAll();
    model.addAttribute("products", products);
    return "products";
  }

  @GetMapping("/delete/{id}")
  public String deleteProduct(@PathVariable(name ="id") long id){
    productRepository.deleteById(id);
    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public ModelAndView showEditProductPage(@PathVariable(name = "id") long id){
    ModelAndView modelAndView = new ModelAndView("edit-product");
    Product product = productRepository.findById(id).get();
    modelAndView.addObject("product", product);
    return modelAndView;
  }

  @GetMapping("/new")
  public String showNewProductPage(Model model) {
    Product product = new Product();
    model.addAttribute("product", product);
    return "new-products";
  }

  @PostMapping(value = "/save")
  public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult result) {
    if(result.hasErrors()){
      return "new-products";
    }
    productRepository.save(product);
    return "redirect:/";
  }
  
}
