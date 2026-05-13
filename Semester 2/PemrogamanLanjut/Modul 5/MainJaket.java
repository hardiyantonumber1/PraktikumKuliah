import java.util.Scanner;

public class MainJaket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Jaket jaket = new Jaket();

        System.out.print("Masukkan jumlah Jaket A: ");
        int a = input.nextInt();

        System.out.print("Masukkan jumlah Jaket B: ");
        int b = input.nextInt();

        System.out.print("Masukkan jumlah Jaket C: ");
        int c = input.nextInt();

        jaket.setJumlahA(a);
        jaket.setJumlahB(b);
        jaket.setJumlahC(c);

        int totalA = jaket.getTotalA();
        int totalB = jaket.getTotalB();
        int totalC = jaket.getTotalC();

        int total = totalA + totalB + totalC;

        System.out.println("\n=== Rincian ===");
        System.out.println("Jaket A = Rp " + totalA);
        System.out.println("Jaket B = Rp " + totalB);
        System.out.println("Jaket C = Rp " + totalC);
        System.out.println("Total Bayar = Rp " + total);
    }
}