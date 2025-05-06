
import java.io.*;
import java.util.ArrayList;


public class Parser {

    private enum ReadState { None, Ask, Tell }

    
    public static boolean readTextFile(String filename) {
        try {
            
            FileReader filereader = new FileReader(new File(filename));
            BufferedReader bufferreader = new BufferedReader(filereader);

           
            ReadState readstate = ReadState.None;
            String l;

            StringBuilder newtell = new StringBuilder();
            ArrayList<String> newask = new ArrayList<String>();
            while ((l = bufferreader.readLine()) != null) {
              
                if (l.equalsIgnoreCase("TELL")) {
                	readstate = ReadState.Tell;
                    continue;
                }
              
                else if (l.equalsIgnoreCase("ASK")) {
                	readstate = ReadState.Ask;
                    continue;
                }

               
                switch (readstate) {
                    case Tell:
                    	newtell.append(l);
                        break;
                    case Ask:
                    	newask.add(l.replaceAll("(?m)^\\s+$", ""));
                        break;
				case None:
					break;
				default:
					break;
                }
            }

        
            String tellend = newtell.toString().replaceAll("(?m)^\\s+$", "");
            String[] tell = tellend.split(";");
            KnowledgeBase.addScentenceArray(tell);

          
            for (String sample : newask) {
                Query.addQuery(sample);
            }

        
        } catch (FileNotFoundException e) {
            System.out.println("Error File Not Found.Please check your input");
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            System.out.println("Error File Not Found. Please check your input");
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
