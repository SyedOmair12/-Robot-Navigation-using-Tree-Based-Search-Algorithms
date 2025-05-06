
import java.util.*;


public class TruthTable extends InferenceMethod {

 
    private int tQuery;

  
    public TruthTable() {
    	tQuery = 0;
    }

    public void reset() {
    	tQuery = 0;
    }

    
    @Override
    public boolean entails(Scentence scentence) {
        
        List<String> sign = KnowledgeBase.getAllSymbols();

       
        long iterate = (long) Math.pow(2, sign.size());
        for (long l = 0; l < iterate; l++) {
            
            String newString = Long.toBinaryString(l);

          
            Map<String, Boolean> var = new HashMap<>();
            for (int i = newString.length() - 1; i >= 0; i--) {
                if (newString.charAt(i) == '0') var.put(sign.get(i), false);
                else var.put(sign.get(i), true);
            }

        
            if (KnowledgeBase.knowledgeBasePLTrue(var)) {
                if (scentence.propositionalLogic(var)) {
                	tQuery++;
                }
                else {
                    return false;
                }
            }
        }

      
        if (tQuery > 0) return true;
        else return false;
    }


 
    @Override
    public String additionalEntail() {
        return Integer.toString(tQuery);
    }
}
