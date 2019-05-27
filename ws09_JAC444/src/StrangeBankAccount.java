public class StrangeBankAccount {
    private double balance;

    StrangeBankAccount() {
        balance = 0;
    }

    synchronized void deposit(double amount) {
        System.out.println("\nDepositing...");

        while(amount <= 0.0 && balance != 0.0){
            System.out.println("Invalid amount or account is not empty!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance += amount;
        System.out.println("Deposit completed! New balance: " + balance);
        notify();
    }

    synchronized void withdraw(){
        System.out.println("\nWithdrawing...");

        while (balance == 0.0) {
            System.out.println("Insufficient funds! Waiting for deposit...");

            try {
                wait();
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
        }

        if(balance > 0.0){
            balance -= balance;
            System.out.println("Withdrawal completed! New balance: " + balance);
            notify();
        }
    }

//    synchronized void withdraw(double amount) {
//        System.out.println("\nWithdrawing...");
//
//        while (amount > balance) {
//            System.out.println("Insufficient funds! Waiting for deposit...");
//
//            try {
//                wait();
//            } catch (Throwable e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//
//
//        balance -= amount;
//        System.out.println("Withdrawal completed! New balance: " + balance);
//
//        if(balance == 0.0){
//            notify();
//        }
//    }


}
