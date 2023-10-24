package panelInAWT;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class myApp extends Frame{
	myApp(){
		super("Panel in AWT");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		
		Panel panel = new Panel();
		panel.setBounds(40,80,200,200);
		panel.setBackground(Color.yellow);
		
		Button b1= new Button();
		b1.setBounds(50,100,80,30);
		b1.setBackground(Color.green);
		
		Button b2 = new Button();
		b2.setBounds(100,100,80,30);
		b2.setBackground(Color.red);
		
		panel.add(b1); //adding button to the panel
		panel.add(b2);
		
		add(panel);
		//close button code
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
}
public class panelInAWT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myApp app = new myApp();
	}

}
