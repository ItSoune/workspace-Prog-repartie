package TD3;

public class Consommateur extends Thread{
	private BAL bal;
	private String message;
	
	public Consommateur (BAL c, String m){
			this.bal=c;
			this.message=m;
	}
	
	public void run(){
		String m="";
		for (int i=0; i<100; i++){
			m = bal.getMail();
			if (!m.equals("Q")){
				System.out.println("Message reçu "+ ": "+ m+"\n"); 	
				
			}
			else{
				this.interrupt();
			}
			 try{sleep(1000);}
			catch(InterruptedException e){};
			
		}
	}
}
