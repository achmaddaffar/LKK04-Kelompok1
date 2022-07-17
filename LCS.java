import java.util.Scanner;

class return2Var {
    int[][] A;
    String[][] B;

    public return2Var(int[][] a, String[][] b) {
        this.A = a;
        this.B = b;
    }
}

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    public static void Print_LCS(String[][] b, String X, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (b[i][j].equals("\\")) {
            Print_LCS(b, X, i - 1, j - 1);
            System.out.printf("%s", X.substring(i - 1, i));
        } else if (b[i][j].equals("|")) {
            Print_LCS(b, X, i - 1, j);
        }
        else {
            Print_LCS(b, X, i, j - 1);
        }
    }
}
