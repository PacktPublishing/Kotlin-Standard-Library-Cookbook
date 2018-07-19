package chapter2.recipe4;

public class LightBulb {
    private final int id;
    private boolean turnedOn = false;

    public LightBulb(int id) {
        this.id = id;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    public boolean getTurnedOn() {
        return turnedOn;
    }

    public int getId() {
        return id;
    }
}
