
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BackwardChaining extends InferenceMethod {

 
    private ArrayList<String> eSymbol;


    @Override
    public boolean entails(Scentence query) {
        
    	eSymbol = new ArrayList<>();
      
        HashMap<String, Boolean> assessed = new HashMap<>();
     
        ArrayList<Scentence> newScentence = new ArrayList<>();

     
        for (String sign : KnowledgeBase.getAllSymbols()) {
        	assessed.put(sign, false);
        }

    
        newScentence.add(query);

      
        while (!newScentence.isEmpty()) {
        	Scentence selected = newScentence.remove(newScentence.size() - 1);

           
         
        	eSymbol.add(selected.getPremise());

      
            if (KnowledgeBase.containScentence(selected)) return true;

        
            if (!(KnowledgeBase.containScentence(selected) && selected.isFact())) {

            
                List<String> sign = selected.getSigns();

          
                for (Scentence scentence : KnowledgeBase.getClauseList()) {
                    if (scentence.getCScentence().getSigns().contains(selected.getPremise())) {
                        List<String> cSymbol = scentence.getPScentence().getSigns();
                        for (String small : cSymbol) sign.add(small);
                    }
                }

               
                if (sign.size() == 0) return false;
                else {
                   
                    if (sign.size() == 1 && sign.get(0).equalsIgnoreCase(query.getScentence())) return false;

                   
                    for (String small : sign) {
                        if (!assessed.get(small)) {
                        	newScentence.add(new Scentence(small));
                        }
                    }
                }
            }
        }

   
        return false;
    }


    @Override
    public String additionalEntail() {
        String output = "";
        for (int z = eSymbol.size() - 1; z >= 0; z--) {
        	output += eSymbol.get(z);
            if (z > 0) output += ", ";
        }

        return output;
    }
}
