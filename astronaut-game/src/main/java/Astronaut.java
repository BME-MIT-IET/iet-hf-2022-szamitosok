import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : projlab
//  @ File Name : Astronaut.java
//  @ Date : 2021. 03. 29.
//  @ Author : Levente Vigh
//
//




public class Astronaut extends Entity implements IDrill, IMine {
	private String name;
	private static int numOfAstronauts = 0;
	/**
	 * az asztronauta eszkoztaraban levo teleport kapuk
	 */
	private ArrayList<Gate> gates;

	/**
	 * az asztronauta eszkoztaraban levo nyersanyagok
	 */
	private ArrayList<Material> collectedMaterials;

	/**
	 * @param a - az aszteroida amin el lesz helyezve az asztronauta
	 * @throws Exception
	 */
	public Astronaut(Asteroid a) throws Exception {
		super(a);
		if(null == a)
			throw new Exception("Argument passed to Astronaut.ctor is null!");
		gates = new ArrayList<Gate>();
		collectedMaterials = new ArrayList<Material>();
		numOfAstronauts++;
		name = "Astronaut " + numOfAstronauts;
	}

	public Astronaut() {
		super();
		gates = new ArrayList<Gate>();
		collectedMaterials = new ArrayList<Material>();
		numOfAstronauts++;
		name = "Astronaut " + numOfAstronauts;
	}

	/**
	 * aszteroidak kozott mozog/teleportal
	 * @throws Exception
	 */
	public void move() throws Exception {
		Logger.call("Astronaut.move()","");

		//lekerjuk a szomszedos helyeket
		ArrayList<Place> neighbours = new ArrayList<Place>(position.getNeighbours());

		System.out.println("\nJelenlegi pozicionak " + neighbours.size() + " szomszedos helye van.");

		//megkerjuk a usert hogy valasszon uticelt
		if(neighbours.size() > 0) {
			System.out.println("Add meg a sorszamat az uticelodnak!" + " (1 - " + neighbours.size() + ")");

			Scanner input = new Scanner(System.in);
			int destinationID = input.nextInt();

			while(destinationID < 1 || destinationID > neighbours.size()) {
				System.out.println("\nFiam annyi eszed van, mint egy furik majomnak!");
				System.out.println("\nJelenlegi pozicionak " + neighbours.size() + " szomszedos helye van.");
				System.out.println("Add meg a sorszamat az uticelodnak!" + " (1 - " + neighbours.size() + ")");

				destinationID = input.nextInt();
			}
			input.close();

			//a user altal kivalasztott helyre lep az asztronauta
			Place nextPosition = neighbours.get(destinationID - 1);


			moveTo(nextPosition);
		}
		Logger.ret("");
	}


	/**
	 * megfurja az aszteroidat amin eppen all
	 * @throws Exception
	 */
	public void drill() throws Exception {
		Logger.call("Astronaut.drill()","");

		position.getDrilled();

		Logger.ret("");
	}


	/**
	 * az asztronauta robotot keszit amit lehelyez azon az aszteroidan amin eppen all
	 * @throws Exception
	 */
	public void craftRobot() throws Exception {
		Logger.call("Astronaut.craftRobot()","");

		//letrehozunk egy recept keszitot es kerunk egy receptet a robothoz
		BillCreator bc = new BillCreator();
		BillOfMaterial b = bc.createRobotBill();

		//megkerjuk a receptet hogy nezze meg az inventorynkban megvan-e minden szukseges anyag
		Collection<Material> newInventory = b.checkInventory(collectedMaterials);

		//a recept egy olyan inventoryt ad vissza amibol mar el lettek tavolitva a szukseges anyagok
		if(newInventory != null) { //ha nincs meg minden szukseges anyag akkor null-t ad vissza
			collectedMaterials = new ArrayList<Material>(newInventory); //beallitjuk az uj inventorynkat
			Robot r = new Robot(position); //letrehozunk egy robotot
			position.addEntity(r); //lehelyezzuk a robotot az aszteroidara
		}

		Logger.ret("");
	}


	/**
	 * az asztronauta teleport kapupart keszit
	 * @throws Exception - lasd: fuggvenytorzs
	 */
	public void craftGate() throws Exception {
		Logger.call("Astronaut.craftGate()","");

		//ha nincs eleg hely az inventoryban kivetelt dobunk
		if(gates.size() > 1)
			throw new Exception("Missing place for new teleport gate(s) in inventory!");

		//letrehozunk egy recept keszitot es kerunk egy receptet a teleport kapuparhoz
		BillCreator bc = new BillCreator();
		BillOfMaterial b = bc.createGateBill();

		//megkerjuk a receptet hogy nezze meg az inventorynkban megvan-e minden szukseges anyag
		Collection<Material> newInventory = b.checkInventory(collectedMaterials);

		//a recept egy olyan inventoryt ad vissza amibol mar el lettek tavolitva a szukseges anyagok
		if(newInventory != null) { //ha nincs meg minden szukseges anyag akkor null-t ad vissza
			collectedMaterials = new ArrayList<Material>(newInventory); //beallitjuk az uj inventorynkat

			//letrehozunk ket kaput
			Gate g1 = new Gate();
			Gate g2 = new Gate();

			//osszetarsitjuk oket
			g1.setOtherEnd(g2);
			g2.setOtherEnd(g1);

			//felvesszuk az invetoryba a kapukat
			addGate(g1);
			addGate(g2);
		}

		Logger.ret("");
	}


	/**
	 * az asztronauta kibanyassza az aszteroida magjat
	 * @throws Exception - lasd: fuggvenytorzs
	 */
	public void mine() throws Exception {
		Logger.call("Astronaut.mine()","");

		//ha nincs eleg hely az inventoryban kivetelt dobunk
		if(collectedMaterials.size() == 10)
			throw new Exception("Missing place for new material in inventory!");
		//kibanyasszuk az aszteroida magjat
		Material core = position.mineCore();

		if(core != null)	//deib: balint
			addMaterial(core); //felvesszuk az inventoryba az anyagot

		Logger.ret("");
	}


	/**
	 * napvihar hatasara az asztronauta meghal
	 */
	public void solarStormEffect() {
		Logger.call("Astronaut.mine()","");

		die(); //BRUH MOMENT #1

		Logger.ret("");
	}


	/**
	 * az asztronauta lehelyez egy kaput az aszteroidara amin eppen all
	 * @throws Exception - lasd: fuggvenytorzs
	 */
	public void deployGate() throws Exception {
		Logger.call("Astronaut.deployGate()","");

		//ha nincs az inventroyban kapu akkor kivetelt dobunk
		if(gates.size() == 0)
			throw new Exception("Can not deploy portal gate: You have no portal gate(s) in your inventory");

		//egyebkent lehelyezunk egy kaput es eltavolitjuk az inventorybol
		//Gate[] portalGates = (Gate[]) gates.toArray();

		Gate g = gates.get(0);
		position.addGate(g);
		gates.remove(g);

		Logger.ret("");
	}


	/**
	 * egy lepest vegrehajt az asztronauta
	 */
	public void step() throws Exception {
		Logger.call("Astronaut.step()","");

		System.out.println("\nValassz egy muveletet es add meg a sorszamat!");
		System.out.println("1 - mozgas\t2 - furas\t3 - banyaszas");
		System.out.println("4 - nyersanyag lehelyezes\t5 - portal kapu keszites\t6 - robot epites");

		//megkerjuk a usert hogy valasszon egy muveletet
		Scanner input = new Scanner(System.in);
		int selectedID = input.nextInt();

		while(selectedID < 1 || selectedID > 6) {
			System.out.println("\nValassz egy muveletet es add meg a sorszamat!");
			System.out.println("1 - mozgas\t2 - furas\t3 - banyaszas");
			System.out.println("4 - nyersanyag lehelyezes\t5 - portal kapupar keszites\t6 - robot epites");

			selectedID = input.nextInt();
		}
		input.close();

		//a kivalasztott muveletet vegrehajtjuk
		switch(selectedID) {
			case 1:
				move();
				break;
			case 2:
				drill();
				break;
			case 3:
				mine();
				break;
			case 4:
				putMaterialInAsteroid();
				break;
			case 5:
				craftGate();
				break;
			case 6:
				craftRobot();
				break;
		}

		Logger.ret("");
	}


	/**
	 * robbanas hatasara az asztronauta meghal
	 */
	public void explosionEffect() {
		Logger.call("Astronaut.explosionEffect()","");

		die(); //BRUH MOMENT #2

		Logger.ret("");
	}

	/**
	 * az asztronauta egy nyersanagot helyez az aszteroida magjaba
	 * non-interacitve
	 * @param n anyag id-je az inventory ban
	 * @throws Exception
	 */
	public void putMaterialInAsteroid(int n) throws Exception {
		ArrayList<Material> materials = new ArrayList<Material>(collectedMaterials);
		//ha nem lehet behelyezni a nyersanyagot, mert aszteroida magja nem ures akkkor kvietelt dobunk
		if( !position.replaceCore(materials.get(n)) )
			throw new Exception("Can not replace asteroid core. Core is not empty.");
		//egyebkent az aszteroida beallitja maganak a nyersanyagot ezert csak el kell tavolitani az inventorybol
		collectedMaterials.remove(materials.get(n));
	}

	/**
	 * az asztronauta egy nyersanagot helyez az aszteroida magjaba
	 * @throws Exception
	 */
	public void putMaterialInAsteroid() throws Exception {
		Logger.call("Astronaut.putMaterialInAsteroid()","");

		ArrayList<Material> materials = new ArrayList<Material>(collectedMaterials);

		//ha ures az inventorynk kivetelt dobunk
		if(materials.size() == 0)
			throw new Exception("Astronaut has no material in its inventory.");

		System.out.println("\nJelenleg " + materials.size() + " nyersanyag van nalad.");
		if(materials.size() > 0) {
			for(int i = 0; i < materials.size(); i++)
				System.out.println("sorszam: " + i+1 + " nyersanyag: " +  materials.get(i).toString());
			System.out.println("\nAdd meg a sorszamat a nyersanyagnak, amit le szeretnel helyezni!" + " (1 - " + materials.size() + ")");

			//megkerjuk a usert hogy valsszon ki egy nyersanyagot
			Scanner input = new Scanner(System.in);
			int selectedID = input.nextInt();

			while(selectedID < 1 || selectedID > materials.size()) {
				System.out.println("\nFiam annyi eszed van, mint egy furik majomnak!");
				System.out.println("\nJelenleg " + materials.size() + " nyersanyag van nalad.");
				for(int i = 0; i < materials.size(); i++)
					System.out.println("sorszam: " + i+1 + " nyersanyag: " +  materials.get(i).toString());
				System.out.println("\nAdd meg a sorszamat a nyersanyagnak, amit le szeretnel helyezni!" + " (1 - " + materials.size() + ")");

				selectedID = input.nextInt();
			}

			//maga az anyagelhelyezes
			// attettem fuggvenybe (balint)
			putMaterialInAsteroid(selectedID - 1);

		}
		Logger.ret("");
	}

	/**
	 * @return az asztronautanal levo nyersanyagok
	 */
	public Collection<Material> getInventory() {
		Logger.call("Astronaut.getInventory()","");
		ArrayList<Material> inv = new ArrayList<Material>(collectedMaterials);
		Logger.ret("inv: " + inv.toString());
		return inv;
	}

	public Collection<Gate> getGates() {
		Logger.call("Astronaut.getGates()","");
		Collection<Gate> gts = new ArrayList<Gate>(gates);
		Logger.ret("gts: " + gts.toString());
		return gts;
	}

	public void addGate(Gate g) throws Exception {
		String s = (null == g) ? "null" : g.toString();
		Logger.call("Astronaut.addGate()","g: " + s);

		if(null == g)
			throw new Exception("Argument passed to Astronaut.addGate(...) is null!");
		//ha nincs eleg hely az inventoryban kivetelt dobunk
		if(gates.size() > 1)
			throw new Exception("Missing place for new teleport gate(s) in inventory!");

		gates.add(g);
		Logger.ret("");
	}

	public void addMaterial(Material m) throws Exception {
		String s = (null == m) ? "null" : m.toString();
		Logger.call("Astronaut.addMaterial()","m: " + s);

		//ha ures volt a mag nem taroljuk el
		if(null == m)
			throw new Exception("Argument passed to Astronaut.addMaterial(...) is null!");
		if(collectedMaterials.size() == 10)
			throw new Exception("Missing place for new material in inventory!");

		collectedMaterials.add(m);
		Logger.ret("");
	}
	
	public String getImageFileName() {
		return "astronaut.png";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String _name) {
		name = _name;
	}
}