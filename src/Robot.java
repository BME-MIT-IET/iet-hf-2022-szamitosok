import java.util.Random;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : projlab
//  @ File Name : Robot.java
//  @ Date : 2021. 03. 29.
//  @ Author : Levente Vigh
//
//



public class Robot extends Entity implements IDrill {
	/**
	 * konstruktor
	 * @param a - az aszteroida amin el lesz helyezve a robot
	 * @throws Exception
	 */
	public Robot(Asteroid a) throws Exception {
		super(a);
		if(a == null)
			throw new Exception("Argument passed to Robot.ctor is null!");
	}

	public Robot() { 
		super();
	}

	/**
	 * napvihar hatasara a robot elromlik
	 */
	public void solarStormEffect() {
		die();

		Logger.ret("");
	}

	/**
	 * a robot megfurja az aszteroidat amin eppen all
	 * @throws Exception
	 */
	public void drill() throws Exception {
		Logger.call("Robot.drill()","");

		position.getDrilled();

		Logger.ret("");
	}


	/**
	 * robbanas hatasara a robot veletlenszeruen egy masik szomszedos aszteroidara esik
	 * @throws Exception
	 */
	public void explosionEffect() throws Exception {
		Logger.call("Robot.explosionEffect()","");

		move(); //milyen szerencse hogy a robot mozgaskor is veletlenszeruen egy szomszedos aszteroidara lep

		Logger.ret("");
	}


	/**
	 * a robot veletlenszeruen vegrehajt egy lepest
	 * @throws Exception
	 */
	public void step() throws Exception {
		Logger.call("Robot.step()","");

		Random r = new Random();
		int stepOption = r.nextInt() %  2;

		if(0 == stepOption)
			move();
		else
			drill();

		Logger.ret("");
	}


	/**
	 * a robot veletlenszeruen egy szomszedos aszteroidara lep
	 * @throws Exception
	 */
	public void move() throws Exception {
		Logger.call("Robot.move()","");

		Place[] neighbours = position.getNeighbours().toArray(new Place[position.getNeighbours().size()]);

		//veletlenszzeruen valasztunk egy uj helyet
		Random r = new Random();
		int nextIndex = r.nextInt() % neighbours.length;
		Place nextPosition = neighbours[nextIndex];

		moveTo(nextPosition); //felteszi magat az uj helyere

		Logger.ret("");
	}
	
	public String getImageFileName() {
		return "robot.png";
	}

}
