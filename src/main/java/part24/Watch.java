package part24;

import mbot.*;

@MBotLab(world = "worlds/part24-yard.json")
public class Watch {
    public static void main(String[] args) {
        MBot2 bot = new Challenge();
        bot.run();
    }
}
