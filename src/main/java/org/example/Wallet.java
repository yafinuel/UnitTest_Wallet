package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String name;
    private ArrayList<ArrayList<Object>> cards = new ArrayList<>();
    private int cash;

    public String withdraw(int amount)
    {
        int saldoCheck = this.cash - amount;
        if (saldoCheck < 0){
            return "Saldo anda tidak mencukupi";
        }
        this.cash = saldoCheck;
        return "Berhasil menarik: " + amount + "sisa saldo anda" + this.cash;
    }

    public String deposit(int amount){
        if(amount < 0 ){
            return "Tidak valid";
        }
        this.cash += amount;
        return "Berhasil, saldo anda sekarang adalah " + this.cash;
    }

    public String setOwner(String name){
        this.name = name;
        return "nama berhasil di set" + this.name;
    }

    public String addCards(String bank, int accountNumber){
        ArrayList<Object> card = new ArrayList<>(List.of(bank, accountNumber));
        cards.add(card);
        return "berhasil menambahkan kartu";
    }

    public String removeCard(String bank, int accountNumber){
        ArrayList<Object> cardCheck = new ArrayList<>(List.of(bank, accountNumber));
        if(cards.contains(cardCheck)){
            int position = cards.indexOf(cardCheck);
            cards.remove(position);
            return "Kartu berhasil dihapus";
        }
        return "Kartu tidak ditemukan";
    }

    public String getName() {
        return name;
    }

    public ArrayList<ArrayList<Object>> getCards() {
        return cards;
    }

    public int getCash() {
        return cash;
    }
}
