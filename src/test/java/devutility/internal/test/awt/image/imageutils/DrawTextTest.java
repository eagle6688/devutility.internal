package devutility.internal.test.awt.image.imageutils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import devutility.internal.awt.RenderingHintsUtils;
import devutility.internal.awt.image.ImageUtils;
import devutility.internal.io.FileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class DrawTextTest extends BaseTest {
	@Override
	public void run() {
		test("E:\\Downloads\\Test\\1.jpg");
	}

	private void test(String file) {
		String extension = FileUtils.getExtension(file);
		String imagePath = file.replace(extension, String.format("_%s%s", UUID.randomUUID().toString(), extension));
		BufferedImage image = null;

		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ImageUtils.drawText(image, new Font(null, Font.BOLD, 26), Color.GRAY, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f), RenderingHintsUtils.highQuality(), null, 0, 26, "Hello world!", imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(DrawTextTest.class);
	}
}