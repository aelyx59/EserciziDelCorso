package it.unibs.fdp.contoCorrente;

public class ContoCorrente {

    private String owner;
    private double balance;

    private static final int soglia = 5000;

    public ContoCorrente(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double withdraw(double importo) {

        if(importo < balance && importo < soglia) {

            balance = balance - importo;

            String.format("%.2f", balance);

            return balance;
        }

        System.out.println("Operazione fallita: hai inserito un importo maggiore rispetto al saldo disponibile o alla soglia (5000$)");
        return balance;

    }

    public double deposit(double versamento) {

        balance = balance + versamento;

        return balance;
    }
}
