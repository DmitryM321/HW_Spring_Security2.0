<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>

<h1>All room</h1>
<br>
<br>
<input type="button" value="For employee" onclick="window.location.href='employee_room'">
Only for employee
<br>
<br>
<security:authorize access="hasRole('IT')">
<input type="button" value="For it" onclick="window.location.href='it_room'">
Only for it
</security:authorize>
<br>
<br>
<security:authorize access="hasRole('SECURITY')">
<input type="button" value="For security" onclick="window.location.href='security_room'">
Only for security
</security:authorize>
<br>
<br>
<security:authorize access="hasRole('DIRECTOR')">
<input type="button" value="For director" onclick="window.location.href='director_room'">
Only for director
</security:authorize>

</body>
</html>