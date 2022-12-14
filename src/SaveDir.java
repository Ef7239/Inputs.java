import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveDir extends Contact{

//    public static void saveDir(){
//        Contact p = new Contact();
//        p.saveDir();
//    }

    public static void saveDir(){

        try {
            bw =new BufferedWriter(new FileWriter("Dir.txt"));
            for (int i = 0; i < dir.size(); i++){
                bw.write(dir.get(i).getFirstName() + "\n");
                bw.write(dir.get(i).getLastName() + "\n");
                bw.write(dir.get(i).getPhNum() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
