package toDoApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

class MainFrame {
	private JFrame frame;

	public MainFrame() {
		initializeFrame();
	}

	private void initializeFrame() {
		frame = new JFrame();
		Container contentPane = frame.getContentPane();
		contentPane.setBackground(new Color(34, 34, 34));

		JPanel sidePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				Color purple = new Color(74, 48, 177, 102);
				Color blue = new Color(35, 146, 180, 102);
				g2d.setPaint(new GradientPaint(0, 0, purple, getWidth(), getHeight(), blue));
				g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0); // change last values for rounded corners
			}
		};
		sidePanel.setOpaque(false);
		sidePanel.setPreferredSize(new Dimension(200, 500));
		sidePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		JLabel sideTitleLabel = new JLabel("sidePanel");
		sideTitleLabel.setForeground(Color.WHITE);
		sidePanel.add(sideTitleLabel);

		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(600, 500));
		mainPanel.setBackground(new Color(34, 34, 34));
		mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		JLabel mainTitleLabel = new JLabel("mainPanel");
		mainTitleLabel.setForeground(Color.WHITE);
		mainPanel.add(mainTitleLabel);

		frame.add(sidePanel, BorderLayout.WEST);
		frame.add(mainPanel, BorderLayout.EAST);

		frame.setTitle("ToDoApp");
		frame.pack();
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
