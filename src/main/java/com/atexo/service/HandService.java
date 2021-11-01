package com.atexo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atexo.model.Card;
import com.atexo.model.CardComparator;
import com.atexo.model.Hand;
import com.atexo.model.OrderedProperty;

/**
 * Classe permettant de trier une main d'un joueur selon un ordre aleatoire 
 *
 */
@Service
public class HandService {
	
	@Autowired
	private OrderedProperty orderedProperty;
	
	/**
	 * Trie d'une main passee en parametre
	 * 
	 * @param hand
	 *              Main a trier
	 *              
	 * @return Une nouvelle main triee
	 */
	public Hand sort(Hand hand){
		
		Hand handSorted = new Hand();
					
		List<Card> cardSorted = new ArrayList<Card>(hand.getCards());		 
		Collections.sort(cardSorted, new CardComparator(orderedProperty.getOrderedColor(), orderedProperty.getOrderedValue()));
		
		handSorted.addCards(cardSorted);
		
		return handSorted;		
	}
	
}
