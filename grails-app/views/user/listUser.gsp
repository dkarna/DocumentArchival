<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="mytheme">
<title>User List</title>
</head>
<body>
	<p align="right" style="padding-right: 40px; padding-top: 5px;">
		<sec:ifLoggedIn>
			Welcome 
		</sec:ifLoggedIn>

		<b><sec:loggedInUserInfo field="username" />!!!</b> |
		<g:link controller="logout">Logout</g:link>
	</p>
	<div class="nav" role="navigation">
		<ul>
			<li><g:link class="list" controller="documentArchival"
					action="dashBoard">Home</g:link></li>
			<li><g:link class="create" action="user">Add User</g:link></li>
			<li><g:link class="create" action="listUser">List User</g:link></li>
		</ul>
	</div>
	<div class="content scaffold-list" role="main">
		<h1>Document List</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>
					<g:sortableColumn property="userName" title="Username" />
					<g:sortableColumn property="status" title="Active Status" />
					<g:sortableColumn property="edit" title="Edit" />
					<g:sortableColumn property="delete" title="Delete" />
				</tr>
			</thead>
			<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="listUser" id="${userInstance.id}">
								${userInstance.username}
							</g:link></td>
						<td>
							${userInstance.enabled}
						</td>
						<td><g:link action="editUser" id="${userInstance.id}">Edit</g:link></td>
						<td><g:link action="deleteUser" id="${userInstance.id}">Delete</g:link></td>
					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${userInstanceTotal}" />
		</div>
	</div>
</body>
</html>