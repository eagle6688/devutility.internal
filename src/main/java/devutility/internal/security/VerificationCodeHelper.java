package devutility.internal.security;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import devutility.internal.awt.ColorHelper;
import devutility.internal.awt.FontHelper;
import devutility.internal.util.RandomHelper;

public class VerificationCodeHelper {
	public static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static final Random RANDOM = new Random();

	// region create

	public static BufferedImage create(int width, int height, int digit, int fontSize) {
		String randomString = RandomHelper.getString(CHARS, digit);
		return create(width, height, randomString, fontSize);
	}

	public static BufferedImage create(int width, int height, String code, int fontSize) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		graphics2d.fillRect(0, 0, width, height);

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
		graphics2d.setFont(font);

		Color color = ColorHelper.getColor();
		graphics2d.setColor(color);

		Color reverseColor = ColorHelper.getReverseColor(color);
		graphics2d.setColor(reverseColor);

		float xOffset = FontHelper.getXOffset(width, graphics2d, font, code);
		float yOffset = FontHelper.getYOffset(height, graphics2d, font);
		graphics2d.drawString(code, xOffset, yOffset);

		int obstacleCount = RANDOM.nextInt(getMaxObstacleCount(width, height));
		setObstacle(graphics2d, obstacleCount, width, height);
		return bufferedImage;
	}

	// endregion

	// region get max obstacle count

	public static int getMaxObstacleCount(int width, int height) {
		return Math.max(width, height);
	}

	// endregion

	// region set obstacle

	public static void setObstacle(Graphics2D graphics2d, int count, int width, int height) {
		for (int i = 0; i < count; i++) {
			graphics2d.drawRect(RANDOM.nextInt(width), RANDOM.nextInt(height), 1, 1);
		}
	}

	// endregion
}