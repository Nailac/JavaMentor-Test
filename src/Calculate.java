public class Calculate {
    public static int calculate(int firstValue, int lastValue, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = firstValue + lastValue;
                break;
            case "-":
                result = firstValue - lastValue;
                break;
            case "*":
                result = firstValue * lastValue;
                break;
            case "/":
                result = firstValue / lastValue;
                break;
            default:
                throw new RuntimeException("Допустимые символы: +, -, *, /");
        }
        return result;
    }

    public static void arabCalculate(int firstValue, int lastValue, String operator) {
        System.out.println(calculate(firstValue, lastValue, operator));
    }

    public static void romanCalculate(String firstValue, String lastValue, String operator) {
        RomanNumber romanNumber = new RomanNumber();
        // Превратить римскую в арабскую (firstValue)
        int firstNumber = romanNumber.romanToArab(firstValue);
        // Превратить римскую в арабскую (lastValue)
        int lastNumber = romanNumber.romanToArab(lastValue);

        // Произвести вычисления
        int result = calculate(firstNumber, lastNumber, operator);

        // Проверить число на отрицательность(меньше 1)
        if(result < 1) {
            throw new RuntimeException("Ошибка: результат меньше 1");
        }
        // Превратить арабскую в римскую
        String romanString = romanNumber.arabToRoman(result);

        // Вывести ответ
        System.out.println(romanString);
    }

}