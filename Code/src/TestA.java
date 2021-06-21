import batisseur.*;
import util.RandomInt;
import java.util.Random;

public class TestA {
	public static void main(String[] args) {
		/*Building b1 = new Building("a",1,2,2,2,1,6);

		Worker w1 = new Worker("b",1,1,1,1,1);
		Machine m1 = new Machine("m",1,1,1,1,1,1,1,1,1);

		System.out.println(b1.checkConstruct());
		b1.addWorkerOn(w1);
		b1.addWorkerOn(m1);
		System.out.println(b1.checkConstruct());
		System.out.println(m1.checkConstruct());
		m1.addWorkerOn(w1);
		System.out.println(m1.checkConstruct());
		b1.addWorkerOn(m1);
		System.out.println(b1.checkConstruct());*/
		//Board b = new Board();
		//b.printBoard();

		//HumanPlayer p = new HumanPlayer("Benjamin", b);
		//System.out.println(p);

		/*for(IWorker c : b.getFiveWorkerCards()) {
			System.out.println(c);
		}*/

		/*HumanPlayer p = new HumanPlayer("Benjamin", b);

		//System.out.println(p);

		p.setCoin(50);
		p.buyAction(1);

		p.hireWorker(b.getFiveWorkerCards().get(0));
		p.hireWorker(b.getFiveWorkerCards().get(0));

		for(IWorker c : b.getFiveWorkerCards()) {
			System.out.println(c);
		}

		for(IBuilding c : b.getFiveBuildingCards()) {
			System.out.println(c);
		}

		p.addBuilding(b.getFiveBuildingCards().get(0));
		p.openBuilding(p.getBuildingsCards().get(0));
		for(int i : p.getStartedBuilding().get(0).checkRessources()) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(p.getWorkerCards().get(0));
		System.out.println(p.getWorkerCards().get(1));
		p.workerToBuilding(p.getWorkerCards().get(0), p.getStartedBuilding().get(0));
		//provoque une erreur si le building a déjà été terminé par l'action précédente 
		//(normal, on l'enlève de la liste des bâtiments et là on essaye de le prendre dans la liste)
		p.workerToBuilding(p.getWorkerCards().get(0), p.getStartedBuilding().get(0)); 


		for(int i : p.getStartedBuilding().get(0).checkRessources()) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println(p);


		/*for(Card card : b.five_building_cards) {
			System.out.println(card);
		}

		for(Card card : b.five_worker_cards) {
			System.out.println(card);
		}*/
		/*Worker w1 = new Worker("name",1,2,3,0,3);
		Worker w2 = new Worker("name2",1,0,1,2,2);
		Worker w3 = new Worker("name3",1,1,0,0,1);

		Building b1 = new Building("name",4,2,2,5,0,5);
		Machine b2 = new Machine("Un instrument de mesure",4,2,2,5,0,5,3,4,2);

		//System.out.println(b.getFiveBuildingCards().get(0));
		System.out.println(b2);
		p.hireWorker(w1);
		System.out.println(p);
		p.hireWorker(w2);
		System.out.println(p);
		p.addBuilding(b1);
		System.out.println(p);
		p.setAction(3);
		p.addBuilding(b2);
		p.workerToBuilding(w1,b1);
		System.out.println(p);
		p.workerToBuilding(w2,b2);
		System.out.println(p);
		//p.play();*/


		Game game = new Game("a","b","c","d",Mode.HHA,UI.TUI);
		game.saveGame();
		//RandomInt.randomInt(1,0, new Random());
	}
}