<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Estudiantes</title>
</head>
<body>

  <table border="1">
       <tr>
           <th>Name</th>
           <th>Last Name</th>
           <th>Age</th>
           <th>Status</th>
           <th>Edit User</th>
       </tr>
       
    
       <c:forEach items="${student}" var="student">
         <tr>
           <th>${student.sName}</th>
           <th>${student.lName}</th>
           <th>${student.sAge}</th>
           <th>${student.activoDelegate}</th>
           <th><form  name="form1" action="${pageContext.request.contextPath}/Modify" method="post">
            <INPUT TYPE="Hidden" NAME="id" value=${student.cStudent}>
            <INPUT TYPE="Submit" VALUE="Editar">
        </form></th>
       </tr>
       </c:forEach>
       
  </table>
  <br>
  
  <form action="${pageContext.request.contextPath}/Result" method="post">

 <label>Id del usuario: </label><input name="id" type="number">
  
  <input type="submit" value="Enviar">
  
</form>

<br>
<form action="${pageContext.request.contextPath}/save" method="post">
  
  <input type="submit" value="Agregar Nuevo Usuario">
  
</form>

<br>

<form action="${pageContext.request.contextPath}/Delete" method="post">

 <label>Nombre a eliminar: </label><input name="name" type="text">
  
  <input type="submit" value="Enviar">
  
</form>


</body>
</html>