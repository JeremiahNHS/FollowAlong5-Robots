package part23;

import mbot.*;

@MBotLab(world = "worlds/part23-maze.json")
public class Watch {
    public static void main(String[] args) {
        new Challenge().explore();
    }
}