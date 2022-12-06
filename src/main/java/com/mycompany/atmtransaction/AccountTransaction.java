package com.mycompany.atmtransaction;

import java.util.*;

public class AccountTransaction {
    public void displayBalanceInquiry(Account account, int index) {
        Scanner sc = new Scanner(System.in);

        displayHeader();
        
        System.out.println("Account #:" + (" ".repeat(8)) + account.getAccountList()[index][0]);
        System.out.println("Account Name:" + (" ".repeat(5)) + account.getAccountList()[index][1]);
        System.out.println("Balance:" + (" ".repeat(10)) + account.getAccountList()[index][2]);
        
    }
    
    public Account withdrawAmount(Account account, int index) {
        try {
            Scanner sc = new Scanner(System.in);

            displayHeader();

            System.out.print("Enter amount to be withdrawn: ");
            int amount = sc.nextInt();
            if(!account.withdrawAmount(amount, index)) throw new Exception();
            else return account;
        } catch(Exception e) {
            System.out.println("\n===============================================\n");
        }
        
        return withdrawAmount(account, index);
    }
    
    public Account depositAmount(Account account, int index) {
        try {
            Scanner sc = new Scanner(System.in);

            displayHeader();

            System.out.print("Enter amount to be deposited: ");
            int amount = sc.nextInt();
            
            if(!account.depositAmount(amount, index)) throw new Exception();
            else return account;
        } catch(Exception e) {
            System.out.println("Invalid input! Please try again.");
            System.out.println("\n===============================================\n");
        }
        
        return depositAmount(account, index);
    }
    
    public void displayHeader() {
        System.out.println("\n\n===============================================");
        System.out.println("                     OOPBC                     ");
        System.out.println("Object Oriented Programming Banking Corporation");
        System.out.println("===============================================\n");
    }
}
