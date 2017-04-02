public class Empty extends Grid {
    private int mines;
    public void setMines(int mines) {
        this.mines = mines;
    }
    public int getMines() {
        return mines;
    }
    @Override
    public boolean check() {
        return true;
    }
    @Override
    public void mark() {
        setIsMarked(!getIsMarked());
    }
    @Override
    public String toString() {
        if (!getIsChecked() && !getIsMarked()) {
            return "_";
        } else if (getIsChecked()) {
            return String.format("%d", mines);
        } else if (getIsMarked()) {
            return "f";
        } else {
            return "";
        }
    }
}