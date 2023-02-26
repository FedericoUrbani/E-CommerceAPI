package it.develhope.shoppyz.account;

/*
bisogna creare queste classi per completare sellsAccount
 */
public class SellsAccount{// extends Account{
    // private Product [] productsStock;
    private Insights insights;
    private Agency agency;
    // private Bank bankDetails;

    public Agency getAgency(){
        return agency;
    }
    public void setAgency(Agency agency){
        this.agency = agency;
    }
    public Insights getInsights(){
        return insights;
    }
    public void setInsights(Insights insights){
        this.insights = insights;
    }
}
