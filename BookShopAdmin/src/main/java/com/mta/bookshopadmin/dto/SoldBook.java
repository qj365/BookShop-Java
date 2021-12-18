package com.mta.bookshopadmin.dto;

public class SoldBook {
    private int IdBook;
    private String Name;
    private int Amount;

    public int getIdBook() {
        return IdBook;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
