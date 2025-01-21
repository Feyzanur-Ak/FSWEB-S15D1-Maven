package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public  static List<String> groceryList=new ArrayList<>();

    public void startGrocery (){
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.println("\nLütfen bir seçenek giriniz:");
            System.out.println("0 - Uygulamayı durdur");
            System.out.println("1 - Eleman ekle");
            System.out.println("2 - Eleman çıkar");
            System.out.println("Seçiminiz: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Geçersiz giriş! Lütfen 0, 1 veya 2 giriniz.");
                scanner.next();
            }
            number=scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 0:
                    System.out.println("Uygulama durduruluyor. Hoşçakalın!");
                    break;
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz (örnek: tomato veya tomato, orange, peach): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;
                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz (örnek: tomato veya tomato, orange, peach): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen 0, 1 veya 2 giriniz.");
            }
        } while (number != 0);

        scanner.close();
    }
    // Listeye eleman ekler
    public static void addItems(String input) {
        String[] items = input.split(","); // Virgülle ayrılmış elemanları ayır
        for (String item : items) {
            item = item.trim(); // Boşlukları temizle
            if (!item.isEmpty()) {
                if (!groceryList.contains(item)) {
                    groceryList.add(item);
                    System.out.println("'" + item + "' listeye eklendi.");
                } else {
                    System.out.println("'" + item + "' zaten listede mevcut.");
                }
            }
        }
        Collections.sort(groceryList);
    }

    // Listeden eleman çıkarır
    public static void removeItems(String input) {
        String[] items = input.split(","); // Virgülle ayrılmış elemanları ayır
        for (String item : items) {
            item = item.trim(); // Boşlukları temizle
            if (!item.isEmpty()) {
                if (groceryList.contains(item)) {
                    groceryList.remove(item);
                    System.out.println("'" + item + "' listeden çıkarıldı.");
                } else {
                    System.out.println("'" + item + "' listede bulunamadı.");
                }
            }
        }
    }

    // Elemanın listede olup olmadığını kontrol eder
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    // Listeyi sıralı şekilde ekrana basar
    public static void printSorted() {
        if (groceryList.isEmpty()) {
            System.out.println("Liste şu anda boş.");
        } else {
            System.out.println("Güncel alışveriş listesi (sıralı): " + groceryList);
        }
        Collections.sort(groceryList);
    }
}



