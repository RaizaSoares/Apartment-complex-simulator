package soares_raiza;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.util.ArrayList;

public class Controller {

    private Layout layout;
    private apartmentComplex model;
    private Scene sc;
    ArrayList<Node> listKeys = new ArrayList<Node>();
    public Controller(apartmentComplex clone, Layout layout, Scene scene) {
        this.sc = scene;
        this.layout = layout;
        this.model = clone;
        layout.ap.setModel(model);
        model.linkSecondObserver(layout.stats_One);
        layout.newMonth.addEventFilter(ActionEvent.ACTION, new Listener());
        layout.labelArea.addEventFilter(ActionEvent.ACTION, new Listener());
        layout.threeBuild.addEventFilter(ActionEvent.ACTION, new Listener());
        layout.fourBuild.addEventFilter(ActionEvent.ACTION, new Listener());
        layout.sixBuild.addEventFilter(ActionEvent.ACTION, new Listener());

        for(Node u : layout.arr)
        {
            if(!listKeys.contains(u)) {
                u.addEventFilter(ActionEvent.ACTION, new Listener());
                listKeys.add(u);
            }
        }
        setUpHotKeys();

    }

    private void setUpHotKeys()
    {
        KeyCombination kc0 = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
        Runnable rn0 = ()-> lay();
        sc.getAccelerators().put(kc0, rn0);

        KeyCombination kc = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
        Runnable rn = ()-> model.newMonth();
        sc.getAccelerators().put(kc, rn);

        KeyCombination kc2 = new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN);
        Runnable rn2 = ()-> {
            layout.resize(4);
            model = new apartmentComplex();
            layout.ap.setModel(model);

            model.linkSecondObserver(layout.stats_One);
            specialupdates();
        };
        sc.getAccelerators().put(kc2, rn2);

        KeyCombination kc3 = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
        Runnable rn3 = ()-> {
            layout.resize(6);
            model = new apartmentComplex();
            layout.ap.setModel(model);

            model.linkSecondObserver(layout.stats_One);
            specialupdates();
        };
        sc.getAccelerators().put(kc3, rn3);

        KeyCombination kc4 = new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN);
        Runnable rn4 = ()-> {
            layout.resize(3);
            model = new apartmentComplex();
            layout.ap.setModel(model);

            model.linkSecondObserver(layout.stats_One);
            specialupdates();
        };
        sc.getAccelerators().put(kc4, rn4);
    }
    /**
     * Handles normal click increase in money
     */

    public void specialupdates()
    {
        for(Node u : layout.arr)
        {
            if(!listKeys.contains(u)) {
                u.addEventFilter(ActionEvent.ACTION, new Listener());
                listKeys.add(u);
            }
        }
    }

    public void lay()
    {
        double y = sc.getHeight();
        double x = sc.getWidth();
        layout.setHandW(y, x);
    }

    private class Listener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (((Node) event.getSource()).getId().equals("NewMonth")) {
                model.newMonth();

            }

            else if (((Node) event.getSource()).getId().equals("IncRent")) {
                double temp = Double.parseDouble( layout.field.getText());
                model.increaseRent(temp);
            }
            else if (((Node) event.getSource()).getId().equals("3build")) {

                layout.resize(3);
                model = new apartmentComplex();
                layout.ap.setModel(model);
                model.linkSecondObserver(layout.stats_One);
                specialupdates();
            }
            else if (((Node) event.getSource()).getId().equals("4build")) {

                layout.resize(4);
                model = new apartmentComplex();
                layout.ap.setModel(model);

                model.linkSecondObserver(layout.stats_One);
                specialupdates();
            }
            else if (((Node) event.getSource()).getId().equals("6build")) {

                layout.resize(6);
                model = new apartmentComplex();
                layout.ap.setModel(model);
                model.linkSecondObserver(layout.stats_One);
                specialupdates();
            }
            else if (((Node) event.getSource()).getId().equals("0")) {
                layout.buildFloor(0);
                specialupdatesTwo();
            }
            else if (((Node) event.getSource()).getId().equals("1")) {
                layout.buildFloor(1);
                specialupdatesTwo();
            }
            else if (((Node) event.getSource()).getId().equals("2")) {
                layout.buildFloor(2);
                specialupdatesTwo();
            }
            else if (((Node) event.getSource()).getId().equals("3")) {
                layout.buildFloor(3);
                specialupdatesTwo();
            }
            else if (((Node) event.getSource()).getId().equals("4")) {
                layout.buildFloor(4);
                specialupdatesTwo();
            }
            else if (((Node) event.getSource()).getId().equals("5")) {
                layout.buildFloor(5);
                specialupdatesTwo();
            }
            else if (((Node) event.getSource()).getId().equals("05") ||
                    ((Node) event.getSource()).getId().equals("04") || ((Node) event.getSource()).getId().equals("03") ||
                    ((Node) event.getSource()).getId().equals("02") || ((Node) event.getSource()).getId().equals("01") ||
                    ((Node) event.getSource()).getId().equals("15") ||
                    ((Node) event.getSource()).getId().equals("14") || ((Node) event.getSource()).getId().equals("13") ||
                    ((Node) event.getSource()).getId().equals("12") || ((Node) event.getSource()).getId().equals("11") ||

                    ((Node) event.getSource()).getId().equals("25") ||
                    ((Node) event.getSource()).getId().equals("24") || ((Node) event.getSource()).getId().equals("23") ||
                    ((Node) event.getSource()).getId().equals("22") || ((Node) event.getSource()).getId().equals("21") ||

                    ((Node) event.getSource()).getId().equals("35") ||
                    ((Node) event.getSource()).getId().equals("34") || ((Node) event.getSource()).getId().equals("33") ||
                    ((Node) event.getSource()).getId().equals("32") || ((Node) event.getSource()).getId().equals("31") ||

                    ((Node) event.getSource()).getId().equals("45") ||
                    ((Node) event.getSource()).getId().equals("44") || ((Node) event.getSource()).getId().equals("43") ||
                    ((Node) event.getSource()).getId().equals("42") || ((Node) event.getSource()).getId().equals("41") ||

                    ((Node) event.getSource()).getId().equals("55") ||
                    ((Node) event.getSource()).getId().equals("54") || ((Node) event.getSource()).getId().equals("53") ||
                    ((Node) event.getSource()).getId().equals("52") || ((Node) event.getSource()).getId().equals("51")

            )
            {

                String key = ((Node) event.getSource()).getId();
                RadioButton selectedRadioButton = (RadioButton) layout.group.getSelectedToggle();
                String toggleGroupValue = selectedRadioButton.getText();
                int index= -1;
                for(int i=0; i<layout.arr2.size(); i++)
                {
                    if(layout.arr2.get(i).getId().equals(key))
                    {
                        index = i;
                        break;
                    }
                }
                if(toggleGroupValue.equals("Basic"))
                {
                    model.remodel(1, index);

                }
                else if(toggleGroupValue.equals("Penthouse"))
                {
                    model.remodel(2, index);
                }

                else if(toggleGroupValue.equals("Empty"))
                {
                    model.remodel(0, index);
                }

            }

            lay();
        }




        public void specialupdatesTwo()
        {
            for(Node u : layout.arr2)
            {
                if(!listKeys.contains(u)) {
                    u.addEventFilter(ActionEvent.ACTION, new Listener());
                    listKeys.add(u);
                }
            }
        }
    }
}
