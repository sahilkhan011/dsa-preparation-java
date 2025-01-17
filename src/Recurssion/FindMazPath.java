package Recurssion;

public class FindMazPath {
    public static void main(String[] args) {
        int m = 5, n = 5;  // Grid size
        int ans = find(0, 0, m, n, new StringBuilder());
        // formula direct : (m+n-2)! / (m-1)!.(n-1)!
        System.out.println("Total Ans: " + ans);  // Total number of paths

    }

    // better solution.. this avoid the unnecessary recursive calls.
    private static int find(int i, int j, int m, int n, StringBuilder output) {
        // When we reach the destination (bottom-right corner), print the path
        if (i == m - 1 && j == n - 1) {
            System.out.println(output);
            return 1;  // This is a valid path
        }

        int paths = 0;

        // Move right if we are not already at the last column
        if (j < n - 1) {
            output.append('R');
            paths += find(i, j + 1, m, n, output);  // Recur for the next column
            output.deleteCharAt(output.length() - 1);  // Backtrack
        }

        // Move down if we are not already at the last row
        if (i < m - 1) {
            output.append('D');
            paths += find(i + 1, j, m, n, output);  // Recur for the next row
            output.deleteCharAt(output.length() - 1);  // Backtrack
        }

        return paths;  // Return total number of valid paths found
    }

    private static int find2(int i, int j, int m, int n,StringBuilder output) {
        if(i == m-1 && j == n-1) { // when we reach the destination...
            System.out.println(output);
            return 1;
        };
        if(i>=m || j>=n) return 0; // when we go outside the board..

        // check all path from right side...
        output.append('R');
        int right = find2(i,j+1,m,n,output);

        // backtrack. and check all path from down side...
        output.setCharAt(output.length()-1,'D');
        int bottom = find2(i+1,j,m,n,output);

        // backtrack..
        output.deleteCharAt(output.length()-1);
        return bottom + right;
    }
}
