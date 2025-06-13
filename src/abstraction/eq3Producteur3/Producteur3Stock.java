package abstraction.eq3Producteur3;

import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.general.Variable;
import abstraction.eqXRomu.general.VariablePrivee;
import abstraction.eqXRomu.produits.Feve;
import abstraction.eqXRomu.produits.Gamme;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;


public class Producteur3Stock extends Producteur3GestionTerrains {
    //protected VariablePrivee stockFeve;
    protected HashMap<Integer,VariablePrivee> stockFeveBQ = new HashMap<Integer,VariablePrivee>();
    protected HashMap<Integer,VariablePrivee> stockFeveBQ_E = new HashMap<Integer,VariablePrivee>();
    protected HashMap<Integer,VariablePrivee> stockFeveMQ = new HashMap<Integer,VariablePrivee>();
    protected HashMap<Integer,VariablePrivee> stockFeveMQ_E = new HashMap<Integer,VariablePrivee>();
    protected HashMap<Integer,VariablePrivee> stockFeveHQ = new HashMap<Integer,VariablePrivee>();
    protected HashMap<Integer,VariablePrivee> stockFeveHQ_B = new HashMap<Integer,VariablePrivee>();
    public VariablePrivee totalStock;
    protected VariablePrivee totalStockBQ;
    protected VariablePrivee totalStockBQ_E;
    protected VariablePrivee totalStockMQ;
    protected VariablePrivee totalStockMQ_E;
    protected VariablePrivee totalStockHQ;
    protected VariablePrivee totalStockHQ_B;
    protected VariablePrivee coutStock;

    


    public Producteur3Stock(){
        super();
        
    }


    //ZoÃ©
    public void initStock(){
        for(int i = 0; i < 8; i++){
            if (i==0){
                stockFeveBQ.put(i, new VariablePrivee(getNom()+"Stock BQ de "+i,this,15000));
                stockFeveBQ_E.put(i, new VariablePrivee(getNom()+"Stock BQ Eq de "+i,this,0));
                stockFeveMQ.put(i, new VariablePrivee(getNom()+"Stock MQ de "+i,this,0));
                stockFeveMQ_E.put(i, new VariablePrivee(getNom()+"Stock MQ_E de "+i,this,41000));
                stockFeveHQ.put(i, new VariablePrivee(getNom()+"Stock HQ de "+i,this,0));
                stockFeveHQ_B.put(i, new VariablePrivee(getNom()+"Stock HQ_B de "+i,this,5200));
            }
            else{
                stockFeveBQ.put(i, new VariablePrivee(getNom()+"Stock BQ de "+i,this,0));
                stockFeveBQ_E.put(i, new VariablePrivee(getNom()+"Stock BQ Eq de "+i,this,0));
                stockFeveMQ.put(i, new VariablePrivee(getNom()+"Stock MQ de "+i,this,0));
                stockFeveMQ_E.put(i, new VariablePrivee(getNom()+"Stock MQ_E de "+i,this,0));
                stockFeveHQ.put(i, new VariablePrivee(getNom()+"Stock HQ de "+i,this,0));
                stockFeveHQ_B.put(i, new VariablePrivee(getNom()+"Stock HQ_B de "+i,this,0));
            }
        }
        totalStock = new VariablePrivee(this.getNom()+"Stock Total", this, 61200);
        totalStockBQ = new VariablePrivee(this.getNom()+"Stock Total BQ", this,15000);
        totalStockBQ_E = new VariablePrivee(this.getNom()+"Stock Total BQ_E", this,0);
        totalStockMQ = new VariablePrivee(this.getNom()+"Stock Total MQ", this,0);
        totalStockMQ_E = new VariablePrivee(this.getNom()+"Stock Total MQ_E", this,41000);
        totalStockHQ = new VariablePrivee(this.getNom()+"Stock Total HQ", this,0);
        totalStockHQ_B = new VariablePrivee(this.getNom()+"Stock Total HQ_B", this,5200);
        coutStock = new VariablePrivee(this.getNom() + "Cout Stockage", this,0);
        getIndicateurs().add(totalStock);
        getIndicateurs().add(coutStock);
        getIndicateurs().add(totalStockBQ);
        getIndicateurs().add(totalStockBQ_E);
        getIndicateurs().add(totalStockMQ);
        getIndicateurs().add(totalStockMQ_E);
        getIndicateurs().add(totalStockHQ);
        getIndicateurs().add(totalStockHQ_B);
    }


    

    public double calculTotalStock(){
        double total = 0;
        for(int i = 0; i < 8; i++){
            total+=stockFeveBQ.get(i).getValeur(cryptogramme);
            total+=stockFeveBQ_E.get(i).getValeur(cryptogramme);
            total+=stockFeveMQ.get(i).getValeur(cryptogramme);
            total+=stockFeveMQ_E.get(i).getValeur(cryptogramme);
            total+=stockFeveHQ.get(i).getValeur(cryptogramme);
            total+=stockFeveHQ_B.get(i).getValeur(cryptogramme);
        }
        totalStock.setValeur(this, total, cryptogramme);
        calculTotalStockBQ();
        calculTotalStockBQ_E();
        calculTotalStockMQ();
        calculTotalStockMQ_E();
        calculTotalStockHQ();
        calculTotalStockHQ_B();

        return total;

    }

    double calculTotalStockBQ(){
        double total = 0;
        for(int i = 0; i < 8; i++){
            total+=stockFeveBQ.get(i).getValeur(cryptogramme);
        }
        totalStockBQ.setValeur(this, total, cryptogramme);

        return total;
    }

    double calculTotalStockBQ_E(){
        double total = 0;
        for(int i = 0; i < 8; i++){
            total+=stockFeveBQ_E.get(i).getValeur(cryptogramme);
        }
        totalStockBQ_E.setValeur(this, total, cryptogramme);
        return total;
    }
    double calculTotalStockMQ(){
        double total = 0;
        for(int i = 0; i < 8; i++){
            total+=stockFeveMQ.get(i).getValeur(cryptogramme);
        }
        totalStockMQ.setValeur(this, total, cryptogramme);
        return total;
    }

    double calculTotalStockMQ_E(){
        double total = 0;
        for(int i = 0; i < 8; i++){
            total+=stockFeveMQ_E.get(i).getValeur(cryptogramme);
        }
        totalStockMQ_E.setValeur(this, total, cryptogramme);
        return total;
    }
    double calculTotalStockHQ(){
        double total = 0;
        for(int i = 0; i < 8; i++){
            total+=stockFeveHQ.get(i).getValeur(cryptogramme);
        }
        totalStockHQ.setValeur(this, total, cryptogramme);
        return total;
    }
    double calculTotalStockHQ_B(){
        double total = 0;
        for(int i = 0; i < 8; i++){
            total+=stockFeveHQ_B.get(i).getValeur(cryptogramme);
        }
        totalStockHQ_B.setValeur(this, total, cryptogramme);
        return total;
    }

    double calculTotalStockParticulier(Feve feve){
        if(feve.getGamme().equals(Gamme.BQ)){
            if(feve.isEquitable()){
                return calculTotalStockBQ_E();
            }else{
                return calculTotalStockBQ();
            }
        }
        else if(feve.getGamme().equals(Gamme.MQ)){
            if(feve.isEquitable()){
                return calculTotalStockMQ_E();
            }else{
                return calculTotalStockMQ();
            }
        }else{
            if (feve.isBio()){
                return calculTotalStockHQ_B();
            }else{
                return calculTotalStockHQ();
            }
        }
    }

    double getNouveauStockParticulier(Feve feve){
        if(feve.getGamme().equals(Gamme.BQ)){
            if(feve.isEquitable()){
                return stockFeveBQ_E.get(0).getValeur(cryptogramme);
            }else{
                return stockFeveBQ.get(0).getValeur(cryptogramme);
            }
        }
        else if(feve.getGamme().equals(Gamme.MQ)){
            if(feve.isEquitable()){
                return stockFeveMQ_E.get(0).getValeur(cryptogramme);
            }else{
                return stockFeveMQ.get(0).getValeur(cryptogramme);
            }
        }else{
            if (feve.isBio()){
                return stockFeveHQ_B.get(0).getValeur(cryptogramme);
            }else{
                return stockFeveHQ.get(0).getValeur(cryptogramme);
            }
        }

    }
    
    double getNouveauStockTotal(){
        double total = stockFeveBQ.get(0).getValeur(cryptogramme);
        total += stockFeveBQ_E.get(0).getValeur(cryptogramme);
        total += stockFeveMQ.get(0).getValeur(cryptogramme);
        total += stockFeveMQ_E.get(0).getValeur(cryptogramme);
        total += stockFeveHQ.get(0).getValeur(cryptogramme);
        total += stockFeveHQ_B.get(0).getValeur(cryptogramme);
        return total;
    }


    double getPerimeParticulier(Feve feve){
        if(feve.getGamme().equals(Gamme.BQ)){
            if(feve.isEquitable()){
                return stockFeveBQ_E.get(stockFeveBQ_E.size()-1).getValeur(cryptogramme);
            }else{
                return stockFeveBQ.get(stockFeveBQ_E.size()-1).getValeur(cryptogramme);
            }
        }
        else if(feve.getGamme().equals(Gamme.MQ)){
            if(feve.isEquitable()){
                return stockFeveMQ_E.get(stockFeveBQ_E.size()-1).getValeur(cryptogramme);
            }else{
                return stockFeveMQ.get(stockFeveBQ_E.size()-1).getValeur(cryptogramme);
            }
        }else{
            if (feve.isBio()){
                return stockFeveHQ_B.get(stockFeveBQ_E.size()-1).getValeur(cryptogramme);
            }else{
                return stockFeveHQ.get(stockFeveBQ_E.size()-1).getValeur(cryptogramme);
            }
        }
    }

    double getDerniere2periodeParticulier(Feve feve){
        if(feve.getGamme().equals(Gamme.BQ)){
            if(feve.isEquitable()){
                return getPerimeParticulier(feve) + stockFeveBQ_E.get(stockFeveBQ_E.size()-2).getValeur(cryptogramme);
            }else{
                return getPerimeParticulier(feve) + stockFeveBQ.get(stockFeveBQ_E.size()-2).getValeur(cryptogramme);
            }
        }
        else if(feve.getGamme().equals(Gamme.MQ)){
            if(feve.isEquitable()){
                return getPerimeParticulier(feve) + stockFeveMQ_E.get(stockFeveBQ_E.size()-2).getValeur(cryptogramme);
            }else{
                return getPerimeParticulier(feve) + stockFeveMQ.get(stockFeveBQ_E.size()-2).getValeur(cryptogramme);
            }
        }else{
            if (feve.isBio()){
                return getPerimeParticulier(feve) + stockFeveHQ_B.get(stockFeveBQ_E.size()-2).getValeur(cryptogramme);
            }else{
                return getPerimeParticulier(feve) + stockFeveHQ.get(stockFeveBQ_E.size()-2).getValeur(cryptogramme);
            }
        }
    }
    void vieillirStock(){
        for (int i = 6; i >= 0; i--) { 
            stockFeveBQ.get(i+1).setValeur(this, stockFeveBQ.get(i).getValeur(cryptogramme), cryptogramme);
            stockFeveBQ_E.get(i+1).setValeur(this, stockFeveBQ_E.get(i).getValeur(cryptogramme), cryptogramme);
            stockFeveMQ.get(i+1).setValeur(this, stockFeveMQ.get(i).getValeur(cryptogramme), cryptogramme);
            stockFeveMQ_E.get(i+1).setValeur(this, stockFeveMQ_E.get(i).getValeur(cryptogramme), cryptogramme);
            stockFeveHQ.get(i+1).setValeur(this, stockFeveHQ.get(i).getValeur(cryptogramme), cryptogramme);
            stockFeveHQ_B.get(i+1).setValeur(this, stockFeveHQ_B.get(i).getValeur(cryptogramme), cryptogramme);
        }
        stockFeveBQ.get(0).setValeur(this, sechageBQ[0], cryptogramme);
        stockFeveBQ_E.get(0).setValeur(this, sechageBQ_E[0], cryptogramme);
        stockFeveMQ.get(0).setValeur(this, sechageMQ[0], cryptogramme);
        stockFeveMQ_E.get(0).setValeur(this, sechageMQ_E[0], cryptogramme);
        stockFeveHQ.get(0).setValeur(this, sechageHQ[0], cryptogramme);
        stockFeveHQ_B.get(0).setValeur(this, sechageHQ_B[0], cryptogramme);
    }
    
    
// Alice

    public void ajouterStockBQ(Feve feve,double delta){
        stockFeveBQ.get(0).ajouter(this,delta,cryptogramme);
        journal.ajouter("Ajout de " + delta + " au stock de " + feve + ". Nouveau stock : " + stockFeveBQ.get(0).getValeur(cryptogramme));
        calculTotalStock();
    }
    public void ajouterStockBQ_E(Feve feve,double delta){
        stockFeveBQ_E.get(0).ajouter(this,delta,cryptogramme);
        journal.ajouter("Ajout de " + delta + " au stock de " + feve + ". Nouveau stock : " + stockFeveBQ_E.get(0).getValeur(cryptogramme));
        calculTotalStock();
    }
    public void ajouterStockMQ(Feve feve,double delta){
        stockFeveMQ.get(0).ajouter(this,delta,cryptogramme);
        journal.ajouter("Ajout de " + delta + " au stock de " + feve + ". Nouveau stock : " + stockFeveMQ.get(0).getValeur(cryptogramme));
        calculTotalStock();
    }
    public void ajouterStockMQ_E(Feve feve,double delta){
        stockFeveMQ.get(0).ajouter(this,delta,cryptogramme);
        journal.ajouter("Ajout de " + delta + " au stock de " + feve + ". Nouveau stock : " + stockFeveMQ_E.get(0).getValeur(cryptogramme));
        calculTotalStock();
    }
    public void ajouterStockHQ(Feve feve,double delta){
        stockFeveHQ.get(0).ajouter(this,delta,cryptogramme);
        journal.ajouter("Ajout de " + delta + " au stock de " + feve + ". Nouveau stock : " + stockFeveHQ.get(0).getValeur(cryptogramme));
        calculTotalStock();
    }
    public void ajouterStockHQ_B(Feve feve,double delta){
        stockFeveHQ.get(0).ajouter(this,delta,cryptogramme);
        journal.ajouter("Ajout de " + delta + " au stock de " + feve + ". Nouveau stock : " + stockFeveHQ_B.get(0).getValeur(cryptogramme));
        calculTotalStock();
    }

    public void ajouterStockBQFin(Feve feve,double delta){
        stockFeveBQ.get(stockFeveBQ.size()-1).ajouter(this,delta,cryptogramme);
        journal.ajouter("Ajout de " + delta + " au stock de " + feve + "en fin de vie.");
        calculTotalStock();
    }
    public void ajouterStockMQFin(Feve feve,double delta){
        stockFeveMQ.get(stockFeveBQ.size()-1).ajouter(this,delta,cryptogramme);
        journal.ajouter("Ajout de " + delta + " au stock de " + feve + "en fin de vie.");
        calculTotalStock();
    }


    public void retirerStockBQ(Feve feve,double delta){
        double qte = delta;
        for(int i = 0; i < 8; i++){
            double val = stockFeveBQ.get(i).getValeur(cryptogramme);
            if(val>=qte){
                stockFeveBQ.get(i).retirer(this, delta, cryptogramme);
                journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockBQ());
                calculTotalStock();
                return;
            }else{
                stockFeveBQ.get(i).retirer(this, val, cryptogramme);
                qte-=val;
            }
        }
        journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockBQ());
        calculTotalStock();
    }

    public void retirerStockBQ_E(Feve feve,double delta){
        double qte = delta;
        for(int i = 0; i < 8; i++){
            double val = stockFeveBQ_E.get(i).getValeur(cryptogramme);
            if(val>=qte){
                stockFeveBQ_E.get(i).retirer(this, delta, cryptogramme);
                journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockBQ_E());
                calculTotalStock();
                return;
            }else{
                stockFeveBQ_E.get(i).retirer(this, val, cryptogramme);
                qte-=val;
            }
        }
        journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockBQ_E());
        calculTotalStock();
    }

    public void retirerStockMQ(Feve feve,double delta){
        double qte = delta;
        for(int i = 0; i < 8; i++){
            double val = stockFeveMQ.get(i).getValeur(cryptogramme);
            if(val>=qte){
                stockFeveMQ.get(i).retirer(this, delta, cryptogramme);
                journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockMQ());
                calculTotalStock();
                return;
            }else{
                stockFeveMQ.get(i).retirer(this, val, cryptogramme);
                qte-=val;
            }
        }
        journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockMQ());
        calculTotalStock();
    }

    public void retirerStockMQ_E(Feve feve,double delta){
        double qte = delta;
        for(int i = 0; i < 8; i++){
            double val = stockFeveMQ_E.get(i).getValeur(cryptogramme);
            if(val>=qte){
                stockFeveMQ_E.get(i).retirer(this, delta, cryptogramme);
                journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockMQ_E());
                calculTotalStock();
                return;
            }else{
                stockFeveMQ_E.get(i).retirer(this, val, cryptogramme);
                qte-=val;
            }
        }
        journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockMQ_E());
        calculTotalStock();
    }

    public void retirerStockHQ(Feve feve,double delta){
        double qte = delta;
        for(int i = 0; i < 8; i++){
            double val = stockFeveHQ.get(i).getValeur(cryptogramme);
            if(val>=qte){
                stockFeveHQ.get(i).retirer(this, delta, cryptogramme);
                journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockHQ());
                calculTotalStock();
                return;
            }else{
                stockFeveHQ.get(i).retirer(this, val, cryptogramme);
                qte-=val;
            }
        }
        journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockHQ());
        calculTotalStock();
    }

    public void retirerStockHQ_B(Feve feve,double delta){
        double qte = delta;
        for(int i = 0; i < 8; i++){
            double val = stockFeveHQ_B.get(i).getValeur(cryptogramme);
            if(val>=qte){
                stockFeveHQ_B.get(i).retirer(this, delta, cryptogramme);
                journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockHQ_B());
                calculTotalStock();
                return;
            }else{
                stockFeveHQ_B.get(i).retirer(this, val, cryptogramme);
                qte-=val;
            }
        }
        journal.ajouter("Retrait de " + delta + " du stock de " + feve + ". Nouveau stock : " + calculTotalStockHQ_B());
        calculTotalStock();
    }

    public double calculCoutStock() {
        coutStock.setValeur(this, 7.5 * calculTotalStock(), cryptogramme);
        return  coutStock.getValeur(cryptogramme); 
        
    }

    public int getStepActuel() {
        return Filiere.LA_FILIERE.getEtape(); // RÃ©cupÃ¨re le step actuel depuis la filiÃ¨re
    }


  



   
    
}