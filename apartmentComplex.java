package soares_raiza;

import java.beans.PropertyChangeSupport;
import java.util.Vector;

public class apartmentComplex {
    private int currmonth = 0;
    private int funds = 100000;
    private int main = 0;
    private int rent = 0;
    private int filled=0;
    private Vector<floor> floors = new Vector<>();
    private PropertyChangeSupport subject= new PropertyChangeSupport(this);
    private secondObserver so = new secondObserver();
    /**********
    Function to link the model and the second observer for the information panel.
     *******/
    public void linkSecondObserver(secondObserver sob)
    {
        so = sob;
        subject.addPropertyChangeListener(so);    //  GRADING: SUBJECT_CUSTOM
        subject.firePropertyChange("incR", -1, this.getRent());  // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("main", -1, this.getmaintainance()); // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("fill", -1, filled);     // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("fund", -1, funds);      // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("month", -1, currmonth); // GRADING: TRIGGER_CUSTOM

    }
    /*
    Increases rent of all floors with tenants
     */
    public void increaseRent(double  amt)
    {
        for (floor f : floors) {
            f.increaseRent(amt);
        }

        subject.firePropertyChange("incR", 0, this.getRent());  // GRADING: TRIGGER_CUSTOM
    }
    public int getFunds()
    {
        return funds;
    }
    public int getMonth()
    {
        return currmonth;
    }
    /*
    Updates current month as well as forwards the call to floor
     */
    public void newMonth()
    {
        funds = funds + getRent() - getmaintainance();
        currmonth = currmonth + 1;
        for (floor f : floors) {
            f.newMonth();
        }
        rent = 0;
        main =0;
        subject.firePropertyChange("fund", null, funds);     // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("month", -1, currmonth);  // GRADING: TRIGGER_CUSTOM
    }
    /*
    Adds a new floor to the model.
     */
    public floor addFloor()
    {
        floor a = new floor();
        floors.add(a);
        funds = funds - 20000;
        subject.firePropertyChange("incR", 0, this.getRent());  // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("main", 0, this.getmaintainance());  // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("fund", null, funds);                // GRADING: TRIGGER_CUSTOM
        return a;

    }
    //type0 -> empty, type 1 -> basic, type 2-> pent, fl -> which floor

    public void remodel(int type, int fl)
    {
        if(floors.get(fl).getAptType() == "1" || floors.get(fl).getAptType() == "2" )
        {
            //no cond
        }
        else if(type == 0)
            filled --;
        else
            filled++;

        int sub = floors.get(fl).remodel(type);
        funds = funds - sub;


        subject.firePropertyChange("fill", -1, filled);                 // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("incR", null, this.getRent());       // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("main", null, this.getmaintainance());  // GRADING: TRIGGER_CUSTOM
        subject.firePropertyChange("fund", null, funds);                 // GRADING: TRIGGER_CUSTOM
    }
    /*
    Getter and setter functions
     */
    public int getmaintainance()
    {
        main =0;
        for (floor f : floors) {
            main = main +  f.getMaint();
        }
        return main;
    }
    public int getRent()
    {
        rent =0;
        for (floor f : floors) {
            rent = rent +  f.getRent();
        }
        return rent;
    }
    public int fill()
    {
        return filled;
    }

    public int getduration(int fl)
    {
        return floors.get(fl).getDur();

    }
    public int getIndividualRent(int fl)
    {
        return floors.get(fl).getRent();
    }

}
