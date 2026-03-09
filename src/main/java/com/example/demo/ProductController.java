package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(name = "keyword", defaultValue = "") String keyword,
                       @RequestParam(name = "page", defaultValue = "0") int page) {
        return index(model, keyword, page);
    }

    @GetMapping("/products")
    public String products(Model model,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword,
                           @RequestParam(name = "page", defaultValue = "0") int page) {
        return index(model, keyword, page);
    }

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword,
                        @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Product> pageProducts = productRepository.findByNameContainingIgnoreCase(keyword, PageRequest.of(page, 5));
        model.addAttribute("products", pageProducts.getContent());
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "products";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/formProduct")
    public String formProduct(Model model) {
        model.addAttribute("product", new Product());
        return "formProduct";
    }

    @GetMapping("/editProduct")
    public String editProduct(@RequestParam("id") Long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow();
        model.addAttribute("product", product);
        return "formProduct";
    }

    @PostMapping("/save")
    public String save(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formProduct";
        }
        productRepository.save(product);
        return "redirect:/products";
    }
}
