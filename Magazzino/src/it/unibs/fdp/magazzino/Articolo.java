package it.unibs.fdp.magazzino;

public class Articolo {

    private String nome;
    private int quantity;
    private int minimum;
    private int maximum;
    private Orario tempoProduzione;

    public Articolo(String nome, int quantity, int minimum, int maximum, Orario tempoProduzione) {
        this.nome = nome;
        this.quantity = quantity;
        this.minimum = minimum;
        this.maximum = maximum;
        this.tempoProduzione = tempoProduzione;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Articolo: " + nome + ", quantita': " + quantity + ", scorta minima: " + minimum + ", scorta massima: " + maximum;
    }

    public void ordina(int articoloAcquistati) {

        int daProdurre;

        if(articoloAcquistati <= quantity) {

            System.out.println("L'ordina e' andato a buon fine");

            quantity = quantity - articoloAcquistati;

            if(quantity < minimum) {

                daProdurre = maximum - quantity;

                System.out.println("Verranno prodotti " + daProdurre + " pezzi di " + nome + ", il restock verrà fatto tra " + Orario.calcolaOrarioProduzione(tempoProduzione, daProdurre));

                quantity = maximum;
            }
            System.out.println("Quantita': " + quantity);
        }

        else {
            System.out.println("Ci dispice, le scorte in magazzino non sono sufficienti.");
            System.out.println("Verranno mandati subito in produzione");

            daProdurre = articoloAcquistati;

            System.out.println("I suoi pezzi saranno pronti tra " + Orario.calcolaOrarioProduzione(tempoProduzione, daProdurre));
        }
    }

    public boolean esaurito() {

        if(quantity == 0)
            return true;

        return false;

    }
}
