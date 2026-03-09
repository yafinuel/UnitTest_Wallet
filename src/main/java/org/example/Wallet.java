package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private Owner owner;
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

    public String setOwner(Owner owner){
        this.owner = owner;
        return "Berhasil menambah owner " + owner.getName() ;
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

    public Boolean checkCards(String bank, int accountNumber) {
        for (ArrayList<Object> card : cards) {
            // Cek apakah bank sama DAN account number sama
            if (card.get(0).equals(bank) && card.get(1).equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public int getCash() {
        return cash;
    }
}
