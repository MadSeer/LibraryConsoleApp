import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BookInfo book = new BookInfo();
        Map<Integer,String> bookID = new HashMap<>();
        LinkedList<String> authors = new LinkedList<>();
        LinkedList<String> titles = new LinkedList<>();
        LinkedList<Integer> years = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Желаете подключить тестовую базу данных?(д/н)");
        String testmode = reader.readLine();
        if (testmode.equals("д") || testmode.equals("y")) {
            TestDatabase db = new TestDatabase();
            titles = db.createTitleDatabase(titles);
            authors = db.createAuthorDatabase(authors);
            years = db.createYearDatabase(years);
            bookID = db.createIDDatabase(bookID,titles);
        }


        boolean exit = false;
        do {

            System.out.println(
                    """
                            Что Вы хотите сделать?
                            1. Добавить книгу
                            2. Вывести всю информацию (ПОКА ЧТО ГОВНО)
                            3. Поиск по ID
                            4. Поиск по автору
                            5. Поиск по годам
                            6. Поиск по названию
                            0. Выйти из программы
                            """);

            int menu = Integer.parseInt(reader.readLine());

            switch (menu) {
                case 1 -> {
                    book.create();
                    authors.addLast(book.author);
                    titles.addLast(book.title);
                    years.addLast(book.year);
                    bookID.put(book.id, book.title);
                }
                case 2 -> {
                    System.out.println(authors);
                    System.out.println(titles);
                    System.out.println(years);
                }
                case 3 -> book.searchByID(bookID,titles,authors,years);
                case 4 -> book.searchByAuthor(titles,authors,years);
                case 5 -> book.searchByYear(titles,authors,years);
                case 6 -> book.searchByTitle(titles,authors,years);
                case 0 -> exit = true;

            }
        } while (!exit);
    }
}