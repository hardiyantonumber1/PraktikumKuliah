import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static GoDriveRentalSystem system = new GoDriveRentalSystem();

    public static void main(String[] args) throws KendaraanTidakTersediaException {
        int pilihan = 0;
        do {
            tampilMenu();
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input tidak valid. Masukkan angka 1-5.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    menuTambahKendaraan();
                    break;
                case 2:
                    system.tampilkanDaftarKendaraan();
                    break;
                case 3:
                    menuSewaKendaraan();
                    break;
                case 4:
                    menuKembalikanKendaraan();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan GoDrive Rental System. Sampai jumpa!");
                    break;
                default:
                    System.out.println("[ERROR] Pilihan tidak valid. Masukkan angka 1-5.");
            }
        } while (pilihan != 5);

        scanner.close();
    }

    static void tampilMenu() {
        System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
        System.out.println("1. Tambah Kendaraan");
        System.out.println("2. Tampilkan Daftar Armada");
        System.out.println("3. Sewa Kendaraan");
        System.out.println("4. Kembalikan Kendaraan");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    static void menuTambahKendaraan() {
        System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
        String jenis = scanner.nextLine().trim().toLowerCase();

        System.out.print("Masukkan kode kendaraan: ");
        String kode = scanner.nextLine().trim();

        System.out.print("Masukkan nama kendaraan: ");
        String nama = scanner.nextLine().trim();

        double harga = 0;
        while (true) {
            System.out.print("Masukkan harga sewa per hari: ");
            try {
                harga = Double.parseDouble(scanner.nextLine().trim());
                if (harga <= 0) {
                    System.out.println("[ERROR] Harga harus lebih dari 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harga tidak valid.");
            }
        }

        if (jenis.equals("mobil")) {
            int kursi = 0;
            while (true) {
                System.out.print("Masukkan kapasitas kursi: ");
                try {
                    kursi = Integer.parseInt(scanner.nextLine().trim());
                    if (kursi <= 0) {
                        System.out.println("[ERROR] Jumlah kursi harus lebih dari 0.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] Input jumlah kursi tidak valid.");
                }
            }
            Mobil mobil = new Mobil(kode, nama, harga, kursi);
            system.tambahKendaraan(mobil);

        } else if (jenis.equals("motor")) {
            System.out.print("Masukkan jenis transmisi (Matik/Manual): ");
            String transmisi = scanner.nextLine().trim();
            Motor motor = new Motor(kode, nama, harga, transmisi);
            system.tambahKendaraan(motor);

        } else {
            System.out.println("[ERROR] Jenis kendaraan tidak dikenali. Masukkan 'mobil' atau 'motor'.");
        }
    }

    static void menuSewaKendaraan() throws KendaraanTidakTersediaException {
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = scanner.nextLine().trim();

        int lamaSewa = 0;
        while (true) {
            System.out.print("Masukkan durasi sewa (dalam hari): ");
            try {
                lamaSewa = Integer.parseInt(scanner.nextLine().trim());
                if (lamaSewa <= 0) {
                    System.out.println("[ERROR] Durasi sewa harus lebih dari 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input durasi tidak valid.");
            }
        }

        System.out.print("Apakah Anda Member VIP? (y/n): ");
        String vipInput = scanner.nextLine().trim().toLowerCase();
        boolean isVIP = vipInput.equals("y");

        system.sewaKendaraan(kode, lamaSewa, isVIP);
    }

    static void menuKembalikanKendaraan() {
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = scanner.nextLine().trim();
        system.kembalikanKendaraan(kode);
    }
}
