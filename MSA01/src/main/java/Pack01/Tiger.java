package Pack01;

import java.sql.*;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;

//@Controller
//public class Tiger {
//   @RequestMapping("t1")
//   String f1() {
//      System.out.println("들어옴");
//      return "TigerView";
//   }
//}

// 백업용
//@RestController
//public class Tiger {
//   @RequestMapping("t1")
//   String f1() {
//      System.out.println("들어옴");
//      return "호랑이";
//   }
//}

@RequiredArgsConstructor
@Getter
@ToString
class Multiplication {
   final int factorA;
   final int factorB;

   public Multiplication() {
      // TODO Auto-generated constructor stub
      this(0, 0);
   }
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class User1 { // 수검자 정보
   String alias;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class MultiplicationResultAttempt1 {
   User1 user; // 수검자
   Multiplication multiplication; // 문제
   int resultAttempt; // 답안
}

// 문제 출제 서비스
// 답안 채점 서비싀
interface MultipleService1 {
   Multiplication createRandomMultiplication();

   boolean checkAttempt(MultiplicationResultAttempt1 resultAttempt);
}

@Service
class MultipleServiceImpl1 implements MultipleService1 {
   // 문제 출제
   @Override
   public Multiplication createRandomMultiplication() {
      Random rnd = new Random();
      int factorA = rnd.nextInt(10);
      int factorB = rnd.nextInt(10);
      return new Multiplication(factorA, factorB);
   }

   // 답안 채점
   @Override
   public boolean checkAttempt(MultiplicationResultAttempt1 mra) {
      return mra.getResultAttempt() == mra.getMultiplication().getFactorA() * mra.getMultiplication().getFactorB();
   }
}

// 채점 서비스
@RestController
public class Tiger {

   int questionId = 0;
   @Autowired
   MultipleServiceImpl1 ms;

   @RequestMapping("t1")
   Multiplication f1231231() {
      System.out.println("들어옴");
      // Multiplication m = ms.createRandomMultiplication();
      // System.out.println(m.getFactorA());
      // System.out.println(m.getFactorB());
      // @RequiredArgsConstructor => 인수 전달해야 한다.
      // return new Multiplication(3, 4);
      return ms.createRandomMultiplication();
   }

   @RequestMapping("t2")
   String f2(@RequestBody MultiplicationResultAttempt1 mra) {

      // 들어온 데이터 확인
      System.out.println(mra);
      System.out.println(mra.user.alias);
      System.out.println(mra.multiplication.factorA);
      System.out.println(mra.multiplication.factorB);
      System.out.println(mra.resultAttempt);
      System.out.println("f2 들어옴");
      boolean result = ms.checkAttempt(mra);

      SqlLink link = new SqlLink();
      link.insertQuestion(mra.user.alias, mra.multiplication.factorA, mra.multiplication.factorB, mra.resultAttempt,
            result, questionId++);
//      link.linkDisconnect();

//      String name = link.getQuestion(1);
//      System.out.println("name : " + name);
      
      String strData = "{\"result\": "+result +", \"questionId\" : " + questionId + "}";

      // 채점한다.
      return strData;
   }

   @RequestMapping("t5")
   String[] f3(@RequestBody questionId questionId) {
      System.out.println("t5 들어옴");

      SqlLink link = new SqlLink();

      String[] name = link.getQuestion(questionId.questionId);
      System.out.println("name : " + name);

      // 얻은 데이터를 반환한다.
      return name;
   }

   @RequestMapping("t6")
   boolean f6(@RequestBody MultiplicationResultAttempt1 mra) {

      // 들어온 데이터 확인
      System.out.println(mra);
      System.out.println(mra.user.alias);
      System.out.println(mra.multiplication.factorA);
      System.out.println(mra.multiplication.factorB);
      System.out.println(mra.resultAttempt);
      System.out.println("f2 들어옴");
      boolean result = ms.checkAttempt(mra);

      SqlLink link = new SqlLink();
      link.insertQuestion(mra.user.alias, mra.multiplication.factorA, mra.multiplication.factorB, mra.resultAttempt,
            result, questionId++);
//      link.linkDisconnect();

//      String name = link.getQuestion(1);
//      System.out.println("name : " + name);

      // 채점한다.
      return result;
   }

}

class questionId {
   int questionId;
}

class SqlLink {
   static Connection conn = null;
   static Statement stat = null;
   PreparedStatement pstmt = null;
   PreparedStatement pstmt_voted = null;

//      String url  = "jdbc:mysql://15.164.217.65:3306/world";
   // database-1.cziyl6rwn9rl.ap-northeast-2.rds.amazonaws.com
   String url = "jdbc:mysql://database-1.cziyl6rwn9rl.ap-northeast-2.rds.amazonaws.com:3306/ahhyun?useSSL=false";
   String dbId = "admin";
   String dbPw = "12345678";

   public SqlLink() {
      try {

         // 동적 클래스 로드
         System.out.println("DB 접속 시도");

         Class.forName("com.mysql.cj.jdbc.Driver"); // DB연결 객체 생성
         conn = DriverManager.getConnection(url, dbId, dbPw);
         stat = conn.createStatement();

         System.out.println("DB 접속 완료");

      } catch (ClassNotFoundException e) {
         System.out.println(e.getMessage());
      } catch (Exception e) {
         System.out.println("DB 접속 실패");
         e.printStackTrace(System.out);
      }

   }

   /**
    * DB 연결을 끊는다.
    */
   public void linkDisconnect() {
      try {

         if (pstmt != null)
            pstmt.close();
         if (conn != null)
            conn.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   public Boolean isConnected() {
      return (conn != null) ? true : false;
   }

   /**
    * 회원가입 - members 테이블에 새 row를 추가한다.
    */
   public int insertQuestion(String name, int a, int b, int inputValue, boolean result, int questionId) {

      if (!isConnected()) {
         System.out.println("DB 연결안됨");
         return 0;
      }

      // 입력 데이터 검사하기
      //
      //
      //

      String sql = "insert into question(name, a, b, inputValue, result, id) values(?,?,?,?,?,?)";
      int cnt = 0;
      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, name);
         pstmt.setInt(2, a);
         pstmt.setInt(3, b);
         pstmt.setInt(4, inputValue);
         pstmt.setBoolean(5, result);
         pstmt.setInt(6, questionId);

         cnt = pstmt.executeUpdate();

      } catch (SQLIntegrityConstraintViolationException e) {
         e.printStackTrace();
         return -1;
      } catch (SQLException e) {
         e.printStackTrace();
         return -2;
      }

      return cnt;

   }

   public String[] getQuestion(int questionId) {
      if (!isConnected()) {
         System.out.println("DB 연결안됨");
         return null;
      }
            
      String[] strArr = null;
      String sql = "select * from question"; //where questionId = " + questionId + ";";
      try {
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         // excute query 해주고 값을 받는다.

         int size = 0;
         if (rs != null) {
            rs.last();
            size = rs.getRow();
         }
         rs.first();
         System.out.println("rs size : " + size);

         String strData = "";
         strArr = new String[size];
         
         for(int i = 0; i < strArr.length; i++) {
            
            String name = rs.getString("name");
               String id = rs.getString("id");
               String a = rs.getString("a");
               String b = rs.getString("b");
               String inputValue = rs.getString("inputValue");
               String result = rs.getString("result");
               int questionId2 = rs.getInt("questionId");
               
               
              
               strData += "{ \"name\" : \"" + name + "\"" 
                      + ", \"id\" : " + "\"" + id + "\""
                      + ", \"a\" : " + "\"" + a + "\""
                      + ", \"b\" : " + "\"" + b + "\""
                      + ", \"inputValue\" : " + "\"" + inputValue + "\""
                      + ", \"result\" : " + "\"" + result + "\""
                      + ", \"questionId\" : " + questionId2
                      + " }";
               
               strArr[i] = strData;
               strData = "";
               rs.next();
         }
   
           
          System.out.println(strArr);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return strArr;
   }
}