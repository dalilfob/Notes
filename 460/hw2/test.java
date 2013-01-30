public class test {
    public static void main(String [] args) {
       int x = 0;
       try {
           x =  Integer.parseInt("D4",16);

       }
       catch (Exception e) {
            System.out.println("fail");
       }

       System.out.printf("%d",x);
    }
}
