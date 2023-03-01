import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookInfo {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String author;
    String title;
    int year;
    int id;

    public Map<Integer, BookModel> createDatabase(Map<Integer, BookModel> bookModel){
        BookModel book = new BookModel();
        while(bookModel.size()<20){
            book.title="Книга " + (bookModel.size()+1);
            book.author="Автор " + (1+bookModel.size()%3);
            book.year=2000+bookModel.size()%5;
            bookModel.put(bookModel.size(),book);
        }
        return bookModel;
    }

    public Map<Integer, BookModel> create(Map<Integer,BookModel> bookModel) throws IOException {

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

        bookModel.put(bookModel.size(),book);
        return bookModel;
    }

    public void display(Map<Integer,BookModel> bookModel){
        BookModel book = new BookModel();
        for (int i = 0; i < bookModel.size();i++) {
            book = bookModel.get(i);
            System.out.println(i + ". " + book.author + " \"" + book.title + "\" " + book.year + ".г");
        }
    }
    
    public void searchByID(Map<Integer, String> bookID,
                           LinkedList<String> titleList,
                           LinkedList<String> authorList,
                           LinkedList<Integer> yearList) throws IOException {
        System.out.println("Введите ID");
        id = Integer.parseInt(reader.readLine());
        if (bookID.containsKey(id)) {
            System.out.println("Автор: " + authorList.get(titleList.indexOf(bookID.get(id))) +
                    "\nКнига: " + bookID.get(id) +
                    "\nГод: " + yearList.get(titleList.indexOf(bookID.get(id))));
        }


    }

    public void searchByAuthor(LinkedList<String> titleList,
                               LinkedList<String> authorList,
                               LinkedList<Integer> yearList) throws IOException {
        System.out.println("Введите имя автора");
        //Поиск всех вхождений в список я спиздил
        //https://www.techiedelight.com/ru/find-all-occurrences-of-value-list-java/
        author = reader.readLine();
        List<Integer> indices;
        indices = IntStream.range(0, authorList.size())
                .filter(i -> Objects.equals(authorList.get(i), author))
                .boxed().collect(Collectors.toList());
        //Тут либо так, либо ебейший пердолинг с перебрасыванием
        //значений между списками. Прошу не пиздить ссаными тряпками
        if (authorList.contains(author)) {
            System.out.println("Автор: " + author);
            System.out.println("Книги: ");
            for (int index : indices
            ) {
                System.out.print(titleList.get(index) + "|");
            }
            System.out.println("\n");
            System.out.println("Год написания: ");
            for (int index : indices
            ) {
                System.out.print(yearList.get(index) + "|");
            }
            System.out.println("\n");
        }
    }

    public void searchByYear(LinkedList<String> titleList,
                             LinkedList<String> authorList,
                             LinkedList<Integer> yearList) throws IOException {
        System.out.println("Введите год написания книги");
        //Поиск всех вхождений в список я спиздил
        //https://www.techiedelight.com/ru/find-all-occurrences-of-value-list-java/
        year = Integer.parseInt(reader.readLine());
        List<Integer> indices;
        indices = IntStream.range(0, yearList.size())
                .filter(i -> Objects.equals(yearList.get(i), year))
                .boxed().collect(Collectors.toList());
        //Тут либо так, либо ебейший пердолинг с перебрасыванием
        //значений между списками. Прошу не пиздить ссаными тряпками
        if (yearList.contains(year)) {
            System.out.println("Год написания: " + year);

            System.out.println("Авторы: ");
            for (int index : indices
            ) {
                System.out.print(authorList.get(index) + "|");
            }
            System.out.println("\n");

            System.out.println("Книги: ");
            for (int index : indices
            ) {
                System.out.print(titleList.get(index) + "|");
            }
            System.out.println("\n");
        }
    }

    public void searchByTitle(LinkedList<String> titleList,
                              LinkedList<String> authorList,
                              LinkedList<Integer> yearList) throws IOException {
        System.out.println("Введите название книги");
        //Поиск всех вхождений в список я спиздил
        //https://www.techiedelight.com/ru/find-all-occurrences-of-value-list-java/
        title = reader.readLine();
        List<Integer> indices;
        indices = IntStream.range(0, titleList.size())
                .filter(i -> Objects.equals(titleList.get(i), title))
                .boxed().collect(Collectors.toList());
        //Тут либо так, либо ебейший пердолинг с перебрасыванием
        //значений между списками. Прошу не пиздить ссаными тряпками
        if (titleList.contains(title)) {
            System.out.println("Книга: " + title);
            System.out.println("Автор: ");
            for (int index : indices
            ) {
                System.out.print(authorList.get(index) + "|");
            }
            System.out.println("\n");

            System.out.println("Год написания: ");
            for (int index : indices
            ) {
                System.out.print(yearList.get(index) + "|");
            }
            System.out.println("\n");
        }
    }

    public void deleteByID(Map<Integer, String> bookID,
                           LinkedList<String> titleList,
                           LinkedList<String> authorList,
                           LinkedList<Integer> yearList) throws IOException {
        System.out.println("Введите ID книги которую желаете удалить");
        id = Integer.parseInt(reader.readLine());
        authorList.remove(titleList.indexOf(bookID.get(id)));
        yearList.remove(titleList.indexOf(bookID.get(id)));
        titleList.remove(titleList.indexOf(bookID.get(id)));
        bookID.remove(id);
    }

}
