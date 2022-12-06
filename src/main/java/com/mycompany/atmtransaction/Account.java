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
    
    public void setNewCustomer(String accountNumber, String accountName, double balance, int pinNumber){
        if(registeredAccounts == accountList.length) extendsArray();
        accountList[registeredAccounts][0] = accountNumber;
        accountList[registeredAccounts][1] = accountName;
        accountList[registeredAccounts][2] = String.valueOf(balance);
        accountList[registeredAccounts][3] = String.valueOf(pinNumber);
        registeredAccounts++;
    }
    
    public void setNewCustomerName(int index, String name) {
        accountList[index][1] = name;
        System.out.println("Account name was successfully updated!");
    }
    
    public void setNewCustomerPin(int index, String pinNumber) {
        accountList[index][3] = pinNumber;
        System.out.println("Account Pin Number was successfully updated!");
    }
    
    public void extendsArray() {
        String[][] tempList = new String[accountList.length * 2][4];
        System.arraycopy(accountList, 0, tempList, 0, accountList.length);
        this.accountList = tempList;
    }
    
    public int verifyAccountNumber(String accountNumber) {
        for(int i = 0; i < accountList.length; i++) {
            if(accountNumber.equalsIgnoreCase(accountList[i][0])) return i;
        }
        
        return -1;
    }
    
    public int verifyAccountName(String accountName) {
        for(int i = 0; i < accountList.length; i++) {
            if(accountName.equalsIgnoreCase(accountList[i][1])) return i;
        }
        
        return -1;
    }
    
    public int verifyPinNumber(String pinNumber) {
        for(int i = 0; i < accountList.length; i++) {
            if(pinNumber.equalsIgnoreCase(accountList[i][3])) return i;
        }
        
        return -1;
    }
    
    public String[][] getAccountList() {
        return accountList;
    }
    
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
