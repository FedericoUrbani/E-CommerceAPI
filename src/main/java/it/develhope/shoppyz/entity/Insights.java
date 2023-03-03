package it.develhope.shoppyz.entity;

public class Insights {
    private SellsAccount sellsAccount = new SellsAccount();
    // private Product[] mostSoldItems;
    // private Product[] salesHystory;
    private int stockThreshold;
    private int stockedAmount;

    public Insights(SellsAccount sellsAccount, int stockThreshold, int stockedAmount){
        this.sellsAccount = sellsAccount;
        this.stockThreshold = stockThreshold;
        this.stockedAmount = stockedAmount;
    }

    public SellsAccount getSellsAccount(){
        return sellsAccount;
    }
    public void setSellsAccount(SellsAccount sellsAccount){
        this.sellsAccount = sellsAccount;
    }
    public int getStockThreshold(){
        return stockThreshold;
    }
    public void setStockThreshold(int stockThreshold){
        this.stockThreshold = stockThreshold;
    }
    public int getStockedAmount(){
        return stockedAmount;
    }
    public void setStockedAmount(int stockedAmount){
        this.stockedAmount = stockedAmount;
    }

    @Override
    public String toString() {
        return "Insights{" +
                "sellsAccount=" + sellsAccount +
                ", stockThreshold=" + stockThreshold +
                ", stockedAmount=" + stockedAmount +
                '}';
    }

    //outOfWarning()
    //readOperation()

}
