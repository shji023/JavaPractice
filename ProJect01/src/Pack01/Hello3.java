package Pack01;
import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
/*
class Tiger {
}
class Aaa {
	void f1() {}
}

class Bbb extends Aaa {
	void f2() {}
}
public class Hello3 {
	public static void main(String[] args) {
		
	}
}
*/
// swing�� �浹 ������ Ȯ��
import javafx.application.Application;
import javafx.stage.Stage;

// ex86) UI
// Swing���̺귯�� => JavaFx
// Hello3���� �������� ����: �θ� �߻�Ŭ�����̱⿡ �� ������ �ؾ��Ѵ�.
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.show();
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // ���������� start ȣ��
	}
}