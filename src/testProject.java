import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class testProject {
    static Scanner scanner = new Scanner(System.in);
    public static int result;

    public static void main(String[] args) {
        helloCalculator();
        String viraz = scanner.nextLine(); //Ввод выражения типа строка
        String[] array = viraz.split(" "); //Сплитим строку на части в массив
        String firstValue = array[0]; //Достаём первое число из массива
        String lastValue = array[2]; //Достаём второе число из массива
        InputParser inputParser = new InputParser();
        Calculate calculate = new Calculate(); //Инициируем класс Calculate
        String operator = array[1]; //Обозначаем оператор

        if( inputParser.isArab(firstValue) && inputParser.isArab(lastValue) ) {
            System.out.println("Выражение с арабскими цифрами.");
            calculate.arabCalculate(valueOf(firstValue), valueOf(lastValue), operator); //Используем метод calculate из класса Calculate
        } else if( inputParser.isRoman(firstValue) && inputParser.isRoman(lastValue) ) { //Почему тут нет кальк
            calculate.romanCalculate(firstValue,lastValue, operator);
            // Нам нужно калькулировать римские цифры в арабские, сделать вычисление, после чего перекальькулировать обратно.
            // Выдать результат и если число меньше 1, то выдать false
            System.out.println("Выражение с римскими цифрами.");
        } else {
            System.out.println("Неверно введено выражение.");
        }
    }

    public static void helloCalculator(){
        System.out.println("Привет, я калькулятор.");
        System.out.println("Я могу работать с римскими и арабскими числами, в диапазон 1 - 10.");
        System.out.println("Ввод примера должен иметь вид \"5 + 5\" или же \"V + V\". ");
        System.out.println("Давай сделаем это!");
        System.out.print("Введи пример: ");
    }

}




























