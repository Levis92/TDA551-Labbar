import java.beans.PropertyChangeEvent;

/**
 * Created by jimcollander on 15/12/16.
 */
import java.beans.PropertyChangeListener;

public class ReversiScoreView implements PropertyChangeListener {

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("PropertyChange i ReversiScoreView");
        if (evt.getSource().getClass() == ReversiModel.class) {
            ReversiModel model = (ReversiModel) evt.getSource();
            System.out.println("Black has " + model.getBlackScore() + " points.");
            System.out.println("White has " + model.getWhiteScore() + " points.");
            System.out.println("Black has " + model.getBlackScore() + " points.");
        }
    }

}
