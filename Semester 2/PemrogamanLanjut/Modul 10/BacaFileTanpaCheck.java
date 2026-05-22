import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BacaFileTanpaCheck {
    public static void main(String[] args) {
        var filename = "file_tidak_ada.txt";
        
        System.out.println("Mulai membaca file...");
        
        try {
            var reader = new FileReader(filename);
            var buffer = new BufferedReader(reader);
            
            var line = buffer.readLine();
            while (line != null) {
                System.out.println(line);
                line = buffer.readLine();
            }
            
            buffer.close();
            reader.close();
            
            System.out.println("Selesai membaca file.");
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            System.err.println("Tipe exception: " + e.getClass().getName());
        }
        
        System.out.println("Program selesai.");
    }
}