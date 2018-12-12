package webapp.timesheetBi.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "timesheet")
public class TimeSheet implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean isValide;
	@EmbeddedId
	private TimesheetPK timesheetPK;
	@ManyToOne
	@JoinColumn(name = "idEmploye", referencedColumnName = "id", insertable = false, updatable = false)
	private Employe employe;
	@ManyToOne
	@JoinColumn(name = "idMission", referencedColumnName = "id", insertable = false, updatable = false)
	private Mission mission;

	
	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public TimesheetPK getTimesheetPK() {
		return timesheetPK;
	}

	public void setTimesheetPK(TimesheetPK timesheetPK) {
		this.timesheetPK = timesheetPK;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}
