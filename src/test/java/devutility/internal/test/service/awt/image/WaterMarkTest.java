package devutility.internal.test.service.awt.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import devutility.internal.awt.image.WatermarkUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class WaterMarkTest extends BaseTest {
	@Override
	public void run() {
		Image image = null;

		try {
			image = ImageIO.read(new File("E:\\Downloads\\1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String imageName = "WaterMarkTest.png";
		String imagePath = String.format("E:\\Downloads\\%s", imageName);

		try {
			WatermarkUtils.mark(image, "Hello world!", 0, new Font(null, Font.BOLD, 26), Color.GRAY, 0, 26, 0.5f, imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(WaterMarkTest.class);
	}
}