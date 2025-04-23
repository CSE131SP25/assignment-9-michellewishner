package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

	private Snake snake;
	private Food food;
	private int score = 0; // New: score tracker

	public Game() {
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.enableDoubleBuffering();

		// Construct new Snake and Food objects
		snake = new Snake();
		food = new Food();
	}

	public void play() {
		while (snake.isInbounds()) { // Check if snake is still in bounds
			int dir = getKeypress();

			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */

			snake.changeDirection(dir); // step 1
			snake.move();               // step 2
         // how food respawns to a new location after being 
			if (snake.eat(food)) {      // step 3
				food = new Food();      // new food in random location
				score++;                // increment score
			}

			updateDrawing();            // step 4
		}

		// Game over screen
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.6, "Game Over!");
		StdDraw.text(0.5, 0.5, "Final Score: " + score); // show final score
		StdDraw.show();
	}

	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}

	/**
	 * Clears the screen, draws the snake and food, draws score, pauses, and shows the content
	 */
	private void updateDrawing() {
		// 1. Clear screen
		StdDraw.clear();

		// 2. Draw snake and food
		snake.draw();
		food.draw();

		// Draw the score in top-left corner
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.textLeft(0.02, 0.98, "Score: " + score);

		// 3. Pause and show
		StdDraw.show();
		StdDraw.pause(100);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
