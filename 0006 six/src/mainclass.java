/**
 * Created by LindXdeep on 08.01.2018.
 */
class mainclass {
    public static void main(String[] args) {
       System.out.println("Hello World!");

       Cat a1 = new Cat("barsic", "red", 5 );

       System.out.println(a1.name + " " + a1.color);
       a1.show();
    }
}
