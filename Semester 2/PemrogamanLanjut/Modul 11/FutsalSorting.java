import java.util.*;

class Player {
    String team;
    int height;
    int weight;

    public Player(String team, int height, int weight) {
        this.team = team;
        this.height = height;
        this.weight = weight;
    }

    public String toString() {
        return "Tim " + team + " | Tinggi: " + height + " cm | Berat: " + weight + " kg";
    }
}

public class FutsalSorting {

    public static void main(String[] args) {

        // Data Tim A
        ArrayList<Player> timA = new ArrayList<>();
        timA.add(new Player("A", 168, 50));
        timA.add(new Player("A", 170, 60));
        timA.add(new Player("A", 165, 56));
        timA.add(new Player("A", 168, 55));
        timA.add(new Player("A", 172, 60));
        timA.add(new Player("A", 170, 70));
        timA.add(new Player("A", 169, 66));
        timA.add(new Player("A", 165, 56));
        timA.add(new Player("A", 171, 72));
        timA.add(new Player("A", 166, 56));

        // Data Tim B
        ArrayList<Player> timB = new ArrayList<>();
        timB.add(new Player("B", 170, 66));
        timB.add(new Player("B", 167, 60));
        timB.add(new Player("B", 165, 59));
        timB.add(new Player("B", 166, 58));
        timB.add(new Player("B", 168, 58));
        timB.add(new Player("B", 175, 71));
        timB.add(new Player("B", 172, 68));
        timB.add(new Player("B", 171, 68));
        timB.add(new Player("B", 168, 65));
        timB.add(new Player("B", 169, 60));

        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(timA);
        allPlayers.addAll(timB);

        System.out.println("--- TUGAS PRAKTIKUM - SORTING & SEARCHING ---");

        // SOAL 1a - Sorting Tinggi Badan Ascending & Descending
        System.out.println("\n--- 1a. Urutan Tinggi Badan ASCENDING ---");
        ArrayList<Player> sortedList = new ArrayList<>(allPlayers);
        Collections.sort(sortedList, (a, b) -> a.height - b.height);
        for (int i = 0; i < sortedList.size(); i++)
            System.out.println((i+1) + ". " + sortedList.get(i));

        System.out.println("\n--- 1a. Urutan Tinggi Badan DESCENDING ---");
        Collections.sort(sortedList, (a, b) -> b.height - a.height);
        for (int i = 0; i < sortedList.size(); i++)
            System.out.println((i+1) + ". " + sortedList.get(i));

        // SOAL 1b - Sorting Berat Badan Ascending & Descending
        System.out.println("\n--- 1b. Urutan Berat Badan ASCENDING ---");
        ArrayList<Player> sortedByWeight = new ArrayList<>(allPlayers);
        Collections.sort(sortedByWeight, (a, b) -> a.weight - b.weight);
        for (int i = 0; i < sortedByWeight.size(); i++)
            System.out.println((i+1) + ". " + sortedByWeight.get(i));

        System.out.println("\n--- 1b. Urutan Berat Badan DESCENDING ---");
        Collections.sort(sortedByWeight, (a, b) -> b.weight - a.weight);
        for (int i = 0; i < sortedByWeight.size(); i++)
            System.out.println((i+1) + ". " + sortedByWeight.get(i));

        // SOAL 1c - Max & Min Tinggi dan Berat per Tim
        System.out.println("\n--- 1c. Nilai MAX dan MIN per Tim ---");

        Player maxTinggiA = Collections.max(timA, (a, b) -> a.height - b.height);
        Player minTinggiA = Collections.min(timA, (a, b) -> a.height - b.height);
        Player maxBeratA  = Collections.max(timA, (a, b) -> a.weight - b.weight);
        Player minBeratA  = Collections.min(timA, (a, b) -> a.weight - b.weight);

        System.out.println("\n[Tim A]");
        System.out.println("Tinggi Badan MAX : " + maxTinggiA.height + " cm");
        System.out.println("Tinggi Badan MIN : " + minTinggiA.height + " cm");
        System.out.println("Berat Badan  MAX : " + maxBeratA.weight  + " kg");
        System.out.println("Berat Badan  MIN : " + minBeratA.weight  + " kg");

        Player maxTinggiB = Collections.max(timB, (a, b) -> a.height - b.height);
        Player minTinggiB = Collections.min(timB, (a, b) -> a.height - b.height);
        Player maxBeratB  = Collections.max(timB, (a, b) -> a.weight - b.weight);
        Player minBeratB  = Collections.min(timB, (a, b) -> a.weight - b.weight);

        System.out.println("\n[Tim B]");
        System.out.println("Tinggi Badan MAX : " + maxTinggiB.height + " cm");
        System.out.println("Tinggi Badan MIN : " + minTinggiB.height + " cm");
        System.out.println("Berat Badan  MAX : " + maxBeratB.weight  + " kg");
        System.out.println("Berat Badan  MIN : " + minBeratB.weight  + " kg");

        
        // SOAL 1d - Copy Tim B ke Tim C        
        System.out.println("\n--- 1d. Copy Tim B ke Tim C ---");
        ArrayList<Player> timC = new ArrayList<>(timB.size());
        for (int i = 0; i < timB.size(); i++)
            timC.add(new Player("C", 0, 0));
        Collections.copy(timC, timB);
        for (Player p : timC) p.team = "C";
        System.out.println("Anggota Tim C (hasil copy dari Tim B):");
        for (int i = 0; i < timC.size(); i++)
            System.out.println((i+1) + ". " + timC.get(i));

        
        // SOAL 2 - Binary Search        
        System.out.println("\n--- SOAL 2 - BINARY SEARCH ---");

        // 2a - ArrayList terpisah tinggi badan dan berat badan
        // Untuk binary search, kita buat list tinggi dan berat terpisah
        ArrayList<Integer> tinggiA = new ArrayList<>();
        ArrayList<Integer> beratA  = new ArrayList<>();
        for (Player p : timA) { tinggiA.add(p.height); beratA.add(p.weight); }

        ArrayList<Integer> tinggiB = new ArrayList<>();
        ArrayList<Integer> beratB  = new ArrayList<>();
        for (Player p : timB) { tinggiB.add(p.height); beratB.add(p.weight); }

        System.out.println("\n--- 2a. ArrayList Tim A dan Tim B ---");
        System.out.println("Tinggi Badan Tim A : " + tinggiA);
        System.out.println("Berat Badan Tim A  : " + beratA);
        System.out.println("Tinggi Badan Tim B : " + tinggiB);
        System.out.println("Berat Badan Tim B  : " + beratB);

        // 2b - Jumlah pemain Tim B dengan tinggi 168 cm dan 160 cm
        System.out.println("\n--- 2b. Frekuensi Tinggi Badan di Tim B ---");
        int freq168B = Collections.frequency(tinggiB, 168);
        int freq160B = Collections.frequency(tinggiB, 160);
        System.out.println("Jumlah pemain Tim B dengan tinggi 168 cm : " + freq168B + " pemain");
        System.out.println("Jumlah pemain Tim B dengan tinggi 160 cm : " + freq160B + " pemain");

        // 2c - Jumlah pemain Tim A dengan berat 56 kg dan 53 kg
        System.out.println("\n--- 2c. Frekuensi Berat Badan di Tim A ---");
        int freq56A = Collections.frequency(beratA, 56);
        int freq53A = Collections.frequency(beratA, 53);
        System.out.println("Jumlah pemain Tim A dengan berat 56 kg : " + freq56A + " pemain");
        System.out.println("Jumlah pemain Tim A dengan berat 53 kg : " + freq53A + " pemain");

        // 2d - Apakah ada pemain Tim A dengan tinggi/berat sama dengan Tim B?
        System.out.println("\n--- 2d. Kesamaan Tinggi/Berat antara Tim A dan Tim B ---");

        boolean disjointTinggi = Collections.disjoint(tinggiA, tinggiB);
        boolean disjointBerat  = Collections.disjoint(beratA, beratB);

        if (!disjointTinggi)
            System.out.println("Ada pemain Tim A yang memiliki TINGGI BADAN sama dengan pemain Tim B.");
        else
            System.out.println("Tidak ada pemain Tim A yang memiliki tinggi badan sama dengan Tim B.");

        if (!disjointBerat)
            System.out.println("Ada pemain Tim A yang memiliki BERAT BADAN sama dengan pemain Tim B.");
        else
            System.out.println("Tidak ada pemain Tim A yang memiliki berat badan sama dengan Tim B.");

        // Detail: Binary Search - cari index spesifik di list yang sudah diurutkan
        System.out.println("\n--- Detail Binary Search Tinggi Badan Tim B (sorted) ---");
        ArrayList<Integer> tinggiBSorted = new ArrayList<>(tinggiB);
        Collections.sort(tinggiBSorted);
        System.out.println("Tinggi Tim B (sorted): " + tinggiBSorted);
        int idx168 = Collections.binarySearch(tinggiBSorted, 168);
        int idx160 = Collections.binarySearch(tinggiBSorted, 160);
        System.out.println("binarySearch 168 cm -> index: " + idx168 + (idx168 >= 0 ? " (ditemukan)" : " (tidak ditemukan)"));
        System.out.println("binarySearch 160 cm -> index: " + idx160 + (idx160 >= 0 ? " (ditemukan)" : " (tidak ditemukan)"));

        System.out.println("\n--- Detail Binary Search Berat Badan Tim A (sorted) ---");
        ArrayList<Integer> beratASorted = new ArrayList<>(beratA);
        Collections.sort(beratASorted);
        System.out.println("Berat Tim A (sorted): " + beratASorted);
        int idx56 = Collections.binarySearch(beratASorted, 56);
        int idx53 = Collections.binarySearch(beratASorted, 53);
        System.out.println("binarySearch 56 kg -> index: " + idx56 + (idx56 >= 0 ? " (ditemukan)" : " (tidak ditemukan)"));
        System.out.println("binarySearch 53 kg -> index: " + idx53 + (idx53 >= 0 ? " (ditemukan)" : " (tidak ditemukan)"));
    }
}
