import java.util.Random;
import java.util.HashSet;
public class Board {
    private Grid[][] grids;
    private int w;
    private int h;
    private int n;
    public Board(int w, int h, int n) {
        grids = new Grid[h][w];
        this.w = w;
        this.h = h;
        this.n = n;
        Random r = new Random();
        HashSet<Integer> s = new HashSet<Integer>();
        while (s.size() < n) {
            s.add(r.nextInt(w * h));
        }
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grids[i][j] = s.contains(cnt++) ? new Mine() : new Empty();
            }
        }
    }
    public Board() {
        this(10, 10, 10);
    }
    public Grid[][] getGrids() {
        return grids;
    }
    public int getW() {
        return w;
    }
    public int getH() {
        return h;
    }
    public void mark(int x, int y) {
        grids[y - 1][x - 1].mark();
    }
    public boolean check(int x, int y) {
        if (!grids[y - 1][x - 1].check()) {
            return false;
        } else {
            int cnt = 0;
            for (int i = Math.max(0, y - 2); i < Math.min(h, y + 1); i++) {
                for (int j = Math.max(0, x - 2); j < Math.min(w, x + 1); j++) {
                    if (!grids[i][j].check()) {
                        cnt++;
                    }
                }
            }
            ((Empty) grids[y - 1][x - 1]).setMines(cnt);
            grids[y - 1][x - 1].setIsChecked(true);
            if (cnt == 0) {
                for (int i = Math.max(0, y - 2); i < Math.min(h, y + 1); i++) {
                    for (int j = Math.max(0, x - 2); j < Math.min(w, x + 1); j++) {
                        if (!grids[i][j].getIsChecked()) {
                            check(j + 1, i + 1);
                        }
                    }
                }
            }

            return true;
        }
    }
    public void lose() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grids[i][j] instanceof Mine) {
                    ((Mine) grids[i][j]).setIsChecked(true);
                }
            }
        }
    }
    public void reveal() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grids[i][j] instanceof Mine) {
                    ((Mine) grids[i][j]).setIsMarked(true);
                }
            }
        }
    }
    public boolean checkWin() {
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grids[i][j].getIsChecked()) {
                    cnt++;
                }
            }
        }
        return cnt == w * h - n;
    }
    @Override
    public String toString() {
        String s = "   ";
        for (int i = 0; i < w; i++) {
            s += String.format("%-3d", i + 1);
        }
        s += "\n";
        for (int i = 0; i < h; i++) {
            s += String.format("%-3d", i + 1);
            for (int j = 0; j < w; j++) {
                s += String.format("%-3s", grids[i][j]) ;
            }
            s += ("\n");
        }
        return s;
    }
}
