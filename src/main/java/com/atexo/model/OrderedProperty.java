package com.atexo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Classe contenant une liste de couleurs et une liste de valeurs<br/> 
 * Les donnees de ces listes sont melangees dans le constructeur
 */
@Component
public class OrderedProperty {
	
	private List<Color> orderedColor;
	private List<Value> orderedValue;
	
	/**
	 * Permet de changer l'ordonnancement des couleurs et valeurs
	 */
	public void shuffle() {
		Collections.shuffle(orderedColor);
		Collections.shuffle(orderedValue);
	}
	
	/**
	 * Construit un ordre aleatoire de couleurs et valeurs
	 */
	public OrderedProperty() {
		orderedColor = new ArrayList<>(Arrays.asList(Color.values()));	
		orderedValue = new ArrayList<>(Arrays.asList(Value.values()));	
		shuffle();
	}

	/**
	 * Retourne l'ordonnancement des couleurs
	 * 
	 * @return Une liste de couleurs ordonnees
	 */
	public List<Color> getOrderedColor() {		
		return orderedColor;	
	}	
	
	/**
	 * Retourne l'ordonnancement des valeurs
	 * 
	 * @return Une liste de valeurs ordonnees
	 */
	public List<Value> getOrderedValue() {		
		return orderedValue;	
	}
	
	/**
	 * Permet de fixer un ordre de couleurs non aleatoires
	 * 
	 * @param orderedColor
	 *                      L'ordre des couleurs a configurer
	 */
	public void setOrderedColor(List<Color> orderedColor) {
		this.orderedColor = orderedColor;
	}

	/**
	 * Permet de fixer un ordre de valeurs non aleatoires
	 * 
	 * @param orderedValue
	 *                      L'ordre des valeurs a configurer
	 */
	public void setOrderedValue(List<Value> orderedValue) {
		this.orderedValue = orderedValue;
	}
}
