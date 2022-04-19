package Pack01;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

class A {
	int a,b;
	A(int a, int b){
		this.a = a;
		this.b = b;
	}
	int getResult() {
		return a*b;
	}
}
interface B {
	int getNum();
}
@Service
class BImpl implements B{
	@Override
	public int getNum() {
		return new Random().nextInt(10);
	}
}

interface C{
	A f1();
}
@Service
class CImpl implements C{
	@Autowired
	B b;
	
	@Override
	public A f1() {
		return new A(b.getNum(), b.getNum());
	}
}
@SpringBootTest
class Msa01ApplicationTests{
	@Autowired
	C c;
	
	@Test
	void test01() {
		A a = c.f1();
		System.out.println(a.a+" "+a.b);
		System.out.println(a.getResult());
	}
}
