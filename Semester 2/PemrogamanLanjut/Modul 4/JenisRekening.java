enum JenisRekening {
    SILVER, GOLD, PLATINUM;

    public static JenisRekening dariKode(String kode) {
        switch(kode){
            case "38": return SILVER;
            case "56": return GOLD;
            case "74": return PLATINUM;
            default: throw new IllegalArgumentException("Kode tidak valid");
        }
    }
}