
public class MixCols {
    
    private static int[][] MDSmatrix = {{2,3,1,1},{1,2,3,1},{1,1,2,3},{3,1,1,2}};

    public static void mixColumns (int[][] matrix) {
        printHexMatrix(multiply(MDSmatrix,matrix));
    }
    
    // Assuming identical sized n by n matrices
    public static int[][] multiply(int[][] a, int [][] b)  {
        int n = a.length;
        int[][] c = new int[n][n];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    c[i][j] ^= galois(a[i][k],b[k][j]);
                }
            }
        }
        return c;
    }
    
    public static int galois(int a, int b) {
        if (a == 1) {
            return b;
        }
        else if (a == 2) {
            b = b << 1;
            if (b > 0xFF) {
                return b ^ 0x11B;
            }
            return b;
        }
        return galois(1,b) ^ galois(2,b); 
    }
    
    public static void printHexMatrix(int[][] m) {
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m.length; ++j) {
                System.out.printf("%2s ", Integer.toHexString(m[i][j]).toUpperCase());
            }
            System.out.println();
        }
    }
    
    public static void main(String[] z) {
        int[][] matrix = {{0xD4, 0xE0, 0xB8, 0x1E},
                          {0xBF, 0xB4, 0x41, 0x27},
                          {0x5D, 0x52, 0x11, 0x98},
                          {0x38, 0xAE, 0xF1, 0xE5}};
        
        mixColumns(matrix);
    }
    
}
