import java.util.Scanner;

public class MCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    public static void printOptimalParentheses(int i, int j, int n, int[][] p) {

        if (i == j) {
            System.out.print(x++);
        } else {
            System.out.print("(");
            printOptimalParentheses(i, p[i][j], n, p);
            printOptimalParentheses(p[i][j] + 1, j, n, p);
            System.out.print(")");
        }
    }
    
}
