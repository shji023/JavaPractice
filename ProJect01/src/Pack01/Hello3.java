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
// swing과 충돌 나는지 확인
import javafx.application.Application;
import javafx.stage.Stage;

// ex86) UI
// Swing라이브러리 => JavaFx
// Hello3에서 에러나는 이유: 부모가 추상클래스이기에 꼭 구현을 해야한다.
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.show();
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // 내부적으로 start 호출
	}
}