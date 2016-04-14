
public class CreatureVector {
	private float x;
	private float y;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y2) {
		this.y = y2;
	}

	private float angle;
	private final static float twoPI = (float) (Math.PI * 2);

	public CreatureVector(float angle) {
		this.angle = angle;
		fixAngle();
	}

	public void setAngle(float theta) {
		angle = theta;
		fixAngle();
	}

	/**
	 * Adjusts the creature's angle from the @param theta that the neural
	 * network toolkit returned
	 */
	public void adjustAngle(float theta) {
		angle += theta;
		fixAngle();
	}

	private void fixAngle() {
		while (angle >= twoPI) {
			angle -= twoPI;
		}
		while (angle < 0) {
			angle += twoPI;
		}
	}

	/**
	 * @return the angle represented by the two-dimensional vector.
	 */
	public float getAngle() {
		return angle;
	}
}
