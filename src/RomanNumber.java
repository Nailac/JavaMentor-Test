import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Integer.valueOf;

public class RomanNumber {
    private final static TreeMap< Integer, String > romanString = new TreeMap<>();
    static {
        romanString.put(1, "I");
        romanString.put(4, "IV");
        romanString.put(5, "V");
        romanString.put(9, "IX");
        romanString.put(10, "X");
        romanString.put(40, "XL");
        romanString.put(50, "L");
        romanString.put(90, "XC");
        romanString.put(100, "C");
    }


    public int romanToArab(String romanNumber){

        HashMap<String, String> roman = new HashMap<String, String>();
        roman.put("I", "1");
        roman.put("II", "2");
        roman.put("III", "3");
        roman.put("IV", "4");
        roman.put("V", "5");
        roman.put("VI", "6");
        roman.put("VII", "7");
        roman.put("VIII", "8");
        roman.put("IX", "9");
        roman.put("X", "10");

        String stringArab = roman.get(romanNumber);
        int arab = valueOf(stringArab);

        return arab;
    }

    private static int letterToNumber(char letter) { //Превращаем отдельную букву в число

        int result = -1; //Значени поумолчанию, которое обозначает отсутсвие соответствия конкретной буквы к числу
        //Например: При вводе буквы A метод вернёт значение -1
        for (Map.Entry < Integer, String > entry: romanString.entrySet()) {  //Перебираем массив romanString
            if (entry.getValue().equals(String.valueOf(letter))) {
                result = entry.getKey(); // Назначаем новое значение для result: ключ соответствующий значение буквы в массиве romanString
            }
        }
        return result; //Возвращаем результат
    }

    static int toArabicNumber(String roman) throws Exception {
        int result = 0;

        int i = 0;// IV = 4
        while (i < roman.length()) { //Максимальное значение длинны String (например: IV) -1. Например, если длинна данного String равна двум,
            //то максимальное значение i = 1
            char letter = roman.charAt(i); // Получаем букву на позиции данного цикла (Например: при введении слова Дима, когда i = 2, то нам вывдаст "м")
            int num = letterToNumber(letter); // Превращаем букву в цифру

            if (num < 1) throw new Exception("Неверный римский символ"); //Если цифра меньше 1, то вернём ошибку

            i++;
            if (i == roman.length()) { //Если римская цифра состоит из 1 буквы, то result будет равен значению этой буквы в арабском варианте
                result += num;
            }else { //Если римское число состтоит из 2 букв и более
                int nextNum = letterToNumber(roman.charAt(i));
                if(nextNum > num) { //Если следующая по циклу римская цифра больше, чем предыдущая, то
                    result += (nextNum - num);// мы отнимаем от значения следующей римской цифры значение нынешней
                    i++;
                }
                else result += num; //Если же нет, то идёт обычное сложение двух значений римских цифр
                //Пример: При вводе значение IV от V отнимается I  и на выводе получаем 4
                //Пример: При вводе значения III все три буквы I будут сложены и на выводе получаем 3
            }
        }
        return result;
    }

    static String arabToRoman(int number) {


        int i = romanString.floorKey(number); // Получаем самое близкое вниз по значению key

        if (number == i) { //Если i равен введённому числу, то вернём число в его форме
            return romanString.get(number);
        }
        return romanString.get(i) + arabToRoman(number - i); //Если же нет, то вызываем заново эту же фунцию (рекурсия) и прибавляем получившийся результат к результату заново вызванной функции
    }
}

