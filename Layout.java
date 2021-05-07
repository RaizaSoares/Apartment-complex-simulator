package soares_raiza;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


import java.util.ArrayList;

public class Layout {

    private double H= 500;  //scene height
    private double W = 800; //scene width
    ArrayList<Button> arr = new ArrayList<Button>();
    ArrayList<Button> arr2 = new ArrayList<Button>();
    Button newMonth;
    TextField field;
    Button labelArea;
    ToggleGroup group;
    RadioButton rBtn1;
    RadioButton rBtn2;
    RadioButton rBtn3;
    Button threeBuild;
    Button fourBuild;
    Button sixBuild;
    private Image img3;
    private Image img2;
    private Image img4;
    private ImageView view5;
    Text display = new Text("");
    Group root = new Group();
    secondObserver stats_One = new secondObserver();
    ApartmentComplexView ap = new ApartmentComplexView();
    private ObservableList<Node> list = root.getChildren();

    //Basic starter layout
    public Layout() {

        Image img = new Image("soares_raiza/cal1.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(40);
        view.setFitWidth(50);
        view.setPreserveRatio(true);

        img2 = new Image("soares_raiza/3build.png");
        ImageView view2 = new ImageView(img2);
        view2.setFitHeight(22);
        view2.setFitWidth(22);
        view2.setPreserveRatio(true);

        img3 = new Image("soares_raiza/4build.png");
        ImageView view3 = new ImageView(img3);
        view3.setFitHeight(22);
        view3.setFitWidth(22);
        view3.setPreserveRatio(true);

        img4 = new Image("soares_raiza/6build.png");
        ImageView view4 = new ImageView(img4);
        view4.setFitHeight(22);
        view4.setFitWidth(22);
        view4.setPreserveRatio(true);

        Image img5 = new Image("soares_raiza/logo.png");
        view5 = new ImageView(img5);
        view5.setFitHeight(H/6);
        view5.setFitWidth(W/1.7);
        view5.setPreserveRatio(true);
        view5.setLayoutX(W*0.42);
        view5.setLayoutY(5);
        list.add(view5);

        arr = ap.buildComplex();
        ap.setLayoutX(W*0.12);
        ap.setLayoutY(H/8);
        ap.setPrefWidth(W*0.7);
        ap.setPrefHeight(H*0.9);
        list.add(ap);
        //new month
        newMonth =  new Button("\nNew month\n");
        newMonth.setLayoutY(H/5.9);
        newMonth.setLayoutX(W*0.85);
        newMonth.setId("NewMonth");
        newMonth.setGraphic(view);
        list.add(newMonth);

        //increase rent
        field = new TextField("");
        field.setLayoutX(W*0.85);
        field.setLayoutY(H/3.72);
        list.add(field);
        labelArea = new Button("Increase rent"); //new lines work with Text
        labelArea.setLayoutX(W*0.85);
        labelArea.setLayoutY(H/3);
        labelArea.setId("IncRent");
        list.add(labelArea);

        //radio buttons
        group = new ToggleGroup(); //the group where only 1 can be selected
        rBtn1 = new RadioButton("Empty");
        rBtn2 = new RadioButton("Basic");
        rBtn3 = new RadioButton("Penthouse");
        rBtn1.setToggleGroup(group);
        rBtn2.setToggleGroup(group);
        rBtn3.setToggleGroup(group);
        rBtn1.setLayoutX(W*0.85);
        rBtn2.setLayoutX(W*0.85);
        rBtn3.setLayoutX(W*0.85);
        rBtn1.setLayoutY(H/1.7);
        rBtn2.setLayoutY(H/1.6);
        rBtn3.setLayoutY(H/1.5);
        group.selectToggle( rBtn1 );
        list.add(rBtn1);
        list.add(rBtn2);
        list.add(rBtn3);

        //stats
        stats_One.setLayoutX(5);
        stats_One.setLayoutY(20);
        stats_One.setSpacing(H*0.80);
        list.add(stats_One);

        //more building options
        threeBuild = new Button("3 buildings");
        threeBuild.setId("3build");
        threeBuild.setLayoutX(W*0.85);
        threeBuild.setLayoutY(H/1.4);
        threeBuild.setGraphic(view2);
        list.add(threeBuild);

        fourBuild = new Button("4 buildings");
        fourBuild.setId("4build");
        fourBuild.setLayoutX(W*0.85);
        fourBuild.setLayoutY(H/1.3);
        fourBuild.setGraphic(view3);
        list.add(fourBuild);

        sixBuild = new Button("6 buildings");
        sixBuild.setId("6build");
        sixBuild.setLayoutX(W*0.85);
        sixBuild.setLayoutY(H/1.2);
        sixBuild.setGraphic(view4);
        list.add(sixBuild);

    }
    /*
    Resizing complex
     */
    public void resize(int num)
    {

        if(num== 3)
        {
            ap.resize(3);
            arr =ap.buildComplex();
        }
        else if(num==4)
        {
            ap.resize(4);
            arr =ap.buildComplex();
        }
        else if(num ==6)
        {
            ap.resize(6);
            arr = ap.buildComplex();
        }
    }
    /*
    Resizing events when H and W change
     */
    public void Haffected()
    {
        newMonth.setLayoutY(H/5.9);
        newMonth.setLayoutX(W*0.85);
        field.setLayoutX(W*0.85);
        field.setLayoutY(H/3.72);
        labelArea.setLayoutX(W*0.85);
        labelArea.setLayoutY(H/3);
        rBtn1.setLayoutX(W*0.85);
        rBtn2.setLayoutX(W*0.85);
        rBtn3.setLayoutX(W*0.85);
        rBtn1.setLayoutY(H/1.7);
        rBtn2.setLayoutY(H/1.6);
        rBtn3.setLayoutY(H/1.5);
        threeBuild.setLayoutX(W*0.85);
        threeBuild.setLayoutY(H/1.4);
        fourBuild.setLayoutX(W*0.85);
        fourBuild.setLayoutY(H/1.3);
        sixBuild.setLayoutX(W*0.85);
        sixBuild.setLayoutY(H/1.2);

        ap.setLayoutX(W*0.12);
        ap.setLayoutY(H/8);
        ap.setPrefWidth(W*0.7);
        ap.setPrefHeight(H*0.9);
        view5.setLayoutX(W*0.42);
        view5.setFitHeight(H/6);
        view5.setFitWidth(W/1.7);

        stats_One.setLayoutY(20);
        stats_One.setSpacing(H*0.80);

    }
    /*
    Tell apartment complex view to build a new floor(View)
     */
    public void buildFloor(int num)
    {
        arr2 = ap.buildFloor(num);
    }

    public void setHandW(double hei, double wid)
    {
        H = hei;
        W = wid;
        Haffected();
    }



}
