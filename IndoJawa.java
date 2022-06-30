import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class IndoJawa{
    private Map<String, String> dict;

    public IndoJawa(){
        this("dict.csv");
    }

    public IndoJawa(String filename){
        dict = new HashMap<String, String>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String[] data = myReader.nextLine().toString().split(",",0);
              if(data.length > 1){
                data[1] = data[1].split(" ",0)[0];
                data[1] = data[1].split(";",0)[0];
                dict.put(data[0], data[1]);
              }
            }
            myReader.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
    }

    private String check(String word){
        try{
            String result = dict.get(word.toLowerCase());
            if(result != null){
                return result;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return word;
    }

    public String translate(String input){
        String result = "";
        String[] words = input.split(" ",0);
        for(int i = 0; i < words.length; i++){
            result += check(words[i])+" ";
        }
        return result;
    }
}