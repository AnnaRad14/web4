package task2;

public class Currency {

    private int r030;
    private String txt;
    private double rate;
    private String cc;
    private String exchangedate;

    public Currency() {
    }

    public int getR030() {
        return r030;
    }

    public String getTxt() {
        return txt;
    }

    public double getRate() {
        return rate;
    }

    public String getCc() {
        return cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    @Override
    public String toString() {
        return cc + " - " + txt +
                ": " + rate +
                " грн, дата: " + exchangedate;
    }
}