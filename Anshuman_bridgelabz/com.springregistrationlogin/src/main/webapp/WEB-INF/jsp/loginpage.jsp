<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${msg}
    <form action="login" method="post">
     <table>
        <tr><td>Email</td><td><input type="email" name="email" required></td></tr>
        <tr><td>Password</td><td><input type="password" name="password" required></td></tr>
        <tr><td><input type="submit" value="login"></td></tr>
        <tr><td><a href="forgetpasswordpage">Forget Password ?</a></td></tr>
        </table>
    </form>
</body>
</html>