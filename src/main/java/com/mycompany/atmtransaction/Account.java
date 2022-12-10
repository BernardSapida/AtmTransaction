package com.mycompany.atmtransaction;

public class Account {
    private String[][] accountList = new String[6][4];
    private int registeredAccounts = 6;
    
    public Account() {
        accountList[0][0] = "0578-9417-2973";
        accountList[0][1] = "Administrator";
        accountList[0][2] = "0.0";
        accountList[0][3] = "0000";
        
        accountList[1][0] = "0123-4567-8901";
        accountList[1][1] = "Roel Richard";
        accountList[1][2] = "5000.0";
        accountList[1][3] = "1111";
        
        accountList[2][0] = "2345-6789-0123";
        accountList[2][1] = "Dorie Marie";
        accountList[2][2] = "0.0";
        accountList[2][3] = "2222";
        
        accountList[3][0] = "3456-7890-1234";
        accountList[3][1] = "Railee Darrel";
        accountList[3][2] = "10000.0";
        accountList[3][3] = "3333";
        
        accountList[4][0] = "4567-8901-2345";
        accountList[4][1] = "Railynne Dessirei";
        accountList[4][2] = "2500.0";
        accountList[4][3] = "4444";
        
        accountList[5][0] = "5678-9012-3456";
        accountList[5][1] = "Rein Dessirei";
        accountList[5][2] = "10000.0";
        accountList[5][3] = "5555";
    }
    
    /**
     * This function takes in a string, a string, a double, and an int, and then adds them to the
     * accountList array
     * 
     * @param accountNumber The account number of the customer
     * @param accountName The name of the account holder
     * @param balance double
     * @param pinNumber The pin number of the account
     */
    public void setNewCustomer(String accountNumber, String accountName, double balance, int pinNumber){
        if(registeredAccounts == accountList.length) extendsArray();
        accountList[registeredAccounts][0] = accountNumber;
        accountList[registeredAccounts][1] = accountName;
        accountList[registeredAccounts][2] = String.valueOf(balance);
        accountList[registeredAccounts][3] = String.valueOf(pinNumber);
        registeredAccounts++;
    }
    
    /**
     * This function takes in an index and a name and sets the name of the customer at the given index
     * to the given name.
     * 
     * @param index the index of the account in the array
     * @param name The name of the account holder
     */
    public void setNewCustomerName(int index, String name) {
        accountList[index][1] = name;
        System.out.println("Account name was successfully updated!");
    }
    
    /**
     * This function sets the pin number of a customer account.
     * 
     * @param index the index of the account in the array
     * @param pinNumber The new pin number that the customer wants to change to.
     */
    public void setNewCustomerPin(int index, String pinNumber) {
        accountList[index][3] = pinNumber;
        System.out.println("Account Pin Number was successfully updated!");
    }
    
    /**
     * It creates a new array that is twice the size of the original array, copies the original array
     * into the new array, and then sets the original array to the new array
     */
    public void extendsArray() {
        String[][] tempList = new String[accountList.length * 2][4];
        System.arraycopy(accountList, 0, tempList, 0, accountList.length);
        this.accountList = tempList;
    }
    
    /**
     * This function takes a string as an argument and returns an integer
     * 
     * @param accountNumber The account number to be verified.
     * @return The index of the account number in the array.
     */
    public int verifyAccountNumber(String accountNumber) {
        for(int i = 0; i < accountList.length; i++) {
            if(accountNumber.equalsIgnoreCase(accountList[i][0])) return i;
        }
        
        return -1;
    }
    
    /**
     * This function takes a string as an argument and returns an integer
     * 
     * @param accountName The name of the account to be verified.
     * @return The index of the account name in the array.
     */
    public int verifyAccountName(String accountName) {
        for(int i = 0; i < accountList.length; i++) {
            if(accountName.equalsIgnoreCase(accountList[i][1])) return i;
        }
        
        return -1;
    }
    
    /**
     * This function takes a pin number as a parameter and returns the index of the account that
     * matches the pin number
     * 
     * @param pinNumber The pin number that the user entered.
     * @return The index of the account in the accountList array.
     */
    public int verifyPinNumber(String pinNumber) {
        for(int i = 0; i < accountList.length; i++) {
            if(pinNumber.equalsIgnoreCase(accountList[i][3])) return i;
        }
        
        return -1;
    }
    
    /**
     * This function returns the accountList array
     * 
     * @return The accountList array.
     */
    public String[][] getAccountList() {
        return accountList;
    }
    
    /**
     * It checks if the amount to withdraw is less than the amount in the account, if it is divisible
     * by 100, and if it is, it withdraws the amount
     * 
     * @param amount the amount to withdraw
     * @param index the index of the account in the array
     * @return A boolean value.
     */
    public boolean withdrawAmount(int amount, int index) {
        if(Double.parseDouble(accountList[index][2]) < amount) {
            System.out.println("The amount to withdraw exceeds the remaining amount in your account.");
            System.out.println("Please try again!");
            return false;
        } else if(!(amount % 100 == 0)) {
            System.out.println("The amount should be divisible by 100! Please try again.");
            return false;
        } else {
            System.out.println("Amount successfully withdrawn!");
            accountList[index][2] = String.valueOf(Double.parseDouble(accountList[index][2]) - amount);
            return true;
        }
    }
    
    /**
     * This function takes in an amount and an index and deposits the amount into the account at the
     * index
     * 
     * @param amount The amount to be deposited
     * @param index the index of the account in the accountList array
     * @return A boolean value.
     */
    public boolean depositAmount(int amount, int index) {
        if(amount < 100) {
            System.out.println("The minimum deposit amount is 100");
            return false;
        } else {
            System.out.println("Amount successfully deposited!");
            accountList[index][2] = String.valueOf(Double.parseDouble(accountList[index][2]) + amount);
            return true;
        }
    }
}
