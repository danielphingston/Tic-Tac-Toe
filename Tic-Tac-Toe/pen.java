import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Line2D;



public class pen extends JPanel implements MouseListener{
	
	static int flag=2;	
	int turn = 100;
	@Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
	this.setBackground(Color.white);
	this.setPreferredSize(new Dimension(100,100));
	this.setBorder(BorderFactory.createLineBorder(Color.black));		
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(10));
	g.setColor(Color.BLUE);
	
       	if(turn==0){		
				g2.drawOval(26,26,100,100);	   
		}
		if(turn==1){
				g2.drawLine(26,26,126,126);
				g2.drawLine(126,26,26,126);
		}
	
   	}
	
	pen(){
		
		this.addMouseListener(this);
	
	}	
	public void mousePressed(MouseEvent e) {
		if(turn==100){
		flag=(flag+1)%2;
		turn=flag;
		repaint();
		}
	}  
	public void mouseClicked(MouseEvent e) {}	
	public void mouseEntered(MouseEvent e) {}  
   	public void mouseExited(MouseEvent e) {}   	
    public void mouseReleased(MouseEvent e) {} 
	
	public int getTurn(){
		return turn;
	}
	
	public void setTurn(int x){
		turn=x;
	}
	
	public void reset(){
		turn=100;
		flag=2;
		repaint();
	}
		
}

