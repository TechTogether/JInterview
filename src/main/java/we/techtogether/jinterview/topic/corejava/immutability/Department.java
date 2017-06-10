package we.techtogether.jinterview.topic.corejava.immutability;

public class Department extends Employee {

	private int deptId;
	
	public Department(int empId, String empName, int empAdhar, Address add, int deptId) {
		super(empId, empName, empAdhar, add);
		this.deptId=deptId;
	}
	

	/**
	 * @return the deptId
	 */
	public int getDeptId() {
		return deptId;
	}


	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	public Department(Employee e,
			int deptId) {
		super(e);
		this.deptId = deptId;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", getEmpId()=" + getEmpId()
				+ ", getEmpName()=" + getEmpName() + ", getEmpAdhar()="
				+ getEmpAdhar() + "]";
	}

	
	
}
