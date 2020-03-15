package devutility.internal.awt.image.watermarkutils;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import devutility.internal.awt.image.WatermarkUtils;
import devutility.internal.io.FileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class BottomRightTextTest extends BaseTest {
	@Override
	public void run() {
		test("E:\\Downloads\\Test\\1.jpg");
		test("E:\\Downloads\\Test\\2.jpg");
		test("E:\\Downloads\\Test\\3.png");
	}

	private void test(String sourceImagePath) {
		String extension = FileUtils.getExtension(sourceImagePath);
		String imagePath = sourceImagePath.replace(extension, String.format("_%s%s", UUID.randomUUID().toString(), extension));
		BufferedImage image = null;

		try {
			image = ImageIO.read(new File(sourceImagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			WatermarkUtils.bottomRightText(image, new Font(null, Font.BOLD, 26), Color.BLACK, 0.5f, "Hello world!", imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(BottomRightTextTest.class);
	}
}