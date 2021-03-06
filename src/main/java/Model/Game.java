package Model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Model.Game.java
//  @ Date : 2021. 03. 19.
//  @ Author :
//
//




public class Game{
	private ArrayList<Asteroid> asteroidField = new ArrayList<>();
	private ArrayList<Robot> robots = new ArrayList<>();
	private ArrayList<Astronaut> astronauts = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
	//0: nem megy,
	//1: megy,
	//2: nyert,
	//3: vesztett
	private int gamestate = 0;

	//aszteroidaovhoz aszteroida hozzadasa
	public void addAsteroid(Asteroid a) {
		asteroidField.add(a);
	}
	//robot hozzadasa
	public void addRobot(Robot r) {
		robots.add(r);
	}
	//ufo hozzadasa
	public void addUfo(Ufo u) {
		ufos.add(u);
	}
	//asztronauta hozzaadasa
	public void addAstronaut(Astronaut a) {
		astronauts.add(a);
	}
	//aszteroida levetel az aszteroidaovbol
	public void removeAsteroid(Asteroid a) {
		asteroidField.remove(asteroidField.indexOf(a));
		if(asteroidField.size() == 0) gamestate = 3;
	}
	//robotot levesz a palyarol
	public void removeRobot(Robot r) {
		robots.remove(robots.indexOf(r));
	}
	//ufo eltavolitasa
	public void removeUfo(Ufo u) {
		ufos.remove(ufos.indexOf(u));
	}
	//levesz egy asztronautat
	public void removeAstronaut(Astronaut a) {
		astronauts.remove(astronauts.indexOf(a));
		if(astronauts.size() == 0) gamestate = 3;
	}
	//aszteroidaov lekerese
	public ArrayList<Asteroid> getAsteroids() {
		return asteroidField;
	}
	//robotok lekerese
	public ArrayList<Robot> getRobots() {
		return robots;
	}
	//ufok lekerese
	public ArrayList<Ufo> getUfos() {
		return ufos;
	}
	//asztronautak lekerese
	public ArrayList<Astronaut> getAstronauts() {
		return astronauts;
	}
//	getAllEntities from AsteroidField (balint)
	public ArrayList<Entity> getEntities() {
		ArrayList<Entity> es=new ArrayList<>();
		for(Asteroid a: asteroidField)
			for(Entity e: a.getEntities())
				if(!es.contains(e))
					es.add(e);
		return es;
	}

	//elinditja a jatekot, kisorsolja a szomszerdokat
	public void start(ArrayList<String> names) throws Exception {
		Logger.call("Model.Game.start", "");
		//seged valtozok
		//aszteroidaov merete
		int asteroidfieldsize = 15;
		//asztronauta szama
		int astronautcount = names.size();
		//randomhoz
		int randomNum;
		//osszes materialbol mennyi kell a gyozelemhez
		int materialsToWin = 3;
		//mennyi material van osszesen
		int materialcount = 4;

		//aszteroidaov keszites:
		for(int i = 0; i < materialsToWin; i++) {
			//ice, iron, carbon, uranium mindenbol 3, osszesen 12
			asteroidField.add(new Asteroid(new Ice()));
			asteroidField.add(new Asteroid(new Iron()));
			asteroidField.add(new Asteroid(new Carbon()));
			asteroidField.add(new Asteroid(new Uranium()));
		}

		for(int i = 0; i < asteroidfieldsize - materialsToWin * materialcount; i++) {
			//maradek 38 random igy osszsesen 50
			//random szam 1-4 kozott
			randomNum = ThreadLocalRandom.current().nextInt(1, materialcount + 1);
			if(randomNum == 1) asteroidField.add(new Asteroid(new Ice()));
			else if(randomNum == 2) asteroidField.add(new Asteroid(new Iron()));
			else if(randomNum == 3) asteroidField.add(new Asteroid(new Carbon()));
			else if(randomNum == 4) asteroidField.add(new Asteroid(new Uranium()));
			else {System.out.println("Hiba a random szammal");}
		}

		//szomszedossagok letrohazosa
		for (Asteroid a : asteroidField) {
			//ha keves szomszedja van 3-nal kevesebb max 4 szomszed
			if(a.getNeighbours().size() < 3) {

				//2 szomszedsag hozzaadasa
				for(int y = 0; y < 2; y++) {
					//Random szam generalasa
					randomNum = ThreadLocalRandom.current().nextInt(0, asteroidField.size());
					boolean same = false;
					//megnezni van e mar ilyen szomszedja, vagy ha sajat magat kapta
					for(Place p : a.getNeighbours()) {
						if(p.equals(asteroidField.get(randomNum)) || a.equals(asteroidField.get(randomNum))) {
							same = true;
						}
					}
					//ha nincs ilyen szomszedja
					if(same == false && asteroidField.get(randomNum).getNeighbours().size() < 4){
						//szomszedsag  beallitasa
						a.addNeighbour(asteroidField.get(randomNum));
						asteroidField.get(randomNum).addNeighbour(a);
					}
				}
			}
		}

		//asztronautak keszitese
		//asztronautak lerakasa random aszteroidakra
		for (int i = 0; i < astronautcount; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(0, asteroidField.size());
			Astronaut astronaut = new Astronaut(asteroidField.get(randomNum));
			astronaut.setName(names.get(i));
			astronauts.add(astronaut);
	      }

		Logger.ret("");
	}

	//ha az aszteroid nem aktiv eltavolitjuk a listabol
	public void RemoveInactiveAsteroid() {
		for(int i = asteroidField.size()-1; i >= 0; i-- ) {
			if(!asteroidField.get(i).getIsActive()) {
				asteroidField.remove(i);
			}
		}
	}

	public void step() throws Exception {
		Logger.call("Model.Game.step", "");


		//Minden robotra meghivjuk a step()
		for(Robot r : robots) {
			r.step();
		}

		//Minden ufora meghivjuk a step()
		for(Ufo u : ufos) {
			//u.step(); //TODO
			u.move();
		}

		RemoveInactiveAsteroid();

		//ha entitasoknak egy aszteroidan megvan a raktarukba az osszes nyersanyag vege
		if(checkGameState() == false) end();
		
		int randomNum;
		randomNum = ThreadLocalRandom.current().nextInt(0, 2);
		if(randomNum == 0) {
			solarStorm();
		}
		if(randomNum == 1) {
			nearSun();
		}
		if(randomNum == 2) {
			int random = ThreadLocalRandom.current().nextInt(0, asteroidField.size());
			
			ufos.add(new Ufo(asteroidField.get(random)));
		}

		Logger.ret("");
	}

	//kiuriti az aszteroidaovet, astronautakat, robotokat
	private void end() {
		Logger.call("Model.Game.end", "");

		//TODO majd kesobb

		asteroidField.clear();
		astronauts.clear();
		robots.clear();

		Logger.ret("");
	}

	//ha megnyertek a jatekot true, ha meg nem false
	public boolean GameWon() {
		if(!checkGameState()) {
			gamestate = 2;
			return true;
		}
		return false;
	}

	//true ha megy a jatek, false ha nem,
	private boolean checkGameState() {
		Logger.call("Model.Game.checkGameState", "");
		BillOfMaterial bill = new BillCreator().createGameWinningBill();
		for (Asteroid a : asteroidField) {
			ArrayList<Material> onAsteroid = new ArrayList<>();
			onAsteroid = a.allMaterial();
			if(bill.checkInventory(onAsteroid) != null) {
				Logger.ret("");
				return false;
			}
		}
		Logger.ret("");
		return true;
	}

	public void solarStorm() {
		Logger.call("Model.Game.solarStorm", "");
		//osszes aszteroidara solarStorm()
		int random = ThreadLocalRandom.current().nextInt(0, 3);
		for(int i = 0; i < random;i++) {
			asteroidField.get(ThreadLocalRandom.current().nextInt(0, asteroidField.size())).solarStorm();
		}

		/*
		for (Model.Asteroid a : asteroidField) {
	          a.solarStorm();
	      }
	    */
		Logger.ret("");
	}

	public void NearSunTest() throws Exception {
		Logger.call("Model.Game.NearSunTest", "");
		//vizjeg 0 layer
		Asteroid ice = new Asteroid(new Ice());
		ice.setLayer(0);
		//iron 0 layer
		Asteroid iron = new Asteroid(new Iron());
		iron.setLayer(0);
		//uranium 0 layer
		Asteroid uranium = new Asteroid(new Uranium());
		uranium.setLayer(0);
		//empty 0 layer
		Asteroid empty = new Asteroid(null);
		empty.setLayer(0);
		//hozzaadas az aszteroidaovhoz
		asteroidField.add(ice);
		asteroidField.add(iron);
		asteroidField.add(uranium);
		asteroidField.add(empty);
		//astronauta rarakasa az ures asteroiodra
		Astronaut a = new Astronaut(empty);
		astronauts.add(a);
		Logger.ret("");
	}

	public void nearSun() throws Exception {
		Logger.call("Model.Game.nearSun", "");
		//osszes aszteroidara checknearsun()
		for (Asteroid a : asteroidField) {
	          a.checkNearSun();
	      }
		Logger.ret("");
	}

}
