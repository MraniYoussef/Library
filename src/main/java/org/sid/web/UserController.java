package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.BookRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Book;
import org.sid.entities.Employee;
import org.sid.entities.Member;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/members", method= RequestMethod.GET)
	public String index(Model model,
			 @RequestParam(name="page",defaultValue ="0")int page,
			  @RequestParam(name="size",defaultValue="5")int size,
			  @RequestParam(name="motCle",defaultValue="")String motCle) {
		
		Page<User> usersPage = userRepository.chercher( "%"+motCle+"%",PageRequest.of(page,size));
		model.addAttribute("listMembers", usersPage.getContent());
		int[] pages=new int[usersPage.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("motCle",motCle);
		return "members";
	}
	@RequestMapping(value="/formMember")
	public String formMember(Model model) {
		model.addAttribute("member",new Member());
		return "formMember";
	}
	@RequestMapping(value="/saveMember")
	public String save(Model model, @Valid Member m,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) 
			  return "formMember";
			
				userRepository.save(m); 
			   return "redirect:/members";	
	}
	
	@RequestMapping(value="/employees", method= RequestMethod.GET)
	public String indexEmp(Model model,
			 @RequestParam(name="page",defaultValue ="0")int page,
			  @RequestParam(name="size",defaultValue="5")int size,
			  @RequestParam(name="motCle",defaultValue="")String motCle) {
		
		Page<User> usersPage = userRepository.chercher( "%"+motCle+"%",PageRequest.of(page,size));
		model.addAttribute("listEmployees", usersPage.getContent());
		int[] pages=new int[usersPage.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("motCle",motCle);
		return "employees";
	}
	@RequestMapping(value="/formEmployee")
	public String formEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		return "formEmployee";
	}
	@RequestMapping(value="/saveEmployee")
	public String saveEmpl(Model model, @Valid Employee e,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) 
			  return "formEmployee";
			
				userRepository.save(e); 
			   return "redirect:/employees";	
	}
}
