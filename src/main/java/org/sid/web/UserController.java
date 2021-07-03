package org.sid.web;

import java.util.List;

import org.sid.dao.BookRepository;
import org.sid.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/books", method= RequestMethod.GET)
	public String index(Model model,
			 @RequestParam(name="page",defaultValue ="0")int page,
			  @RequestParam(name="size",defaultValue="5")int size,
			  @RequestParam(name="motCle",defaultValue="")String motCle) {
		
		Page<Book> booksPage = bookRepository.findAll(PageRequest.of(page,size));
		model.addAttribute("listBooks", booksPage.getContent());
		int[] pages=new int[booksPage.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("motCle",motCle);
		return "books";
	}

}
