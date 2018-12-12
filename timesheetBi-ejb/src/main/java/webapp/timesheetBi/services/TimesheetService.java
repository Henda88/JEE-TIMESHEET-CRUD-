package webapp.timesheetBi.services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import webapp.timesheetBi.entities.Departement;
import webapp.timesheetBi.entities.Mission;
import webapp.timesheetBi.entities.TimeSheet;
import webapp.timesheetBi.entities.TimesheetPK;

@Stateless
public class TimesheetService implements TimesheetServiceRemote {

	@PersistenceContext(unitName = "timesheetBi-ejb")
	private EntityManager em;

	@Override
	public int ajouterMission(Mission mission) {
		em.persist(mission);
		return mission.getId();
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {

		Mission missionEntityMnaged = em.find(Mission.class, missionId);
		Departement depEntityManager = em.find(Departement.class, depId);
		//depEntityManager.getMissions().add(missionEntityMnaged);
		missionEntityMnaged.setDepartements(depEntityManager);
		em.merge(depEntityManager);
	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {

		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);

		TimeSheet timesheet = new TimeSheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false);

		em.persist(timesheet);

	}

}
