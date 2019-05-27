package preandroid;

import java.io.*;
import java.util.Date;

import com.kitri.dto.Child;
import com.kitri.dto.Product;

public class SerializeTest {
	public static void main(String[] args) {
		//Create File - Serialization(직렬화)
		/*
		 *  file-name : a.ser
		 *  OutputStream per byte : FileOutputStream
		 *  Object Output Stream : ObjectOutputStream
		 * */
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("a.ser"));
			
			Date now = new Date();
			Product p = new Product();
			p.setProduct_no("001");
			p.setProduct_name("아메리카노");
			p.setProduct_price(2500);
			
			Child c = new Child();
			c.setC("Child Instance Variable");
			
			oos.writeObject(now);
			oos.writeObject(p);	//	Serialization 결과 : 에러
			oos.writeObject(c);
			//클래스가 직렬화가 가능하게하려면 제약조건이 필요함.
			//public class Product implements Serializable {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// Read File - Deserialization(역직렬화)
		/*
		 * file-name : a.ser
		 * ByteInputStream : FileInputStream
		 * Object Input Stream
		 * 
		 * */
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("a.ser"));
			Object obj = ois.readObject();
			System.out.println(obj);
			
			obj = ois.readObject();
			System.out.println(obj);
			
			obj = ois.readObject();
			Child c1 = (Child)obj;
			System.out.println(c1.getC());
			System.out.println(c1.getP());//??
			
			
	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
