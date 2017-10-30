package persistence.UserManagement;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import persistence.AdoptionManagement.Animal;;

/**
 * Entity implementation class for Entity: AssociationAgent
 *
 */
@Entity

public class AssociationAgent extends User implements Serializable {

	private String label;
	private String local;

	
	private static final long serialVersionUID = 1L;

	public AssociationAgent() {
		super();
	}

	  
	public AssociationAgent(String label, String local, List<Animal> animals) {
		super();
		this.label = label;
		this.local = local;
	
	}





	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
