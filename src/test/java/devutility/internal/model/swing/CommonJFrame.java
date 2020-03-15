package devutility.internal.model.swing;

import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CommonJFrame {
	private JFrame frame = new JFrame();
	private JPanel panel;
	private String title = "Common JFrame";
	private int width = 500;
	private int height = 500;

	public CommonJFrame(JPanel panel) {
		this.panel = panel;
		this.init();
	}

	private void init() {
		frame.setContentPane(this.panel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
	}

	public void show() {
		frame.setTitle(title);
		Insets insets = frame.getInsets();
		frame.setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}