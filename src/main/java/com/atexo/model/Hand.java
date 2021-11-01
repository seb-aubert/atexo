package com.atexo.model;

import java.util.ArrayList;
import java.util.List;


/**
 * La liste de cartes du joueur 
 */
public class Hand {
	private List<Card> cards;
	
	/**
	 * 	Retourne l'ensemble des cartes du joueur
	 * 
	 * @return Sa liste de cartes
	 */
	public List<Card> getCards() {
		return cards;
	}
	
	/**
	 * Contruction d'une main vide
	 */
	public Hand(){
		cards = new ArrayList<Card>();			
	}
	
	/**
	 * Ajoute une carte a la main du joueur
	 * 
	 * @param card
	 *              Carte a ajouter au joueur
	 */
	public void addCard(Card card) {
		cards.add(card);
	}
	
	/**
	 * Ajoute plusieurs cartes a la main du joueur
	 * 
	 * @param newCards
	 *                   Liste de cartes a ajouter dans la main
	 */
	public void addCards(List<Card> newCards) {		
		cards.addAll(newCards);		
	}
		
	
	/**
	 * Permet de convertir la liste de carte en chaine
	 * 
	 * @return Une chaine representant la liste de cartes separees par une virgule
	 */
	public String toString() {
		return cards.toString().replaceAll("[ \\[\\]]", "");
	}	
	
}
