package Model;

import java.util.ArrayList;
import java.util.Arrays;

/*
A Model.BillCreator osaztály az egyes
szükséges anyag listák alapján 
állítja elő az adottt szituációhoz 
megfelelő Model.BillOfMaterial-t
*/
public class BillCreator {
/*
A createRobotBill() egy Model.BillOfMaterial-t
ad vissza, olyan anyagok alapán, ami egy 
robot elkészítéséhez szükséges:
Vas, Szén, Urán
Támogatja a naplózást (Model.Logger)
*/
	public BillOfMaterial createRobotBill() {
		Logger.call("Model.BillCreator.createRobotBill", "");
		BillOfMaterial r=
				new BillOfMaterial(
						new ArrayList<Material>(
								Arrays.asList(
										new Iron(),
										new Carbon(),
										new Uranium()
								)
						)
				);
		Logger.ret("Model.Iron,Model.Carbon,Model.Uranium ("+r+")");
		return r;

	}
	
/*
A createGateBill() egy Model.BillOfMaterial-t
ad vissza, olyan anyagok alapán, ami egy 
kapu elkészítéséhez szükséges:
2 Vas, Jég, Urán
Támogatja a naplózást (Model.Logger)
*/
	public BillOfMaterial createGateBill() {
		Logger.call("Model.BillCreator.createGategBill", "");
		BillOfMaterial r=
				new BillOfMaterial(
						new ArrayList<Material>(
								Arrays.asList(
										new Iron(),
										new Iron(),
										new Ice(),
										new Uranium()
								)
						)
				);
		Logger.ret("Model.Iron,Model.Carbon,Model.Uranium ("+r+")");
		return r;
	}
	
/*
A createRobotBill() egy Model.BillOfMaterial-t
ad vissza, olyan anyagok alapán, ami egy 
játék megnyeréséhez szükséges:
minden anyagfajtából egy:
Vas, Jég, Szén, Urán
Támogatja a naplózást (Model.Logger)
*/
	public BillOfMaterial createGameWinningBill() {
		Logger.call("Model.BillCreator.createGameWinningBill", "");
		BillOfMaterial r=
				new BillOfMaterial(
						new ArrayList<Material>(
								Arrays.asList(
										new Iron(),
										new Ice(),
										new Carbon(),
										new Uranium()
								)
						)
				);
		Logger.ret("Model.Iron,Model.Carbon,Model.Uranium ("+r+")");
		return r;
	}
}
