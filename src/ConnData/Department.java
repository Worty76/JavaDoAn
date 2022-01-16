package ConnData;

public class Department {
	private String idDepartment;
	private String nameDepartment;
	private int numbersOfEmployeesDepart;
	
	
	public Department(String idDepartment, String nameDepartment, int numbersOfEmployeesDepart) {
		
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


	public int getNumbersOfEmployeesDepart() {
		return numbersOfEmployeesDepart;
	}


	public void setNumbersOfEmployeesDepart(int numbersOfEmployeesDepart) {
		this.numbersOfEmployeesDepart = numbersOfEmployeesDepart;
	}
	
	
}
