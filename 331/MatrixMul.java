public class MatrixMul {
  
  public int[][] classic(int [][] a, int [][] b) {
    int n = a.length;
    int [][] c = new int[n][n];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    } // triple four-loop of doom
    return c;
  }

  public int[][] divideConq(int [][] a, int [][] b) {
    int n = a.length;
    int q = n / 2;
    int [][] c = new int[n][n];

    if (n == 1) {
      c[0][0] = a[0][0] * b[0][0];
    }
    else {

      int [][][][] x = new int[2][4][q][q];
      int [][][] z = new int[4][q][q];
      this.split(x,a,b);

      z[0] = add(divideConq(x[0][0],x[1][0]), divideConq(x[0][1],x[1][2]));
      z[1] = add(divideConq(x[0][0],x[1][1]), divideConq(x[0][1],x[1][3]));
      z[2] = add(divideConq(x[0][2],x[1][0]), divideConq(x[0][3],x[1][2]));
      z[3] = add(divideConq(x[0][2],x[1][1]), divideConq(x[0][3],x[1][3]));

      c = reconstruct(z);
    }

    return c;
  }

  public int[][] strassen(int [][] a, int [][] b) {
    int n = a.length;
    int q = n / 2;
    int [][] c = new int[n][n];

    if (n == 1) {
      c[0][0] = a[0][0] * b[0][0];
    }
    else {

      int [][][][] x = new int[2][4][q][q];
      int [][][] p = new int[7][q][q];
      int [][][] z = new int[4][q][q];
      this.split(x,a,b);

      p[0] = strassen(add(x[0][0], x[0][3]), add(x[1][0], x[1][3]));
      p[1] = strassen(add(x[0][2], x[0][3]), x[1][0]);
      p[2] = strassen(x[0][0], sub(x[1][1], x[1][3]));
      p[3] = strassen(x[0][3], sub(x[1][2], x[1][0]));
      p[4] = strassen(add(x[0][0], x[0][1]), x[1][3]);
      p[5] = strassen(sub(x[0][2], x[0][0]), add(x[1][0], x[1][1]));
      p[6] = strassen(sub(x[0][1], x[0][3]), add(x[1][2], x[1][3]));

      z[0] = add(sub(add(p[0],p[3]),p[4]),p[6]);
      z[1] = add(p[2],p[4]);
      z[2] = add(p[1],p[3]);
      z[3] = add(sub(add(p[0],p[2]),p[1]),p[5]);
    
      c = reconstruct(z);
    }
  
    return c;
  }

  public void split(int [][][][] m, int [][] a, int [][] b) {
    int n = m[0][0].length;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        m[0][0][i][j] = a[i][j];
        m[0][1][i][j] = a[i][j+n];
        m[0][2][i][j] = a[i+n][j];
        m[0][3][i][j] = a[i+n][j+n];
        m[1][0][i][j] = b[i][j];
        m[1][1][i][j] = b[i][j+n];
        m[1][2][i][j] = b[i+n][j];
        m[1][3][i][j] = b[i+n][j+n];
      }  
    }
  }

  public int[][] add(int [][] a, int [][] b) {
    int n = a.length;
    int [][] c = new int[n][n];
    
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        c[i][j] = a[i][j] + b[i][j];
      }
    }
    return c;
  }

  public int[][] sub(int [][] a, int [][] b) {
    int n = a.length;
    int [][] c = new int[n][n];
    
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        c[i][j] = a[i][j] - b[i][j];
      }
    }
    return c;
  }

  public int[][] reconstruct(int [][][] m) {
    int q = m[0].length;
    int n = q * 2;
    int [][] z = new int[n][n];

    for (int i = 0; i < q; ++i) {
      for (int j = 0; j < q; ++j) {
        z[i][j] = m[0][i][j];
        z[i][j+q] = m[1][i][j];
        z[i+q][j] = m[2][i][j];
        z[i+q][j+q] = m[3][i][j];  
      }
    }
    return z;
  }

  public void print(int [][] m) {
    for (int [] i : m) {
      for (int j : i) {
        System.out.printf("%2d ",j);
      } 
      System.out.println();
    }
  }

  public int [][] generate(int n, int seed) {
    int [][] z = new int[n][n];
    for (int [] i : z) {
      for (int j : i) {
        j = seed;
      }
    }
    return z;
  }

  public static void main(String...args) {
    MatrixMul m = new MatrixMul();
    long s, e;

    int max = 13;

    System.out.println("Classic\n=========\n");
    for (int i = 1; i < max; ++i) {
      int size = (int)Math.pow(2,i);
      int [][] a = m.generate(size,2);
      int [][] b = m.generate(size,2);

      s = System.nanoTime();
      m.classic(a,b);
      e = System.nanoTime();
      
      System.out.printf("Size: %4d | Execution Time: %8d ns\n", size, e-s);

    }

    System.out.println("\nDivide and Conquer\n====================\n");
    for (int i = 1; i < max; ++i) {
      int size = (int)Math.pow(2,i);
      int [][] a = m.generate(size,2);
      int [][] b = m.generate(size,2);

      s = System.nanoTime();
      m.divideConq(a,b);
      e = System.nanoTime();
      
      System.out.printf("Size: %4d | Execution Time: %8d ns\n", size, e-s);

    }

    System.out.println("\nStrassen\n=========\n");
    for (int i = 1; i < max; ++i) {
      int size = (int)Math.pow(2,i);
      int [][] a = m.generate(size,2);
      int [][] b = m.generate(size,2);

      s = System.nanoTime();
      m.strassen(a,b);
      e = System.nanoTime();
      
      System.out.printf("Size: %4d | Execution Time: %8d ns\n", size, e-s);

    }

  }

}
