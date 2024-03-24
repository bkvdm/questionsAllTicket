import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Билет №1
        // Решение №1
        List<String> names = new ArrayList<>(List.of("ZСевастополь", "ZЛуганск", "ZДонецк"));
        List<String> namesOne = new ArrayList<>();
        for (String name : names) {
            namesOne.add(name.substring(1));
        }
        Collections.sort(namesOne);
        System.out.println("namesOne = " + namesOne);

// Решение №2
        List<String> namesTwo = new ArrayList<>();
        names.forEach(name -> namesTwo.add(name.substring(1)));
        Collections.sort(namesTwo);

        System.out.println("namesTwo = " + namesTwo);

// Решение №3
        List<String> namesThree = names.stream()
                .map(name -> name.substring(1))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("namesThree = " + namesThree);
    }

    // Билет №2. Напишите программу, которая проверяет, является ли строка палиндромом.

    private static boolean isPalindrome(String str) {
        str = str.toLowerCase(); // Строка кода приводит строку str к нижнему регистру.
        int left = 0; // Создает переменную left и инициализирует ее значением 0.
        int right = str.length() - 1; // Строка создает переменную right и инициализирует ее длиной строки str минус 1.

        while (left <= right) { // Цикл while выполняется до тех пор, пока левая граница меньше или равна правой границе.
            if (str.charAt(left) == str.charAt(right)) { // Проверяет, равны ли символы в строке str на левой и правой границе.
                left++; // Увеличивает значение переменной left на 1.
                right--; // Уменьшает значение переменной right на 1.
            } else {
                return false; // Возвращает false, если условие в операторе if не выполняется.
            }
        }
        return true; // Возвращает true, если достигнут конец метода и ни одно из условий не вернуло false.
    }

    // Билет №3. Напишите код, с помощью которого можно перевернуть массив.

    private static String[] split(String input) { // Начало метода split, который принимает строку input в качестве аргумента и возвращает массив строк.
        if (input == null || input.trim().isEmpty()) { // Строка проверяет, является ли входная строка null или пустой.
            return new String[0];
        } else {
            String[] parts = input.split("\\s+"); // Разбивает входную строку на массив строк, используя регулярное выражение "\s", которое соответствует пробелам.
            for (int i = 0; i < parts.length; i++) { // Цикл выполняется для каждого элемента в массиве parts.
                if (parts[i].trim().isEmpty()) { // Убирает пробелы в начале и в конце входной строки и проверяет, пуста ли она.
                    if (i == 0) {
                        return new String[]{""}; // Если входная строка пустая или null, то возвращается массив из одной пустой строки.
                    } else { // Если входная строка не пустая и не null, выполняется блок кода в ветке else.
                        String[] newParts = new String[parts.length - 1]; // Объявляет переменную parts как массив строк и инициализирует его входной строкой.
                        // System.arraycopy - это статический метод класса System,
                        // который используется для копирования одного массива в другой.
                        // Он принимает следующие параметры: исходный массив,
                        // индекс исходного массива, целевой массив и целевой индекс,
                        // а также количество элементов для копирования.
                        System.arraycopy(parts, 0, newParts, 0, i);
                        // Копируются элементы исходного массива parts, начиная с индекса 0
                        // (т.е. первый элемент) в целевой массив newParts, также начиная с индекса 0,
                        // и количество копируемых элементов равно i (т.е. копируется только текущий элемент).
                        System.arraycopy(parts, i + 1, newParts, i, parts.length - i - 1);
                        // Копируются элементы из исходного массива parts, начиная с индекса i + 1
                        // (т.е. все элементы, кроме текущего), в целевой массив newParts,
                        // начиная с текущего индекса i, и количество копируемых элементов рассчитывается
                        // как длина исходного массива parts минус текущий индекс i минус 1
                        // (это означает, что копируется все оставшиеся элементы исходного массива).
                        return newParts;
                    }
                }
            }
        }
        return input.split(Pattern.quote(""));
        // Разбивает строку input на массив подстрок с использованием регулярного выражения Pattern.quote(“”),
        // которое представляет собой строку, заключенную в кавычки.
        // Метод split() принимает регулярное выражение в качестве аргумента и разбивает исходную строку в соответствии с этим регулярным выражением.
        // То есть, разбивает строку на подстроки, используя в качестве разделителя пустую строку.
        // Нужно, для того, чтобы получить массив подстрок,
        // соответствующих отдельным словам в исходной строке.
    }

    // Билет №4. Напишите код, с помощью которого можно перевернуть массив.
    public static void reverse(Object[] arr) {
        int len = arr.length; // Получаем длину массива arr, которая сохраняется в переменной len.
        Object[] reversed = new Object[len]; // Создаем новый массив объектов reversed, размер которого равен длине исходного массива.
        // Цикл используется для переворачивания массива.
        // Начинаем с индекса 0 и идем до середины массива (len / 2).
        // На каждой итерации меняем местами элементы исходного массива на
        // противоположных позициях относительно середины массива.
        for (int i = 0; i < len / 2; i++) {
            reversed[i] = arr[len - 1 - i];
            reversed[len - i - 1] = arr[i];
        }
        // Проверяем является ли длина массива нечетной.
        // Если да, то мы сохраняем центральный элемент на своем месте,
        // в противном случае тоже переворачиваем.
        if (len % 2 == 1) {
            reversed[(len - 1) / 2] = arr[(len - 1) / 2];
        }
        arr = reversed; // Заменена оригинального массива arr на перевернутый reversed.
    }

    // ... или сделать возвращаемый метод.
    public static class ReversedArray {
        private Object[] original;
        private Object[] reversed;

        public ReversedArray(Object[] array) {
            this.original = array;
            this.reversed = new Object[array.length];
            for (int i = 0; i < array.length / 2; i++) {
                reversed[i] = array[array.length - 1 - i];
                reversed[array.length - i - 1] = array[i];
            }
            if (array.length % 2 == 1) {
                reversed[(array.length - 1) / 2] = array[(array.length - 1) / 2];
            }
        }

        public Object[] getReversed() {
            return reversed;
        }
    }
}