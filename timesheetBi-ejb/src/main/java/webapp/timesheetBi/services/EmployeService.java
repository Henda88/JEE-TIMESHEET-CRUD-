package webapp.timesheetBi.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import webapp.timesheetBi.entities.Contrat;
import webapp.timesheetBi.entities.Departement;
import webapp.timesheetBi.entities.Employe;

@Stateless
public class EmployeService implements EmployeServiceRemote {

	@PersistenceContext(unitName = "timesheetBi-ejb")
	private EntityManager em;

	public EmployeService() {
	}

	@Override
	public int ajouterEmploye(Employe employe) {
		em.persist(employe);
		return employe.getId();
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {

		Employe employeManagedEntity = em.find(Employe.class, employeId);
		Departement depManagedEntity = em.find(Departement.class, depId);

		// (test != null) && !test.isEmpty()
		if (depManagedEntity.getEmploye().isEmpty() && depManagedEntity.getEmploye() == null) {

			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity);
			depManagedEntity.setEmploye(employes);
		}

		else {

			depManagedEntity.getEmploye().add(employeManagedEntity);

		}
	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		em.persist(contrat);
		return contrat.getReference();
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		Employe employeManagerEntity = em.find(Employe.class, employeId);
		Contrat contratManagedEntity = em.find(Contrat.class, contratId);

		employeManagerEntity.setContrat(contratManagedEntity);
		em.merge(contratManagedEntity);
	}

	@Override
	public String getEmployePrenomById(int employeId) {

		Employe employeManagerEntity = em.find(Employe.class, employeId);
		return employeManagerEntity.getPrenom();
	}

	@Override
	public long getNombreEmployeJPQL() {

		//TypedQuery<long> query = em.createQuery("select count(e) from Employe e", Long.class);

		// return query.getSingleResult();
		return 0;

	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		List<Employe> employes = em.createQuery("select e from Employe e", Employe.class).getResultList();
		List<String> employeNames = new ArrayList<>();
		for (Employe employe : employes) {
			employeNames.add(employe.getNom());
		}

		return employeNames;
	}

}
