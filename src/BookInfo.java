import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

    public void searchByID(Map<Integer,String> bookID,
                       LinkedList<String> title,
                       LinkedList<String> author,
                       LinkedList<Integer> year) throws IOException {
        System.out.println("Введите ID");
        id = Integer.parseInt(reader.readLine());
        if(bookID.containsKey(id)){
            System.out.println("Автор: " + author.get(title.indexOf(bookID.get(id)))+
                    "\nКнига: " + bookID.get(id) +
                    "\nГод: " + year.get(title.indexOf(bookID.get(id))));
        }

    }


}
