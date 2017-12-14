package devutility.internal.test.service.basic.awt.Font;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class FontService extends BaseTest {
	@Override
	public void run() {
		BufferedImage bufferedImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		displayFontMetrics(graphics2d, new Font(Font.SANS_SERIF, Font.BOLD, 14));
		displayFontMetrics(graphics2d, new Font(Font.SANS_SERIF, Font.BOLD, 15));
		displayFontMetrics(graphics2d, new Font(Font.SANS_SERIF, Font.BOLD, 16));
		displayFontMetrics(graphics2d, new Font(Font.SANS_SERIF, Font.BOLD, 17));
		displayFontMetrics(graphics2d, new Font(Font.SANS_SERIF, Font.BOLD, 18));
		displayFontMetrics(graphics2d, new Font(Font.SANS_SERIF, Font.BOLD, 19));
	}

	private void displayFontMetrics(Graphics2D graphics2d, Font font) {
		println("Font size: %d", font.getSize());
		FontMetrics fontMetrics = graphics2d.getFontMetrics(font);
		println(fontMetrics.charWidth('A'));
		println(fontMetrics.stringWidth("ABC"));
		println(fontMetrics.getHeight());
		println(fontMetrics.getAscent());
	}

	public static void main(String[] args) {
		TestExecutor.run(FontService.class);
	}
}