import java.beans.PropertyChangeEvent;

/**
 * Created by jimcollander on 15/12/16.
 */
import java.beans.PropertyChangeListener;

public class ReversiScoreView implements PropertyChangeListener {

    /**
     * used to tell view that it should update
     * @param evt
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource().getClass() == ReversiModel.class) {
            ReversiModel model = (ReversiModel) evt.getSource();
            System.out.println("Black has " + model.getBlackScore() + " points.");
            System.out.println("White has " + model.getWhiteScore() + " points.");
            System.out.println("It is " + model.getTurnColor() + "'s turn.");
        }
    }

}
