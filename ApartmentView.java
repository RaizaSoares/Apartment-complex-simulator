package soares_raiza;

import javafx.scene.control.Button;
import javafx.scene.Node;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ApartmentView extends Button  implements PropertyChangeListener {

    int month =0;
    String type ="Empty";
    int rent = 0;

    public String makedurString(String type, int duration, int rent)
    {
        String s = type + "\nDuration: " + duration + "\nRent: " + rent;
        return s;
    }
    public ApartmentView()
    {
        setText("         \n" + type + "\n         ");
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {    // GRADING: OBSERVER
        if (evt.getPropertyName().equals("newMonth"))
        {
            month = (int) evt.getNewValue();

        }
        else if (evt.getPropertyName().equals("remodel"))
        {
            apartment temp = (apartment) evt.getNewValue();
            String t = temp.getType();
            if(t.equals("1"))
            {
                type = "Basic";
            }
            else if(t.equals("0"))
            {
                type = "Empty";
            }
            else if(t.equals("2")) {
                type = "Penthouse";
            }
            rent = temp.getRent();
            month= temp.sendMonth();
        }

        else if(evt.getPropertyName().equals("incRent"))
        {
            rent = (int) evt.getNewValue();
        }

        if(!type.equals("Empty"))
            setText(makedurString(type, month, rent));
        else
        {
            setText("         \n" + type + "\n         ");
        }

    }


}
