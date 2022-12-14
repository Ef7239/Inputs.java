import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Inputs {
    Contact p = new Contact();
    Scanner keyboard = new Scanner(System.in);
    String n = "1";
    BufferedReader br = null;
    FileReader fr = null;

    String line;

    public void readDir(){
        try {
            br = new BufferedReader(new FileReader("Dir.txt"));

            while ((line = br.readLine()) != null){
                p.setFirstName(line);
                p.setLastName(br.readLine());
                p.setPhNum(br.readLine());


                p.addToDir(p);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}


