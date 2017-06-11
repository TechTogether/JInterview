package we.techtogether.jinterview.topic.corejava.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeStatic_Final_Fields {
	
	public static void main(String[] args) {
		Emp emp =new Emp();
		emp.setFirstName("Hi  Pooja");
		emp.setLastName("Jain");
		emp.compName="NIIT";
		emp.setCompAdd("Gr. Noida");
		
		try {
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(new File("SerializeStaticFinalField.txt")));
			oos.writeObject(emp);
		}catch (Exception e){
			e.printStackTrace();
		}
		emp.compName="NIIT technology";
		emp.setLastName("JAIN");
		
		System.out.println("Done");
		
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(("SerializeStaticFinalField.txt")));
			Emp newEmp=(Emp)ois.readObject();
			System.out.println(newEmp.getFirstName());
			System.out.println(newEmp.getLastName());
			System.out.println(newEmp.getCompName());
			System.out.println(newEmp.getCompAdd());
			System.out.println(newEmp.compCity);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}


class Emp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3609834950828403618L;
	public String firstName;
	
	/*-whatever be the value of static variable at the time of serialization that value gonna save, 
	 * if in same session deserializing then whatever be the value that static variable would have that time is gonna show
	 * if in another session then old persisted value would be display */
	static String lastName;
	transient String compName;
	static transient String compAdd;
	static transient final String compCity="Delhi";
	
	public String getFirstName() {
		return firstName;
	}
	public static String getLastName() {
		return lastName;
	}
	public String getCompName() {
		return compName;
	}
	public static String getCompAdd() {
		return compAdd;
	}
	public static String getCompcity() {
		return compCity;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public static void setLastName(String lastName) {
		Emp.lastName = lastName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public static void setCompAdd(String compAdd) {
		Emp.compAdd = compAdd;
	}
	
	
	
}