package test.mobile;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuExample extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void menu(){
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton botn = new JButton("Boton");
		//3. Create components and put them in the frame.
		//...create emptyLabel...
		frame.getContentPane().add(botn);

		//4. Size the frame.
		frame.pack();

		//5. Show it.
		frame.setVisible(true);
	}
	
	
	
}
