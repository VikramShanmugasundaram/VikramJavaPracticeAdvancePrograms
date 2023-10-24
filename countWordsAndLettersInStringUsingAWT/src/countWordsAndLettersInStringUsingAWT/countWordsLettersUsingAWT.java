package countWordsAndLettersInStringUsingAWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class myApp extends Frame implements ActionListener{
	Label l1,l2;
	TextArea t;
	Button b;
	
	myApp(){
		super("Word Letter Counter");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		
		l1=new Label("------");
		l1.setBounds(20,30,200,20);
		
		l2=new Label("------");
		l2.setBounds(20,60,200,20);
		
		t=new TextArea(10,30);//rows and column
		t.setBounds(20,100,300,200);
		
		b=new Button("Get Details");
		b.setBounds(20,320,100,30);
		b.addActionListener(this);
		add(l1);
		add(l2);
		add(t);
		add(b);
		
		
		//close button code
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text = t.getText();
		String word[]=text.split("\\s");
		l1.setText("Words: "+word.length);
		l2.setText("Letters: "+text.length());
	}
	
}
public class countWordsLettersUsingAWT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myApp app = new myApp();

	}

}
