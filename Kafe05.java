import java.util.Scanner;

public class Kafe05 {

    public static void Menu(String namaPelanggan, boolean isMember, String kodePromo) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("==== MENU RESTO KAFE ====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappucino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("==========================");

        if (kodePromo.equals("DISKON50")) {
            System.out.println("Selamat! Anda mendapatkan diskon 50%.");
        } else if (kodePromo.equals("DISKON30")) {
            System.out.println("Selamat! Anda mendapatkan diskon 30%.");
        } else {
            System.out.println("Kode promo tidak valid.");
        }

        System.out.println("Silahkan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga05(int pilihanMenu, int banyakItem, String kodePromo) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        if (pilihanMenu < 1 || pilihanMenu > hargaItems.length) {
            System.out.println("Pilihan menu tidak valid.");
            return 0;
        }

        int totalHarga = hargaItems[pilihanMenu - 1] * banyakItem;

        if (kodePromo.equals("DISKON50")) {
            totalHarga *= 0.5;
        } else if (kodePromo.equals("DISKON30")) {
            totalHarga *= 0.7; 
        }

        return totalHarga;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = sc.nextLine();

        System.out.print("Apakah Anda member? (true/false): ");
        boolean isMember = sc.nextBoolean();

        System.out.print("Masukkan kode promo (jika ada, kosongkan jika tidak): ");
        sc.nextLine(); 
        String kodePromo = sc.nextLine();

        Menu(namaPelanggan, isMember, kodePromo);

        int totalKeseluruhan = 0;
        boolean selesai = false;

        while (!selesai) {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan (0 untuk selesai): ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu == 0) {
                selesai = true;
            } else {
                System.out.print("Masukkan jumlah item yang ingin dipesan: ");
                int banyakItem = sc.nextInt();

                totalKeseluruhan += hitungTotalHarga05(pilihanMenu, banyakItem, kodePromo);
            }
        }

        System.out.println("\nTotal keseluruhan pesanan Anda: Rp" + totalKeseluruhan);
    }
}
