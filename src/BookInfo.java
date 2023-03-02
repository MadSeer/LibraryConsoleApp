import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class BookInfo {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String author;
    String title;
    int year;
    int id;

    public Map<Integer, BookModel> createDatabase(Map<Integer, BookModel> bookModel) {
        while (bookModel.size() < 20) {
            BookModel book = new BookModel();
            book.title = "Книга " + (bookModel.size() + 1);
            book.author = "Автор " + (1 + bookModel.size() % 3);
            book.year = 2000 + bookModel.size() % 5;
            bookModel.put(bookModel.size(), book);
        }
        return bookModel;
    }

    public void create(Map<Integer, BookModel> bookModel) throws IOException {

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
    }

    public void display(Map<Integer, BookModel> bookModel) {
        for (int i = 0; i < bookModel.size(); i++) {
            BookModel book;
            book = bookModel.get(i);
            if (bookModel.containsKey(i))
                System.out.println(i + ". " + book.author + " \"" + book.title + "\" " + book.year + ".г");
        } //Это костыль, я хз как тут использовать правильно foreach.
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
        List<BookModel> models;
        System.out.println("Введите имя автора");
        author = reader.readLine();
        models = bookID.values().stream().filter(bookModel -> bookModel.author.equals(author)).toList();
        if (!models.isEmpty()) {
            models.forEach(i -> System.out.println("Книга: " + i.title + " Год:" + i.year));
        } else System.out.println("По Вашему запросу ничего не найдено");
    }

    public void searchByYear(Map<Integer, BookModel> bookID) throws IOException {
        List<BookModel> models;
        System.out.println("Введите год издания");
        year = Integer.parseInt(reader.readLine());
        models = bookID.values().stream().filter(bookModel -> bookModel.year == year).toList();
        if (!models.isEmpty()) {
            models.forEach(i -> System.out.println("Книга: " + i.title + " Автор: " + i.author));
        } else System.out.println("По Вашему запросу ничего не найдено");
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

    public void createTXT(Map<Integer, BookModel> bookID) throws IOException {
        FileWriter writer = new FileWriter("Library.txt", true);
        List<BookModel> model = bookID.values().stream().toList();
        for (BookModel book : model
        ) {
            writer.write(book.author + " \"" + book.title + "\" " + book.year + ".г");
            writer.append("\r\n");
        }
        writer.flush();
        writer.close();
    }

    public void edit(Map<Integer, BookModel> bookID) throws IOException {
        System.out.println("Введите ID книги, которую вы хотите редактировать");
        id = Integer.parseInt(reader.readLine());
        BookModel model = bookID.get(id);
        System.out.println("""
                Что Вы хотите изменить?
                1. Название
                2. Автор
                3. Год
                Другая клавиша - главное меню
                """);
        String changeMenu = reader.readLine();
        switch (changeMenu) {
            case ("1") -> {
                System.out.println("Старое название \"" + model.title + "\", введите новое");
                model.title = reader.readLine();
            }
            case ("2") -> {
                System.out.println("Старый автор \"" + model.author + "\", введите нового");
                model.author = reader.readLine();
            }
            case ("3") -> {
                System.out.println("Старый год издания \"" + model.year + "\", введите новый");
                model.year = Integer.parseInt(reader.readLine());
            }
            default -> System.out.println("Возврат в главное меню");
        }
        bookID.put(id, model);
    }

}
