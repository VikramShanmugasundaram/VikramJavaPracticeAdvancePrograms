package simpleRegistrationForm;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class myApp extends Frame{
	
	Label lblTitle, lblName, lblFatherN, lblAge, lblGender, lblCourse, lblHobbies, lblAddress;
	TextField txtName, txtFatherN, txtAge;
	TextArea txtAddress;
	Checkbox checkMale, checkFemale, hobbies1, hobbies2, hobbies3, hobbies4;
	CheckboxGroup cbg;
	Choice course;
	Button btnSave, btnClear;
	
	myApp(){
		super("Simple Registration Form");
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		
		//setting the background color of the frame
		Color formColor = new Color(53,59,72);
		setBackground(formColor);
		//font setting
		Font titleFont = new Font("arial", Font.BOLD, 25);
		Font labelFont = new Font("arial", Font.PLAIN, 18);
		Font textFont = new Font("arial", Font.PLAIN, 15);
		//Title
		lblTitle=new Label("Registration Form");
		lblTitle.setBounds(250, 40, 300, 50);
		lblTitle.setFont(titleFont);
		lblTitle.setForeground(Color.yellow);
		add(lblTitle);
		//name label and Text filed
		lblName= new Label("Name");
		lblName.setBounds(250, 100, 150, 30);
		lblName.setFont(textFont);
		lblName.setForeground(Color.white);
		add(lblName);
		
		txtName= new TextField();
		txtName.setBounds(400, 100, 400, 30);
		txtName.setFont(textFont);
		add(txtName);
		
		//Father name label and Text filed
		lblFatherN= new Label("Father Name");
		lblFatherN.setBounds(250, 150, 150, 30);
		lblFatherN.setFont(labelFont);
		lblFatherN.setForeground(Color.white);
		add(lblFatherN);
				
		txtFatherN= new TextField();
		txtFatherN.setBounds(400, 150, 400, 30);
		txtFatherN.setFont(textFont);
		add(txtFatherN);
		
		//Age label and Text filed
		lblAge= new Label("Age");
		lblAge.setBounds(250, 200, 150, 30);
		lblAge.setFont(labelFont);
		lblAge.setForeground(Color.white);
		add(lblAge);
				
		txtAge= new TextField();
		txtAge.setBounds(400, 200, 400, 30);
		txtAge.setFont(textFont);
		add(txtAge);
		
		//Gender label and Radio button using check box group
		lblGender= new Label("Gender");
		lblGender.setBounds(250, 250, 150, 30);
		lblGender.setFont(labelFont);
		lblGender.setForeground(Color.white);
		add(lblGender);
		
		cbg = new CheckboxGroup();
		
		checkMale= new Checkbox("Male", cbg, true);
		checkMale.setBounds(400, 250, 100, 30);
		checkMale.setFont(labelFont);
		checkMale.setForeground(Color.white);
		add(checkMale);
		
		checkFemale= new Checkbox("Female", cbg, false);
		checkFemale.setBounds(500, 250, 100, 30);
		checkFemale.setFont(labelFont);
		checkFemale.setForeground(Color.white);
		add(checkFemale);
		
		//Course label and Choice drop down
		lblCourse= new Label("Course");
		lblCourse.setBounds(250, 300, 150, 30);
		lblCourse.setFont(labelFont);
		lblCourse.setForeground(Color.white);
		add(lblCourse);
		
		course = new Choice();
		course.setBounds(400, 300, 400, 50);
		course.setFont(labelFont);
		course.add("C");
		course.add("C++");
		course.add("Jave");
		course.add("C#");
		course.add("Python");
		add(course);
		
		//Hobbies label and 4 check boxes
		lblHobbies= new Label("Hobbies");
		lblHobbies.setBounds(250, 350, 150, 30);
		lblHobbies.setFont(labelFont);
		lblHobbies.setForeground(Color.white);
		add(lblHobbies);
		
		hobbies1= new Checkbox("Drawing");
		hobbies1.setBounds(400, 350, 100, 50);
		hobbies1.setFont(labelFont);
		hobbies1.setForeground(Color.white);
		add(hobbies1);
		
		hobbies2= new Checkbox("Singing");
		hobbies2.setBounds(500, 350, 100, 50);
		hobbies2.setFont(labelFont);
		hobbies2.setForeground(Color.white);
		add(hobbies2);
		
		hobbies3= new Checkbox("Music");
		hobbies3.setBounds(600, 350, 100, 50);
		hobbies3.setFont(labelFont);
		hobbies3.setForeground(Color.white);
		add(hobbies3);
		
		hobbies4= new Checkbox("Others");
		hobbies4.setBounds(700, 350, 100, 50);
		hobbies4.setFont(labelFont);
		hobbies4.setForeground(Color.white);
		add(hobbies4);
		
		//Address label and Text Area
		lblAddress= new Label("Address");
		lblAddress.setBounds(250, 400, 150, 30);
		lblAddress.setFont(labelFont);
		lblAddress.setForeground(Color.white);
		add(lblAddress);
		
		txtAddress= new TextArea(10,30);
		txtAddress.setBounds(400, 400, 400, 100);
		txtAddress.setFont(labelFont);
		add(txtAddress);
		
		//Save button and clear button
		btnSave= new Button("Save Details");
		btnSave.setBounds(400, 530, 150, 30);
		btnSave.setFont(labelFont);
		btnSave.setBackground(Color.blue);
		btnSave.setForeground(Color.white);
		add(btnSave);
		
		btnClear= new Button("Clear All");
		btnClear.setBounds(560, 530, 150, 30);
		btnClear.setFont(labelFont);
		btnClear.setBackground(Color.red);
		btnClear.setForeground(Color.white);
		add(btnClear);
		
		
		//close window code 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
}
public class simpleRegistrationForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myApp app = new myApp();
	}

}
