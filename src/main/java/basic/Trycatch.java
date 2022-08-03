package basic;

public class Trycatch {

    public static int mechod1(){
        int number = 0;
        try {
            number++;
            int nu = 0/0;
            return 1;
        }catch (Exception e){
            System.out.println("catch 执行");
             return 2;
        }finally {
            System.out.println("finally 执行");
            number++;
            return 12;
        }
    }


    public static void main(String[] args) {
      int number =   Trycatch.mechod1();
      System.out.println(number);
    }
}
