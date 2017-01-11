package we.techtogether.jinterview.topic.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sort by Salary 
 * If salary same sort by name
 * @author sumitkawatra
 *
 */
public class MyCompareable implements Comparable<MyCompareable>{
	
	protected String name;
	protected int salary;

	public MyCompareable() {
	}

	/**
	 * @param name
	 * @param salary
	 */
	public MyCompareable(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}




	public static void main(String[] args) {
		List<MyCompareable> myList = new ArrayList<MyCompareable>();
		
		myList.add(new MyCompareable("C", 1000));
		myList.add(new MyCompareable("A", 109));
		myList.add(new MyCompareable("M", 150));
		myList.add(new MyCompareable("J", 50));
		myList.add(new MyCompareable("K", 100));
		myList.add(new MyCompareable("M", 13));
		myList.add(new MyCompareable("L", 13));
	
		Collections.sort(myList);
		
		for(MyCompareable obj:myList) {
			System.out.println(obj);
		}
		
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyCompareable [name=");
		builder.append(name);
		builder.append(", salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}

	public int compareTo(MyCompareable myCompareable) {
		if(this.salary == myCompareable.salary) {
			return name.compareTo(myCompareable.name);
		} else {
			return this.salary - myCompareable.salary;
		}
	}
	
	

}
