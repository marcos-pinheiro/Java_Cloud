package br.com.fiap.cloud.dogcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.cloud.dogcare.domain.Dog;
import br.com.fiap.cloud.dogcare.service.VaccineService;
import br.com.fiap.cloud.dogcare.service.exception.APIException;

@Controller
public class DogsController {
	
	@Autowired VaccineService vaccineServiceImpl;
	
	@RequestMapping(value = "/dogs", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("dogs", vaccineServiceImpl.listAll());
        System.out.println("Returning rpoducts:");
        return "dogs";
    }
	
	@RequestMapping("dog/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("dog", vaccineServiceImpl.getById(id).get());
		return "dogshow";
	}
	
	@RequestMapping("dog/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("dog", vaccineServiceImpl.getById(id));
		return "dogform";
	}
	
	@RequestMapping("dog/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		vaccineServiceImpl.delete(id);
		return "redirect:/dogs";
	}
	
	@RequestMapping("dog/new")
	public String newProduct(Model model) {
		model.addAttribute("dog", new Dog());
		return "dogform";
	}
	
	@RequestMapping(value = "dog", method = RequestMethod.POST)
	public String saveProduct(Dog product) throws APIException {
	
		vaccineServiceImpl.register(product);
	
		return "redirect:/dog/" + product.getId();
	}
}
