<%@ page import="org.documentarchive.*"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="mytheme">
<title>Edit Users</title>
</head>
<body>

	<%--<p align="right" style="padding-right: 40px; padding-top: 5px;">
		<sec:ifLoggedIn>
			Welcome 
		</sec:ifLoggedIn>

		<b><sec:loggedInUserInfo field="username" />!!!</b> |
		<g:link controller="logout">Logout</g:link>
	</p>

	--%><div class="nav" role="navigation">
		<ul>
			<li><g:link class="list" controller="documentArchival"
					action="dashBoard">Home</g:link></li>
			<li><g:link class="create" action="user">Add User</g:link></li>
			<li><g:link class="create" action="listUser">List User</g:link></li>
		</ul>
	</div>
	<div class="content scaffold-create" role="main">
		<h1>Create New User</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:form controller="user" action="userEdit" method="post">
			<input type="hidden" name="id" value="${userInstance.id}" />
			<table style="background-color: window;">
				<tr>

					<th><label for="username">User Name:</label></th>
					<td><input type="text" name="username"
						value="${userInstance.username}" disabled="disabled" /></td>

				</tr>
				<tr>

					<th><label for="password">Password:</label></th>
					<td><input type="text" name="password" value="" /></td>

				</tr>
				<tr>

					<th><label for="activate">Activate:</label></th>
					<td>
						<!-- input type="checkbox" name="activate" value="" checked="{userInstance.enabled == true}"/-->
						<g:checkBox name="activate" value="${userInstance?.enabled}" />
					</td>

				</tr>
				<tr>
					<fieldset class="buttons">
						<th></th>
						<td><g:submitButton name="update" class="save" value="Update" /></td>
				</tr>
			</table>
		</g:form>
	</div>

</body>
</html>