/**
 * Created by jimcollander on 14/12/16.
 */
import java.beans.PropertyChangeListener;

public interface IObservable {

    /**
     * adds an observer
     * @param observer
     */
    void addObserver(PropertyChangeListener observer);

    /**
     * removes an observer
     * @param observer
     */
    void removeObserver(PropertyChangeListener observer);

}
