package com.atexo.model;

import java.util.Comparator;
import java.util.List;

/**
 * Permet de comparer des cartes entre elles pour effectuer un trie
 */
public class CardComparator implements Comparator<Card>{	
	
	private final List<Color> orderedColor;
	private final List<Value> orderedValue;
		
	/**
	 * Constructeur de CarComparator
	 *  
	 * @param orderedColor
	 *                      Liste ordonnee des couleurs a prendre en compte pour le trie
	 * @param orderedValue
	 *                      Liste ordonnee des valeurs a prendre en compte pour le trie
	 */
	public CardComparator(List<Color> orderedColor, List<Value> orderedValue) {
		this.orderedColor = orderedColor;
		this.orderedValue = orderedValue;
	}
	
	/**
	 * Compare 2 cartes entre elles selon l'ordre des couleurs et valeurs a respecter<br/>
	 * On compare dans un premier temps les couleurs<br/>
	 * Puis si la couleur est identique, on compare les valeurs
	 */
	@Override
    public int compare(Card card1, Card card2) {
		int indexColorCard1 = orderedColor.indexOf(card1.getColor());
		int indexColorCard2 = orderedColor.indexOf(card2.getColor());
		
		int colorCompare =  indexColorCard1 - indexColorCard2;
		if(colorCompare == 0) {
			int indexValueCard1 = orderedValue.indexOf(card1.getValue());
			int indexValueCard2 = orderedValue.indexOf(card2.getValue());
			
			return indexValueCard1 - indexValueCard2;
		}
		else return colorCompare;	 
    }
}
