import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String mode;
        do {
            System.out.println("d for default, c for custom");
            mode = s.next();
        } while (!mode.equals("d") && !mode.equals("c"));
        Board b;
        boolean cond = true;
        switch (mode) {
        case "d":
            b = new Board();
            cond = false;
            break;
        case "c":
            System.out.println("width");
            int w = s.nextInt();
            System.out.println("height");
            int h = s.nextInt();
            System.out.println("number");
            int n = s.nextInt();
            b = new Board(w, h, n);
            cond = false;
            break;
        default:
            b = new Board();
            break;
        }

        boolean cont = true;
        while (cont) {
            System.out.println("\n" + b);
            String action;
            do {
                System.out.println("m for mark, c for check, q for quit");
                action = s.next();
            } while (!action.equals("m")
                && !action.equals("c")
                && !action.equals("q"));
            if (action.equals("q")) {
                cont = false;
                continue;
            }
            int x;
            int y;
            do {
                System.out.println("x cordinate");
                x = s.nextInt();
            } while (x < 1 || x > b.getW());
            do {
                System.out.println("y cordinate");
                y = s.nextInt();
            } while (y < 1 || y > b.getH());
            switch (action) {
            case "m":
                b.mark(x, y);
                break;
            case "c":
                cont = b.check(x, y);
                if (!cont) {
                    b.lose();
                    System.out.println("\n" + b);
                    System.out.println("You lose!");
                    continue;
                }
                break;
            default:
                continue;
            }
            if (b.checkWin()) {
                b.reveal();
                System.out.println("\n" + b);
                System.out.println("You win!");
                cont = false;
            }
        }
    }
}
