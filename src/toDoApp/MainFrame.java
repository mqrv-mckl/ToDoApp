package toDoApp;

import java.awt.Container;

import javax.swing.JFrame;

class MainFrame {
	private JFrame frame;

	public MainFrame() {
		initializeFrame();
	}

	private void initializeFrame() {
		frame = new JFrame();
		Container contentPane = frame.getContentPane();

		// ...

		frame.pack();
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
