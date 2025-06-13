package abstraction.eqXRomu.appelDOffre;

import abstraction.eqXRomu.filiere.IActeur;
import java.util.List;

public interface IAcheteurAO extends IActeur {

	/**
	 * @param propositions une liste non vide de propositions de prix pour une offre d'achat emise par this
	 * @return retourne la proposition choisie parmi celles de propositions 
	 *         (retourne null si aucune des propositions de propositions ne satisfait l'acheteur this)
	 */
	public OffreVente choisirOV(List<OffreVente> propositions);

}
