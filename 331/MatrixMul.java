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

      int [][][] x = new int[4][q][q];
      int [][][] y = new int[4][q][q];
      int [][][] z = new int[4][q][q];
      this.split(x,a);
      this.split(y,b);

      z[0] = add(divideConq(x[0],y[0]), divideConq(x[1],y[2]));
      z[1] = add(divideConq(x[0],y[1]), divideConq(x[1],y[3]));
      z[2] = add(divideConq(x[2],y[0]), divideConq(x[3],y[2]));
      z[3] = add(divideConq(x[2],y[1]), divideConq(x[3],y[3]));

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

      int [][][] p = new int[7][q][q];
      int [][][] x = new int[4][q][q];
      int [][][] y = new int[4][q][q];
      int [][][] z = new int[4][q][q];
      this.split(x,a);
      this.split(y,b);

      p[0] = strassen(add(x[0], x[3]), add(y[0], y[3]));
      p[1] = strassen(add(x[2], x[3]), y[0]);
      p[2] = strassen(x[0], sub(y[1], y[3]));
      p[3] = strassen(x[3], sub(y[2], y[0]));
      p[4] = strassen(add(x[0], x[1]), y[3]);
      p[5] = strassen(sub(x[2], x[0]), add(y[0], y[1]));
      p[6] = strassen(sub(x[1], x[3]), add(y[2], y[3]));

      z[0] = add(sub(add(p[0],p[3]),p[4]),p[6]);
      z[1] = add(p[2],p[4]);
      z[2] = add(p[1],p[3]);
      z[3] = add(sub(add(p[0],p[2]),p[1]),p[5]);
    
      c = reconstruct(z);
    }
  
    return c;
  }

  public void split(int [][][] m, int [][] s) {
    int n = m[0][0].length;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        m[0][i][j] = s[i][j];
        m[1][i][j] = s[i][j+n];
        m[2][i][j] = s[i+n][j];
        m[3][i][j] = s[i+n][j+n];
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

  public static void main(String...args) {
    MatrixMul m = new MatrixMul();

    int [][] a = new int[4][4];
    
    int [][] b = {{5,6,7,8},{10,12,14,16},{15,18,21,24},{20,24,28,32}};

    int [][] c = {{5,10,15,20},{6,12,18,24},{7,14,21,28},{8,16,24,32,40}};

    int [][] d = new int[4][4];

    int [][][] f = new int[4][4][4];
    f[0] = a;
    f[1] = b;
    f[2] = c;
    f[3] = d;

    int [][] x = {{1,2},{3,4}};
    int [][] y = {{5,6},{7,8}};

    int [][] z = m.divideConq(x,y);

    for(int i = 0; i < z.length; ++i) {
      for (int j = 0; j < z.length; ++j) {
        System.out.printf("%2d ", z[i][j]);
      }
      System.out.println();
    }

    System.out.println();

    z = m.classic(x,y);

    for(int i = 0; i < z.length; ++i) {
      for (int j = 0; j < z.length; ++j) {
        System.out.printf("%2d ", z[i][j]);
      }
      System.out.println();
    }

    System.out.println();

    z = m.strassen(b,c);

    for(int i = 0; i < z.length; ++i) {
      for (int j = 0; j < z.length; ++j) {
        System.out.printf("%2d ", z[i][j]);
      }
      System.out.println();
    }

  }

}
