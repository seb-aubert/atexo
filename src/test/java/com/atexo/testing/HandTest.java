package com.atexo.testing;


import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.atexo.model.Card;
import com.atexo.model.Color;
import com.atexo.model.Hand;
import com.atexo.model.Value;

/**
 * Test unitaire sur la main d'un joueur
 */
public class HandTest{
	
	/**
	 * On test l'ajout de 3 cartes dans la main du joueur<br/>
	 * On verifie la correspondance si l'on convertie cette main en chaine
	 */
	@Test
	public void testAddCard() {
		//Creation d'une main
		Hand hand = new Hand();
			
		//Ajout des cartes
		hand.addCard(new Card(Color.TREFLE,Value.VALET));
		hand.addCard(new Card(Color.COEUR,Value.DIX));
		hand.addCard(new Card(Color.CARREAUX,Value.CINQ));
		
		//Verification du resultat
		assertEquals(hand.toString(), "TREFLE-VALET,COEUR-DIX,CARREAUX-CINQ");
	}

}
