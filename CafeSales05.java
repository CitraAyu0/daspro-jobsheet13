import java.util.Scanner;

public class CafeSales05 {

    static int[][] penjualan;
    static String[] menu;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah menu: ");
        int jumlahMenu = input.nextInt();
        menu = new String[jumlahMenu];

        for (int i = 0; i < jumlahMenu; i++) {
            System.out.print("Masukkan nama menu ke-" + (i + 1) + ": ");
            menu[i] = input.next();
        }

        System.out.print("Masukkan jumlah hari penjualan: ");
        int jumlahHari = input.nextInt();
        penjualan = new int[jumlahMenu][jumlahHari];

        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println("Masukkan data penjualan untuk menu " + menu[i] + ":");
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("  Hari ke-" + (j + 1) + ": ");
                penjualan[i][j] = input.nextInt();
            }
        }

        SeluruhDataPenjualan();

        MenuPenjualanTertinggi();

        Rata2Penjualan();
    }

    public static void SeluruhDataPenjualan() {
        System.out.println("\nData Penjualan:");
        for (int i = 0; i < penjualan.length; i++) {
            System.out.print(menu[i] + ": ");
            for (int j = 0; j < penjualan[i].length; j++) {
                System.out.print(penjualan[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void MenuPenjualanTertinggi() {
        int penjualanTertinggi = 0;
        String menuTertinggi = "";

        for (int i = 0; i < penjualan.length; i++) {
            int total = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                total += penjualan[i][j];
            }
            if (total > penjualanTertinggi) {
                penjualanTertinggi = total;
                menuTertinggi = menu[i];
            }
        }

        System.out.println("\nMenu dengan penjualan tertinggi: " + menuTertinggi + " (Total: " + penjualanTertinggi + ")");
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
