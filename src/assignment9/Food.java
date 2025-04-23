package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;

	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		x = Math.random(); // Random x between 0 and 1
		y = Math.random(); // Random y between 0 and 1
	}

	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}

	// Optional: add getters if needed elsewhere
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void randomizePosition() {
		x = Math.random();
		y = Math.random();
	}
}
