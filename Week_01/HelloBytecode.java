/**
 * @author lixiaobing
 * @date 2020-10-15 20:18
 * @Description:
 */
public class HelloBytecode {
    public static void main(String[] args) {
        boolean bo = true;
        byte    b  = 15;
        short   s  = 233;
        char    c  = 'e';
        int     i  = 10;
        long    l  = 11111L;
        float   f  = 1124.123F;
        double  d  = 123.213;

        byte n = (byte) (c + i);

        int plus     = 10 + 2;
        int minus    = 20 - 1;
        int multiply = 3 * 20;
        int divide   = 17 / 2;

        if (10 + 2 == 12) {
            System.out.println("hello if");
        } else {
            System.out.println("hello else");
        }

        System.out.println("----------------");
        int[] a = new int[]{1, 3, 9};
        for (int i1 : a) {
            System.out.println(i1);
        }
        System.out.println("------------------");
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
        }

    }
}
