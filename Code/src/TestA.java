import batisseur.*;

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
		Board b = new Board();

		/*for(IWorker c : b.getFiveWorkerCards()) {
			System.out.println(c);
		}*/

		HumanPlayer p = new HumanPlayer("Benjamin", b);

		System.out.println(p);

		p.setCoin(50);
		p.buyAction(1);

		p.hireWorker(b.getFiveWorkerCards().get(0));
		p.hireWorker(b.getFiveWorkerCards().get(0));
		p.hireWorker(b.getFiveWorkerCards().get(0));

		/*for(IWorker c : b.getFiveWorkerCards()) {
			System.out.println(c);
		}*/
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

	}
}