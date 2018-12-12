package webapp.timesheetBi.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "entreprise")
public class Entreprise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String raisonSocial;
	@OneToMany(mappedBy = "entreprise", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
	private List<Departement> departements;

	public Entreprise() {
		super();
	}

	public Entreprise(String name, String raisonSocial) {
		super();
		this.name = name;
		this.raisonSocial = raisonSocial;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

}
