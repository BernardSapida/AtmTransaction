package com.mycompany.atmtransaction;

import java.util.*;

public class AccountTransaction {
    /**
     * This function displays the header, account number, account name, and balance of the account.
     * 
     * @param account the account object
     * @param index the index of the account in the array
     */
    public void displayBalanceInquiry(Account account, int index) {
        Scanner sc = new Scanner(System.in);

        displayHeader();
        
        System.out.println("Account #:" + (" ".repeat(8)) + account.getAccountList()[index][0]);
        System.out.println("Account Name:" + (" ".repeat(5)) + account.getAccountList()[index][1]);
        System.out.println("Balance:" + (" ".repeat(10)) + account.getAccountList()[index][2]);
        
    }
    
    /**
     * It takes an account object and an index as parameters, and returns an account object.
     * 
     * @param account The account object that is being used
     * @param index the index of the account in the arraylist
     * @return The account object is being returned.
     */
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
    
    /**
     * It takes in an account object and an index, and returns an account object
     * 
     * @param account Account object
     * @param index the index of the account in the arraylist
     * @return The account object is being returned.
     */
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
    
    // A method that displays a header.
    public void displayHeader() {
        System.out.println("\n\n===============================================");
        System.out.println("                     OOPBC                     ");
        System.out.println("Object Oriented Programming Banking Corporation");
        System.out.println("===============================================\n");
    }
}
