public class CafeSales05 {

    static int[][] penjualan = {
        {20, 20, 25, 20, 10, 60, 10}, 
        {30, 80, 40, 10, 15, 20, 25}, 
        {5, 9, 20, 25, 10, 5, 45},   
        {50, 8, 17, 18, 10, 30, 6},   
        {15, 10, 16, 15, 10, 10, 55}  
    };

    static String[] menu = {"Kopi", "Teh", "Es Degan", "Roti Bakar", "Gorengan"};

    public static void main(String[] args) {
        SeluruhDataPenjualan();

        MenuPenjualanTertinggi();

        Rata2Penjualan();
    }

    public static void SeluruhDataPenjualan() {
        System.out.println("Data Penjualan:");
        for (int i = 0; i < penjualan.length; i++) {
            System.out.print(menu[i] + ": ");
            for (int j = 0; j < penjualan[i].length; j++) {
                System.out.print(penjualan[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void MenuPenjualanTertinggi() {
        int PenjualanTertinggi = 0;
        String MenuTertinggi = "";

        for (int i = 0; i < penjualan.length; i++) {
            int total = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                total += penjualan[i][j];
            }
            if (total > PenjualanTertinggi) {
                PenjualanTertinggi = total;
                MenuTertinggi = menu[i];
            }
        }

        System.out.println("\nMenu dengan penjualan tertinggi: " + PenjualanTertinggi + " (Total: " + PenjualanTertinggi + ")");
    }

    public static void Rata2Penjualan() {
        System.out.println("\nRata-rata Penjualan per Menu:");
        for (int i = 0; i < penjualan.length; i++) {
            int total = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                total += penjualan[i][j];
            }
            double average = (double) total / penjualan[i].length;
            System.out.println(menu[i] + ": " + String.format("%.2f", average));
        }
    }
}
