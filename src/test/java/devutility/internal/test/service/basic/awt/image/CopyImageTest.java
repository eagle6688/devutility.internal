package devutility.internal.test.service.basic.awt.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import devutility.internal.io.FileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CopyImageTest extends BaseTest {
	@Override
	public void run() {
		String sourceImagePath = "E:\\Downloads\\Test\\1.jpg";
		String extension = FileUtils.getExtension(sourceImagePath);
		String imagePath = sourceImagePath.replace(extension, String.format("_%s%s", UUID.randomUUID().toString(), extension));

		Image image = null;

		try {
			image = ImageIO.read(new File(sourceImagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		graphics.drawImage(image, 0, 0, null);
		graphics.dispose();

		try {
			ImageIO.write(bufferedImage, "png", new File(imagePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(CopyImageTest.class);
	}
}