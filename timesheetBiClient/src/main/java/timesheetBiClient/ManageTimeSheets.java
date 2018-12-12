package timesheetBiClient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import webapp.timesheetBi.entities.Mission;
import webapp.timesheetBi.entities.MissionExterne;
import webapp.timesheetBi.services.TimesheetServiceRemote;

public class ManageTimeSheets {

	public static void main(String[] args) throws NamingException, ParseException {

		String jndiName = "timesheetBi-ear/timesheetBi-ejb/TimesheetService!webapp.timesheetBi.services.TimesheetServiceRemote";
		Context context = new InitialContext();
		TimesheetServiceRemote timesheetServiceRemote = (TimesheetServiceRemote) context.lookup(jndiName);

		// Entreprise ssiiConsulting = new Entreprise("SSII Consulting", "Cite El
		// Ghazela");

		MissionExterne miseenplace4G = new MissionExterne("Mise en place du 4G pour l’entreprise Orange", "",
				"facturation@orange.tn", 400);

		MissionExterne nouvelOutilVente = new MissionExterne(
				"Développement d’un nouvel outil de vente pour l’entreprise Orange", "", "facturation@orange.tn", 400);
		Mission maintenanceSIRHinterne = new Mission("Maintenance du SIRH interne", "");
		
		int miseenplace4GID = timesheetServiceRemote.ajouterMission(miseenplace4G);
		int nouvelOutilVenteID = timesheetServiceRemote.ajouterMission(nouvelOutilVente);
		int maintenanceID = timesheetServiceRemote.ajouterMission(maintenanceSIRHinterne);
		
		int depRHID = 1; 
		int depTelecomID = 2; 
		
		timesheetServiceRemote.affecterMissionADepartement(miseenplace4GID, depTelecomID);
		timesheetServiceRemote.affecterMissionADepartement(nouvelOutilVenteID, depTelecomID);
		timesheetServiceRemote.affecterMissionADepartement(maintenanceID, depRHID);
		
		//Aymen ouali a travaillé du 01/01/2016 jusqu'à fin 2016 sur la mission “Mise en place du 4G pour
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dateDebutAymen = dateFormat.parse("01/01/2016");
		Date dateFinAymen = dateFormat.parse("31/12/2016"); 
		
		int aymenOualiID = 4; 
		
		timesheetServiceRemote.ajouterTimesheet(miseenplace4GID, aymenOualiID, dateDebutAymen, dateFinAymen);
		
		//Mohamed zitouni a travaillé du 01/01/2016 jusqu'à 16/03/2016 pour Orange sur la mission “Mise
		//en place du 4G pour Orange”, puis du 17/03/2016 jusqu'à la fin de l’année sur la mission interne
		//“Maintenance du SIRH interne”.
		
		Date dateDebutMohamed = dateFormat.parse("01/01/2016");
		Date dateFinMohamed = dateFormat.parse("16/03/2016");
		
		int mohamedZitouniID = 3; 
		
		timesheetServiceRemote.ajouterTimesheet(miseenplace4GID, mohamedZitouniID, dateDebutMohamed, dateFinMohamed);
		
		Date dateDebutMohamed2 = dateFormat.parse("17/03/2016"); 
		Date dateFinMohamed2 = dateFormat.parse("31/12/2016"); 
		
		timesheetServiceRemote.ajouterTimesheet(maintenanceID, mohamedZitouniID, dateDebutMohamed2, dateFinMohamed2);
		
		
		/*Khaled kallel a travaillé du 01/01/2016 jusqu'à 15/06/2016 pour Orange sur la mission
		“Développement d’un nouvel outil de vente pour Orange”, puis du 16/06/2016 jusqu'à la fin de
		l’année sur la mission “Maintenance du SIRH interne”.*/
		
		int khaledKallelID = 2; 
		
		Date dateDebutKhaled = dateFormat.parse("01/01/2016");
		Date dateFinKhaled = dateFormat.parse("15/06/2016");
		
		timesheetServiceRemote.ajouterTimesheet(nouvelOutilVenteID, khaledKallelID, dateDebutKhaled, dateFinKhaled);
		
		Date dateDebutKhaled2 = dateFormat.parse("16/06/2016");
		Date dateFinKhaled2 = dateFormat.parse("31/12/2016");
		
		timesheetServiceRemote.ajouterTimesheet(maintenanceID, khaledKallelID, dateDebutKhaled2, dateFinKhaled2);
		
		/*Yosra Arbi et Bochra bouzid ont validé les feuilles de temps (Timesheet) de Mohamed zitouni et
		Khaled kallel sur toute l’année.*/
		

	}

}
