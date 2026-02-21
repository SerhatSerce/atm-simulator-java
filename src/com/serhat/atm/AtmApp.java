package com.serhat.atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Çoklu kullanıcı listesi
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("1111", 1000));
        accounts.add(new Account("2222", 500));
        accounts.add(new Account("3333", 2000));

        int hak = 3;
        Account girisYapanHesap = null;

        // LOGIN
        while (hak > 0) {

            System.out.print("PIN giriniz: ");
            String girilenPin = scanner.nextLine();

            for (Account acc : accounts) {
                if (acc.getPin().equals(girilenPin)) {
                    girisYapanHesap = acc;
                    break;
                }
            }

            if (girisYapanHesap != null) {
                System.out.println("Giris basarili.");
                break;
            } else {
                hak--;
                System.out.println("Yanlis PIN. Kalan hak: " + hak);
            }
        }

        if (girisYapanHesap == null) {
            System.out.println("Kart bloke edildi.");
            scanner.close();
            return;
        }

        // MENU
        boolean devam = true;

        while (devam) {

            System.out.println("\n--- ATM MENU ---");
            System.out.println("1 - Bakiye Goruntule");
            System.out.println("2 - Para Yatir");
            System.out.println("3 - Para Cek");
            System.out.println("4 - Cikis");
            System.out.print("Seciminiz: ");

            String secim = scanner.nextLine();

            switch (secim) {

                case "1":
                    System.out.println("Bakiyeniz: " + girisYapanHesap.getBalance());
                    break;

                case "2":
                    System.out.print("Yatirilacak tutar: ");
                    try {
                        double yatirilan = Double.parseDouble(scanner.nextLine());

                        if (girisYapanHesap.deposit(yatirilan)) {
                            System.out.println("Para yatirildi. Yeni bakiye: "
                                    + girisYapanHesap.getBalance());
                        } else {
                            System.out.println("Tutar 0'dan buyuk olmali.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Gecersiz sayi girdiniz.");
                    }
                    break;

                case "3":
                    System.out.print("Cekilecek tutar: ");
                    try {
                        double cekilen = Double.parseDouble(scanner.nextLine());

                        if (girisYapanHesap.withdraw(cekilen)) {
                            System.out.println("Para cekildi. Yeni bakiye: "
                                    + girisYapanHesap.getBalance());
                        } else {
                            System.out.println("Yetersiz bakiye veya gecersiz tutar.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Gecersiz sayi girdiniz.");
                    }
                    break;

                case "4":
                    System.out.println("Cikis yapiliyor...");
                    devam = false;
                    break;

                default:
                    System.out.println("Gecersiz secim.");
            }
        }

        scanner.close();
    }
}