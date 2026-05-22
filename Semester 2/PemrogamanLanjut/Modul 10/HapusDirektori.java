import java.io.File;
import java.util.Scanner;

public class HapusDirektori {
    public static void main(String[] args) {
        var keyboard = new Scanner(System.in);
        System.out.print("Masukkan path direktori yang akan dihapus: ");
        var dirPath = keyboard.nextLine();
        
        var dir = new File(dirPath);
        
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Direktori ditemukan: " + dir.getAbsolutePath());
            
            File[] daftarFile = dir.listFiles();
            
            if (daftarFile != null) {
                System.out.println("Jumlah file dalam direktori: " + daftarFile.length);
                
                System.out.print("Apakah Anda yakin ingin menghapus direktori ini? (y/n): ");
                String konfirmasi = keyboard.nextLine();
                
                if (konfirmasi.equalsIgnoreCase("y")) {
                    int berhasilDihapus = 0;
                    
                    for (File file : daftarFile) {
                        if (file.isFile()) {
                            if (file.delete()) {
                                System.out.println("Menghapus: " + file.getName());
                                berhasilDihapus++;
                            } else {
                                System.out.println("Gagal menghapus: " + file.getName());
                            }
                        }
                    }
                    
                    if (dir.delete()) {
                        System.out.println("\nBerhasil menghapus direktori!");
                        System.out.println("Total file yang dihapus: " + berhasilDihapus);
                    } else {
                        System.out.println("\nGagal menghapus direktori!");
                        System.out.println("Mungkin masih ada file yang tidak terhapus.");
                    }
                } else {
                    System.out.println("Penghapusan dibatalkan.");
                }
            } else {
                System.out.println("Tidak dapat membaca isi direktori.");
            }
        } else {
            System.out.println("Direktori tidak ditemukan atau path bukan direktori.");
        }
    }
}