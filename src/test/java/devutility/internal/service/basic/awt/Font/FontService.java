package devutility.internal.service.basic.awt.Font;

import java.awt.Font;
import java.awt.FontMetrics;

import devutility.internal.test.BaseService;

public class FontService extends BaseService {
	@Override
	public void run() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
		FontMetrics fontMetrics = sun.font.FontDesignMetrics.getMetrics(font);
		println(fontMetrics.charWidth('A'));
		println(fontMetrics.stringWidth("ABC"));
		println(fontMetrics.getHeight());
	}
}