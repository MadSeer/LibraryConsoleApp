import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BookInfo book = new BookInfo();
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
                            2. Вывести всю информацию
                            3. Поиск по ID
                            4. Поиск по автору\s
                            5. Поиск по годам
                            6. Поиск по названию
                            7. Удаление по ID
                            8. Создать TXT
                            9. Редактировать запись
                            0. Выйти из программы
                            """);

            String menu = reader.readLine();

            switch (menu) {
                case "1" -> book.create(bookID);
                case "2" -> book.display(bookID);
                case "3" -> book.searchByID(bookID);
                case "4" -> book.searchByAuthor(bookID);
                case "5" -> book.searchByYear(bookID);
                case "6" -> book.searchByTitle(bookID);
                case "7" -> book.deleteByID(bookID);
                case "8" -> book.createTXT(bookID);
                case "9" -> book.edit(bookID);
                case "0" -> exit = true;
                default -> System.out.println("Вы ввели неправильное значение") ;
            }
        } while (!exit);
    }
}