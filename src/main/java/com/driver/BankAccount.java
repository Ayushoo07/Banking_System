package com.driver;


import java.util.HashSet;public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    public String   getName() {
        return name;
    }
    public double   getBalance() {
        return balance;
    }
    public double   getMinBalance() {
        return minBalance;
}

    public BankAccount(String name, double balance, double minBalance)
    {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        String accountNumber=generate(sum,digits);

        if(accountNumber.equals("-1"))
        {
            throw new Exception("Account Number can not be generated");
        }

        return accountNumber;
    }

    public void deposit(double amount)
    {
        this.balance+=amount;
        //add amount to balance

    }


    public void withdraw(double amount) throws Exception
    {
        if(this.balance-amount<this.minBalance)
        {
            throw new Exception("Insufficient Balance");
        }
        else
        {
            this.balance -= amount;
        }


        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

    }

  private String generate(int S, int D)
  {
    if ((9 * D) < S) return "-1";

    String ans = "";
    for (int i = D - 1; i >= 0; i--)
    {
      if (S > 9)
      {
        ans = "9" + ans;
        S = S - 9;
      }
      else
      {
        if (i == 0)
        {
          ans = S + "" + ans;
        }
        else
        {
          ans = (int) (S - 1) + "" + ans;
          i--;
          while (i != 0)
          {
            ans = "0" + ans;
            i--;
          }
          ans = "1" + ans;
          break;
        }
      }
    }
    return ans;
  }

}