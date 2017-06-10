package we.techtogether.jinterview.topic.corejava.immutability;

//immutabiblity got polluted if class is not final and any other class sub classed this class.
//public final class Employee{

public class Employee{		
		private final int empId;
		private final String empName;
		private final int empAdhar;
		private Address add;
		
		public Employee (Employee e)
		{
			this.empId = e.empId;
			this.empName = e.empName;
			this.empAdhar = e.empAdhar;
			this.add=e.add;
		}
		public Employee(int empId, String empName, int empAdhar, Address add) {
			this.empId = empId;
			this.empName = empName;
			this.empAdhar = empAdhar;
			
			//Do not use this for reference variables
			this.add=add;
			
			//Solution to first immutability - create copy this address. 
			//this.add=new Address(add);
			
		}
		/**
		 * @return the empId
		 */
		public int getEmpId() {
			return empId;
		}
		/**
		 * @return the empName
		 */
		public String getEmpName() {
			return empName;
		}
		/**
		 * @return the empAdhar
		 */
		public int getEmpAdhar() {
			return empAdhar;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName
					+ ", empAdhar=" + empAdhar + ", add=" + add + "]";
		}
}



