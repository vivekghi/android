package com.accenture.training.anddemo1;

public class Expense {

    public String title;
    public int amount;
    public String category;
    public boolean isCredit;
    public String toString() {
        return category + " " + title +" " + isCredit + " " + amount;
    }
}
