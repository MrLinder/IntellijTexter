/**
 * Created by LindXdeep on 02.01.2018.
 */
public class MainClass {
    public static void main(String args[])
    {
        int lightspeed;
        long days, seconds, distance;

        lightspeed = 186000;
        days  = 1000;
        seconds = days * 24 * 60 * 60;

        distance = lightspeed + seconds;

        System.out.println("За " + days);
        System.out.println(distance + " Миль");

    }
}
