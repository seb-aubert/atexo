package com.atexo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.atexo.model.Deck;
import com.atexo.model.OrderedProperty;
import com.atexo.model.Player;
import com.atexo.service.HandService;



/**
 * Ce controller permet d'afficher les cartes du joueur
 */
@Controller
public class GameController {
	
	@Autowired
	private OrderedProperty orderedProperty;
	
    @Autowired
	private HandService cardService;
	
	/**
	 * Affiche une page contenant l'ordonancement des couleurs et valeurs, la main non triee puis celle triee
	 * 
	 * @return La vue pour la page game avec les info a afficher
	 */
	@RequestMapping("/")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("game");
		
		//Initialisation d'un ordre aleatoire des couleurs et valeurs des cartes pour le trie
		orderedProperty.shuffle();
		
		//Retourne à la vue l'ordre des couleurs et valeurs à respecter pour le trie
		mv.addObject("colors", orderedProperty.getOrderedColor());
		mv.addObject("values", orderedProperty.getOrderedValue());
					
		//Creation d'un joueur
		Player player = new Player();
		
		//Creation d'un paquet de 52 cartes
		Deck deck = new Deck();
		
		//Le joueur pioche 10 cartes aleatoirement dans le paquet	
		player.addCards(deck.takeCards(10));				
		
		//Retourne à la vue la liste non triée des cartes du joueur
		mv.addObject("hand", player.getHand().toString());
					
		//Retourne à la vue la liste triée des cartes du joueur
		mv.addObject("handOrdered", cardService.sort(player.getHand()).toString());
	
		return mv;
	}
}


