import java.io.BufferedReader;
import java.io.FileReader;

public class Program {

	//dosya okuma ve  comment satirlarini temizleme
public static String getClearText(String fileName)throws Exception
{
    BufferedReader reader = new BufferedReader(new FileReader(fileName));

    boolean currentlyInComment = false;

	String clearText = "";

    String line = reader.readLine();
    while (line != null) {
        if(line.trim().startsWith("/*")){
            currentlyInComment = true;
        }

        if(!currentlyInComment) {
        	if(line.trim().contains("//")) {
        		int startComment = line.indexOf("//");
            	if(startComment>0) {
                 	clearText = clearText + "\n" + line.substring(0,startComment);
            	}
        	} else {
             	clearText = clearText + "\n" + line;
        	}
        }

        if(line.trim().startsWith("*/") && currentlyInComment) {
            currentlyInComment = false;
        }

        line = reader.readLine();
    }
	return clearText;			
}
