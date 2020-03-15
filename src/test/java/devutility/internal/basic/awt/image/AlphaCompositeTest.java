package devutility.internal.basic.awt.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class AlphaCompositeTest extends BaseTest {
	@Override
	public void run() {
		test();
	}

	private void test() {
		Font font = new Font(null, Font.ITALIC, 26);

		BufferedImage background = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		Graphics2D bgGraphics = (Graphics2D) background.getGraphics();
		bgGraphics.setColor(Color.yellow);
		bgGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		bgGraphics.fillRect(0, 0, background.getWidth(), background.getHeight());

		bgGraphics.setColor(Color.BLACK);
		bgGraphics.setFont(font);
		bgGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		bgGraphics.drawString("Yellow background!", 50, 150);
		bgGraphics.dispose();

		BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		Graphics2D imageGraphics = (Graphics2D) image.getGraphics();
		imageGraphics.setColor(Color.GREEN);
		imageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		imageGraphics.fillRoundRect(0, 0, image.getWidth(), image.getHeight(), image.getWidth(), image.getHeight());

		imageGraphics.setColor(Color.BLACK);
		imageGraphics.setFont(font);
		imageGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		imageGraphics.drawString("Green foreground!", 50, 200);
		imageGraphics.dispose();

		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(BorderFactory.createLineBorder(Color.blue));

		JLabel label = new JLabel();
		label.setText("AlphaComposite:");
		contentPanel.add(label);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("Default");
		comboBox.addItem("CLEAR");
		comboBox.addItem("SRC");
		comboBox.addItem("DST");
		comboBox.addItem("SRC_OVER");
		comboBox.addItem("DST_OVER");
		comboBox.addItem("SRC_IN");
		comboBox.addItem("DST_IN");
		comboBox.addItem("SRC_OUT");
		comboBox.addItem("DST_OUT");
		comboBox.addItem("SRC_ATOP");
		comboBox.addItem("DST_ATOP");
		comboBox.addItem("XOR");
		contentPanel.add(comboBox);

		JFrame jFrame = new JFrame();
		jFrame.setContentPane(contentPanel);
		jFrame.setBounds(200, 200, 500, 500);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);

		DrawingPanel drawPanel = new DrawingPanel();
		drawPanel.setBounds(0, 35, 500, 440);
		drawPanel.setPreferredSize(new Dimension(500, 440));
		drawPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		drawPanel.setBg(background);
		drawPanel.setImage(image);
		contentPanel.add(drawPanel);

		Map<String, AlphaComposite> compositeMap = new HashMap<>();
		compositeMap.put("CLEAR", AlphaComposite.Clear);
		compositeMap.put("SRC", AlphaComposite.Src);
		compositeMap.put("DST", AlphaComposite.Dst);
		compositeMap.put("SRC_OVER", AlphaComposite.SrcOver);
		compositeMap.put("DST_OVER", AlphaComposite.DstOver);
		compositeMap.put("SRC_IN", AlphaComposite.SrcIn);
		compositeMap.put("DST_IN", AlphaComposite.DstIn);
		compositeMap.put("SRC_OUT", AlphaComposite.SrcOut);
		compositeMap.put("DST_OUT", AlphaComposite.DstOut);
		compositeMap.put("SRC_ATOP", AlphaComposite.SrcAtop);
		compositeMap.put("DST_ATOP", AlphaComposite.DstAtop);
		compositeMap.put("XOR", AlphaComposite.Xor);

		comboBox.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selected = e.getItem().toString();
				System.out.println(selected);
				drawPanel.setAlphaComposite(compositeMap.get(selected));
				drawPanel.repaint();
			}
		});

		jFrame.addWindowStateListener(e -> {
			System.out.println("window state:" + e.paramString());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(AlphaCompositeTest.class);
	}

	static class DrawingPanel extends JPanel {
		private static final long serialVersionUID = -7613773527713556970L;
		BufferedImage background;
		BufferedImage image;
		AlphaComposite alphaComposite;

		public BufferedImage getBg() {
			return background;
		}

		public void setBg(BufferedImage background) {
			this.background = background;
		}

		public BufferedImage getImage() {
			return image;
		}

		public void setImage(BufferedImage image) {
			this.image = image;
		}

		public AlphaComposite getAlphaComposite() {
			return alphaComposite;
		}

		public void setAlphaComposite(AlphaComposite alphaComposite) {
			this.alphaComposite = alphaComposite;
		}

		@Override
		public void paint(Graphics graphics) {
			super.paint(graphics);
			Graphics2D graphics2d = (Graphics2D) graphics;
			graphics2d.setComposite(AlphaComposite.Src);
			graphics2d.drawImage(background, 100, 100, null);

			if (alphaComposite != null) {
				graphics2d.setComposite(alphaComposite);
			} else {
				graphics2d.setComposite(AlphaComposite.SrcOver);
			}

			graphics2d.drawImage(image, 100, 100, null);
			graphics2d.dispose();
		}
	}
}