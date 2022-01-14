package ConnData;

public class Project {
	
	private String idProject;
	private String nameProject;
	private int NOE;
	
	
	
	public Project( String idProject, String nameProject, int NOE ) {
		
		this.idProject = idProject;
		this.nameProject = nameProject;
		this.NOE = NOE;
	}



	public Project() {
		// TODO Auto-generated constructor stub
	}




	public String getIdProject() {
		return idProject;
	}



	public void setIdProject(String idProject) {
		this.idProject = idProject;
	}



	public String getNameProject() {
		return nameProject;
	}



	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}



	public int getNOE() {
		return NOE;
	}



	public void setNOE(int nOE) {
		NOE = nOE;
	}
	


		
		
	

}
