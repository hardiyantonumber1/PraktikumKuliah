public class Jaket {
    private int jumlahA;
    private int jumlahB;
    private int jumlahC;

    private final int hargaA = 100000;
    private final int hargaB = 125000;
    private final int hargaC = 175000;

    public void setJumlahA(int jumlahA) {
        this.jumlahA = jumlahA;
    }

    public void setJumlahB(int jumlahB) {
        this.jumlahB = jumlahB;
    }

    public void setJumlahC(int jumlahC) {
        this.jumlahC = jumlahC;
    }

    public int getTotalA() {
        if (jumlahA > 100) {
            return jumlahA * 95000;
        }
        return jumlahA * hargaA;
    }

    public int getTotalB() {
        if (jumlahB > 100) {
            return jumlahB * 120000;
        }
        return jumlahB * hargaB;
    }

    public int getTotalC() {
        if (jumlahC > 100) {
            return jumlahC * 160000;
        }
        return jumlahC * hargaC;
    }
}