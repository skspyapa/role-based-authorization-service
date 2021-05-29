package lk.sky360solutions.authorization.role.controller;

import lk.sky360solutions.authorization.role.model.Product;
import lk.sky360solutions.authorization.role.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {


	private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = productService.listAll();
		model.addAttribute("listProducts", listProducts);

		return "index";
	}

	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);

		return "new_product";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
    productService.save(product);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");

		Product product = productService.get(id);
		mav.addObject("product", product);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
    productService.delete(id);

		return "redirect:/";
	}
}
