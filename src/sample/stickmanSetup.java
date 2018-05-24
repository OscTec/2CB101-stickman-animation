package sample;

import java.util.ArrayList;
import java.util.HashMap;


public class stickmanSetup {
    ArrayList<String> namesAndNumbers = new ArrayList<String>();
    HashMap<String, Points> figure = new HashMap<String, Points>();//Makes a HashMap of all the points that make up the stickman
    double x = 200, y = 200;

    public void namesToNumbers() {
        namesAndNumbers.add("head");//Head
        namesAndNumbers.add("chest");//CHEST
        namesAndNumbers.add("leftHand");//Left Hand
        namesAndNumbers.add("rightHand");//Right Hand
        namesAndNumbers.add("post");//Post
        namesAndNumbers.add("leftFoot");//Left Foot
        namesAndNumbers.add("rightFoot");//Right Foot
    }

    public void createStickmanPoints() {//Method for setting the coords of stickman points
        figure.put("head", new Points(x, y - 40));
        figure.put("chest", new Points(x, y));
        figure.put("leftHand", new Points(x - 30, y));
        figure.put("rightHand", new Points(x + 30, y));
        figure.put("post", new Points(x, y + 50));
        figure.put("leftFoot", new Points(x - 30, y + 70));
        figure.put("rightFoot", new Points(x + 30, y + 70));
    }


}
