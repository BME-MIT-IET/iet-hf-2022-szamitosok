package Model;

import java.util.Random;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : projlab
//  @ File Name : Model.Ufo.java
//  @ Date : 2021. 03. 29.
//  @ Author : Levente Vigh
//
//


public class Ufo extends Entity implements IMine {

	public Ufo(Asteroid a) throws Exception {
		super(a);
		if(null == a)
			throw new Exception("Argument passed to Model.Ufo.ctor is null!");
	}

	public Ufo() {
		super();
	}

	@Override
	public void move() throws Exception {
		Logger.call("Model.Ufo.move()","");

		Place[] neighbours = (Place[]) position.getNeighbours().toArray();

		//veletlenszzeruen valasztunk egy uj helyet
		Random r = new Random();
		int nextIndex = r.nextInt() % neighbours.length;
		Place nextPosition = neighbours[nextIndex];

		moveTo(nextPosition); //felteszi magat az uj helyere

		Logger.ret("");
	}

	@Override
	public void solarStormEffect() {
		Logger.call("Model.Ufo.solarStormEffect()","");
		Logger.ret("");
	}

	@Override
	public void explosionEffect() {
		Logger.call("Model.Ufo.explosionEffect()","");
		Logger.ret("");
	}

	public void die() {
		Logger.call("Model.Ufo.die()","");
		Logger.ret("");
	}

	public void mine() throws Exception {
		Logger.call("Model.Ufo.mine()","");
		Material m = position.mineCore();
		if(null == m)
			this.move();
		Logger.ret("");
	}

	public void step() throws Exception {
		this.mine();
	}
	
	public String getImageFileName() {
		return "ufo.png";
	}
}
