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

public class BottomRightWatermarkTest extends BaseTest {
	@Override
	public void run() {
		Image image = null;

		try {
			image = ImageIO.read(new File("E:\\Downloads\\2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String imageName = "BottomRightWatermarkTest.png";
		String imagePath = String.format("E:\\Downloads\\%s", imageName);

		try {
			WatermarkUtils.bottomRightMark(image, "Hello world!", new Font(null, Font.BOLD, 26), Color.white, 0.5f, imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(BottomRightWatermarkTest.class);
	}
}