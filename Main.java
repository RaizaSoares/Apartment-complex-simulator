/**************************************************************************************

 * Author: Raiza Soares
 * Class: CSC468/568 GUI Spring 2020
 * Checklist:
 * Mark off what items are complete, and put a P if partially complete. If 'P' include how to test what is working for partial credit below the checklist line.
 *
 *
 * __X__ Tierless: Followed the class OOP diagram 	10 total
 *
 *
 * Tierless: Initial Layout with 3 buildings 	30 total
 * __X__ Location of info bar, command bar, build bar, and apartment complex in correct areas
 * __X__ Info and command areas properly spaced
 * __X__ Command bar vertically aligned and in correct order
 * __X__ Apartment complex area fill the remaining space
 * __X__ Floors are even rectangles
 * __P__ All of the above holds true on window resize  (SEE COMMENT BELOW CHECKLIST TO TEST FOR PARTIAL CREDIT)
 *
 *
 * 1. Tier: Functionality 	40  total
 * __X__ Able to add a new floor
 * __X__ New floor build costs applied properly
 * __X__ Rent increase does not affect new tenants
 * __X__ Rent increase works on all tenants, and does not affect Empty floors
 * __X__ Able to remodel the 3 apartment types
 * __X__ Remodeling immediately, and properly affects monthly funds, rent, maintenance, and filled
 * __X__ New month affects tenants time since remodel, run time, and funds.
 *
 *
 * 2. Tier: Stress Test with Resize	30  total
 * __X__ Resize clears the apartment complex area
 * __X__ Correct # of build buttons after resize
 * __X__ New floors the right size after resize (filled area and evenly sized)
 * __X__ Resize reset info pane (5 items, evenly weighted)
 * __X__ All of tier 3 still works (-3 for each up to a max)
 *
 *
 * 3 Final Tier: Extensions	20  total
 * Extension 1: <1> <10> <Add images instead of using only text>: <Images were added for the newMonth button,
 *              The three building size buttons (3 buildings, 4 buildings, 6buildings)
 *              have a picture on each of them, The entire scene has a logo titled "Apartment
 *              complex">
 * Extension 2: <2> <10> <Add hot keys>:
 *              <
 *              CTRL + N  - New month  (Same as new month button)
 *              CTRL + T - Resizes the complex with three buildings (Same as "3 buildings" button)
 *              CTRL + F - Resizes the complex with four buildings (Same as "4 buildings" button)
 *              CTRL + S - Resizes the complex with six buildings (Same as "6 buildings" button)
 *              >
 * HOW TO TEST FOR WINDOW RESIZE: After resizing window by clicking maximize/ minimize button or dragging window to resize,
 * either press CTRL + R , or any button in the simulator to trigger the resizing events. The simulator should then resize according to
 * the window.
 * I had to do this because I wasn't able to implement the listener for the scene resizing events properly.
 *
 * bugs: Apart from the one listed above, none.

 **************************************************************************************/


package soares_raiza;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Group root = new Group();
    //View
    private Layout layout;
    apartmentComplex ap = new apartmentComplex();
    //Controller
    private Controller ctrl;
    private ObservableList<Node> list = root.getChildren();
    //Just starts the scene
    @Override
    public void start(Stage primaryStage) throws Exception {
        layout = new Layout();
        primaryStage.setTitle("Apartment complex simulator");
        Scene s = new Scene(layout.root, 800, 500);
        ctrl = new Controller(ap, layout, s);
        primaryStage.setScene(s);
        primaryStage.show();
        double h = s.getHeight();
        double w = s.getWidth();


    }
}
