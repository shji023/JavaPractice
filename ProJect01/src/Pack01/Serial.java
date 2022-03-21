package Pack01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//1. Serializable 인터페이스 내부는 비어있지만
//JVM이 알아서 뭔가를 한다.
//JSON으로 대충 만들고 (직렬화) 대충 가져온다.(역직렬화)
//2. FileOutputStream(byte저장 12 34) >> FileWriter(문자 저장) >> 1234
//3. 자바 직렬화, JSON직렬화
//4. FileOutputStream은 Serializable상속하지 않으면 익셉션 발생
class Apple implements Serializable{
	String name = "호랑이";
	int age = 1000;
}
public class Serial {
	public static void main(String[] args) {
		Apple apple = new Apple();
		try {
			FileOutputStream fos = new FileOutputStream("sample.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(apple);
			fos.close();
			oos.close();
			
			FileInputStream fis = new FileInputStream("sample.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Apple a2 = (Apple)ois.readObject();
			System.out.println(a2.name+""+a2.age);
			fis.close();
			ois.close();
		} catch (Exception e){
			
		}
		
	}
} 
