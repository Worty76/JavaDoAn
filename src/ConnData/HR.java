package ConnData;

public class HR extends Project{

	private String idHumanResource;
	private String name;
	private int age,gender;
	private String address;
	private String position;
	private String part;
	private int workDay;
	private String email;
	private String idProject;
	private String idDepartment;


		public HR(String idHumanResource, String name, int age, int gender, String address, String position, String part, int workDay, String email, String idProject,String idDepartment) {
			
			this.idHumanResource = idHumanResource;
			this.name = name;
			this.age =age;
			this.gender = gender;
			this.address = address;
			this.position = position;
			this.part = part;
			this.workDay = workDay;
			this.email = email;
			this.idProject = idProject;
			this.idDepartment =idDepartment;
		}
		//setter
		
		public String getIdDepartment() {
			return idDepartment;
		}

		public void setIdDepartment(String idDepartment) {
			this.idDepartment = idDepartment;
		}

		public String getIdProject() {
			return idProject;
		}
		
		public void setIdProject(String idProject) {
			this.idProject = idProject;
		}
		public String getIdHumanResource() {
			return idHumanResource;
		}
		
		public void setIdHumanResource(String idHumanResource) {
			this.idHumanResource = idHumanResource;
		}

		public String getPart() {
			return part;
		}

		public void setPart(String part) {
			this.part = part;
		}

		public int getWorkDay() {
			return workDay;
		}

		public void setWorkDay(int workDay) {
			this.workDay = workDay;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public HR() {
			// TODO Auto-generated constructor stub
		}
		
		
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public void setGender(int gender) {
			this.gender = gender;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		
		
		//getter
		
		public String getName() {
			return name;
		}
	
		public int getAge() {
			return age;
		}
		public int getGender() {
			return gender;
		}
		public String getAddress() {
			return address;
		}
		public String getPosition() {
			return position;
		}
}
