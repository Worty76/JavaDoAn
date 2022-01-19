package ConnData;

import java.sql.Date;

public class Project {
	
	private String idProject;
	private String nameProject;
	private int NOE;
	private String startingDay;
	private String endingDay;
	
	
	
	
	public Project(String idProject, String nameProject, int NOE, String startingDay, String endingDay ) {
		
		this.idProject = idProject;
		this.nameProject = nameProject;
		this.NOE = NOE;
		this.startingDay = startingDay;
		this.endingDay = endingDay;
	}



	public String getStartingDay() {
		return startingDay;
	}



	public void setStartingDay(String startingDay) {
		this.startingDay = startingDay;
	}



	public String getEndingDay() {
		return endingDay;
	}



	public void setEndingDay(String endingDay) {
		this.endingDay = endingDay;
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
