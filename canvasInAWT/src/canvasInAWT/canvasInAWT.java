package canvasInAWT;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class myCanvas extends Canvas{
	public myCanvas() {
		setBackground(Color.yellow);
		setSize(300,200);
	}
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(75,75,150,75);
	}
}
class myApp extends Frame{
	
	myApp(){
		super("Canvas in AWT");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		
		add(new myCanvas());
		
		//close button code
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
}
public class canvasInAWT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myApp app = new myApp();
	}

}
