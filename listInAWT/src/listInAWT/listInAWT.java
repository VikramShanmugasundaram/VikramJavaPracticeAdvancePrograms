package listInAWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;


class myApp extends Frame implements ActionListener{
	@SuppressWarnings("rawtypes")
	List list;
	Button btn;
	Label l1;
	
	myApp(){
		super("List in AWT");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		//getting the below error as List cannot be instantiated
		list=new List(1,true); //1 is for scrolling 1 by 1 and true is for multiple selection
		list.setBounds(10,50,100,100);
		list.add("Mercury");
		list.add("Venus");
		list.add("Earth");
		list.add("mars");
		list.add("Jupiter");
		list.add("Saturn");
		list.add("Uranus");
		list.add("Neptune");
		list.add("Pluto");
		
		btn=new Button("Show Details");
		btn.setBounds(10,170,100,30);
		btn.addActionListener(this);
		
		l1=new Label("Empty Label");
		l1.setBounds(200,170,300,30);
		
		add(list);
		add(btn);
		add(l1);
		
		//close button code
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String list[]= list.getSelectedItems();
		
		String data = "Selected Planets are: ";
		for(String l:list) {
			data+=l+" , ";
		}
		l1.setText(data);
		
	}
	
}
public class listInAWT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myApp app = new myApp();
	}

}
