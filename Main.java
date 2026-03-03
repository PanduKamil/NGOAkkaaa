import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int pilihan;
    public static void main(String[] args) {
        ArrayList<Nasabah> daftarNasabah = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        boolean jalan = true;

        while (running) {
            System.out.println("\n--- BANK DIGITAL UT ---");
            System.out.println("1. Daftar Nasabah");
            System.out.println("2. Lihat Semua Nasabah");
            System.out.println("3. Login (Transfer/Cek Saldo)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // Buat "buang" hantu ENTER!

            try {
                switch (pilihan) {
                    case 1:
                        // LOGIKA DAFTAR
                        System.out.println("\n--- PENDAFTARAN NASABAH BARU ---");
                        System.out.print("Masukkan PIN (6 digit): ");
                        String pinBaru = sc.next();
                        System.out.print("Setoran Awal: Rp");
                        double saldoBaru = sc.nextDouble();
                        sc.nextLine(); // SAPU HANTU ENTER

                        // 1. BUAT OBJEK DAN MEMANGGIL CONSTUCTOR NASABAH
                        Nasabah nasabahBaru = new Nasabah(pinBaru, saldoBaru);
                        
                        // 2. MASUKIN KE GUDANG
                        daftarNasabah.add(nasabahBaru);
                        
                        System.out.println("Berhasil! No Rekening Anda: " + nasabahBaru.getNoRekening());
                        break;
                    case 2:
                        // DAFTAR NASABAH
                        System.out.println("\n--- DAFTAR NASABAH ---");
                        if (daftarNasabah.isEmpty()) {
                            System.out.println("Bank kosong");
                        }
                        for (Nasabah n : daftarNasabah) {
                            System.out.println(n.toString());
                        }
                        break;
                    case 3:
                        // LOGIKA LOGIN & TRANSAKSI
                        // INPUT NO REK
                        while (jalan) {
                            System.out.println("Masukan Nomor Rekening");
                            String n = sc.next();
                            sc.nextLine();
                            for (Nasabah n2 : daftarNasabah) {
                                System.out.println(n.toString());
                            }
                            if (daftarNasabah == null) {
                                System.out.println("Nasabah tidak ditemukan");
                                break;
                            }
                            break;
                        }
                        
                        // CARI REKENING
                        // INPUT PIN
                        // VALIDASI PIN
                        while (jalan) {
                            System.out.println("\n--- Menu ---");
                            System.out.println("1. Cek Saldo");
                            System.out.println("2. Transfer");
                            System.out.println("3. logOut");
                            System.out.print("Pilih : ");
                            int Pilihan = sc.nextInt();
                            sc.nextLine();

                            switch (pilihan) {
                                case 1:
                                    System.out.println("--- Menu Saldo ---");
                                    break;
                                case 2:
                                    System.out.println("--- Menu Transfer ---");
                                    break;
                                case 3:
                                    jalan = false;
                                    System.out.println("Terima kasih");
                                    break;
                                
                                default:
                                    break;
                            }
                        }
                        break;
                    case 4:
                        running = false;
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        sc.close();
    }
}
