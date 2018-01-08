/**
 * Created by LindXdeep on 02.01.2018.
 */

package linder.igor;

class MainClass {
    public static void main(String[] args)
    {
        System.out.println("Lesson one");

        byte a = 8;
        short b = 1234;
        int c = 12345;
        long d = 1234567890L;
        float e = 123.345f;
        double f = 2.345d;
        boolean g = true;
        char h ='q';

        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h);

        System.out.println( calc(9,4,5,6) );

        System.out.println( inscope(5,3) );
        System.out.println( inscope(5,23) );
        System.out.println( inscope(10,5) );

        nowyear(0);
        nowyear(1);
        nowyear(4);
        nowyear(8);
        nowyear(100);
        nowyear(200);
        nowyear(300);
        nowyear(400);
        nowyear(500);
    }

    public static int calc(int a, int b, int c, int d)
    {
        return a * (b+(c/d));
    }

    public static boolean inscope(int x, int y)
    {
        if( (x+y) > 10 && (x+y) < 20)
            return true;
        return false;
    }

    public static void nowyear(int year)
    {
        if(year <= 0 )
            return;

        if( ((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0)
        {
            System.out.println( "Leap" );
            return;
        }
        System.out.println( "Non-leap" );
    }
}























