package webapp.timesheetBi.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import webapp.timesheetBi.entities.Entreprise;

@ManagedBean
@RequestScoped
public class TodoBean {

	//private EntrepriseServiceLocal todoServiceLocal;

	private List<Entreprise> todos;
	//private Entreprise todo;

	public TodoBean() {
	}

	//@PostConstruct
	/*public void init() {
		todos = todoServiceLocal.findAll();
		todo = new Entreprise();
	}

	public String doCreateTodo() {
		String navigateTo = "/todos?faces-redirect=true";
		todoServiceLocal.create(todo);
		return navigateTo;
	}

	public List<Entreprise> getTodos() {
		return todos;
	}

	public void setTodos(List<Entreprise> todos) {
		this.todos = todos;
	}

	public Entreprise getTodo() {
		return todo;
	}

	public void setTodo(Entreprise todo) {
		this.todo = todo;
	}
*/
}
