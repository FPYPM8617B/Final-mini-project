package Model;

public class Employee {

	private int EmpId;
	private String EmpName;
	private int EmpSal;
	private String EmpJoiningDate;
	private String EmpLocation;
	private String EmpMail;
	private long EmpMobile;
	private int EmpDid;
	private int EmpRid;

	public Employee() {

	}

	public Employee(int empId, String empName, int empSal, String empJoiningDate, String empLocation, String empMail,
			long empMobile, int empDid, int empRid) {
		super();
		EmpId = empId;
		EmpName = empName;
		EmpSal = empSal;
		EmpJoiningDate = empJoiningDate;
		EmpLocation = empLocation;
		EmpMail = empMail;
		EmpMobile = empMobile;
		EmpDid = empDid;
		EmpRid = empRid;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public int getEmpSal() {
		return EmpSal;
	}

	public void setEmpSal(int empSal) {
		EmpSal = empSal;
	}

	public String getEmpJoiningDate() {
		return EmpJoiningDate;
	}

	public void setEmpJoiningDate(String empJoiningDate) {
		EmpJoiningDate = empJoiningDate;
	}

	public String getEmpLocation() {
		return EmpLocation;
	}

	public void setEmpLocation(String empLocation) {
		EmpLocation = empLocation;
	}

	public String getEmpMail() {
		return EmpMail;
	}

	public void setEmpMail(String empMail) {
		EmpMail = empMail;
	}

	public long getEmpMobile() {
		return EmpMobile;
	}

	public void setEmpMobile(long empMobile) {
		EmpMobile = empMobile;
	}

	public int getEmpDid() {
		return EmpDid;
	}

	public void setEmpDid(int empDid) {
		EmpDid = empDid;
	}

	public int getEmpRid() {
		return EmpRid;
	}

	public void setEmpRid(int empRid) {
		EmpRid = empRid;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpSal=" + EmpSal + ", EmpJoiningDate="
				+ EmpJoiningDate + ", EmpLocation=" + EmpLocation + ", EmpMail=" + EmpMail + ", EmpMobile=" + EmpMobile
				+ ", EmpDid=" + EmpDid + ", EmpRid=" + EmpRid + "]";
	}

}
