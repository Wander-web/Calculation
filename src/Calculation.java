public class Calculation {

    public  static int Calculation(int x, int y, String sign){
        int result = -1000000000;
        switch (sign){
            case "+":
                result = x+y;
                break;
            case "-":
                result = x-y;
                break;
            case "*":
                result = x*y;
                break;
            case "/":
                if(y==0){
                    throw new IllegalArgumentException("Ошибка деления на ноль");
                }
                double temp = x/y;
                result = (int) Math.round(temp);
                break;
            default:
                System.out.println("Введена неверная операция");
        }


        return result;
    }
}
