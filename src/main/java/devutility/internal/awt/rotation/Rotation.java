package devutility.internal.awt.rotation;

/**
 * 
 * Rotation
 * 
 * @author: Aldwin Su
 * @version: 2020-03-09 00:03:15
 */
public class Rotation {
	private RotationType type;
	private double radians;
	private double anchorX;
	private double anchorY;

	public RotationType getType() {
		return type;
	}

	public void setType(RotationType type) {
		this.type = type;
	}

	public double getRadians() {
		return radians;
	}

	public void setRadians(double radians) {
		this.radians = radians;
	}

	public double getAnchorX() {
		return anchorX;
	}

	public void setAnchorX(double anchorX) {
		this.anchorX = anchorX;
	}

	public double getAnchorY() {
		return anchorY;
	}

	public void setAnchorY(double anchorY) {
		this.anchorY = anchorY;
	}
}