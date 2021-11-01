package com.atexo.testing;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.atexo.model.Deck;

/**
 * Test unitaire sur un paquet de carte
 */
public class DeckTest {		
	
	/**
	 * Verifie qu'il y ait bien 52 cartes dans un nouveau paquet
	 */
	@Test
	public void testCardsInit() {
		Deck deck = new Deck();
		
		assertEquals(deck.count(), 52);
	}
	
	/**
	 * Verifie le retrait effectif d'une carte du paquet
	 */
	@Test
	public void testRemoveCard() {
		Deck deck = new Deck();
		
		//On ne retire qu'une carte, il devrait donc en avoir une de moins dans le paquet
		deck.takeCards(1);
		
		assertEquals(deck.count(), 51);	
	}
	
	/**
	 * Verification qu'il n'y ait pas de doublon dans le paquet de carte
	 */
	@Test
	public void testUniqueCards() {
		Deck deck = new Deck();
		
		Set<String> mapCards = new HashSet<String>();
		for(int i = 1; i <= 52; i++) {
			mapCards.add(deck.takeCards(1).get(0).toString());
		}
		
		assertEquals(mapCards.size(), 52);	
	}

}
