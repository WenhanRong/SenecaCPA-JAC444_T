public class Main {
    public static void main(String[] args) {
        StrangeBankAccount sharedAccount = new StrangeBankAccount();

        new Thread(){
            public void run(){sharedAccount.withdraw();}
        }.start();

        new Thread(){
            public void run(){sharedAccount.deposit(1);}
        }.start();

        new Thread(){
            public void run(){sharedAccount.deposit(2);}
        }.start();

        new Thread(){
            public void run(){sharedAccount.withdraw();}
        }.start();

        new Thread(){
            public void run(){sharedAccount.deposit(3);}
        }.start();

        new Thread(){
            public void run(){sharedAccount.withdraw();}
        }.start();







    }
}
