package part22;

import mbot.*;

@MBotLab(world = "worlds/part22-track.json")
public class Watch {
    public static void main(String[] args) {
        new Challenge().followLine(900);
    }
}