package com.atexo.model;

import java.util.List;


import org.springframework.stereotype.Component;



/**
 * Representation d'un joueur possedant une liste de carte
 */
@Component
public class Player {
		
	private Hand hand;
	
	
	/**
	 * Constructeur d'un joueur avec une main vide
	 */
	public Player() {
		hand = new Hand();		
	}
	
	/**
	 * Ajoute une liste de cartes dans la main du joueur
	 * 
	 * @param cards
	 *              Les cartes a ajouter au joueur
	 */
	public void addCards(List<Card> cards) {			
		hand.addCards(cards);		
	}
	
	/**
	 * Retourne la main du joueur
	 * 
	 * @return Sa main
	 */
	public Hand getHand() {			
		return hand;
	}	
	
}
