<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>CRUD App</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="AddServlet" method="post">
    <table border="1px">
        <tr><td>First name: </td><td><input type="text" placeholder="Enter first name" name="firstName"/></td></tr>
        <tr><td>Last name: </td><td><input type="text" placeholder="Enter last name" name="lastName"/></td></tr>
        <tr><td>Email:</td><td><input type="email" placeholder="Enter email" name="email"/></td></tr>
        <tr><td>Phone number:</td><td><input type="text" placeholder="Enter phone number" name="phoneNumber"></td><tr>
        <tr><td align="center" colspan="2"><input type="submit" value="Add Employee"/></td></tr>
    </table>
</form>

<br/>
<button><a href="ViewServlet">view employees</a></button>
</body>
</html>