package greta.java;

public class Position {

    private int x;
    private int y;
    private boolean casePosition = false;

    public boolean getCasePosition() {
        return casePosition;
    }

    public void setCasePosition(boolean casePosition) {
        this.casePosition = casePosition;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
