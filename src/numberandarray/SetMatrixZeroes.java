package numberandarray;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(row[i]==1 || col[j]==1){
                   matrix[i][j]=0;
                }
            }
        }


    }
    public void setZeroesOptimal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isRow = false, isCol = false;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    if(i==0) isRow = true;
                    if(j==0) isCol = true;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if (isRow){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }
        if (isCol){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
