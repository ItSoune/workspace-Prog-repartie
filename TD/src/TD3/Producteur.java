package TD3;

import java.util.Scanner;

public class Producteur extends Thread{
	private BAL bal;
	private String message;
	Scanner sc = new Scanner(System.in);
	public Producteur (BAL c, String m){
			bal=c;
			this.message=m;
		
	}
	public void run(){
		for(int i=0; i<20;i++){	
			message = sc.nextLine();
			bal.setmail(message);
			if (!message.equals("Q")){
				System.out.println("Ceci est le message "+ i + ": "+ message); 	
				
			}
			else{
				i--;
				this.interrupt();
			}
			
		}
		
	}
}
