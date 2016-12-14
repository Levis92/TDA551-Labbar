/**
 * Created by jimcollander on 14/12/16.
 */
import java.util.ArrayList;


public class PropertyChangeSupport implements IObservable {
    private ArrayList<PropertyChangeListener> list = new ArrayList<>(10);

    public void removeObserver(PropertyChangeListener observer) {
        list.remove(observer);
    }

    public void addObserver(PropertyChangeListener observer) {
        list.add(observer);
    }

    public void notifyObservers(GameModel model) {
        for (int i = 0; i < list.size(); i++) {

        }
    }

}
