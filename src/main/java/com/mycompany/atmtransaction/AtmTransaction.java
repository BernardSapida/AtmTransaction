package com.mycompany.atmtransaction;

import java.util.Scanner;

public class AtmTransaction {
    private Account account = new Account();
    private AccountTransaction accountTransaction = new AccountTransaction();
    private Administrator administrator = new Administrator();
    private Terminal terminal = new Terminal();
    
    public static void main(String[] args) {
        AtmTransaction atmTransaction = new AtmTransaction();
        atmTransaction.startProgram();
    }
    
    /**
     * It starts the program by asking the user to enter a choice, then it asks the user to enter a pin
     * number, and then it starts the administrator or client program depending on the pin number.
     */
    public void startProgram() {
        outerLoop: while(true) {
            Scanner sc = new Scanner(System.in);
            
            String choice = terminal.queryChoice();
            if(choice.equalsIgnoreCase("Q")) break;
            
            int pinNumber = terminal.queryPinNumber(account);
            if(pinNumber == -1) continue;
            
            if(pinNumber == 0) startAdministrator(pinNumber);
            else startClient(pinNumber);
        }
        
        System.out.println("\nThank you for using ATM Transaction Program!");
    }
    
    /**
     * This function is called when the user selects the administrator option from the main menu. It
     * then prompts the user to select an action to perform. The user can then select from a list of
     * actions to perform
     * 
     * @param pinNumber the pin number of the customer
     */
    public void startAdministrator(int pinNumber) {
        innerLoop: while(true) {
            String administratorAction = terminal.queryAdminAction();
            Scanner sc = new Scanner(System.in);

            switch(administratorAction.toUpperCase()){
                case "V" -> { administrator.viewCustomerInformation(account); }
                case "A" -> { account = administrator.addNewCustomer(account); }
                case "E" -> { account = administrator.editCustomerInformation(account); }
                case "C" -> { account = administrator.changeCustomerPinNumber(account, pinNumber); }
                case "X" -> { break innerLoop; }
            }
        }
    }
    
    /**
     * It's a function that starts the client and asks the user to input a transaction type
     * 
     * @param pinNumber the pin number of the account
     */
    public void startClient(int pinNumber) {
        innerLoop: while(true) {
            String transactionType = terminal.queryTransactionType();
            Scanner sc = new Scanner(System.in);

            switch(transactionType.toUpperCase()){
                case "B" -> { accountTransaction.displayBalanceInquiry(account, pinNumber); }
                case "W" -> { account = accountTransaction.withdrawAmount(account, pinNumber); }
                case "D" -> { account = accountTransaction.depositAmount(account, pinNumber); }
                case "C" -> { break innerLoop; }
            }
            
            System.out.print("Press X to Exit: ");
            String response = sc.nextLine();

            while(!response.equalsIgnoreCase("X")) {
                System.out.println("Invalid input! Please try again.");
                System.out.println("\n===============================================\n");
                System.out.print("Press X to Exit: ");
                response = sc.nextLine();
            }
        }
    }
}
