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

    public static return2Var LCS_Length(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        String[][] b = new String[m + 1][n + 1];
        int[][] c = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            c[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "\\";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "|";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "-";
                }
            }
        }
        return2Var rtn = new return2Var(c, b);
        return rtn;
    }

    public static void Print_LCS(String[][] b, String X, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (b[i][j].equals("\\")) {
            Print_LCS(b, X, i - 1, j - 1);
            System.out.printf("%s", X.substring(i - 1, i));
        } else if (b[i][j].equals("|")) {
            Print_LCS(b, X, i - 1, j);
        } else {
            Print_LCS(b, X, i, j - 1);
        }
    }
}
