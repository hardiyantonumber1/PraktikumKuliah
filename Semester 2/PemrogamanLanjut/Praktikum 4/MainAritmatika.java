import java.util.Scanner;

public class MainAritmatika {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        
        System.out.print("Masukkan nilai 1 : ");
        int a = input.nextInt();
        System.out.print("Masukkan nilai 2 : ");
        int b = input.nextInt();
        Aritmatika.hitungPenjumlahan(a, b);
        System.out.println("------------------------");

        System.out.print("Masukkan nilai 1 : ");
        int nil1 = input.nextInt();
        System.out.print("Masukkan nilai 2 : ");
        int nil2 = input.nextInt();
        Aritmatika.hitungPengurangan(nil1, nil2);
        System.out.println("------------------------");
        
        Aritmatika art = new Aritmatika();

        System.out.print("Masukkan nilai 1 : ");
        int per1 = input.nextInt();
        System.out.print("Masukkan nilai 2 : ");
        int per2 = input.nextInt();
        art.hitungPerkalian(per1, per2);
        System.out.println("------------------------");

        System.out.print("Masukkan nilai 1 : ");
        int pem1 = input.nextInt();
        System.out.print("Masukkan nilai 2 : ");
        int pem2 = input.nextInt();
        art.hitungPembagian(pem1, pem2);
        System.out.println("------------------------");

        System.out.print("Masukkan pembilang : ");
        int pec1 = input.nextInt();
        System.out.print("Masukkan penyebut  : ");
        int pec2 = input.nextInt();
        art.Sederhana(pec1, pec2);
    }
}
