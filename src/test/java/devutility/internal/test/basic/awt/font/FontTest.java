package devutility.internal.test.basic.awt.font;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class FontTest extends BaseTest {
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
		displayFontMetrics(graphics2d, new Font(Font.SANS_SERIF, Font.BOLD, 200));
	}

	void displayFontMetrics(Graphics2D graphics2d, Font font) {
		FontMetrics fontMetrics = graphics2d.getFontMetrics(font);

		println("========================");
		println("Font size: %d", font.getSize());
		println(fontMetrics.charWidth('A'));
		println(fontMetrics.stringWidth("asdfghjkl"));
		println("getHeight: " + String.valueOf(fontMetrics.getHeight()));
		println("getDescent: " + String.valueOf(fontMetrics.getDescent()));
		println("getAscent: " + String.valueOf(fontMetrics.getAscent()));
		println("getLeading: " + String.valueOf(fontMetrics.getLeading()));
		println("------------------------");

		LineMetrics lineMetrics = font.getLineMetrics("asdfghjkl", graphics2d.getFontRenderContext());
		println("getHeight: " + String.valueOf(lineMetrics.getHeight()));
		println("getDescent: " + String.valueOf(lineMetrics.getDescent()));
		println("getAscent: " + String.valueOf(lineMetrics.getAscent()));
		println("getLeading: " + String.valueOf(lineMetrics.getLeading()));
	}

	public static void main(String[] args) {
		TestExecutor.run(FontTest.class);
	}
}