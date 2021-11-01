package com.atexo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Un paquet de 52 cartes
 */
@Component
public class Deck {
	private List<Card> cards;	
	
	/**
	 * Construction du paquet de cartes avec toutes les couleurs et valeurs possibles
	 */
	public Deck() {
		cards = new ArrayList<Card>();
		for(Color color : Color.values()) {
			for(Value value : Value.values()) {
				cards.add(new Card(color,value));
			}
		}
	}
	
	/**
	 * Permet de savoir combien il y a encore de cartes de disponibles
	 * 
	 * @return Le nombre de cartes restantes dans le paquet
	 */
	public int count() {
		return cards.size();
	}
	
	/**
	 * Pioche un nombre donne de cartes
	 * 
	 * @param nbCard
	 *                Le nombre de cartes a piocher dans le paquet
	 *                
	 * @return La liste de cartes piochees
	 */
	public List<Card> takeCards(int nbCard) {
		List<Card> cards = new ArrayList<Card>();
		for(int i=1; i<= nbCard; i++) {
			Card card = getRandomCard();
			if(card != null) {
				cards.add(card);
			}
		}
		
		return cards;
	}
	
	/**
	 * Donne aleatoirement une carte du paquet, la carte est retiree du paquet
	 * 
	 * @return Une carte du paquet de cartes
	 */
	private Card getRandomCard() {
		Card card = null;
		
		if(!cards.isEmpty()){
			card = cards.remove((int)(Math.random() * cards.size()));
		}
		
		return card;
	}
}
