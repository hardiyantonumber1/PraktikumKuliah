import java.io.File;
import java.util.Scanner;

public class UkuranFile {
    public static void main(String[] args) {
        var keyboard = new Scanner(System.in);
        System.out.print("Masukkan nama file: ");
        var filename = keyboard.nextLine();
        
        var file = new File(filename);
        
        if (file.exists() && file.isFile()) {
            long ukuranBytes = file.length();
            double ukuranKB = ukuranBytes / 1024.0;
            double ukuranMB = ukuranKB / 1024.0;
            
            if (ukuranMB >= 1) {
                System.out.printf("Ukuran file: %.2f MB\n", ukuranMB);
            } else {
                System.out.printf("Ukuran file: %.2f KB\n", ukuranKB);
            }
            
            // Informasi tambahan
            System.out.printf("(Detail: %d bytes)\n", ukuranBytes);
        } else {
            System.out.println("File tidak ditemukan atau bukan sebuah file");
        }
    }
}