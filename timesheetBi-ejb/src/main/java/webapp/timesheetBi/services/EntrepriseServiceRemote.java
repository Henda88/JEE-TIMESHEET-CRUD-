package webapp.timesheetBi.services;

import java.util.List;

import javax.ejb.Remote;

import webapp.timesheetBi.entities.Departement;
import webapp.timesheetBi.entities.Entreprise;

@Remote
public interface EntrepriseServiceRemote {

	 public int ajouterDepartement(Departement dep);
	 public int ajouterEntreprise(Entreprise entreprise);
	 void affecterDepartementEntreprise(int depID, int entrepriseId);
	 List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);

}
