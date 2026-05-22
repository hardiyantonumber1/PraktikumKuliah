import java.io.File;
import java.util.Scanner;

public class DaftarFile {
    public static void main(String[] args) {
        var keyboard = new Scanner(System.in);
        System.out.print("Masukkan path direktori: ");
        var dirPath = keyboard.nextLine();
        
        var dir = new File(dirPath);
        
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("\nDaftar file dalam direktori: " + dir.getAbsolutePath());
            System.out.println("=".repeat(60));
            
            String[] daftarFile = dir.list();
            
            if (daftarFile != null && daftarFile.length > 0) {
                int counter = 1;
                for (String namaFile : daftarFile) {
                    System.out.println(counter + ". " + namaFile);
                    counter++;
                }
                System.out.println("\nTotal: " + daftarFile.length + " file/direktori");
            } else {
                System.out.println("Direktori kosong");
            }
        } else {
            System.out.println("Direktori tidak ditemukan atau path bukan direktori");
        }
    }
}