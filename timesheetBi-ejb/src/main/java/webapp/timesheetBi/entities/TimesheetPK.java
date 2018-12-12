package webapp.timesheetBi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TimesheetPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idEmploye;
	private int idMission;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	

	public TimesheetPK() {
		super();
	}

	public TimesheetPK(int idEmploye, int idMission, Date dateDebut, Date dateFin) {
		this.idEmploye = idEmploye;
		this.idMission = idMission;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmploye;
		result = prime * result + idMission;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimesheetPK other = (TimesheetPK) obj;
		if (idEmploye != other.idEmploye)
			return false;
		if (idMission != other.idMission)
			return false;
		return true;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public int getIdMission() {
		return idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	
}
