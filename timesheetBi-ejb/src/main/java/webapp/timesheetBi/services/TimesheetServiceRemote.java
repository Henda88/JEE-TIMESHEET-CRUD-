package webapp.timesheetBi.services;

import java.util.Date;

import javax.ejb.Remote;

import webapp.timesheetBi.entities.Mission;

@Remote
public interface TimesheetServiceRemote {

	public int ajouterMission(Mission mission);
	public void affecterMissionADepartement(int missionId, int depId);
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);
}
