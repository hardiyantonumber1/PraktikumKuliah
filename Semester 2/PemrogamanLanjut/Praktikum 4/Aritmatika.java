public class Aritmatika {
    public static void hitungPenjumlahan(int a, int b) {
        int nilai = a + b;
        System.out.println("Hasil penjumlahan: " + nilai);
    }

    public static void hitungPengurangan(int a, int b) {
        int nilai = a - b;
        System.out.println("Hasil pengurangan: " + nilai);
    }

    public void hitungPerkalian(int a, int b) {
        int nilai = a * b;
        System.out.println("Hasil perkalian  : " + nilai);
    }

    public void hitungPembagian(int a, int b) {
        int nilai = a / b;
        System.out.println("Hasil pembagian  : " + nilai);
    }

    public void Sederhana(int pembilang, int penyebut) {
        if (penyebut == 0) {
            System.out.println("Tidak valid (penyebut tidak boleh 0)");
            return;
        }

        if (penyebut < 0) {
            pembilang *= -1;
            penyebut *= -1;
        }

        int a = Math.abs(pembilang);
        int b = Math.abs(penyebut);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        int fpb = a;

        pembilang /= fpb;
        penyebut /= fpb;

        System.out.println("Hasil sederhana    : " + pembilang + "/" + penyebut);
    }
}