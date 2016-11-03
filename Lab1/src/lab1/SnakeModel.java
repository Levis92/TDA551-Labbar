package lab1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Simple snake game
 */
public class SnakeModel extends GameModel {
	public enum Directions {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, -1),
		SOUTH(0, 1),
		NONE(0, 0);

		private final int xDelta;
		private final int yDelta;

		Directions(final int xDelta, final int yDelta) {
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		public int getXDelta() {
			return this.xDelta;
		}

		public int getYDelta() {
			return this.yDelta;
		}
	}

	//number of coins on the board
	private static final int COIN_START_AMOUNT = 30;

	/*
	 * The following GameTile objects are used only
	 * to describe how to paint the specified item.
	 *
	 * This means that they should only be used in
	 * conjunction with the get/setGameboardState()
	 * methods.
	 */

	/** Graphical representation of a coin. */
	private static final GameTile COIN_TILE = new RoundTile(new Color(255, 215,
			0),
			new Color(255, 255, 0), 2.0);

	/** Graphical representation of the head */
	private static final GameTile HEAD_TILE = new RoundTile(Color.BLACK,
			Color.RED, 2.0);

	/** Graphical representation of the body */
	private static final GameTile BODY_TILE = new SnakeTile(Color.BLACK,
			Color.GREEN, 2.0);

	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE = new GameTile();

	/** A list containing the positions of all coins. */
	private final List<Position> coins = new ArrayList<Position>();
	/*
	 * The declaration and object creation above uses the new language feature
	 * 'generic types'. It can be declared in the old way like this:
	 * private java.util.List coins = new ArrayList();
	 * This will however result in a warning at compilation
	 * "Position" in this case is the type of the objects that are going
	 * to be used in the List
	 */

	/** The position of the collector. */
	private ArrayList<Position> collectorPos;

	/** The direction of the collector. */
	private Directions direction = Directions.NORTH;

	/** The number of coins found. */
	private int score;

	private Queue<Position> eatQueue = new LinkedList<Position>();

	/**
	 * Create a new model for the Snake game.
	 */
	public SnakeModel() {
		Dimension size = getGameboardSize();

		// Blank out the whole gameboard
		for (int i = 0; i < size.width; i++) {
			for (int j = 0; j < size.height; j++) {
				setGameboardState(i, j, BLANK_TILE);
			}
		}

		this.collectorPos = new ArrayList<Position>(10);

		// Insert the collector in the middle of the gameboard.
		this.collectorPos.add(new Position(size.width / 2, size.height / 2));
		setGameboardState(this.collectorPos.get(0), HEAD_TILE);

		// Insert coins into the gameboard.
		for (int i = 0; i < COIN_START_AMOUNT; i++) {
			addCoin();
		}
	}

	/**
	 * Insert another coin into the gameboard.
	 */
	private void addCoin() {
		Position newCoinPos;
		Dimension size = getGameboardSize();
		// Loop until a blank position is found and ...
		do {
			newCoinPos = new Position((int) (Math.random() * size.width),
										(int) (Math.random() * size.height));
		} while (!isPositionEmpty(newCoinPos));

		// ... add a new coin to the empty tile.
		setGameboardState(newCoinPos, COIN_TILE);
		this.coins.add(newCoinPos);
	}

	/**
	 * Return whether the specified position is empty.
	 * 
	 * @param pos
	 *            The position to test.
	 * @return true if position is empty.
	 */
	private boolean isPositionEmpty(final Position pos) {
		return (getGameboardState(pos) == BLANK_TILE);
	}

	/**
	 * Update the direction of the collector
	 * according to the user's keypress.
	 */
	private void updateDirection(final int key) {
		switch (key) {
			case KeyEvent.VK_LEFT:
				if (this.direction != Directions.EAST) {
					this.direction = Directions.WEST;
				}
				break;
			case KeyEvent.VK_UP:
				if (this.direction != Directions.SOUTH) {
					this.direction = Directions.NORTH;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (this.direction != Directions.WEST) {
					this.direction = Directions.EAST;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (this.direction != Directions.NORTH) {
					this.direction = Directions.SOUTH;
				}
				break;
			default:
				// Don't change direction if another key is pressed
				break;
		}
	}

	//Move all parts of the snake one step forward
	private void updateCollectorPos() {
		for (int i = collectorPos.size() - 1; i > 0; i--) {
			collectorPos.set(i, collectorPos.get(i-1));
		}
		collectorPos.set(0, getNextHeadPos());
	}
	/**
	 * Get next position of the head of the snake.
	 */
	private Position getNextHeadPos() {
		return new Position(
				this.collectorPos.get(0).getX() + this.direction.getXDelta(),
				this.collectorPos.get(0).getY() + this.direction.getYDelta());
	}

	//Increase the length of the snake by 1
	private void incSnakeLength() {
		collectorPos.add(eatQueue.poll());
	}

	/**
	 * This method is called repeatedly so that the
	 * game can update its state.
	 * 
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	@Override
	public void gameUpdate(final int lastKey) throws GameOverException {
		updateDirection(lastKey);

		// Erase the previous position.
		if (eatQueue.peek() != null) {
			if (this.collectorPos.get(collectorPos.size() - 1).equals(eatQueue.peek())) {
				setGameboardState(this.collectorPos.get(collectorPos.size() - 1), BLANK_TILE);
			} else {
				incSnakeLength();
			}
		}
		else {
			setGameboardState(this.collectorPos.get(collectorPos.size() - 1), BLANK_TILE);
		}

		// Change collector position.
		updateCollectorPos();

		//Check if snake hits wall
		if (isOutOfBounds(this.collectorPos.get(0))) {
			throw new GameOverException(this.score);
		}

		//Check if snake collides with itself
		for (int i = 1; i < collectorPos.size(); i++) {
			if (collectorPos.get(0).equals(collectorPos.get(i))) {
				throw new GameOverException(this.score);
			}
		}
		// Draw collector at new position.
		setGameboardState(this.collectorPos.get(0), HEAD_TILE);

		// Change previous head tile to body tile
		if (collectorPos.size() > 1) {
			setGameboardState(this.collectorPos.get(1), BODY_TILE);
		}

		// Remove the coin at the new collector position (if any)
		if (this.coins.remove(this.collectorPos.get(0))) {
			this.score++;
			eatQueue.add(collectorPos.get(0));
		}

		// Check if all coins are found
		if (this.coins.isEmpty()) {
			throw new GameOverException(this.score + 5);
		}

	}

	/**
	 * 
	 * @param pos The position to test.
	 * @return <code>false</code> if the position is outside the playing field, <code>true</code> otherwise.
	 */
	private boolean isOutOfBounds(Position pos) {
		return pos.getX() < 0 || pos.getX() >= getGameboardSize().width
				|| pos.getY() < 0 || pos.getY() >= getGameboardSize().height;
	}

}
