package soares_raiza;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class ApartmentComplexView extends GridPane {
    apartmentComplex model = new apartmentComplex();
    private int size =3;
    boolean floorMap[][] = new boolean[6][6]; //floormap to determine which floors are full
    ArrayList<Button> arr = new ArrayList<Button>(6);
    ArrayList<Button> arr2 = new ArrayList<Button>(100);

    public void setModel(apartmentComplex m)
    {
        model = m;
    }

    public void resize(int cols)
    {
        size = cols;
    }

    public void reserArray()
    {
        for (int row = 0; row < floorMap.length; row++)
        {
            for (int col = 0; col < floorMap[0].length; col++) {

                floorMap[row][col] = false;
            }

        }

    }

    public ArrayList<Button> buildComplex()
    {
        reserArray();
        arr.clear();
        arr2.clear();
        getChildren().clear();
        getRowConstraints().clear();
        getColumnConstraints().clear();

        //set up grid pane and its rows and column constraints
        this.setMaxHeight(Double.MAX_VALUE);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setAlignment(Pos.CENTER);


        for(int i=0; i<size; i++)
        {
            Button button = new Button("Build");
            button.setId("" +i);
            ApartmentComplexView.setHgrow(button, Priority.ALWAYS);
            button.setMaxWidth(Double.MAX_VALUE);
            ApartmentComplexView.setConstraints(button, i, 0);
            this.getChildren().add(button);
            arr.add(button);

        }
        for (int i = 0; i < 6; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(65);
            this.getRowConstraints().add(row);

        }
        for (int i = 0; i < size; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(95);
            this.getColumnConstraints().add(col);
        }


        return arr;

    }
    /*
    If there is space, build a new floor, create corresponding apartmentview
     */
    public ArrayList<Button> buildFloor(int i)
    {
        ApartmentView temp = new ApartmentView();
        ApartmentComplexView.setHgrow(temp, Priority.ALWAYS);
        temp.setMaxWidth(Double.MAX_VALUE);
        int j = 5;
        while(floorMap[i][j] && j>0)
        {
            j--;
        }
        if(j >0)
        {
            floorMap[i][j] = true;
            ApartmentComplexView.setConstraints(temp, i, j);
            temp.setId(""+i+j);
            this.add(temp, i, j);
            arr2.add(temp);
            //model part
            floor mem;
            mem = model.addFloor();
            mem.linkApartmentView(temp);
        }

        return arr2;

    }

}
