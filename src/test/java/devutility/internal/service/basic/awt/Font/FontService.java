package devutility.internal.service.basic.awt.Font;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import devutility.internal.test.BaseService;

public class FontService extends BaseService {
	@Override
	public void run() {
		BufferedImage bufferedImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
		FontMetrics fontMetrics = graphics2d.getFontMetrics(font);
		println(fontMetrics.charWidth('A'));
		println(fontMetrics.stringWidth("ABC"));
		println(fontMetrics.getHeight());
	}
}