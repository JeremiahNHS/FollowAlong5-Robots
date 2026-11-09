package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9 (the line sensor's numbers, and followLine)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B adds a new class, Lapper, at the bottom of this file.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "line-track")
public class Stretch {
    public static void main(String[] args){
        /* MY GUESS:
        6: straight (middle left + middle right)
        12: turn left (far left + left)
        3: turn right (far right + right)
        0: lost it (none)

         */
        int[] readings = {6, 12, 3, 0};
        for (int s : readings) {
            if (s == 4 || s == 8 || s == 12) {
                System.out.println(s + ": turn left");
            } else if (s == 1 || s == 2 || s == 3) {
                System.out.println(s + ": turn right");
            } else if (s == 0) {
                System.out.println(s + ": lost it");
            } else {
                System.out.println(s + ": straight");
            }
        }

        //B2
        Lapper lapper = new Lapper(new Rover("Loop"));
        lapper.laps(2);

        //B3
        // Lapper takes the Rover as a parameter, instead of making its own because it allows for more flexibility, this way any Rover can complete laps and have them tracked w/o having to change the code
    }

}
