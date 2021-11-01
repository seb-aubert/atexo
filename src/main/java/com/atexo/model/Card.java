package com.atexo.model;

/**
 * Une carte ayant une couleur et une valeur
 */
public class Card {
	private Value value;
	private Color color;
	
	/**
	 * 
	 * @param color
	 *               La couleur de la carte a creer
	 * @param value
	 *               La valeur de la carte a creer
	 */
	public Card(Color color,Value value) {
		this.color = color;
		this.value = value;
	}
	
	/**
	 * Retourne la valeur
	 * 
	 * @return La valeur de la carte
	 */
	public Value getValue() {
		return value;
	}
	
	/**
	 * Retourne la couleur
	 * 
	 * @return La couleur de la carte
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Retourne les proprietes de la carte sous une chaine
	 * 
	 * @return La couleur et valeur de la carte dans une chaine au format "[Couleur]-[Valeur]"
	 */
	public String toString() {
		return this.color + "-" + this.value;
	}
	
}
