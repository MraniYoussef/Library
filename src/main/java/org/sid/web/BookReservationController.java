package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.BookRepository;
import org.sid.dao.BookReservationRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Book;
import org.sid.entities.BookReservation;
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
public class BookReservationController {
	@Autowired
	private BookReservationRepository bookReservationRepository ;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/booksReservation", method= RequestMethod.GET)
	public String index(Model model,
			 @RequestParam(name="page",defaultValue ="0")int page,
			  @RequestParam(name="size",defaultValue="5")int size,
			  @RequestParam(name="motCle",defaultValue="")String motCle) {
		
		Page<BookReservation> booksReservationPage = bookReservationRepository.chercher( "%"+motCle+"%",PageRequest.of(page,size));
		model.addAttribute("listBooksReservation", booksReservationPage.getContent());
		int[] pages=new int[booksReservationPage.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("motCle",motCle);
		return "booksReservation";
	}
	@RequestMapping(value="/formBookReservation")
	public String formBook(Model model) {
		model.addAttribute("bookReservation",new BookReservation());
		
		return "formBookReservation";
	}
	@RequestMapping(value="/saveBookReservation")
	public String save(Model model, @Valid BookReservation bk,
			@RequestParam(name="book",defaultValue="")Long idBook,
			@RequestParam(name="member",defaultValue="")Long idUser,
			BindingResult bindingResult) {

		Book bkObj = bookRepository.getById( idBook );		
		model.addAttribute("bookObject",bkObj);
		
		Member mbObj = (Member) userRepository.getById( idUser );		
		model.addAttribute("memberObject",mbObj);
		
		if(bindingResult.hasErrors()) 
			  return "formBookReservation";
			
			   bookReservationRepository.save(bk); 
			   return "redirect:/booksReservation";	
	}
}
