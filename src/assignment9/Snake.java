package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;

	public Snake() {
		// Set up the segments instance variable
		segments = new LinkedList<>();
		// Start snake in center
		segments.add(new BodySegment(0.5, 0.5));
		deltaX = 0;
		deltaY = 0;
	}

	public void changeDirection(int direction) {
		if (direction == 1) { // up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { // down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { // left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { // right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}

	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		// Get current head position
		BodySegment head = segments.getFirst();
		double newX = head.getX() + deltaX;
		double newY = head.getY() + deltaY;

		// Add new head
		segments.addFirst(new BodySegment(newX, newY));

		// Remove tail (unless growing, which happens in eat())
		segments.removeLast();
	}

	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment s : segments) {
			s.draw();
		}
	}

	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param food the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eat(Food food) {
		// checks if head is close enough to the food
		BodySegment head = segments.getFirst();
		double dist = Math.hypot(head.getX() - food.getX(), head.getY() - food.getY());
		if (dist < SEGMENT_SIZE) {
			// Grow: add a new head at the same spot (we already moved forward)
			segments.addFirst(new BodySegment(head.getX(), head.getY()));
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
		return head.getX() >= 0 && head.getX() <= 1 &&
			   head.getY() >= 0 && head.getY() <= 1;
	}
}
