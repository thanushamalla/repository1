<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Aplication</title>
</head>

<body>
<center>
		<h1>User Management</h1>
        <h2>
        	<a href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All User</a>

        </h2>
	</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="10" id="emp-table">
            <caption>
            	<h2>
            		<c:if test="${user != null}">
            			Edit User
            		</c:if>
            		<c:if test="${user == null}">
            			Add New User
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${user != null}">
        			<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        		</c:if>
        		   <tr>
                <th col-index=1>ID </th>
                <td>
                	<input type="number" name="id" size="45"
                			value="<c:out value='${user.id}' />"
                		/>
                </td>
            </tr>         
            <tr>
                <th col-index=2>FirstName </th>
                <td>
                	<input type="text" name="firstname" size="45"
                			value="<c:out value='${user.firstname}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th col-index=3>LastName </th>
                <td>
                	<input type="text" name="lastname" size="45"
                			value="<c:out value='${user.lastname}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th col-index=4>Salary </th>
                <td>
                	<input type="number" name="salary" size="15"
                			value="<c:out value='${user.salary}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th col-index=5>Department </th>
                <td>
                	<input type="text" name="department" size="15"
                			value="<c:out value='${user.department}' />"
                	/>
                </td>
                <select class="table-filter" onchange="filter_rows()">
                    <option value="all"></option>
                </select>
            </tr>
            <tr>
                <th col-index=6>Position </th>
                <td>
                	<input type="text" name="position" size="15"
                			value="<c:out value='${user.position}' />"
                	/>
                </td>
                <select class="table-filter" onchange="filter_rows()">
                    <option value="all"></option>
                </select>
            </tr>
            <tr>
                <th col-index=7>EmailAddress </th>
                <td>
                	<input type="text" name="emailaddress" size="15"
                			value="<c:out value='${user.emailaddress}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th col-index=8>ContactNumber </th>
                <td>
                	<input type="number" name="contactnumber" size="15"
                			value="<c:out value='${user.contactnumber}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th col-index=9>Picture </th>
                <td>
                	<input type="image" name="picture" size="15"
                			value="<c:out value='${user.picture}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
        <script>
        window.onload = () => {
            console.log(document.querySelector("#emp-table > tbody > tr:nth-child(1) > td:nth-child(2) ").innerHTML);
        };

        getUniqueValuesFromColumn()

    </script>
    var pagination = UIkit.pagination(element, { /* options */ });
    <ul class="uk-pagination" data-uk-pagination="{items:100, itemsOnPage:10}"></ul>
    $('[data-uk-pagination]').on('select.uk.pagination', function(e, pageIndex){
    alert('You have selected page: ' + (pageIndex+1));
});
    </div>	
</body>
</html>