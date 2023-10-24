package basicAddition;

import java.awt.Frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//class that inherits Frame class and implements the interface ActionListener
class myApp extends Frame implements ActionListener{
	//label instances
	Label l1,l2,l3;
	//TextField instances
	TextField tx1;
	TextField tx2;
	//Button instances
	Button b;
	
	public myApp() {
		super("Vikram Project");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		//setting the label
		l1=new Label("Enter the value 1: ");
		l1.setBounds(10,50,100,30);
		//creating Testfield
		tx1=new TextField();
		tx1.setBounds(150,50,250,30);
		
		l2=new Label("Enter the value 2: ");
		l2.setBounds(10,100,100,30);
		
		tx2=new TextField();
		tx2.setBounds(150,100,250,30);
		//creating button
		b = new Button("Click Me");
		b.setBounds(150,150,100,30);
		b.addActionListener(this);
		
		l3=new Label("---");
		l3.setBounds(10,200, 300, 30);
		//adding all the fields in the frame
		add(l1);
		add(tx1);
		add(l2);
		add(tx2);
		add(b);
		add(l3);
		//code for close button
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
}	
	//override the interface method
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s1=tx1.getText();
		String s2=tx2.getText();
		if(s1.isEmpty() || s2.isEmpty()) {
			l3.setText("PLease enter the data");
		}
		else {
			int a = Integer.parseInt(s1);
			int b = Integer.parseInt(s2);
			int c = a+b;
			String result = String.valueOf(c);
			l3.setText("Total: "+result);
		}
	}
	
	
}
public class basicAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myApp o = new myApp();
	}
}
