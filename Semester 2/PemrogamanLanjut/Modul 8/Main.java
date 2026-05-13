public class Main {
    public static void main(String[] args) {

        // Data karyawan 1
        Invoice[] invoicesEmp1 = {
            new Invoice("Beras 5kg", 2, 65000),
            new Invoice("Minyak Goreng 2L", 3, 28000),
            new Invoice("Gula Pasir 1kg", 4, 15000)
        };
        Employee emp1 = new Employee(1001, "Budi Santoso", 5000000, invoicesEmp1);

        // Data karyawan 2
        Invoice[] invoicesEmp2 = {
            new Invoice("Susu UHT 1L", 5, 18000),
            new Invoice("Sabun Mandi", 3, 12000),
            new Invoice("Detergen 1kg", 2, 22000),
            new Invoice("Teh Celup", 2, 10000)
        };
        Employee emp2 = new Employee(1002, "Siti Rahayu", 4500000, invoicesEmp2);

        // Array Payable untuk polimorfisme
        Payable[] payables = { emp1, emp2 };

        System.out.println("=============================================================");
        System.out.println("       NV. MENEER - LAPORAN GAJI & BELANJA KOPERASI         ");
        System.out.println("=============================================================");

        for (Payable payable : payables) {
            if (payable instanceof Employee) {
                Employee emp = (Employee) payable;

                System.out.println();
                System.out.println("-------------------------------------------------------------");
                System.out.printf("  No. Registrasi : %d%n", emp.getRegistrationNumber());
                System.out.printf("  Nama Karyawan  : %s%n", emp.getName());
                System.out.printf("  Gaji per Bulan : Rp%,d%n", emp.getSalaryPerMonth());
                System.out.println();
                System.out.println("  Detail Belanja di Koperasi:");
                System.out.println("  -----------------------------------------------------------");

                // Tampilkan setiap invoice secara polimorfis
                for (Payable invoicePayable : emp.getInvoices()) {
                    if (invoicePayable instanceof Invoice) {
                        System.out.println(invoicePayable.toString());
                        System.out.printf("  %-27s | Total Tagihan Invoice  : Rp%,d%n",
                                "", invoicePayable.getPayableAmount());
                    }
                }

                System.out.println("  -----------------------------------------------------------");
                System.out.printf("  Total Belanja Koperasi : Rp%,d%n", emp.getTotalInvoiceAmount());
                System.out.printf("  Gaji Bersih (Dipotong) : Rp%,d%n", payable.getPayableAmount());
                System.out.println("-------------------------------------------------------------");
            }
        }

        System.out.println();
        System.out.println("=============================================================");
        System.out.println("                    RINGKASAN PEMBAYARAN                    ");
        System.out.println("=============================================================");
        for (Payable payable : payables) {
            if (payable instanceof Employee) {
                Employee emp = (Employee) payable;
                System.out.printf("  %-15s => Gaji Bersih: Rp%,d%n",
                        emp.getName(), payable.getPayableAmount());
            }
        }
        System.out.println("=============================================================");
    }
}
