package org.sid.web;

import org.sid.dao.SubscriptionRepository;
import org.sid.entities.Subscription;
import org.sid.metier.BibliothequeMetier;
import org.sid.metier.IBibliothequeMetier;
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
public class SubscriptionController {
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@RequestMapping(value="/subscriptions", method= RequestMethod.GET)
	public String index(Model model,
			 @RequestParam(name="page",defaultValue ="0")int page,
			  @RequestParam(name="size",defaultValue="5")int size,
			  @RequestParam(name="motCle",defaultValue="")String motCle) {
		
		
		  Page<Subscription> subscriptionsPage = subscriptionRepository.chercher(
		  "%"+motCle+"%",PageRequest.of(page,size));
		  model.addAttribute("listSubscriptions", subscriptionsPage.getContent());
		  int[] pages=new int[subscriptionsPage.getTotalPages()];
		  model.addAttribute("pages", pages); 
		  model.addAttribute("currentPage",page);
		  model.addAttribute("size",size); 
		  model.addAttribute("motCle",motCle);
		 
		return "subscriptions";
	}
	@RequestMapping(value="/formSubscription")
	public String formSubscription(Model model) {
		model.addAttribute("subscription",new Subscription());
		return "formSubscription";
	}
	@RequestMapping(value="/saveSubscription")
	public String save(Model model, Long idUser, int BlockageDaysPeriod,
			 Boolean isBlocked,	BindingResult bindingResult) {
	
		
		
		if(bindingResult.hasErrors()) 
			  return "formSubscription";
			
		   // subscriptionRepository.save(s); 
			   return "redirect:/subscriptions";	
	}
}
