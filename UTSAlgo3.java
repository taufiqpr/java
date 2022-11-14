import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

    public class UTSAlgo3 {

        public static String[] dontbe_late = new String[400];
        public static String[] goncang_jiwa = new String[300];
        public static String[] jalan_kenangan = new String[300];
        public static String[] tanpa_rasa = new String[250];

        public static int stok = dontbe_late.length + goncang_jiwa.length + jalan_kenangan.length + tanpa_rasa.length;
        public static int sisa = stok;

        public static void main(String[] args) {
            System.out.println("Program Pesan Kopi");

            pesan();
        }

        public static void Printdata_Pesanan() {
            int total_dontbelate = 0;
            for (int i = 0; i < dontbe_late.length; i++) {
                if (dontbe_late[i] != null) {
                    total_dontbelate++;
                }
            }

            int total_goncangjiawa = 0;
            for (int i = 0; i < goncang_jiwa.length; i++) {
                if (goncang_jiwa[i] != null) {
                    total_goncangjiawa++;
                }
            }

            int total_jalankenangan = 0;
            for (int i = 0; i < jalan_kenangan.length; i++) {
                if (jalan_kenangan[i] != null) {
                    total_jalankenangan++;
                }
            }

            int total_tanparasa = 0;
            for (int i = 0; i < tanpa_rasa.length; i++) {
                if (tanpa_rasa[i] != null) {
                    total_tanparasa++;
                }
            }

            //menampilkan data
            sisa = stok - total_dontbelate - total_goncangjiawa - total_jalankenangan - total_tanparasa;
            System.out.println("\n===============================================\n\t\tData Penjualan Kopi\n===============================================");
            System.out.println("Don't Be Late\t      : " + total_dontbelate + " Cup terjual | " + (dontbe_late.length-total_dontbelate) + " Cup tersisa");
            System.out.println("Goncang Jiwa\t      : " + total_goncangjiawa + " Cup terjual | " + (goncang_jiwa.length-total_goncangjiawa) + " Cup tersisa");
            System.out.println("Jalan Kenangan\t      : " + total_jalankenangan + " Cup terjual | " + (jalan_kenangan.length-total_jalankenangan) + " Cup tersisa");
            System.out.println("Kopi Pahit Tanpa Rasa : " + total_tanparasa + " Cup terjual | " + (tanpa_rasa.length-total_tanparasa) + " Cup tersisa" );

            //daftar total penjualan setiap jenis kopi
            ArrayList<Integer> penjualan = new ArrayList<Integer>();
            penjualan.add(total_dontbelate);
            penjualan.add(total_goncangjiawa);
            penjualan.add(total_jalankenangan);
            penjualan.add(total_tanparasa);

            //mengurutkan agar nilai terbesar berada di atas (index 0) dan tekecil dibawah (index 3)
            Collections.sort(penjualan, Collections.reverseOrder());

            //cetak semua nama jika memiliki penjualan sama dengan nilai pnejualan tertinggi
            System.out.println("=========================================================");
            System.out.println("\tKopi paling banyak disukai\n" );

            if (total_dontbelate == penjualan.get(0)) {
                System.out.println("- Don't Be Late");
            }

            if (total_goncangjiawa == penjualan.get(0)) {
                System.out.println("- Goncang Jiwa");
            }

            if (total_jalankenangan == penjualan.get(0)) {
                System.out.println("- Jalan Kenangan");
            }

            if (total_tanparasa == penjualan.get(0)) {
                System.out.println("- Pahit Tanpa Rasa");
            }

            System.out.println("\t\tKopi paling tidak disukai\n");


            if (total_dontbelate == penjualan.get(3)) {
                System.out.println("- Don't Be Late");
            }

            if (total_goncangjiawa == penjualan.get(3)) {
                System.out.println("- Goncang Jiwa");
            }

            if (total_jalankenangan == penjualan.get(3)) {
                System.out.println("- Jalan Kenangan");
            }

            if (total_tanparasa == penjualan.get(3)) {
                System.out.println("- Pahit Tanpa Rasa");
            }

            System.out.println("===============================");
            System.out.println("Total kopi terjual\t\t: " + (total_dontbelate + total_goncangjiawa + total_jalankenangan + total_tanparasa) + " Cup");
            System.out.println("Total sisa kopi\t\t\t: " + sisa + " Cup");
        }

        static void cek_data_pesanan(String[] jenis, String pembeli) {
            for (int i = 0; i < jenis.length; i++) {
                if (jenis[i] == null) {
                    jenis[i] = pembeli;
                    break;
                }
            }
        }

        static void data_pesanan(int jenis, String nama){
            System.out.print(nama + " pememesan Kopi ");
            switch (jenis) {
                case 1:
                    cek_data_pesanan(dontbe_late, nama);
                    System.out.println("Dontbe_Late");
                    break;
                case 2:
                    cek_data_pesanan(goncang_jiwa, nama);
                    System.out.println("Goncang_Jiwa");
                    break;
                case 3:
                    cek_data_pesanan(jalan_kenangan, nama);
                    System.out.println("Jalan_Kenangan");
                    break;
                case 4:
                    cek_data_pesanan(tanpa_rasa, nama);
                    System.out.println("Pahit_Tanparasa");
                    break;
            }

            Printdata_Pesanan();
        }

        public static void pesan() {
            try (Scanner pembeli = new Scanner(System.in)) {
                while (true) {
                    System.out.print("\nnama pembeli : ");
                    String nama_pemebeli =  pembeli.nextLine();

                    if (nama_pemebeli.isBlank()) {
                        System.out.println("nama pembeli wajib diisi");
                        pesan();
                    }else if (sisa == 0) {
                        System.out.println("Maaf semua kopi sudah habis");
                        pesan();
                    }else{
                        Random acak = new Random();
                        int jenisrandom = acak.nextInt(4) + 1;
                        data_pesanan(jenisrandom, nama_pemebeli);
                    }
                }
            }
        }
    }

