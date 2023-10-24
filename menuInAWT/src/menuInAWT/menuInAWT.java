package menuInAWT;

import java.awt.Frame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class myApp extends Frame{
	myApp(){
		super("Menu in AWT");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		
		MenuBar menuB = new MenuBar();
		Menu menu = new Menu();
		Menu subMenu = new Menu();
		MenuItem i1= new MenuItem();
		MenuItem i2= new MenuItem();
		MenuItem i3= new MenuItem();
		MenuItem i4= new MenuItem();
		MenuItem i5= new MenuItem();
		
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		
		subMenu.add(i4);
		subMenu.add(i5);
		
		menu.add(subMenu);//attaching sub menu to main menu
		menuB.add(menu);//attaching menu to menu bar
		setMenuBar(menuB);
		
		//close button code
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
}
public class menuInAWT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myApp app = new myApp();
	}

}
