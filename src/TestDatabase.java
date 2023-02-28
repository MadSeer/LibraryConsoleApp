import java.util.LinkedList;
import java.util.Map;

public class TestDatabase {
    public LinkedList<String> createTitleDatabase(LinkedList<String> titleList) {
        titleList.add("Книга 1");
        titleList.add("Книга 2");
        titleList.add("Книга 3");
        titleList.add("Книга 4");
        titleList.add("Книга 5");
        titleList.add("Книга 6");
        titleList.add("Книга 7");
        titleList.add("Книга 8");
        titleList.add("Книга 9");
        titleList.add("Книга 10");
        return titleList;
    }

    public LinkedList<String> createAuthorDatabase(LinkedList<String> authorList) {
        authorList.add("Автор 1");
        authorList.add("Автор 2");
        authorList.add("Автор 3");
        authorList.add("Автор 1");
        authorList.add("Автор 1");
        authorList.add("Автор 1");
        authorList.add("Автор 3");
        authorList.add("Автор 2");
        authorList.add("Автор 3");
        authorList.add("Автор 4");
        return authorList;
    }

    public LinkedList<Integer> createYearDatabase(LinkedList<Integer> yearList) {
        yearList.add(2000);
        yearList.add(2000);
        yearList.add(2000);
        yearList.add(2001);
        yearList.add(2002);
        yearList.add(2003);
        yearList.add(2003);
        yearList.add(2003);
        yearList.add(2004);
        yearList.add(2000);
        return yearList;
    }

    public Map<Integer, String> createIDDatabase(Map<Integer, String> idList, LinkedList<String> titleList){
        int i = 0;
        for (String title : titleList
        ) {
            idList.put(i, title);
            i++;
        }
        return idList;
    }

}



