package Model;

import java.util.Collection;
import java.util.Random;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Model.Gate.java
//  @ Date : 2021. 03. 19.
//  @ Author : Mate Simko
//
//


public class Gate extends Place {
	/**
	 * A kapu megkergultseget tarolo valtozo
	 */
	private boolean isBolond;
	/**
	 * A kapu poziciojat tarolo valtozo
	 */
	private Asteroid position;
	/**
	 * A kapu parjat tarolo valtozo
	 */
	private Gate otherEnd;

	/**
	 * Konstruktor
	 */
	public Gate() {
		isActive = false;
	}

	/**
	 * Pozicio beallitasa
	 * @param a Aszteroida
	 */
	public void setPosition(Asteroid a) {
		Logger.call("Model.Gate.setPosition ", "Asterioda = " + a);
		position = a;
		Logger.ret("");
	}

	/**
	 * A kapu parjanak beallitasa
	 * @param g Kapu
	 */
	public void setOtherEnd(Gate g) {
		Logger.call("Model.Gate.setOtherEnd", " Model.Gate = " + g);
		otherEnd = g;
		Logger.ret("");
	}

	/**
	 * Entitas belepese a kapun
	 * @param e Entitas
	 */
	public void addEntity(Entity e) {
		Logger.call("Model.Gate.AddEntity", " Model.Entity = " + e);
		if(isActive && otherEnd != null) {
			otherEnd.getPosition().addEntity(e);
		} else {
			position.addEntity(e);
		}
		Logger.ret("");
	}

	/**
	 * Robbanas fuggveny
	 * Eltavolitja onmagat es a parjat
	 */
	public void explode() {
		Logger.call("Model.Gate.explode", "");
		otherEnd.setPosition(null);
		otherEnd.getPosition().removeGate(otherEnd);
		otherEnd.setOtherEnd(null);
		position.removeGate(this);
		Logger.ret("");
	}

	/**
	 * Kapu aktivalasa
	 */
	public void enable() {
		Logger.call("Model.Gate.enable", "");
		isActive = true;
		Logger.ret("");
	}

	/**
	 * Kapu inaktivalasa
	 */
	public void disable() {
		Logger.call("Model.Gate.disable", "");
		isActive = false;
		Logger.ret("");
	}

	/**
	 * A kapu poziciojanak lekerese
	 * @return Aszteroida
	 */
	public Asteroid getPosition() {
		Logger.call("Model.Gate.getPosition", "");
		Logger.ret("position");
		return position;
	}

	/**
	 * Lepes
	 */
	public void step() {
		if(isBolond) {
			Collection<Place> neighbours = position.getNeighbours();
			Random rand = new Random();
			int choosen = rand.nextInt(neighbours.size());
			position.removeGate(this);
			Place[] places = (Place[])neighbours.toArray();
			places[choosen].addGate(this);
		}
	}

	/**
	 * Kapu felvetele
	 * @param g Kapu
	 */
	public void addGate(Gate g) {
		Logger.call("Model.Gate.addGate ", "Model.Gate = " + g);
		g.setPosition(otherEnd.position);
		otherEnd.position.addGate(g);
		Logger.ret("");
	}

	/**
	 * Kapu eltavolitasa
	 * @param g Kapu
	 */
	public void removeGate(Gate g) {
		Logger.call("Model.Gate.removeGate ", "Model.Gate = " + g);
		otherEnd.position.removeGate(g);
		Logger.ret("");
	}

	/**
	 * Megkergules allitasa
	 * @param b megkergultseg
	 */
	public void setBolond(boolean b) {
		isBolond = b;
	}

	/**
	 * Kapu par getter
	 * @return Kapu
	 */
	public Gate getOtherEnd() {
		return otherEnd;
	}
}