package devutility.internal.basic.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import devutility.internal.model.swing.CommonJFrame;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class JPanelTest extends BaseTest {
	@Override
	public void run() {
		CommonJFrame commonJFrame = new CommonJFrame(new MyJPanel());
		commonJFrame.setWidth(420);
		commonJFrame.setHeight(300);
		commonJFrame.show();
	}

	public static void main(String[] args) {
		TestExecutor.run(JPanelTest.class);
	}

	static class MyJPanel extends JPanel {
		private static final long serialVersionUID = -7978357580449013264L;

		@Override
		public void paint(Graphics g) {
			Graphics2D graphics2d = (Graphics2D) g;
			graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 40));
			graphics2d.setPaint(Color.ORANGE);
			graphics2d.drawString("Hello World!", 50, 100);
		}
	}
}