package webapp.timesheetBi.services;

import java.util.List;

import javax.ejb.Remote;
//import javax.ws.rs.Path;

import webapp.timesheetBi.entities.Contrat;
import webapp.timesheetBi.entities.Employe;

//@Path("/emplyee")
@Remote
public interface EmployeServiceRemote {

	public int ajouterEmploye(Employe employe);
	public void affecterEmployeADepartement(int employeId, int depId);
	public int ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	
	 
}
