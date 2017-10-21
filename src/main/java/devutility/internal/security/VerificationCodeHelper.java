package devutility.internal.security;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import devutility.internal.awt.ColorHelper;
import devutility.internal.util.RandomHelper;

public class VerificationCodeHelper {
	public static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static final Random RANDOM = new Random();

	public static BufferedImage create(int digit, int width, int height) {
		String randomString = RandomHelper.getString(CHARS, digit);
		return create(randomString, width, height);
	}

	public static BufferedImage create(String code, int width, int height) {
		
		
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		
		graphics2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		graphics2d.fillRect(0, 0, width, height);
		
		Color color = ColorHelper.getColor();
		graphics2d.setColor(color);
		
		
		Color reverseColor = ColorHelper.getReverseColor(color);
		graphics2d.setColor(reverseColor);
		
		
		graphics2d.drawString(code, 18, 20);
		setObstacle(graphics2d, RANDOM.nextInt(100), width, height);
		return bufferedImage;
	}

	public static void setObstacle(Graphics2D graphics2d, int count, int width, int height) {
		for (int i = 0; i < count; i++) {
			graphics2d.drawRect(RANDOM.nextInt(width), RANDOM.nextInt(height), 1, 1);
		}
	}
}