package com.atexo.testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atexo.model.Card;
import com.atexo.model.Color;
import com.atexo.model.Hand;
import com.atexo.model.OrderedProperty;
import com.atexo.model.Value;
import com.atexo.service.HandService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HandService.class, OrderedProperty.class})
public class CardServiceTest {

	@Autowired
	private OrderedProperty orderedProperty;
	
    @Autowired
	private HandService cardService;
    
	/**
	 * Test du trie d'une main de 10 cartes<br/>
	 * Avec un ordonnancement de couleurs et valeurs a respecter<br/>
	 * On verifie le resultat attendu sous forme de chaine
	 */
	@Test
	public void testSortHand() {
		//Creation d'une main
		Hand hand = new Hand();
		
		//Ajout des cartes
		hand.addCard(new Card(Color.CARREAUX,Value.AS));
		hand.addCard(new Card(Color.CARREAUX,Value.CINQ));
		hand.addCard(new Card(Color.CARREAUX,Value.ROI));
		hand.addCard(new Card(Color.COEUR,Value.SIX));
		hand.addCard(new Card(Color.COEUR,Value.DAME));
		hand.addCard(new Card(Color.COEUR,Value.DIX));
		hand.addCard(new Card(Color.PIQUE,Value.ROI));
		hand.addCard(new Card(Color.PIQUE,Value.QUATRE));
		hand.addCard(new Card(Color.TREFLE,Value.VALET));
		hand.addCard(new Card(Color.TREFLE,Value.DEUX));
		
		//Creation de l'ordre à respecter
		List<Color> orderedColor = new ArrayList<>(Arrays.asList(Color.COEUR,Color.TREFLE,Color.CARREAUX,Color.PIQUE));	
		List<Value> orderedValue = new ArrayList<>(
				Arrays.asList(Value.QUATRE, Value.DEUX, Value.ROI, Value.CINQ, Value.NEUF, Value.SIX,
						Value.DIX, Value.HUIT, Value.AS, Value.VALET, Value.TROIS, Value.DAME, Value.SEPT)
				);					
		orderedProperty.setOrderedColor(orderedColor);
		orderedProperty.setOrderedValue(orderedValue);
		
		//Methode de trie à tester
		String handSorted = cardService.sort(hand).toString();
		
		//Verification du resultat
		assertEquals(handSorted, "COEUR-SIX,COEUR-DIX,COEUR-DAME,TREFLE-DEUX,TREFLE-VALET,CARREAUX-ROI,CARREAUX-CINQ,CARREAUX-AS,PIQUE-QUATRE,PIQUE-ROI");
	}

}
