public abstract class Animal extends Organism {
	float health;

	// private CreatureVector pos;
	public Animal() {
		super(0f, 10, 10f);
	}

	public Animal(float theta, float x, float y) {
		super(theta, x, y);
	}

	public float getAngle() {
		return position.getAngle();
	}

	public void adjustAngle(float theta) {
		position.adjustAngle(theta);
	}

	public void move(float amount) {
		super.setX((float) (position.getX() + amount * Math.cos(position.getAngle())));
		super.setY((float) (position.getY() + amount * Math.sin(position.getAngle())));

	}

	public CreatureVector getVelocity() {
		return position;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	/**
	 * Depletes health
	 * 
	 * @param amount
	 *            of health depletion
	 * @return boolean: True if Dead, False if Alive
	 */
	public boolean depleteHealth(float amount) {
		health -= amount;
		return health < 0;
	}
}
