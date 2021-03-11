package TD3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BAL c = new BAL();
		Producteur p1 = new Producteur(c,"test");
		Consommateur c1 = new Consommateur(c, "");
		
		p1.start();
		c1.start();
		

	}

}
