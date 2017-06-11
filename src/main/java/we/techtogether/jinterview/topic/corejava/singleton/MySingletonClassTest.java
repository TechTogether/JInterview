package we.techtogether.jinterview.topic.corejava.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MySingletonClassTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		//case 1 eager loading
		/*EagerSingleton e1 = EagerSingleton.getInstance();
		EagerSingleton e2 = EagerSingleton.getInstance();
		if (e1==e2)
			System.out.println("same instance ");
		else
			System.out.println("different instance ");*/
		
		
		// case 2 static block 
	/*	StaticBlock static1= StaticBlock.getStaticInstance();
		StaticBlock static2= StaticBlock.getStaticInstance();
		if (static1==static2)
			System.out.println("same static instance ");
		else
			System.out.println("different instance ");*/
		
		//case 3 lazy loading sinagleton
		/*LazySingleton l1=LazySingleton.getLazyInstance();
		LazySingleton l2=LazySingleton.getLazyInstance();
		if (l1==l2)
			System.out.println("same Lazy  instance ");
		else
			System.out.println("different instance ");*/
		
		
		//case 4 sync lazy loading sinagleton
		/*ThreadSafeSingleton t1= ThreadSafeSingleton.getThreadSafeSingletonInstance();
		ThreadSafeSingleton t2= ThreadSafeSingleton.getThreadSafeSingletonInstanceBlock();
		
				if (t1==t2)
					System.out.println("same Lazy but sync instance ");
				else
					System.out.println("different instance ");*/
				
	
				
		// case 5  ReflectionToBreakSingleton
			/*	EagerSingleton e3= EagerSingleton.getInstance();
				EagerSingleton e4=null;
				
				try{
					Constructor[] dummyCon=EagerSingleton.class.getDeclaredConstructors();
					for (Constructor dumConstructor:dummyCon){
						dumConstructor.setAccessible(true);
						e4=(EagerSingleton)dumConstructor.newInstance();
					}
					
					if (e3==e4)
						System.out.println("yes singleton maintain");
					else
						System.out.println("singleton break, e3's hash "+e3.hashCode()+" and e4 "+e4.hashCode());
				
				}catch (Exception e) {
					// TODO: handle exception
				}*/
		
		//case 6 serializable singleton
			SerializableSingleton sInstance= SerializableSingleton.getInstanceOfSerializableSingleton();
			SerializableSingleton sInstance2;
			File f= new File ("SerialSingleton.txt");
			try {
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream os= new ObjectOutputStream(fos);
				os.writeObject(sInstance);
				os.flush();
				os.close();
				
				// now deserialize that object 
				System.out.println("now deserialize that object ");
				ObjectInputStream ois= new ObjectInputStream(new FileInputStream(f));
				sInstance2= (SerializableSingleton)ois.readObject();
				
				// now check ref equality 
				if (sInstance== sInstance2)
					System.out.println("same instance after serialization too");
				else
					System.out.println("different instance after serialization. Hash of instance 1"+sInstance.hashCode()+" and another one is "+sInstance2.hashCode());
				
				//to over come case 6's problem uncomment readResolve method in SerializableSingleton
				
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
}


class SerializableSingleton implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5328257738729608768L;
	private static final SerializableSingleton SERIALIZABLE_SINGLETON=new SerializableSingleton();
	
	private SerializableSingleton(){}
	
	public static SerializableSingleton getInstanceOfSerializableSingleton(){
		return SERIALIZABLE_SINGLETON;
	}
	
	public void writeObject(ObjectOutputStream oos) throws IOException{
		System.out.println("writeObject ");
		oos.defaultWriteObject();
	}
	
	public Object writeReplace(){
		System.out.println("writeReplace ");
		return SERIALIZABLE_SINGLETON;
	}
	public void validateObject(){
		System.out.println("validate  ");
	}
	public void readObject(ObjectInputStream ois){
		System.out.println("writeObject ");
	}
	
	public Object readResolve(){
		System.out.println("readResolve");
		return getInstanceOfSerializableSingleton();
	}
}



class ThreadSafeSingleton{
	private static ThreadSafeSingleton threadSafeSingletonInstance;
	
	private ThreadSafeSingleton(){
	}
	public static synchronized ThreadSafeSingleton getThreadSafeSingletonInstance(){
		if (threadSafeSingletonInstance==null)
		{
			threadSafeSingletonInstance=new ThreadSafeSingleton();
		}
		return threadSafeSingletonInstance;
	}
	
	public static  ThreadSafeSingleton getThreadSafeSingletonInstanceBlock(){
		
		if (threadSafeSingletonInstance==null)
		{
			synchronized (ThreadSafeSingleton.class) {
				if (threadSafeSingletonInstance==null)
				{
					threadSafeSingletonInstance=new ThreadSafeSingleton();
				}
			}
	
		}
		return threadSafeSingletonInstance;
	}
}

class LazySingleton{
	
	private static LazySingleton lazySingletonInstance;
	
	private LazySingleton(){
	}
	
	public static LazySingleton getLazyInstance (){
		System.out.println("In getLazyInstance ");
		if (lazySingletonInstance==null){
			System.out.println("in lazyloading first if");
			lazySingletonInstance= new LazySingleton();
		}
		else{
			System.out.println("returning old object");
		}
		return lazySingletonInstance;
	}
}



class StaticBlock{
	private static final StaticBlock staticInstance;
	private StaticBlock(){
	}
	
	static{
		try {
				staticInstance=new StaticBlock();
		}catch (Exception e) {
			throw new RuntimeException("exception in creating static instance!!");
			
		}
	}
	
	public static StaticBlock getStaticInstance(){
		return staticInstance;
	}
}



class EagerSingleton{

	private static final EagerSingleton eInstance =new EagerSingleton();
	private EagerSingleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static EagerSingleton getInstance(){
		return eInstance;
	}
}