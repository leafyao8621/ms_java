public abstract class Grid implements Action {
    private boolean isChecked;
    private boolean isMarked;
    public boolean getIsChecked() {
        return isChecked;
    }
    public void setIsChecked(boolean checked) {
        isChecked = checked;
    }
    public boolean getIsMarked() {
        return isMarked;
    }
    public void setIsMarked(boolean marked) {
        isMarked = marked;
    }
}