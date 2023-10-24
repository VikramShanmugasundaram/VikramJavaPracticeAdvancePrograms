package awtDemo;

import java.awt.*;
class MyApp extends Frame{
		Button btn;
		MyApp(){
			super("Vikram AWT");
			setSize(1000,600);
			setLayout(null);
			btn = new Button("Click Me");
			btn.setBounds(75, 75, 200, 50);
			add(btn);
			setVisible(true);
		}
	}
public class app {
//2nd approach
	//	Button btn;
//	public app() {
//		super("Vikram AWT");
//		setSize(1000,600);
//		setLayout(null);
//		btn = new Button("Click Me");
//		btn.setBounds(75, 75, 200, 50);
//		add(btn);
//		setVisible(true);
//	}
	public static void main(String[] args) {
		MyApp o = new MyApp();
//first approach of creating frame		
//		//outside frame
//		Frame f = new Frame("Vikram AWT");
//		//setting the frame size
//		f.setSize(1000,600);
//		//removing the frame layout so that we can add other objects
//		f.setLayout(null);
//		//creating new button obj
//		Button btn = new Button("Click Me");
//		//must provide the bounds for button
//		btn.setBounds(75, 75, 200, 50);
//		//adding the btn to frame
//		f.add(btn);
//		//make the frame visible
//		f.setVisible(true);

	}

}
