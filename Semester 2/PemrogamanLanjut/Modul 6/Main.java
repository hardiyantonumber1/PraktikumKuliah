public class Main {
    public static void main(String[] args) {

        // Manusia
        Manusia a = new Manusia("A", "111", true, true);
        System.out.println(a + "\n");

        // Mahasiswa
        MahasiswaFILKOM b = new MahasiswaFILKOM("165150300111100", 4.0, "B", "111", false, false);
        System.out.println(b + "\n");

        // Pekerja
        Pekerja c = new Pekerja(1000, 2016, 3, 2, "C", "111", true, true);
        c.setJumlahAnak(4);
        System.out.println(c + "\n");

        // Manager
        Manager d = new Manager("HRD", 1000, 2017, 1, 2, "D", "111", true, true);
        System.out.println(d);
    }
}