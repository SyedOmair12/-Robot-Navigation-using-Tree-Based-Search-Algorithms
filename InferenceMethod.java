
public abstract class InferenceMethod {

   
    public String execute(Scentence clause) {
        boolean en = entails(clause);
        String output = en ? "YES" : "NO";
        String newEntail = additionalEntail();

        return output + (en ? " " + newEntail : "");
    }

   
    public String additionalEntail() { return ""; }

 
    public abstract boolean entails(Scentence clause);
}
