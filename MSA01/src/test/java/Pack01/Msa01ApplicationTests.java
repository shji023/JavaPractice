package Pack01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
class A {
	void f1() {
		System.out.println("call 1");
	}
}
class B {
	@Autowired
	A a;
	void f2() {
		System.out.println("call 2");
		System.out.println(a);
	}
}
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
		B b = new B();
		b.f2();
	}
}
