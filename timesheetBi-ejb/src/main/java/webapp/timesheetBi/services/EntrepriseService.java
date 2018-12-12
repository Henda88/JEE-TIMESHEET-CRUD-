package webapp.timesheetBi.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import webapp.timesheetBi.entities.Departement;
import webapp.timesheetBi.entities.Entreprise;

@Stateless
public class EntrepriseService implements EntrepriseServiceRemote{

	@PersistenceContext(unitName = "timesheetBi-ejb")
	private EntityManager em;

	public EntrepriseService() {
	}

	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		em.persist(entreprise);
		return entreprise.getId();
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		em.persist(dep);
		return dep.getId();
	}

	@Override
	public void affecterDepartementEntreprise(int depID, int entrepriseId) {

		Entreprise entrepriseManagedEntity = em.find(Entreprise.class, entrepriseId);
		Departement depManagedEntity = em.find(Departement.class, depID);
		depManagedEntity.setEntreprise(entrepriseManagedEntity);
		em.merge(depManagedEntity);
	
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		
		Entreprise entrepriseManagedEntity = em.find(Entreprise.class, entrepriseId);
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		
		return depNames;
	}
}
