package devutility.internal.test.basic.awt.geom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import devutility.internal.awt.FontUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.model.swing.CommonJFrame;

public class AffineTransformTest extends BaseTest {
	@Override
	public void run() {
		new CommonJFrame(new MyJPanel()).show();
	}

	public static void main(String[] args) {
		TestExecutor.run(AffineTransformTest.class);
	}

	static class MyJPanel extends JPanel {
		private static final long serialVersionUID = -7978357580449013264L;

		@Override
		public void paint(Graphics g) {
			Graphics2D graphics2d = (Graphics2D) g;
			graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics2d.setPaint(Color.ORANGE);

			Font font = new Font(null, Font.PLAIN, 40);
			String text = "asdfghjkl Hello World!";
			float textWidth = FontUtils.getWidth(graphics2d, font, text);
			System.out.println("Text width: " + String.valueOf(textWidth));

			normal(graphics2d, font, text);
			//rotateFont(graphics2d, font, text);
			//rotateFontCenter1(graphics2d, font, text);
			rotateFontCenter2(graphics2d, font, text);
			graphics2d.dispose();
		}

		void normal(Graphics2D graphics2d, Font font, String text) {
			LineMetrics lineMetrics = font.getLineMetrics(text, graphics2d.getFontRenderContext());
			graphics2d.setFont(font);
			graphics2d.drawString(text, 0, lineMetrics.getAscent());
		}

		void rotateFont(Graphics2D graphics2d, Font font, String text) {
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.rotate(Math.toRadians(45), 0, 0);
			Font rotatedFont = font.deriveFont(affineTransform);

			graphics2d.setFont(rotatedFont);
			graphics2d.drawString(text, 0, 0);
		}

		void rotateFontCenter1(Graphics2D graphics2d, Font font, String text) {
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.rotate(Math.toRadians(45), 0, 0);
			Font rotatedFont = font.deriveFont(affineTransform);
			graphics2d.setFont(rotatedFont);

			double textWidth = FontUtils.getWidth(graphics2d, font, text);
			double diagonalLength = Math.sqrt(Math.pow(500, 2) + Math.pow(500, 2));
			double centerSlopeLength = (diagonalLength - textWidth) / 2;
			double centerPoint = centerSlopeLength / Math.sqrt(2);
			graphics2d.drawString(text, (int) centerPoint, (int) centerPoint);
		}

		void rotateFontCenter2(Graphics2D graphics2d, Font font, String text) {
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.rotate(Math.toRadians(45), 0, 0);
			Font rotatedFont = font.deriveFont(affineTransform);
			graphics2d.setFont(rotatedFont);

			double textWidth = FontUtils.getWidth(graphics2d, rotatedFont, text);
			double centerPoint = (500 - textWidth) / 2;
			System.out.println("Rotated text width: " + String.valueOf(textWidth));
			graphics2d.drawString(text, (int) centerPoint, (int) centerPoint);
		}
	}
}