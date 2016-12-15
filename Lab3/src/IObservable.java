/**
 * Created by jimcollander on 14/12/16.
 */
import java.beans.PropertyChangeListener;

public interface IObservable {

    void addObserver(PropertyChangeListener observer);

    void removeObserver(PropertyChangeListener observer);

}
