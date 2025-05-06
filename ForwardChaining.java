
import java.util.ArrayList;
import java.util.HashMap;


public class ForwardChaining extends InferenceMethod {

    private ArrayList<String> eSymbol;

  
    @Override
    public boolean entails(Scentence q) {
        
    	eSymbol = new ArrayList<>();
      
        HashMap<Scentence, Integer> number = new HashMap<>();
        HashMap<String, Boolean> assessed = new HashMap<>();
     
        ArrayList<Scentence> list = new ArrayList<>();

  
        for (String sign : KnowledgeBase.getAllSymbols()) {
        	assessed.put(sign, false);
        }

 
        for (Scentence newScentence : KnowledgeBase.getScentenceList()) {
            if (newScentence.isFact()) list.add(newScentence);
            else {
            	number.put(newScentence, newScentence.getPScentence().getSigns().size());
            }
        }

     
        while (!list.isEmpty()) {
        	Scentence select = list.remove(0);

          
        	eSymbol.add(select.getPremise());

        
            if (select.equals(q)) return true;

       
            if (assessed.get(select.getScentence()) == false) {
            	assessed.replace(select.getScentence(), true);

               
                for (Scentence query : KnowledgeBase.getScentenceList()) {
                    if (!query.isFact() && query.getPremise().contains(select.getPremise())) {
                    	number.replace(query, number.get(query) - 1);
                        if (number.get(query) == 0) list.add(new Scentence(query.getConclusion()));
                    }
                }
            }
        }

       
        return false;
    }

   
    @Override
    public String additionalEntail() {
        String output = "";
        for (int z = 0; z < eSymbol.size(); z++) {
        	output += eSymbol.get(z);
            if (z < eSymbol.size() - 1) output += ", ";
        }

        return output;
    }
}
