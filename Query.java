
import java.util.ArrayList;

public class Query {
  
    private static ArrayList<String> qList;

  
    static {
        qList = new ArrayList<>();
    }

 static void addQuery(String newStrig) {
        qList.add(newStrig);
    }

    public static ArrayList<String> getQueryList() { return qList; }
}
