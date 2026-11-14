package part24;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–3 and 6
//
// Part 24 — overriding: your robot keeps a method's name, but changes what it does.
//
// SECTION A — FOLLOW ALONG: type the CarefulBot class from the guide.
//    Leave the "package part24;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
// defines the name of the class, CarefulBot, which is a type of MBot2 so it inherits driving and sensors from it
public class CarefulBot extends MBot2 {
    private int refused;
    // public constructor for the CarefulBot class
    public CarefulBot() {
        // calls the MBot2 constructor to initialize the inherited parts of the CarefulBot
        super();
    }
    // tells Java that the method below is intended to override a method from the parent class
    @Override
    // overrides MBot2's straight method using the same parameter and return type
    public void straight(double cm){
        // checks if the measured distance is greater than cm + 20
        if (readUltrasonic() > cm + 20){
            // calls MBot2's original straight method to move forward the requested distance
            super.straight(cm);
        // if the measured distance is less than cm + 20 this code is ran
        } else {
            // turns the first LED on to red
            turnLedOn(1,255,0,0);
            // prints out the text indicating that the measured distance is too close and CarefulBot will not drive
            System.out.println("CarefulBot: not driving " + cm + " cm, too close");
            refused++;
        }
    }
    // tells Java that the method below is intended to override a method from the parent class
    @Override
    // overrides MBot2's run method, has the same name and returns nothing
    public void run(){
        // repeats the code inside the loop 5 times
        for (int i = 0; i < 5; i++){
            // calls CarefulBot's overridden straight method to attempt to move forward 40 cm
            straight(40);
        }
    }

    @Override
    public String toString(){
        return "CarefulBot (refused " + refused + " moves)";
    }
}
