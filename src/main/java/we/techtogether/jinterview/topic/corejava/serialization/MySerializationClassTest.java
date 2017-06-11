package we.techtogether.jinterview.topic.corejava.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import we.techtogether.jinterview.topic.corejava.immutability.Address;


public class MySerializationClassTest{
 
	public static void main(String[] args) {

		
		
		//Simple serialization
		/*try {
		 	DummyObject dummyObj=new DummyObject(1, "Pooja Jain", 100);
		    File f= new File ("SerialDummyObject.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream os= new ObjectOutputStream(fos);
			os.writeObject(dummyObj);
			os.flush();
			os.close();
			System.out.println("Our dummy obj is "+dummyObj.toString());
			System.out.println("File is created in your eclipse location and serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 
		//deserialization
		
		/*try {
		 	File f= new File ("SerialDummyObject.txt");
			FileInputStream fis= new FileInputStream(f);
			ObjectInputStream ois= new ObjectInputStream(fis);
			DummyObject newDummyobj = (DummyObject)ois.readObject();
			
			System.out.println("De-Serilization Done");
			System.out.println("New  dummy obj is "+dummyObj.toString());
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
		
		/*// case 1, step comment 2nd try block, 
		 * and run 1st then change serial uid in dummyobjet class 
		 * and after that comment 1st try run 2nd try block.
		 * 
		 * This will give Class cast exception
		 * java.io.InvalidClassException: poojajain0804.serialization.DummyObject;
		 * local class incompatible: stream classdesc 
		 * serialVersionUID = 2934251837922908981, local class serialVersionUID = 2934251837322908981*/
		
		
		
		/*
		 * case 2  - is a relation 
		 * child class is not  implementing serializable but parent class is .
		 * now trying to serialize child object
		 * */
		
		
		/*try {
			DummyChild dummyChild=new DummyChild(1, "Pooja Jain", 100, 28);
			File f= new File ("SerialDummyChildIsARelation.txt");
			FileOutputStream fos1 = new FileOutputStream(f);
			ObjectOutputStream os= new ObjectOutputStream(fos1);
			os.writeObject(dummyChild);
			os.flush();
			os.close();
			System.out.println("Our dummy child object is  "+dummyChild.toString());
			System.out.println("File is created in your eclipse location and serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	
		
		/*
		 * case 3   -Child class contain a  HAS-A relation 
		 *but reference class doesnot implements serialization
		 * now trying to serialize child object
		 * 
		 * this will not gonna serializable because ref class doesnt implements serialization 
		 * */
		
		
		/*try {
			Address a= new Address(201301,"Noida");
			DummyChild dummyChild=new DummyChild(1, "Pooja Jain", 100, 28,a);
			File f= new File ("SerialDummyChildHasARelation.txt");
			FileOutputStream fos1 = new FileOutputStream(f);
			ObjectOutputStream os= new ObjectOutputStream(fos1);
			os.writeObject(dummyChild);
			os.flush();
			os.close();
			System.out.println("Our dummy child object is  "+dummyChild.toString());
			System.out.println("File is created in your eclipse location and serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/* case 4 - Static members in class
		 * static class data member not gonna serialize,*/
		
		
		try {
//			Address a= new Address(201301,"Noida");
			DummyChild dummyChild=new DummyChild(1, "Hi this is Pooja Jain", 100, 28);
			
			File f= new File ("SerialDummyChildStaticMember.txt");
			FileOutputStream fos1 = new FileOutputStream(f);
			ObjectOutputStream os= new ObjectOutputStream(fos1);
			os.writeObject(dummyChild);
			os.flush();
			os.close();
			System.gc();
			
			System.out.println("Our dummy child object is  "+dummyChild.toString());
			
			System.out.println("File is created in your eclipse location and serialization Done");
			
			dummyChild.setSkills("developer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
		 	File f= new File ("SerialDummyChildStaticMember.txt");
			FileInputStream fis= new FileInputStream(f);
			ObjectInputStream ois= new ObjectInputStream(fis);
//			DummyObject newDummyobj = (DummyObject)ois.readObject();
			DummyChild newDummyChild = (DummyChild)ois.readObject();
			
			System.out.println("De-Serilization Done");
//			System.out.println("New  dummy obj is "+newDummyobj.toString());
			System.out.println("New  dummy obj is "+newDummyChild.toString());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

// if you will not append interface then this will give notSerializableObject
//class DummyObject 
class DummyObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2934251837322908981L;
	private int id;
	private String name;
	private transient int salary;
	
	@Override
	public String toString() {
		return "MySerializationClassTest [id=" + id + ", name=" + name + ", salary="+salary+"]";
	}
	
	public DummyObject(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
//	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
}


class DummyChild extends DummyObject{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5640899444248882729L;
	
	private int age;
	
	private Address address;
	
	private static String skills="java";
	
	
	/**
	 * @return the skills
	 */
	public static String getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public static void setSkills(String skills) {
		DummyChild.skills = skills;
	}
	public DummyChild(int id, String name, int salary, int age) {
		super(id, name, salary);
		this.age=age;
	}
	public DummyChild(int id, String name, int salary, int age, Address add) {
		super(id, name, salary);
		this.age=age;
		this.address=add;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}



	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DummyChild [age=" + age + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getSalary()=" + getSalary()
				+ ", Skills= "+getSkills()+"]";
	}
	
}