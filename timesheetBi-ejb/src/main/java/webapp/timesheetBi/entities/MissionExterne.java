package webapp.timesheetBi.entities;

import javax.persistence.Entity;

@Entity
public class MissionExterne extends Mission {

	private static final long serialVersionUID = 1L;

	private String emailFacturation;
	private float txJournalierMoyen;

	public MissionExterne() {
		super();
	}

	public MissionExterne(String name, String description, String emailFacturation, float txjournalierMoyen) {
		super(name, description);
		this.emailFacturation = emailFacturation;
		this.txJournalierMoyen = txjournalierMoyen;

	}

	public String getEmailFacturation() {
		return emailFacturation;
	}

	public void setEmailFacturation(String emailFacturation) {
		this.emailFacturation = emailFacturation;
	}

	public float getTxJournalierMoyen() {
		return txJournalierMoyen;
	}

	public void setTxJournalierMoyen(float txJournalierMoyen) {
		this.txJournalierMoyen = txJournalierMoyen;
	}

}
