import java.util.Arrays;
import java.util.Scanner;

/**
 * Общая логика работы программы такова:
 * 1. В методе `main` выводится сообщение пользователю с запросом ввода примера.
 * 2. С помощью объекта `Scanner` читается введенная пользователем строка и сохраняется в переменную `in`.
 * 3. В методе `calk` строка `in` разбивается на массив строк `input`, используя пробел как разделитель.
 * 4. Проверяется, что массив `input` содержит не более трех элементов (два операнда и один оператор). Если это не так, бросается исключение.
 * 5. Проверяется, являются ли оба операнда арабскими числами от 1 до 10 или римскими числами от I до X. Если это не так, бросается исключение.
 * 6. Если оба операнда являются арабскими числами, они преобразуются в тип int с помощью метода parseInt() класса Integer.
 * 7. Если оба операнда являются римскими числами, они находятся в массиве строк rome1 с помощью метода indexOf(), после чего их индексы сохраняются в переменные типа int.
 * 8. Вызывается метод result(), который вычисляет результат арифметической операции в зависимости от выбранного оператора.
 * 9. Если первый операнд арабский, результат операции преобразуется в строку с помощью метода toString() класса Integer.
 * 10. Если первый операнд римский, результат операции находится в массиве строк rome1 и сохраняется в качестве строки.
 * 11. Если результат операции меньше 1, бросается исключение, так как в римской системе нет нуля и отрицательных чисел.
 * 12. Результат операции выводится на экран в методе main.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите пример"); // выводим сообщение пользователю
        Scanner scn = new Scanner(System.in); // создаем объект класса Scanner для чтения данных из консоли
        String in = scn.nextLine(); // читаем данные из консоли и сохраняем в переменную in
        System.out.println("Равно " + calculator(in)); // вызываем функцию calculator(), передавая ей введенный пользователем пример, и выводим результат на экран
    }

    public static String calculator(String in) throws Exception {
        String[] input = in.split(" "); // разбиваем строку на массив строк, используя пробел как разделитель
        String x = input[0]; // записываем первый элемент массива в переменную x
        String y = input[2]; // записываем третий элемент массива в переменную y
        String i = input[1]; // записываем второй элемент массива (оператор) в переменную i
        char i1 = i.charAt(0); // получаем первый символ строки, содержащей оператор, и сохраняем его в виде символа
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}; // создаем массив строк, содержащий арабские числа от 1 до 10
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; // создаем массив строк, содержащий римские числа от I до X
        // создаем массив строк, содержащий римские числа от 1 до 100
        String[] rome1 = {null, "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int x1;
        int y1;
        if (input.length > 3) { // если массив input содержит больше трех элементов, бросаем исключение
            throw new Exception("Два операнда один оператор");
        } else {
            if (Arrays.asList(arab).contains(x) && Arrays.asList(arab).contains(y)) { // проверяем, являются ли оба числа арабскими
                x1 = Integer.parseInt(x); // переводим строку в число и сохраняем в переменную x1
                y1 = Integer.parseInt(y); // переводим строку в число и сохраняем в переменную y1
            } else {
                if (Arrays.asList(rome).contains(x) && Arrays.asList(rome).contains(y)) { // проверяем, являются ли оба числа римскими
                    x1 = Arrays.asList(rome1).indexOf(x); // находим индекс числа x в массиве rome1 и сохраняем в переменную x1
                    y1 = Arrays.asList(rome1).indexOf(y); // находим индекс числа y в массиве rome1 и сохраняем в переменную y1
                } else {
                    throw new Exception("Разные системы исчисления или числа на вход больше 10"); // если числа не соответствуют ни арабской, ни римской системе исчисления, бросаем исключение
                }
            }
        }
        String resultOut;
        if (Arrays.asList(arab).contains(x)) { // если первое число арабское
            resultOut = Integer.toString(result(x1, y1, i1)); // вызываем функцию result() для вычисления результата и преобразуем его в строку
            return resultOut; // возвращаем результат
        } else {
            if (Arrays.asList(rome).contains(x)) { // если первое число римское
                resultOut = rome1[result(x1, y1, i1)]; // вызываем функцию result() для вычисления результата и сохраняем его в виде строки с римским числом
                if (result(x1, y1, i1) < 1) { // если результат меньше 1, бросаем исключение, так как в римской системе нет нуля и отрицательных чисел
                    throw new Exception("В римской системе нет нуля и отрицательных чисел");
                } else {
                    return resultOut; // возвращаем результат
                }
            }
        }
        return null;
    }

    public static int result(int x1, int y1, char i1) throws Exception { // функция для вычисления результата арифметической операции
        int result;
        switch (i1) { // выбираем операцию в зависимости от символа оператора
            case '+':
                result = x1 + y1;
                break;
            case '-':
                result = x1 - y1;
                break;
            case '*':
                result = x1 * y1;
                break;
            case '/':
                result = x1 / y1;
                break;
            default:
                throw new Exception("Операция не распознана. Повторите ввод."); // если оператор не распознан, бросаем исключение
        }
        return result; // возвращаем результат
    }
}