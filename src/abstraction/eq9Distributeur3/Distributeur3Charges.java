package abstraction.eq9Distributeur3;

import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.produits.ChocolatDeMarque;

public class Distributeur3Charges extends Distributeur3ContratCadre {
    Distributeur3Charges(){
        super();
    }

    @Override
    public void next() {
        super.next();

        int nbEmployes = 3;
        int salaireEmployes = 700;
        //System.out.println("paiement des frais de stockage : "+this.stockTotal.getValeur(Filiere.LA_FILIERE.getEtape(),this.cryptogramme)+" tonnes ");
        this.journalCharges.ajouter("--------- ETAPE "+Filiere.LA_FILIERE.getEtape()+" ---------");
        Filiere.LA_FILIERE.getBanque().payerCout(this,this.cryptogramme,"Stockage",Filiere.LA_FILIERE.getParametre("cout moyen stockage producteur").getValeur()*16*this.stockTotal.getValeur(this.cryptogramme));
        this.journalCharges.ajouter("paiment stock : "+Filiere.LA_FILIERE.getParametre("cout moyen stockage producteur").getValeur()*16*this.stockTotal.getValeur(this.cryptogramme));
        double totalEnRayon = 0.0;

        //on itère sur les chocolats en vente chez nous on fait le total et on multiplie ça par les charges de mise en rayon

        for(ChocolatDeMarque choco : Filiere.LA_FILIERE.getChocolatsProduits()){
            if(this.stockChocoMarque.containsKey(choco)){
                //System.out.println(choco.toString()+" : "+this.quantiteEnVente(choco,cryptogramme)+" tonnes");
                //System.out.println(choco.toString()+" : "+this.quantiteEnVenteTG(choco,cryptogramme)+" tonnes en tête de gondole");
                totalEnRayon += this.quantiteEnVente(choco,cryptogramme);
            }
        }
        System.out.println("total en vente "+totalEnRayon);
        Filiere.LA_FILIERE.getBanque().payerCout(this,this.cryptogramme,"Mise en rayon",Filiere.LA_FILIERE.getParametre("cout mise en rayon").getValeur()*totalEnRayon);
        this.journalCharges.ajouter("paiement mise en rayon "+Filiere.LA_FILIERE.getParametre("cout mise en rayon").getValeur()*totalEnRayon);
        Filiere.LA_FILIERE.getBanque().payerCout(this,this.cryptogramme,"Salaires",salaireEmployes*nbEmployes);
        this.journalCharges.ajouter("Paiement des salaire : "+salaireEmployes*nbEmployes);

    }
}
