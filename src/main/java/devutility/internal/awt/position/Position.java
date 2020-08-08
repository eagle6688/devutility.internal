package devutility.internal.awt.position;

/**
 * 
 * Position
 * 
 * @author: Aldwin Su
 * @creation: 2019-03-18 20:05:20
 */
public class Position {
	private float x;
	private float y;

	public Position() {
	}

	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}