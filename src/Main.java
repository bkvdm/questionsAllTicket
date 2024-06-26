import java.util.*;
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

    // простое решение
    public String[] split(String str) {
        return str.split("\\s+");
    }

    // сложное решение
    private static String[] splitDifficult(String input) { // Начало метода split, который принимает строку input в качестве аргумента и возвращает массив строк.
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

    //Билет №5. Как отсортировать коллекцию элементов?
    List<Student> students = Collections.sort(students, Comparator.comparing(Student::getAge)); // Сортировка по возрасту

    private Object Student;
    List<Student> sorted = students.stream()
            .sorted(Comparator.comparing(Student::getName))
            .collect(Collectors.toList()); // Сортировка по имени

//Задача
//Напишите методы Equals and HashCode для класса Student,
// который состоит из полей String name и int age.

    public class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Геттеры и сеттеры опущены для краткости

        @Override
        public boolean equals(Object o) {
            // Если объект сравнивается сам с собой, он точно равен
            if (this == o) return true;
            // Если объект null или классы разные, объекты точно не равны
            if (o == null || getClass() != o.getClass()) return false;
            // Приведение типа и сравнение полей
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            // Использование стандартного метода из класса Objects для генерации хэш-кода
            return Objects.hash(name, age);
        }
    }
    //Билет №6.
    //В этом примере пытаемся выполнить деление на ноль,
    // что приводит к генерации `ArithmeticException`.
    // Ошибка перехватывается блоком `catch` и
    // обрабатывается путем вывода сообщения об ошибке на консоль.

    public class ExceptionExample {

        public static void main(String[] args) {
            try {
                int result = divide(10, 0);
                System.out.println("Результат деления: " + result);
            } catch (ArithmeticException e) {
                System.err.println("Произошла ошибка: " + e.getMessage());
                // Ошибка: / by zero
            }
        }

        public static int divide(int a, int b) {
            return a / b; // Может привести к ArithmeticException в случае b == 0
        }
    }

    //Билет №7.
    //Есть таблица book с колонками name и author_id и
    // таблица author с колонками id и name.
    // Вывести все книги определенного автора (author.name).
    //
    // Чтобы вывести все книги определенного автора
    // (пусть, например, автор будет "Достоевский"), необходимо выполнить SQL запрос,
    // который выполнит соединение таблиц `book` и `author` и
    // отфильтрует результаты по имени автора:
//    SELECT b.name, b.year
//    FROM book b
//    JOIN author a ON b.author_id = a.id
//    WHERE a.name = 'Достоевский';

    // Билет №8. Напишите пример перехвата и обработки исключения
    // с использованием собственных исключений."
    // В этом примере создается пользовательское исключение `MyException`,
    // которое наследуется от `Exception`. Метод `test` генерирует `MyException`,
    // если его аргумент меньше нуля. В методе `main` вызывается метод `test`,
    // и возможное исключение перехватывается и обрабатывается в блоке `try-catch`.

    class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }

    public class TestExceptionHandling {
        public static void test(int value) throws MyException {
            if (value < 0) {
                throw new MyException("Значение не должно быть меньше нуля");
            }
            System.out.println("Значение корректно: " + value);
        }

        public static void main(String[] args) {
            try {
                test(-1);
            } catch (MyException e) {
                System.err.println("Перехвачено пользовательское исключение: " + e.getMessage());
            }
        }
    }

    //Билет №9. Пример обработки нескольких исключений в одном блоке catch
    //В этом примере демонстрируется обработка двух типов исключений
    // `ArithmeticException` и `ArrayIndexOutOfBoundsException`
    // в одном блоке `catch`. Такая возможность появилась в Java 7 и
    // позволяет более компактно обрабатывать множество исключений,
    // когда логика их обработки идентична.
    public class MultipleExceptionsHandling {
        public static void main(String[] args) {
            try {
                int a = args.length;
                int b = 10 / a;
                int[] c = {1};
                System.out.println(c[a]);
            } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //Билет №10. Дан массив строк, необходимо удалить из него все дубли,
    // оставшиеся строки объединить в одну в порядке следования в массиве.
    //В этом примере для устранения дубликатов и сохранения исходного порядка элементов
    // используется `LinkedHashSet`.
    // Это позволяет легко добавлять элементы, автоматически исключая дубли,
    // и затем объединять оставшиеся уникальные строки в одну.

    public class UniqueStringConcatenator {
        public static void main(String[] args) {
            String[] array = {"Java", "Python", "Java", "C", "Python", "Java"};
            // Используем LinkedHashSet для сохранения уникальности и порядка элементов
            Set<String> uniqueElements = new LinkedHashSet<>();
            for (String element : array) {
                uniqueElements.add(element);
            }
            // Объединяем оставшиеся элементы в одну строку
            String result = String.join("", uniqueElements);
            System.out.println(result);
        }
    }

    // Билет №11. Дан массив пар названий книг и авторов,
    // необходимо привести каждую пару в строку вида:
    // «Название книги» Имя Отчество Фамилия автора.
    // В этом решении мы имеем дело с двумерным массивом `String`,
    // где каждый вложенный массив состоит из двух строк:
    // название книги и полное имя автора.
    // Затем мы просто проходимся по массиву и форматируем строки согласно заданию.
    public class BookPairsToString {
        public static void main(String[] args) {
            String[][] bookAuthorPairs = {
                    {"Война и мир", "Лев Николаевич Толстой"},
                    {"Преступление и наказание", "Федор Михайлович Достоевский"}
            };

            for (String[] pair : bookAuthorPairs) {
                String bookTitle = pair[0];
                String authorName = pair[1];
                System.out.println("«" + bookTitle + "» " + authorName);
            }
        }
    }
}