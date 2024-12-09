import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn1 = new Scanner(System.in);
        int deneme = 0;
        boolean devamMi = true;
        System.out.print("Kelime gir:");
        String cevap = scn1.nextLine();
        char[] cevapYaz = new char[cevap.length()];
        for (int i = 0; i < cevapYaz.length; i++) {
            cevapYaz[i] = '?';
        }
        for (int i = 1; i < 20; i++) {//cevap gözükmesin diye boşluk
            System.out.println();
        }
        char[][] sablon = {
                {' ', '_', '_', '_', '_', '_', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
        };
        do {
            Scanner scn2 =new Scanner(System.in);
            switch (deneme) {
                case 0:
                    break;
                case 1:
                    sablon[2][5] = '0';
                    break;
                case 2:
                    sablon[3][5] = '|';
                    sablon[4][5] = '|';
                    break;
                case 3:
                    sablon[3][4] = '/';
                    sablon[3][6] = '\\';
                    break;
                case 4:
                    sablon[5][4] = '/';
                    sablon[5][6] = '\\';
                    break;
            }
            if (deneme <= 4) {
                System.out.println();
                for (char[] chars : sablon) {//sablonu yaz
                    for (int j = 0; j < sablon[0].length; j++) {
                        System.out.print(chars[j] + " ");
                    }
                    System.out.println();
                }
                for (char c : cevapYaz) {//cevap yaz
                    System.out.print(c + " ");
                }
                System.out.print("\n(SEÇ) Harf Tahmin(1),Kelime Tahmin(2) : ");
                int select = scn1.nextByte();
                if (select == 1) {
                    System.out.print("Harf: ");
                    String harfTahmin = scn2.nextLine();
                    if (cevap.contains(harfTahmin)) {
                        for (int i = 0; i < cevap.length(); i++) {
                            String harf=cevap.charAt(i)+"";
                            if (harf.equals(harfTahmin)) {
                                cevapYaz[i] = cevap.charAt(i);
                            }
                        }
                    } else {
                        deneme++;
                    }
                } else if (select == 2) {
                    System.out.print("Kelime: ");
                    String kelimeTahmin = scn2.nextLine();
                    if (kelimeTahmin.equals(cevap)) {
                        System.out.println("Tebrikler Kazandınız");
                        devamMi = false;
                    } else {
                        System.out.println("Yanlış Tahmin");
                        deneme++;
                    }
                }
            } else {
                System.out.println("Kaybettiniz");
                devamMi = false;
            }
        } while (devamMi);
    }
}