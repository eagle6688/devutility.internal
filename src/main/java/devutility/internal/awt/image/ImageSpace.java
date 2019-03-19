package devutility.internal.awt.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageSpace {
	private int width;
	private int height;
	private BufferedImage image;
	private Graphics2D graphics2D;

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	public Graphics2D getGraphics2D() {
		return graphics2D;
	}

	public void setGraphics2D(Graphics2D graphics2d) {
		graphics2D = graphics2d;
	}
}