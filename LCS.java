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
        System.out.print("Masukkan String X : ");
        String X = sc.nextLine();
        System.out.print("Masukkan String Y : ");
        String Y = sc.nextLine();
        return2Var rtn = LCS_Length(X, Y);
        int[][] c = rtn.A;
        String[][] b = rtn.B;
        System.out.println("\nTabel LCS-Length :");
        for (int i = 1; i < c.length; i++) {
            for (int j = 1; j < c[i].length; j++) {
                System.out.printf("[%3d] ", c[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        int counter1 = 0, counter2 = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (i == 0 & j == 0)
                    System.out.print("   ");
                else if (j == 0)
                    System.out.printf(" %s ", X.substring(counter1, counter1++ + 1));
                else if (i == 0)
                    System.out.printf(" %s  ", Y.substring(counter2, counter2++ + 1));
                else
                    System.out.printf("[%s] ", b[i][j]);
            }
            System.out.println();
        }
        System.out.printf("\nLongest Common Subsequence dari %s dan %s adalah ", X, Y);
        Print_LCS(b, X, X.length(), Y.length());
        sc.close();
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
