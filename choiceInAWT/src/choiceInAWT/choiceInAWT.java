package choiceInAWT;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class myApp extends Frame implements ActionListener{
	Choice c;
	Label l1;
	Button btn;
	
	myApp(){
		super("Choice in AWT");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		
		c= new Choice();
		c.setBounds(10,50,100,100);
		c.add("C");
		c.add("C++");
		c.add("Java");
		c.add("Python");
		c.add("pHp");
		
		l1= new Label("Empty Choice");
		l1.setBounds(10,70,300,20);
		
		btn= new Button("Show Details");
		btn.setBounds(120,50,100,20);
		btn.addActionListener(this);
		
		
		add(c);
		add(btn);
		add(l1);
		
		//close window button
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String data = "programming language Selected is : "+c.getItem(c.getSelectedIndex());//getting the text in the index
		l1.setText(data);
	}


}
public class choiceInAWT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myApp app = new myApp();
	}

}
