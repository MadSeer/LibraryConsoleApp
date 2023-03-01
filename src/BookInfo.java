import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class BookInfo {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String author;
    String title;
    int year;
    int id;

    public Map<Integer, BookModel> createDatabase(Map<Integer, BookModel> bookModel) {
        BookModel book = new BookModel();
        while (bookModel.size() < 20) {
            book.title = "Книга " + (bookModel.size() + 1);
            book.author = "Автор " + (1 + bookModel.size() % 3);
            book.year = 2000 + bookModel.size() % 5;
            bookModel.put(bookModel.size(), book);
        }
        return bookModel;
    }

    public Map<Integer, BookModel> create(Map<Integer, BookModel> bookModel) throws IOException {

        BookModel book = new BookModel();
        System.out.println("Введите название книги");
        book.title = reader.readLine();
        System.out.println("Введите автора книги");
        book.author = reader.readLine();
        System.out.println("Введите год издания книги");

        boolean yearcheck = true;
        do {
            try {
                book.year = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите число, а не текст");
                continue;
            }
            if (book.year > 0) {
                yearcheck = false;
            } else {
                System.out.println("Вы ввели отрицательный год издания");
            }
        } while (yearcheck);

        bookModel.put(bookModel.size(), book);
        return bookModel;
    }

    public void display(Map<Integer, BookModel> bookModel) {
        BookModel book;
        for (int i = 0; i < bookModel.size(); i++) {
            book = bookModel.get(i);
            System.out.println(i + ". " + book.author + " \"" + book.title + "\" " + book.year + ".г");
        }
    }

    public void searchByID(Map<Integer, BookModel> bookID) throws IOException {

        BookModel book;
        System.out.println("Введите ID");
        id = Integer.parseInt(reader.readLine());
        if (bookID.containsKey(id)) {
            book = bookID.get(id);
            System.out.println("Автор: " + book.author +
                    "\nКнига: " + book.title +
                    "\nГод: " + book.year);
        }

    }

    public void searchByAuthor(Map<Integer, BookModel> bookID) throws IOException {
        BookModel book;
        boolean empty = true;
        System.out.println("Введите имя автора");
        author = reader.readLine();
        for (int i = 0; i < bookID.size(); i++) {
            book = bookID.get(i);
            if (author.equals(book.author)) {
                System.out.println("Книга: " + book.title + " Год:" + book.year);
                empty = false;
            }
        }
        if (empty) System.out.println("По Вашему запросу ничего не найдено");
    }

    public void searchByYear(Map<Integer, BookModel> bookID) throws IOException {
        BookModel book;
        boolean empty = true;
        System.out.println("Введите год издания");
        year = Integer.parseInt(reader.readLine());
        for (int i = 0; i < bookID.size(); i++) {
            book = bookID.get(i);
            if (year == book.year) {
                System.out.println("Книга: " + book.title + " Автор: " + book.author);
                empty = false;
            }
        }
        if (empty) System.out.println("По Вашему запросу ничего не найдено");
    }

    public void searchByTitle(Map<Integer, BookModel> bookID) throws IOException {
        BookModel book;
        boolean empty = true;
        System.out.println("Введите название книги");
        title = reader.readLine();
        for (int i = 0; i < bookID.size(); i++) {
            book = bookID.get(i);
            if (title.equals(book.title)) {
                System.out.println("Автор: " + book.author + " Год издания:" + book.year + " Идентефикатор: " + i);
                empty = false;
            }
        }
        if (empty) System.out.println("По Вашему запросу ничего не найдено");
    }

    public void deleteByID(Map<Integer, BookModel> bookID) throws IOException {
        System.out.println("Введите ID книги которую желаете удалить");
        id = Integer.parseInt(reader.readLine());
        bookID.remove(id);
    }

}
