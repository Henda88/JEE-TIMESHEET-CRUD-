package timesheetBiClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import webapp.timesheetBi.entities.Departement;
import webapp.timesheetBi.entities.Entreprise;
import webapp.timesheetBi.services.EntrepriseServiceRemote;

public class AddEntrepriseandDepartement {

	public static void main(String[] args) throws NamingException {

		String jndiName = "timesheetBi-ear/timesheetBi-ejb/EntrepriseService!webapp.timesheetBi.services.EntrepriseServiceRemote";
		Context context = new InitialContext();
		EntrepriseServiceRemote entrepriseServiceRemote = (EntrepriseServiceRemote) context.lookup(jndiName);

		Entreprise ssiiConsulting = new Entreprise("SSII Consulting", "Cite El Ghazela");

		int ssiiConsultingId = entrepriseServiceRemote.ajouterEntreprise(ssiiConsulting);
		ssiiConsulting.setId(ssiiConsultingId);

		Departement depRH = new Departement("RH");
		Departement depTelecom = new Departement("Telecom");

		int depRHID = entrepriseServiceRemote.ajouterDepartement(depRH);
		entrepriseServiceRemote.affecterDepartementEntreprise(depRHID, ssiiConsultingId);
		
		int depTelecomID = entrepriseServiceRemote.ajouterDepartement(depTelecom);
		entrepriseServiceRemote.affecterDepartementEntreprise(depTelecomID, ssiiConsultingId);

		//entrepriseServiceRemote.getAllDepartementsNamesByEntreprise(ssiiConsultingId);
		
		System.out.println(depRHID);
		System.out.println(depTelecomID);
		System.out.println(ssiiConsultingId);

	}

}
