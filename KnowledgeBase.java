import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class KnowledgeBase {
  
    private static List<Scentence> newscentences;

  
    static {
    	newscentences = new ArrayList<>();
    }

   
    public static void addScentenceArray(String[] arrayAcentence) {
        for (String newString : arrayAcentence) {
            addScentence(new Scentence(newString));
        }
    }

    
    public static void addScentence(Scentence Scentence) { newscentences.add(Scentence); }

   
    public static List<Scentence> getScentenceList() { return newscentences; }

    
    public static List<Scentence> getClauseList() {
        List<Scentence> output = new ArrayList<>();
        for (Scentence scentence : newscentences) {
            if (!scentence.isFact()) output.add(scentence);
        }

        return output;
    }

   
    public static void cList() { newscentences.clear(); }

    
    public static List<String> getAllSymbols() {
        List<String> output = new ArrayList<>();

        for (Scentence scentence : newscentences) {
            List<String> ScentenceSymbol = scentence.getSigns();
            for (String newString : ScentenceSymbol) {
                if (!output.contains(newString)) output.add(newString);
            }
        }

        return output;
    }

   
    public static boolean knowledgeBasePLTrue(Map<String, Boolean> signs) {
        for (Scentence scentence : newscentences) {
            if (!scentence.propositionalLogic(signs)) return false;
        }

        return true;
    }

    
    public static boolean containScentence(Scentence newScentence) {
        return newscentences.contains(newScentence);
    }
}
