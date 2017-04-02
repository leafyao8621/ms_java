public class Mine extends Grid {
    @Override
    public String toString() {
        if (!getIsMarked() && !getIsChecked()) {
            return "_";
        } else if (getIsMarked()) {
            return "f";
        } else if (getIsChecked()){
            return "*";
        } else {
            return "";
        }
    }
    @Override
    public void mark() {
        setIsMarked(!getIsMarked());
    }
    @Override
    public boolean check() {
        return false;
    }
}