import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
	static semaphore sem = new semaphore(2); 
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote=40;
    Color couleur = Color.black;
   
    UnMobile(int telleLargeur, int telleHauteur)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	setSize(telleLargeur, telleHauteur);
    }

    public void run()
    {
    	int debut_SC = (saLargeur/3);
    	int fin_SC = (saLargeur*2/3);	
    	int a = 0;
	    while(true) {
	   
			for (; sonDebDessin < debut_SC-sonCote; sonDebDessin+= sonPas){
				repaint();
				
				try{Thread.sleep(sonTemps);}
				catch (InterruptedException telleExcp)
				    {telleExcp.printStackTrace();}
			}
			
			sem.syncWait();
			couleur = Color.red;
			
			for (; sonDebDessin < fin_SC-sonCote ; sonDebDessin+= sonPas){
				
				repaint();
				
				try{Thread.sleep(sonTemps);}
				catch (InterruptedException telleExcp)
				    {telleExcp.printStackTrace();}
			}
			couleur = Color.black;
			sem.syncSignal();
			
			for (; sonDebDessin < saLargeur-sonCote ; sonDebDessin+= sonPas){
	
				repaint();
				
				try{Thread.sleep(sonTemps);}
				catch (InterruptedException telleExcp)
				    {telleExcp.printStackTrace();}
		    }
			
			for (; sonDebDessin > fin_SC; sonDebDessin-= sonPas){
				repaint();
				
				try{Thread.sleep(sonTemps);}
				catch (InterruptedException telleExcp)
				    {telleExcp.printStackTrace();}
		    }
			
			sem.syncWait();
			couleur = Color.red;

			for (; sonDebDessin > debut_SC ; sonDebDessin-= sonPas){
		
				repaint();
					
				try{Thread.sleep(sonTemps);}
				catch (InterruptedException telleExcp)
					{telleExcp.printStackTrace();}
			}
			couleur = Color.black;
			sem.syncSignal();
			
			for (; sonDebDessin > 0 ; sonDebDessin-= sonPas){
		
				repaint();
				
				try{Thread.sleep(sonTemps);}
				catch (InterruptedException telleExcp)
				    {telleExcp.printStackTrace();}
		    }
		}
    }


    public void paintComponent(Graphics telCG)
    {
	super.paintComponent(telCG);
	telCG.setColor(couleur);
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}