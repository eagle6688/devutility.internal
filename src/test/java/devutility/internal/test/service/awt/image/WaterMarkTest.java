package devutility.internal.test.service.awt.image;

import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import devutility.internal.awt.ImageUtils;
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

		try (ByteArrayOutputStream outputStream = (ByteArrayOutputStream) ImageUtils.waterMark(image, "Hello world!", 45, new Color(0, 0, 0), "png")) {
			if (outputStream == null) {
				println("No OutputStream!");
				return;
			}

			String name = String.format("%s.png", UUID.randomUUID().toString());
			FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\Downloads\\" + name));
			outputStream.writeTo(fileOutputStream);
			fileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(WaterMarkTest.class);
	}
}