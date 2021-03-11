import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener 
{
	int sonNbMobiles;
    UnMobile lesMobiles[];
    Thread threads[];
    JButton sp[];
    private final int LARG=500, HAUT=250;
    boolean running = true;
    
    public UneFenetre()
    {	
    	super("le Mobile");
    	this.setSize(800,600);
    	this.setVisible(true);
	// TODO 
    	Container leConteneur = getContentPane();
    	sonNbMobiles=8;
    	GridLayout experimentLayout = new GridLayout(sonNbMobiles,1);
    	this.setLayout(experimentLayout);
    	// ajouter sonMobile a la fenetre
    	

    	lesMobiles = new UnMobile[sonNbMobiles];
    	threads = new Thread[sonNbMobiles];
    	for (int i=0; i<sonNbMobiles; i++) {
    		lesMobiles[i] = new UnMobile(LARG, HAUT/sonNbMobiles);
    		leConteneur.add(lesMobiles[i]);
    		threads[i]=new Thread(lesMobiles[i]);
    		//sp[i] = new JButton("Start/Pause");
    		//lesMobiles[i].add(sp[i]);
    		//sp[i].addActionListener(this,threads[i]);

    	}
    	
    	
    	System.out.println("Début du programme...");
    	for(int i=0; i<sonNbMobiles;i++) {
    		
    		threads[i].start();
    		
    	}
   

    }
    /*
    public void actionPerformed(ActionEvent e, Thread thread) {
		if (running == true) {
			thread.suspend();
			running = false;	
		}
		else {
			thread.resume();
			running = true;	
		}
    } */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
