public class Manager extends Pekerja {
    private String departemen;

    public Manager(String departemen, double gaji, int year, int month, int day, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(gaji, year, month, day, nama, nik, jenisKelamin, menikah);
        this.departemen = departemen;
    }


    @Override
    public double getPendapatan() {
        return super.getPendapatan() + (0.1 * super.getGaji());
    }

    public double getGaji() {
        return super.getGaji();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ndepartemen    : " + departemen;
    }
}