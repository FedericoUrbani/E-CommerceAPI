package it.develhope.shoppyz.account;

import it.develhope.shoppyz.account.SellsAccount;

public class Insights {
    private SellsAccount sellsAccount = new SellsAccount();
    // private Product[] mostSoldItems;
    // private Product[] salesHystory;
    private int stockThreshold;
    private int stockedAmount;

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
    //outOfWarning()
    //readOperation()
}
