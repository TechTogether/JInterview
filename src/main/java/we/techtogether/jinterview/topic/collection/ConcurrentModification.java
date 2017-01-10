package we.techtogether.jinterview.topic.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {

	public ConcurrentModification() {
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		Iterator<Integer> iterator = list.iterator();/*Fail fast*/
		
		list.remove(0);// this is causing structure change hence Concurrent modification exception
		while(iterator.hasNext()) { 
			System.out.println(iterator.next());
		}
	}

}
