package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0.0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate = rate;
        // minimum balance is 0 by default

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance



        if(this.maxWithdrawalLimit<amount)
        {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }

        if(amount > this.getBalance())
        {

            throw new Exception("Insufficient Balance");
        }

       // this.maxWithdrawalLimit=this.maxWithdrawalLimit-amount;
        this.setBalance(this.getBalance()-amount);



    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

  public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on current amount

        double simpleIntrest=this.getBalance()*(1+(this.rate*years)/100);

        return simpleIntrest;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundIntrest=this.getBalance()*Math.pow((1+this.rate/(100*times)),times*years);

        return compoundIntrest;
    }

}
