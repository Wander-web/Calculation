import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static boolean IS_ROMAN = false;

    public static void main(String[] args){
        /*String s = "12 + 4";
        String[] argument = s.split("\\s+");

        for(String arg:argument){
            System.out.println(arg);
        }*/

        int result = -100000;
        System.out.print("Введите выражение:");
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        String[] arguments = expression.split("\\s+");


        String regex = "^(?=[MDCLXVI])M*D?C{0,4}L?X{0,4}V?I{0,4}$";
        Pattern pattern = Pattern.compile(regex);


        if(arguments.length!=3){
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            //System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }



        Matcher matcher_1 = pattern.matcher(arguments[0]);
        Matcher matcher_2 = pattern.matcher(arguments[2]);

        if(matcher_1.matches()&matcher_2.matches()){
            IS_ROMAN=true;
        } else if (!matcher_1.matches()&!matcher_2.matches()){
            IS_ROMAN=false;
        } else{
            throw new IllegalArgumentException("используются одновременно разные системы счисления");
            //System.out.println("используются одновременно разные системы счисления");
        }

        if(IS_ROMAN){
            result = Calculation.Calculation(Convert.romanToArabic(arguments[0]), Convert.romanToArabic(arguments[2]), arguments[1]);
        } else{
            result = Calculation.Calculation(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[2]), arguments[1]);
        }



        if(App.IS_ROMAN) {
            if (result < 0) {
                throw new IllegalArgumentException("в римской системе нет отрицательных чисел");
                //System.out.println("в римской системе нет отрицательных чисел");
            }
        }

        if(IS_ROMAN){
            String roman_res = Convert.arabicToRoman(result);
            System.out.println("Реузльтат: "+roman_res);
        } else{
            System.out.println("Результат: "+result);
        }

    }
}
