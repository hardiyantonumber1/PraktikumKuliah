import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buku {

    private String judul;
    private String kategori;
    private String sinopsis;
    private String penulis;

    public Buku(String judul, String kategori, String sinopsis, String penulis) {
        this.judul = judul;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public String getKategori() {
        return kategori;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getPenulis() {
        return penulis;
    }

    public int hitungJumlahKataSinopsis() {
        String[] kata = sinopsis.split(" ");
        return kata.length;
    }

    public int cekKesamaan(Buku bukuLain) {

        int sama = 0;
        int total = 3;

        if (this.judul.equalsIgnoreCase(bukuLain.judul)) {
            sama++;
        }

        if (this.kategori.equalsIgnoreCase(bukuLain.kategori)) {
            sama++;
        }

        if (this.sinopsis.equalsIgnoreCase(bukuLain.sinopsis)) {
            sama++;
        }

        return (sama * 100) / total;
    }

    public Buku copy() {
        return new Buku(this.judul, this.kategori, this.sinopsis, this.penulis);
    }

    // 1. Method bacaFile(“pathFile”)
    public void bacaFile(String pathFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String baris = br.readLine();
            if (baris != null) {
                String[] data = baris.split(";");
                if (data.length >= 4) {
                    this.judul    = data[0].trim();
                    this.kategori = data[1].trim();
                    this.sinopsis = data[2].trim();
                    this.penulis  = data[3].trim();
                    System.out.println("Data buku berhasil dibaca dari file: " + pathFile);
                } else {
                    System.out.println("Format file tidak sesuai. Gunakan format: judul;kategori;sinopsis;penulis");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + pathFile);
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

    // 2. Method simpanFile(“namaFile”)
    public void simpanFile(String namaFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            bw.write(judul + ";" + kategori + ";" + sinopsis + ";" + penulis);
            System.out.println("Data buku berhasil disimpan ke file: " + namaFile);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }

    // 3. Method hitungRoyalti 10%(1 parameter)
    public double hitungRoyalti(double hargaBuku) {
        double royalti = hargaBuku * 0.10;
        System.out.println("Royalti (10%) dari harga Rp" + hargaBuku + " = Rp" + royalti);
        return royalti;
    }

    // 4. Method hitungRoyalti(2 parameter)
    public double hitungRoyalti(double hargaBuku, double persen) {
        double royalti = hargaBuku * (persen / 100);
        System.out.println("Royalti (" + persen + "%) dari harga Rp" + hargaBuku + " = Rp" + royalti);
        return royalti;
    }

    public void tampilkanInfo() {

        System.out.println("Judul Buku : " + judul);
        System.out.println("Kategori   : " + kategori);
        System.out.println("Penulis    : " + penulis);
        System.out.println("Sinopsis   : " + sinopsis);
        System.out.println("Jumlah kata sinopsis : " + hitungJumlahKataSinopsis());
        System.out.println("----------------------------------");

    }
}