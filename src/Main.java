import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BookInfo book = new BookInfo();
        LinkedList<String> authors = new LinkedList<>();
        LinkedList<String> titles = new LinkedList<>();
        LinkedList<Integer> years = new LinkedList<>();
        BookModel books = new BookModel();
        Map<Integer,BookModel> bookID = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Желаете подключить тестовую базу данных?(д/н)");
        String testmode = reader.readLine();
        if (testmode.equals("д") || testmode.equals("y")) {
            bookID = book.createDatabase(bookID);
        }


        boolean exit = false;
        do {

            System.out.println(
                    """
                            Что Вы хотите сделать?
                            1. Добавить книгу
                            2. Вывести всю информацию (ПОКА ЧТО ГОВНО)
                            3. Поиск по ID
                            4. Поиск по автору\s
                            5. Поиск по годам
                            6. Поиск по названию (Нужно добавить вывод ID)
                            7. Удаление по ID (Нужно тестировать)
                            0. Выйти из программы
                            """);

            String menu = reader.readLine();

            switch (menu) {
                case "1" -> book.create(bookID);
                case "2" -> book.display(bookID);
                case "3" -> book.searchByID(bookID);
                case "4" -> book.searchByAuthor(titles,authors,years);
                case "5" -> book.searchByYear(titles,authors,years);
                case "6" -> book.searchByTitle(titles,authors,years);
                //case "7" -> book.deleteByID(bookID,titles,authors,years);
                case "0" -> exit = true;
                default -> System.out.println("Вы ввели неправильное значение") ;
            }
        } while (!exit);
    }
}