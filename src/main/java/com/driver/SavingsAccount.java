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
        if(amount > this.getBalance())
        {
            try {

            throw new Exception();
            }
            catch (Exception e)
            {
                System.out.println("Insufficient Balance");
            }
        }

        double limit=this.maxWithdrawalLimit-amount;

        if(limit<0)
        {
            try {

            throw new Exception();
            }
            catch (Exception e)
            {
                System.out.println("Maximum Withdraw Limit Exceed");
            }
        }
        else
        {
            this.maxWithdrawalLimit = limit;
            this.setBalance(this.getBalance()-amount);
        }


    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

  public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on current amount

        double simpleIntrest=(this.getBalance()*this.rate*years)/100;

        return this.getBalance()+simpleIntrest;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundIntrest=this.getBalance()*Math.pow((1+(this.rate/times)),times*years);

        return this.getBalance() + compoundIntrest;
    }

}
