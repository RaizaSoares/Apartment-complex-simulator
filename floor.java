package soares_raiza;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class floor {
    boolean hasRemodel = false;
    apartment temp = new empty();
    private int currmonth = 0;
    private PropertyChangeSupport s= new PropertyChangeSupport(this);  // GRADING: SUBJECT
    private ApartmentView apview = new ApartmentView();

    //add observer
    public void linkApartmentView(ApartmentView apartmentView)
    {
        apview = apartmentView;
        s.addPropertyChangeListener(apview);
    }
    public void increaseRent(double amt)
    {
        if(hasRemodel) {
            int a = (int) amt;
            temp.increaseRent(a);
        }

        s.firePropertyChange("incRent", 0, temp.getRent());  // GRADING: TRIGGER

    }
    public String getAptType()
    {
        return temp.getType();
    }
    public void newMonth()
    {
        currmonth = currmonth +  1;
        temp.newMonth();
        s.firePropertyChange("newMonth", 0, temp.sendMonth());  // GRADING: TRIGGER

    }
    public int remodel(int type)
    {

        if(type == 1 && !temp.getType().equals("1")) {
            temp = new basic();
            hasRemodel = true;
        }

        else if(type == 2 && !temp.getType().equals("2")) {
            temp = new penthouse();
            hasRemodel = true;
        }

        else if(type == 0) {
            temp = new empty();
            hasRemodel = false;
        }



        s.firePropertyChange("remodel", 0, temp);  // GRADING: TRIGGER
        return temp.getRemodelcost();
    }

    public int getMaint() {
        return temp.getMaint();
    }

    public int getRent() {
        return temp.getRent();
    }

    public int getDur() {
        return temp.sendMonth();
    }
}
