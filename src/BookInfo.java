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

    public void create() throws IOException {
        System.out.println("Введите название книги");
        title = reader.readLine();
        System.out.println("Введите автора книги");
        author = reader.readLine();
        System.out.println("Введите год издания книги");
        year = Integer.parseInt(reader.readLine());
        System.out.println("Введите id книги");
        id = Integer.parseInt(reader.readLine());
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
        if (authorList.contains(author)){
            System.out.println("Автор: " + author);
            System.out.println("Книги: ");
            for (int index: indices
                 ) {
                System.out.print(titleList.get(index) + "|");
            }
            System.out.println("\n");
            System.out.println("Год написания: ");
            for (int index: indices
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
        if (yearList.contains(year)){
            System.out.println("Год написания: " + year);

            System.out.println("Авторы: ");
            for (int index: indices
            ) {
                System.out.print(authorList.get(index) + "|");
            }
            System.out.println("\n");

            System.out.println("Книги: ");
            for (int index: indices
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
        if (titleList.contains(title)){
            System.out.println("Книга: " + title);
            System.out.println("Автор: ");
            for (int index: indices
            ) {
                System.out.print(authorList.get(index) + "|");
            }
            System.out.println("\n");

            System.out.println("Год написания: ");
            for (int index: indices
            ) {
                System.out.print(yearList.get(index) + "|");
            }
            System.out.println("\n");
        }
    }


}
