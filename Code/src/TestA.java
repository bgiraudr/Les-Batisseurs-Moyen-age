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
		for(Card card : b.five_building_cards) {
			System.out.println(card);
		}

		for(Card card : b.five_worker_cards) {
			System.out.println(card);
		}
	}
}