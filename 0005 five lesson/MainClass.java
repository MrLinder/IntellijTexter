/**
 * Created by LindXdeep on 06.01.2018.
 */
public class MainClass {
    public static void main(String args[]) {
        Animals a1 = new Animals();
        Cat c1 = new Cat();

        a1.color = "Brown";
        c1.color = "black";

        c1.name = "barsic";

        a1.ShowColor();

        c1.ShowNameAndColor();
    }
}