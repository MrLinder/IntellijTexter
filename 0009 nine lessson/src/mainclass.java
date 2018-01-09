/**
 * Created by LindXdeep on 08.01.2018.
 */
public class mainclass {
    public static void main(String args[])
    {
        String habr = "habrhabr";
        char[] habrAsarraychar = {'q', 'q', 'w'};
        byte[] habrAsArrayofbyte = {104, 97, 98, 114, 97, 104, 97, 98, 114};

        System.out.println(habr);
        System.out.println(habrAsarraychar);

        String first = new String();
        String seccond  = new String("test");

        String third = new String(habrAsarraychar);
        String fourth = new String(habrAsArrayofbyte, 0, 4);

        String sixth = new String(new StringBuffer(habr));
        String seventh = new String(new StringBuilder(habr));

        System.out.println(first);
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(sixth);
        System.out.println(seventh);

        String[] animals = {"haski", "morj"};
        String[] food = {"kolbasa", "korj"};

        String results = animals[0].concat(" eat ").concat(food[0]);
        String results1 = animals[1].concat(" eat ").concat(food[1]);

        System.out.println(results);
        System.out.println(results1);

        String habr1 = "habra" + "habr";
               habr1 += ".ru";

        System.out.println(habr1);

        String a = "habra";
        String b  = "habr4";
        String c =  a + b ;
        System.out.println(c);

        String d = new StringBuilder().append(a).append(b).toString();
        System.out.println("builder " + d);

        String str = null;
        str += " habra5";
        str = null;
       // str.concat("s");
        System.out.println(str);

        String[] cars = {"volga", "jiguli", "chaka"};
        String results3 = "in garane stay cars: ";

        for (int i = 0; i < cars.length; i++ )
        {
            if (i != cars.length-1)
                results3 += cars[i] + ", ";
            else
                results3 += cars[i] + ".";
        }

        System.out.println(results3);

        String hello = "hello";
        String habr7  = "habrahabr";
        String delimiter = ", ";

        System.out.println(String.join(delimiter, hello, habr7));

        String str1 = "Строка из букв, цифр 492 и специальных символов %*;№?";
        int length = str1.length();
        System.out.println(length);

        String str2 = "Последний символ в этой строке - о";
        int last = str2.length()-1;
        char ch  = str2.charAt(last);
        System.out.println(ch);


        String str3 = "1 000 000";
        char[] chArray = str3.toCharArray();

        for (int i = 0; i < chArray.length; i++)
        {
            if (chArray[i] == ' ')
                    chArray[i] = '.';
        }

        System.out.println(chArray);

        String s = "www.mysite.com";
        String name = s.substring(4, s.length()-4);
        System.out.println(name);

        String domain = s.substring(4);
        System.out.println(domain);

        String isbn = "978-3-16-148410-0";
        String[] isbnparts = isbn.split("-");
        for (int i = 0; i < isbnparts.length; i ++)
        {
            System.out.print(isbnparts[i] + " / ");
        }
        System.out.println();

        boolean isContains1 = s.contains("mysite.com");
        System.out.println(isContains1);

        isContains1 = s.contains("mysite.ru");
        System.out.println(isContains1);

        boolean isComEnding = s.endsWith("com");
        System.out.println(isComEnding);

        boolean isRuEnding = s.endsWith("ru");
        System.out.println(isRuEnding);

         /*
        boolean isWWW = s.startsWith("www");
        if(isWWW)
            boolean isNameStarts = s.startsWith("my", 4);
        else
            boolean isNameStarts = s.startsWith("my");
        */

        String data = "name:Igor\nsurname:Kolashnikov\nage:14\ntime:14:55";
        String[] lines = data.split("\n");

        for (String line : lines)
        {
            int pos = line.indexOf(":");
            String attributeName = line.substring(0,pos);
            String value = line.substring(pos+1,line.length());
            System.out.println(attributeName + " - " + value);
        }

        String str6 = " Я помню ЧУДНОЕ мгновенье ";

        str = str6.trim();     			            //убрали символы пробела в начале и конце строки
        System.out.println(str6.toLowerCase());	    //я помню чудное мгновенье
        System.out.println(str6.toUpperCase());	    //Я ПОМНЮ ЧУДНОЕ МГНОВЕНЬЕ

        String str7 = "1 000 000 000";
        String newStr = str7.replace(" ", ".");
        System.out.println(newStr);

        String str10 = "Я помню ЧУДНОЕ мгновенье";
        String str20 = "я помню чудное мгновенье";

        System.out.println(str10.equals(str20));                //false //строки не идентичны
        System.out.println(str10.toLowerCase().equals(str20));  // true, строки идентичны после перевода 1 строки в нижний регистр

        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("buffer = " + sb);
        System.out.println("length = " + sb.length());
        System.out.println("capacity = " + sb.capacity());




    }
}
