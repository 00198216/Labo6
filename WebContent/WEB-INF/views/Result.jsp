<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda Estudiante</title>
</head>
<body>
 <table border="1">
       <tr>
           <th>Name</th>
           <th>Last Name</th>
           <th>Age</th>
           <th>Status</th>
           
       </tr>
       
         <tr>
           <th>${student.sName}</th>
           <th>${student.lName}</th>
           <th>${student.sAge}</th>
           <th>${student.activoDelegate}</th>
           
       </tr>
       
  </table>
</body>
</html>