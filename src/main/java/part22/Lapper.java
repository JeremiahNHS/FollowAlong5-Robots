package part22;

public class Lapper {
    private Rover rover;
    private int done;

    public Lapper(Rover rover) {
        this.rover = rover;
    }

    public void laps(int n){
        for (int i = 0; i < n; i++){
            rover.followLine(725);
            done++;
            System.out.println("Lap " + done + " done");
        }
    }
}
