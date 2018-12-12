package timesheetBiClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import webapp.timesheetBi.entities.Contrat;
import webapp.timesheetBi.entities.Employe;
import webapp.timesheetBi.entities.Role;
import webapp.timesheetBi.services.EmployeServiceRemote;


public class ManageEmployeandContrats {

	public static void main(String[] args) throws NamingException, ParseException {

		String jndiName = "timesheetBi-ear/timesheetBi-ejb/EmployeService!webapp.timesheetBi.services.EmployeServiceRemote";
		Context context = new InitialContext();
		EmployeServiceRemote employeServiceRemote = (EmployeServiceRemote) context.lookup(jndiName);

		Employe YosraArbi = new Employe("Arbi", "Yosra", "yosra.arbi@ssiiconsulting.tn", true, Role.chefDepartement);
		Employe KhaledKallel = new Employe("Kallel", "khaled", "khaled.kalled@ssiiconsulting.tn ,", true, Role.ingénieur);
		Employe MohamedZitouni = new Employe("zitouni", "mohamed", "mohamed.zitouni@ ssiiconsulting.tn", true, Role.technicien);
		Employe AymenOuali = new Employe("Ouali", "Aymen", "Aymen.ouali@ ssiiconsulting.tn ,", true, Role.ingénieur);
		Employe BouchraBouzid = new Employe("Bouzid", "bochra", "Bochra.bouzid@ ssiiconsulting.tn", true, Role.chefDepartement);
		
		int yosraArbiID = employeServiceRemote.ajouterEmploye(YosraArbi);
		int khaledKallelID = employeServiceRemote.ajouterEmploye(KhaledKallel);  
		int mohamedZitouniID = employeServiceRemote.ajouterEmploye(MohamedZitouni);
		int aymenOualiID = employeServiceRemote.ajouterEmploye(AymenOuali);
		int bouchraBouzidID = employeServiceRemote.ajouterEmploye(BouchraBouzid); 
		
		
		int depRHID = 1; 
		int depTelecomID = 2; 
		
		employeServiceRemote.affecterEmployeADepartement(yosraArbiID, depTelecomID);
		employeServiceRemote.affecterEmployeADepartement(khaledKallelID, depRHID);
		employeServiceRemote.affecterEmployeADepartement(khaledKallelID, depTelecomID);
		employeServiceRemote.affecterEmployeADepartement(mohamedZitouniID, depRHID);
		employeServiceRemote.affecterEmployeADepartement(mohamedZitouniID, depTelecomID);
		employeServiceRemote.affecterEmployeADepartement(aymenOualiID, depTelecomID);
		employeServiceRemote.affecterEmployeADepartement(bouchraBouzidID, depRHID);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Contrat yosraContrat = new Contrat(dateFormat.parse("01/03/2010"), "CDI", 2600);
		Contrat khaledContrat = new Contrat(dateFormat.parse("01/02/2015"), "CDI", 1600);
		Contrat mohamedContrat = new Contrat(dateFormat.parse("15/05/2013"), "CDI", 900); 
		Contrat aymenContrat = new Contrat(dateFormat.parse("10/05/2014"), "CDI", 2000);
		Contrat bochraContrat = new Contrat(dateFormat.parse("12/06/2010"), "CDI", 2700);
		
		int yosraContratID = employeServiceRemote.ajouterContrat(yosraContrat); 
		int khaledContratID = employeServiceRemote.ajouterContrat(khaledContrat);
		int mohamedContratID = employeServiceRemote.ajouterContrat(mohamedContrat); 
		int aymenContratID = employeServiceRemote.ajouterContrat(aymenContrat);
		int bochraContratID = employeServiceRemote.ajouterContrat(bochraContrat);
		
		employeServiceRemote.affecterContratAEmploye(yosraContratID, yosraArbiID);
		employeServiceRemote.affecterContratAEmploye(khaledContratID, khaledKallelID);
		employeServiceRemote.affecterContratAEmploye(mohamedContratID, mohamedZitouniID);
		employeServiceRemote.affecterContratAEmploye(aymenContratID, aymenOualiID);
		employeServiceRemote.affecterContratAEmploye(bochraContratID, bouchraBouzidID);
		
		System.out.println(employeServiceRemote.getEmployePrenomById(yosraArbiID));
		System.out.println(employeServiceRemote.getEmployePrenomById(khaledKallelID));
		System.out.println(employeServiceRemote.getEmployePrenomById(mohamedZitouniID));
		System.out.println(employeServiceRemote.getEmployePrenomById(aymenOualiID));
		System.out.println(employeServiceRemote.getEmployePrenomById(bouchraBouzidID));
		
	    

	}

}
