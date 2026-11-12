package part24;
// imports the classes from the mbot package so they can be used in this program
import mbot.*;

// Guide: GUIDE.md in this folder, steps 2, 5 and 7
//
// SECTION A — FOLLOW ALONG: type the mission method and the main method from the guide.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.
// specifies the world setup for the mBot simulation, a wall-ahead
@MBotLab(world = "wall-ahead")
// defines the name of the class
public class Mission {
    // defines a public static method called mission that takes an MBot2 object as a parameter and returns nothing
    public static void mission(MBot2 bot) {
        // prints on the text "Mission start"
        System.out.println("Mission start");
        // calls the run method for the specific bot that is passed in
        bot.run();
        // prints out the text "Mission done"
        System.out.println("Mission done");
    }
    // the main method is the start of the program
    public static void main(String[] args){
        // stores the number used to decide which type of robot to create
        int pick = 1;
        // declares a variable of type MBot2 that will hold the selected robot object
        MBot2 bot;
        // checks if pick is equal to 1
        if (pick == 1){
            // creates a new CarefulBot object and assigns it to bot
            bot = new CarefulBot();
        // checks whether pick is equal to 2 if the first condition was false
        } else if (pick == 2){
            // creates a new FlashyBot object and assigns it to bot
            bot = new FlashyBot();
        // if pick is not 1 or 2 this code is ran
        } else {
            // creates a regular MBot2 object and assigns it to bot
            bot = new MBot2();
        }
        // calls the mission method and passes the selected robot object to it
        mission(bot);
    }
}
