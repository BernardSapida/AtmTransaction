package com.mycompany.atmtransaction;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Administrator {
    /**
     * It prints out the account information of the customer
     * 
     * @param account Account object
     */
    public void viewCustomerInformation(Account account) {
        try {
            System.out.println("==========================================================================================");
            System.out.println("Account Number" + " ".repeat(11) + "Account Name" + " ".repeat(18) + "Balance" + " ".repeat(18) + "Pin Number");
            System.out.println("==========================================================================================");
            for(int i = 0; i < account.getAccountList().length; i++) {
                System.out.print(account.getAccountList()[i][0] + " ".repeat(5 + (20-account.getAccountList()[i][0].length())));
                System.out.print(account.getAccountList()[i][1] + " ".repeat(5 + (25-account.getAccountList()[i][1].length())));
                System.out.print(account.getAccountList()[i][2] + " ".repeat(5 + (20-account.getAccountList()[i][2].length())));
                System.out.print(account.getAccountList()[i][3]);
                System.out.print("\n==========================================================================================\n");
            }
        } catch(Exception e) {}
    }
    
    /**
     * It adds a new customer to the bank
     * 
     * @param account An object of the Account class
     * @return The method is returning an object of type Account.
     */
    public Account addNewCustomer(Account account) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Account Number (Format: 0000-0000-0000): ");
        String accountNumber = sc.nextLine();
        while(true) {
            if(Pattern.compile("^[0-9]{4}-[0-9]{4}-[0-9]{4}$").matcher(accountNumber).find() && account.verifyAccountNumber(accountNumber) == -1) break;
            if(!Pattern.compile("^[0-9]{4}-[0-9]{4}-[0-9]{4}$").matcher(accountNumber).find()) System.out.println("Invalid input! Please try again.");
            else System.out.println("Account number already exists! Please try again.");
            System.out.println("\n===============================================\n");
            System.out.print("Account Number (Format: 0000-0000-0000): ");
            accountNumber = sc.nextLine();
        }
        
        System.out.print("Account Name (Format: Firstname Surname): ");
        String accountName = sc.nextLine();
        while(true) {
            if(Pattern.compile("^[a-zA-Z]+ [a-zA-Z]+$").matcher(accountName).find() && account.verifyAccountName(accountName) == -1) break;
            if(!Pattern.compile("^[a-zA-Z]+ [a-zA-Z]+$").matcher(accountName).find()) System.out.println("Invalid account name! Please try again.");
            else System.out.println("Account name already exists! Please try again.");
            System.out.println("\n===============================================\n");
            System.out.print("Account Name (Format: Firstname Surname): ");
            accountName = sc.nextLine();
        }
        
        System.out.print("Account Balance: ");
        String balance = sc.nextLine();
        while(!Pattern.compile("^[0-9]+$").matcher(balance).find()) {
            System.out.println("Invalid input! Please try again.");
            System.out.println("\n===============================================\n");
            System.out.print("Account Balance: ");
            balance = sc.nextLine();
        }
        
        System.out.print("Account Pin Number (Format: 0000): ");
        String pinNumber = sc.nextLine();
        while(true) {
            if(Pattern.compile("^[0-9]{4}$").matcher(pinNumber).find() && account.verifyPinNumber(pinNumber) == -1) break;
            if(!Pattern.compile("^[0-9]{4}$").matcher(pinNumber).find()) System.out.println("Invalid pin number! Please try again.");
            else System.out.println("Invalid pin number! Please try another pin number.");
            System.out.println("\n===============================================\n");
            System.out.print("Account Pin Number (Format: 0000): ");
            pinNumber = sc.nextLine();
        }
        
        account.setNewCustomer(accountNumber, accountName, Integer.parseInt(balance), Integer.parseInt(pinNumber));
        return account;
    }
    
    /**
     * It edits the customer's name
     * 
     * @param account An object of the Account class
     * @return The account object is being returned.
     */
    public Account editCustomerInformation(Account account) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Account Number of user you want to edit (Format: 0000-0000-0000): ");
        String accountNumber = sc.nextLine();
        int position = account.verifyAccountNumber(accountNumber);
        
        while(true) {
            if(position != -1) {
                System.out.print("New Account Name (Format: Firstname Surname): ");
                String accountName = sc.nextLine();
                
                while(!Pattern.compile("^[a-zA-Z]+ [a-zA-Z]+$").matcher(accountName).find()) {
                    System.out.println("Invalid account name! Please try again.");
                    System.out.println("\n===============================================\n");
                    System.out.print("New Account Name (Format: Firstname Surname): ");
                    accountName = sc.nextLine();
                }
                
                account.setNewCustomerName(position, accountName);
                break;
            }
            
            System.out.println("Account number didn't exist! Please try again.");
            System.out.println("\n===============================================\n");
            System.out.print("Enter Account Number of user you want to edit (Format: 0000-0000-0000): ");
            accountNumber = sc.nextLine();
            position = account.verifyAccountNumber(accountNumber);
        }
        
        return account;
    }
    
    // A method that changes the pin number of a customer.
    public Account changeCustomerPinNumber(Account account, int index) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Account Number of user you want to edit (Format: 0000-0000-0000): ");
        String accountNumber = sc.nextLine();
        int position = account.verifyAccountNumber(accountNumber);
        
        while(true) {
            if(position != -1) {
                System.out.print("New Pin Number (Format: 0000): ");
                String pinNumber = sc.nextLine();
                
                while(true) {
                    if(!Pattern.compile("^[0-9]{4}$").matcher(pinNumber).find()) System.out.println("Invalid Pin Number! Please try again.");
                    else if(account.verifyPinNumber(pinNumber) != -1) System.out.println("Invalid Pin Number! Please try another pin number.");
                    else break;
                    
                    System.out.println("\n===============================================\n");
                    System.out.print("New Pin Number (Format: 0000): ");
                    pinNumber = sc.nextLine();
                }
                
                account.setNewCustomerPin(position, pinNumber);
                break;
            }
            
            System.out.println("Account pinnumber didn't exist! Please try again.");
            System.out.println("\n===============================================\n");
            System.out.print("Enter Account Number of user you want to edit (Format: 0000-0000-0000): ");
            accountNumber = sc.nextLine();
            position = account.verifyAccountNumber(accountNumber);
        }
        
        return account;
    }
}
