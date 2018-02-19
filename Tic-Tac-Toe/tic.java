import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;


public class tic extends JPanel{
	static JFrame J,D;
	static pen[][] p=new pen[3][3];
	public static int f=0;
	static check c=new check();

	tic (){
		
		J= new JFrame("Tic-Tac-Toe");
		J.setSize(500,500);			
			
		J.setLayout(new GridLayout(3,3));
		J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		J.setVisible(true);	
		game();			
	}
	
	public static void game(){
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				p[i][j]=new pen();
			}
		}
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				J.add(p[i][j]);
			}
		}
	}
	
	public static void infoBox(String infoMessage, String titleBar)
    	{
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				p[i][j].reset();
			}
		}
	}
	public static void set(){
		f=1;
	}
	
	public static void main(String args[]){
		new tic();
		
		new Thread (
            	new Runnable() {


                public void run() {
					int f=0;
					int[] w=new int[8] ;
					game:
					while(true){
						
						for(int i=0;i<8;i++)
							w[i]=0;
						
						
						for(int i=0;i<3;i++){
							w[0]=w[0]+p[0][i].getTurn();
							w[1]=w[1]+p[1][i].getTurn();
							w[2]=w[2]+p[2][i].getTurn();
						}
						
						for(int i=0;i<3;i++){
							w[3]=w[3]+p[i][0].getTurn();
							w[4]=w[4]+p[i][1].getTurn();
							w[5]=w[5]+p[i][2].getTurn();
						}
						
						w[6]=p[0][0].getTurn()+p[1][1].getTurn()+p[2][2].getTurn();
						w[7]=p[0][2].getTurn()+p[1][1].getTurn()+p[2][0].getTurn();
						
						for(int i=0;i<8;i++)
						if(w[i]==0||w[i]==3){
							if(w[i]==0)
								infoBox("O WINS","GAME OVER");
							else
								infoBox("X WINS","GAME OVER");
							break ;
						}
						
						
						draw: for(int i=0;i<3;i++){
							for(int j=0;j<3;j++){
								if(p[i][j].getTurn()==100){
								f=0;
								break draw;
								}
								else {
									f=1;
								}
							}
						}
						
						if (f==1){
							infoBox("DRAW","GAME OVER");
							}							
						try{
						while(c.get()!=1){	
							Thread.sleep(100);							
							}
						System.out.println("hi");	
						}catch(Exception e){}												
					}
                }
            }
        ).start();
		
	}
}