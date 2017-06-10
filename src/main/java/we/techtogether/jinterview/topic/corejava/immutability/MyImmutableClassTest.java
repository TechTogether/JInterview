package we.techtogether.jinterview.topic.corejava.immutability;



public class MyImmutableClassTest {

	public static void main(String[] args) {
		Address a1=new Address();
		a1.setCity("Noida");
		a1.setPinCode(201301);
		
		Employee e= new Employee(1, "Pooja", 11234, a1);
		System.out.println("Original Employee obj \n"+e.toString());
		
		
		//Immutability polluted by ref variable - now e is no longer immutable - solution is in emp class line 23
		a1.setCity("Delhi");
		System.out.println("New polluted emp object \n"+e.toString());
		
		
		//Immutability get polluted by subclass variable; to solve this make class final emp class line  4 
		Department d= new Department(e, 2056);
		System.out.println("Department obj \n "+d.toString());
		d.setDeptId(2014);
		System.out.println("new Department obj \n "+d.toString());
		
	}

}

