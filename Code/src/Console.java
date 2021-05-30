public class Console {

	public static void print(String str) {
		System.out.println(str);
	}

	public static void print_nom(String[] nom) {
		for(String name : nom) 
			System.out.print("--- " + name + " ---| ");
		print("");
		print("");
	}

	public static void print_nb(int[] nb, String[] nom) {
		String espace = "";
		for(int i = 0; i < nom.length; i++) {
			int length = nom[i].length() + 8;
			for(int j = 12; j < length; j++) {
				espace+=" ";
			}
			System.out.print("Victoire : " + nb[i] + espace + "| ");
			espace = "";
		}
		print("");
		print("");
	}

	public static void print_ecus(int[] ecus, String[] nom) {
		String espace = "";
		for(int i = 0; i < nom.length; i++) {
			int length = nom[i].length() + 8;
			for(int j = 8; j < length; j++) {
				espace+=" ";
			}
			System.out.print("Écus : " + ecus[i] + espace + "| ");
			espace = "";
		}
		print("");
		print("");
	}

	public static void print_pierre(int[] pierre, String[] nom) {
		String espace = "";
		for(int i = 0; i < nom.length; i++) {
			int length = nom[i].length() + 8;
			for(int j = 11; j < length; j++) {
				espace+=" ";
			}
			System.out.print("Pierres : " + pierre[i] + espace + "| ");
			espace = "";
		}
		print("");
	}

	public static void print_bois(int[] bois, String[] nom) {
		String espace = "";
		for(int i = 0; i < nom.length; i++) {
			int length = nom[i].length() + 8;
			for(int j = 8; j < length; j++) {
				espace+=" ";
			}
			System.out.print("Bois : " + bois[i] + espace + "| ");
			espace = "";
		}
		print("");
	}

	public static void print_savoir(int[] savoir, String[] nom) {
		String espace = "";
		for(int i = 0; i < nom.length; i++) {
			int length = nom[i].length() + 8;
			for(int j = 10; j < length; j++) {
				espace+=" ";
			}
			System.out.print("Savoir : " + savoir[i] + espace + "| ");
			espace = "";
		}
		print("");
	}

	public static void print_tuile(int[] tuile, String[] nom) {
		String espace = "";
		for(int i = 0; i < nom.length; i++) {
			int length = nom[i].length() + 8;
			for(int j = 10; j < length; j++) {
				espace+=" ";
			}
			System.out.print("Tuiles : " + tuile[i] + espace + "| ");
			espace = "";
		}
		print("");
		print("");
	}

	public static void main(String[] args) {
		String[] tab = {"Maitre","Compagnon","Maitre","Manoeuvre","Apprenti"};
		String[] tabm = {"Compagnon","Manoeuvre","Apprenti"};
		String[] tabb = {"Le lavoir", "La charette", "La ferme", "L'aqueduc", "Le pont suspendu"};
		int[] tab2 = {4,2,5,4,3};
		int[] tab3 = {3,1,2,1,3};
		int[] tab4 = {3,2,1,2,3};
		int[] tab5 = {1,0,2,1,3};

		print_nom(tabb);
		print_nb(tab2,tabb);
		print_pierre(tab4,tabb);
		print_bois(tab3,tabb);
		print_savoir(tab2,tabb);
		print_tuile(tab5,tabb);

		print_nom(tab);
		print_ecus(tab2,tab);
		print_pierre(tab3,tab);
		print_bois(tab4,tab);
		print_savoir(tab5,tab);
		print_tuile(tab2,tab);

		print_nom(tabm);
		print_ecus(tab2,tabm);
		print_pierre(tab4,tabm);
		print_bois(tab3,tabm);
		print_savoir(tab2,tabm);
		print_tuile(tab5,tabm);
	}
}