package com.serhat.atm.ui;

import com.serhat.atm.model.Account;
import com.serhat.atm.repository.AccountRepository;
import com.serhat.atm.service.AccountService;
import com.serhat.atm.service.AuthService;

import java.util.List;
import java.util.Scanner;

public class AtmConsoleUI {

    private AccountRepository repository;
    private AuthService authService;
    private AccountService accountService;
    private Scanner scanner;

    public AtmConsoleUI() {
        this.repository = new AccountRepository();
        this.authService = new AuthService();
        this.accountService = new AccountService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        List<Account> accounts = repository.getAllAccounts();

        int hak = 3;
        Account girisYapanHesap = null;

        // LOGIN
        while (hak > 0) {
            System.out.print("PIN giriniz: ");
            String girilenPin = scanner.nextLine();

            girisYapanHesap = authService.login(accounts, girilenPin);

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

                        if (accountService.deposit(girisYapanHesap, yatirilan)) {
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

                        if (accountService.withdraw(girisYapanHesap, cekilen)) {
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
    }
}