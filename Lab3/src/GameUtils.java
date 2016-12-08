import java.awt.*;

/**
 * Created by jimcollander on 08/12/16.
 */
public class GameUtils {

    private GameUtils() {}

    /**
     * Set the tile on a specified position in the gameboard.
     *
     * @param pos
     *            The position in the gameboard matrix.
     * @param tile
     *            The type of tile to paint in specified position
     */
    public static void setGameboardState(final Position pos, final GameTile tile, final GameTile[][] gameboardState) {
        setGameboardState(pos.getX(), pos.getY(), tile, gameboardState);
    }

    /**
     * Set the tile on a specified position in the gameboard.
     *
     * @param x
     *            Coordinate in the gameboard matrix.
     * @param y
     *            Coordinate in the gameboard matrix.
     * @param tile
     *            The type of tile to paint in specified position
     */
    public static void setGameboardState(final int x, final int y,
                                     final GameTile tile, final GameTile[][] gameboardState) {
        gameboardState[x][y] = tile;
    }

    public static GameTile getGameboardState(final Position pos, final GameTile[][] gameboardState) {
        return getGameboardState(pos.getX(), pos.getY(), gameboardState);
    }

    public static GameTile getGameboardState(final int x, final int y, final GameTile[][] gameboardState) {
        return gameboardState[x][y];
    }

    public static Dimension getGameboardSize() {
        return Constants.getGameSize();
    }

}
