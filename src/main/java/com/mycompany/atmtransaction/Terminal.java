package com.mycompany.atmtransaction;

import java.util.*;

public class Terminal extends AccountTransaction {
    private int passwordAttempt = 0;
    public String queryChoice() {
        try {
            Scanner sc = new Scanner(System.in);

            displayHeader();
            System.out.println("S -> Start Transaction");
            System.out.println("Q -> Quit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            if(!choice.equalsIgnoreCase("S") && !choice.equalsIgnoreCase("Q")) throw new Exception();
            System.out.println("===============================================");
            return choice;
        } catch(Exception e) {
            System.out.println("Invalid input! Please try again.");
            System.out.print("\n===============================================\n");
        }
        
        return queryChoice();
    }
    
    public int queryPinNumber(Account account) {
        try {
            Scanner sc = new Scanner(System.in);
            
            if(passwordAttempt >= 3) {
                System.out.println("\nCAPTURED CARD.... PLEASE CALL 143-44");
                System.out.print("\n===============================================\n");
                passwordAttempt = 0;
                return -1;
            }

            displayHeader();
            System.out.print("Enter your Pin Number: ");
            String pinNumber = sc.nextLine();

            if(account.verifyPinNumber(pinNumber) == -1) throw new Exception();
            System.out.println("===============================================");
            return account.verifyPinNumber(pinNumber);
        } catch(Exception e) {
            passwordAttempt++;
            System.out.println("Invalid input! Please try again.");
            System.out.print("\n===============================================\n");
        }
        
        return queryPinNumber(account);
    }
    
    public String queryTransactionType() {
        try {
            Scanner sc = new Scanner(System.in);

            displayHeader();
            System.out.println("Select Type of Transaction");
            System.out.println("B -> Balance Inquiry");
            System.out.println("W -> Withdrawal");
            System.out.println("D -> Deposit");
            System.out.println("C -> Cancel");
            System.out.print("Enter transaction type: ");
            String transactionType = sc.nextLine();

            if(!transactionType.equalsIgnoreCase("B") && 
               !transactionType.equalsIgnoreCase("W") &&
               !transactionType.equalsIgnoreCase("D") &&
               !transactionType.equalsIgnoreCase("C")) throw new Exception("Invalid input! Please try again.");
            System.out.println("===============================================");
            return transactionType;
        } catch(Exception e) {
            System.out.println(e);
            System.out.print("\n===============================================\n");
        }
        
        return queryTransactionType();
    }
    
    public String queryAdminAction() {
        try {
            Scanner sc = new Scanner(System.in);

            displayHeader();
            System.out.println("What would you like to do?");
            System.out.println("(V) -> View Customer Information");
            System.out.println("(A) -> Add New Customer");
            System.out.println("(E) -> Edit Customer Information");
            System.out.println("(C) -> Change Customer Pin Number");
            System.out.println("(X) -> Exit");
            System.out.print("Enter your choice: ");
            String transactionType = sc.nextLine();

            if(!transactionType.equalsIgnoreCase("V") && 
               !transactionType.equalsIgnoreCase("A") &&
               !transactionType.equalsIgnoreCase("E") &&
               !transactionType.equalsIgnoreCase("C") &&
               !transactionType.equalsIgnoreCase("X")) throw new Exception();
            System.out.println("===============================================");
            return transactionType;
        } catch(Exception e) {
            System.out.println("Invalid input! Please try again.");
            System.out.print("\n===============================================\n");
        }
        
        return queryAdminAction();
    }
    
    public void displayHeader() {
        System.out.println("\n\n===============================================");
        System.out.println("                     OOPBC                     ");
        System.out.println("Object Oriented Programming Banking Corporation");
        System.out.println("===============================================\n");
    }
}
