public class Calculation {

    public  static int Calculation(int x, int y, String sign){
        int result = -1000000000;
        if(x>10 || y>10|| x<1 || y<1){
            throw new IllegalArgumentException("Недопустимые значения");
        }
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
