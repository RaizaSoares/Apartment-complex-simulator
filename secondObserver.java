package soares_raiza;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/********************************
Second oberver for the information pane
 ******************************/
public class secondObserver extends VBox implements PropertyChangeListener {

        int rentCollect = 0;
        int maintenance= 0;
        int filled = 0;
        int funds =100000;
        int mon = 0;
        private String makedurString(int rentCollect, int maintenance, int filled)
        {
        String s = "Rent to collect: " + rentCollect + "\nMaintenance: " + maintenance + "\nFilled: " + filled;
        return s;
        }

        private String makedurString2( int mon, int funds)
        {
                String s = "Month: " + mon + "\nFunds: " + funds ;
                return s;
        }

        public secondObserver()
        {
                VBox.setVgrow(this, Priority.ALWAYS);
                this.getChildren().add( new Text(makedurString(rentCollect, maintenance, filled)));
                this.getChildren().add(new Text(makedurString2(mon, funds)));
        }


        @Override
        public void propertyChange(PropertyChangeEvent evt) {  //GRADING: OBSERVE_CUSTOM
                if (evt.getPropertyName().equals("incR"))
                {
                        rentCollect = (int) evt.getNewValue();
                }
                else if (evt.getPropertyName().equals("fill"))
                {
                        filled = (int) evt.getNewValue();

                }
                else if (evt.getPropertyName().equals("main"))
                {
                        maintenance = (int) evt.getNewValue();

                }

                else if (evt.getPropertyName().equals("month"))
                {
                        mon = (int) evt.getNewValue();

                }
                else if (evt.getPropertyName().equals("fund"))
                {
                        funds = (int) evt.getNewValue();

                }

                this.getChildren().clear();

                this.getChildren().add( new Text(makedurString(rentCollect, maintenance, filled)));
                this.getChildren().add(new Text(makedurString2(mon, funds)));

        }


    }


