<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="./style.css"/>

<form method="post" action="insertUser.jsp">
   <table>
    <tr>
      <td class="label"><label for="idt">아이디</label></td>
      <td class="content"><input id="idt" name="idt" type="text" size="20" 
          maxlength="50" placeholder="아이디를 입력하세요" autofocus required></td>
    </tr>
    <tr>
      <td class="label"><label for="passwd">비밀번호</label></td>
      <td class="content"><input id="passwd" name="passwd" type="password" 
          size="20" placeholder="비밀번호를 입력하세요" maxlength="16" required></td>
    </tr>
    <tr>
      <td class="label"><label for="name">이름</label></td>
      <td class="content"><input id="name" name="name" type="text" size="20" 
                 maxlength="10" placeholder="이름을 입력하세요" required></td>
    </tr>
    <tr>
      <td class="label"><label for="age">나이</label></td>
      <td class="content"><input id="age" name="age" type="text" size="20" 
                 maxlength="100" placeholder="나이를 입력하세요" required></td>
    </tr>
    <tr>
      <td class="label2" colspan="2"><input type="submit" value="입력완료">
         <input type="reset" value="다시작성"></td>
    </tr>   
  </table>
</form>