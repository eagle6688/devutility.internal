package devutility.internal.awt;

import java.awt.Color;
import java.util.Random;

public class ColorUtils {
	private static final Random RANDOM = new Random();

	public static Color getRandomColor() {
		return new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));
	}

	public static Color getReverseColor(Color color) {
		return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
	}
}