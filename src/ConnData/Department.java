package ConnData;

public class Department {
	private String idDepartment;
	private String nameDepartment;
	private String numbersOfEmployeesDepart;
	
	
	public Department(String idDepartment, String nameDepartment, String numbersOfEmployeesDepart) {
		
		this.idDepartment = idDepartment;
		this.nameDepartment = nameDepartment;
		this.numbersOfEmployeesDepart = numbersOfEmployeesDepart;
	}


	public Department() {
		// TODO Auto-generated constructor stub
	}


	public String getIdDepartment() {
		return idDepartment;
	}


	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}


	public String getNameDepartment() {
		return nameDepartment;
	}


	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}


	public String getNumbersOfEmployeesDepart() {
		return numbersOfEmployeesDepart;
	}


	public void setNumbersOfEmployeesDepart(String numbersOfEmployeesDepart) {
		this.numbersOfEmployeesDepart = numbersOfEmployeesDepart;
	}
	
	
}
