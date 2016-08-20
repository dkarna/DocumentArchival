<%@ page import="org.documentarchive.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mytheme">
		<title>Upload Document</title>
	</head>
	<body>
	
	<%--<p align="right" style="padding-right:40px; padding-top:5px;">
		<sec:ifLoggedIn>
			Welcome 
		</sec:ifLoggedIn>
		
		<b><sec:loggedInUserInfo field="username"/>!!!</b> | <g:link controller="logout">Logout</g:link>
	</p>
	
			--%><div class="nav" role="navigation">
				<ul>
					<li><g:link class="list" action="list">Document List</g:link></li>
					<li><g:link class="create" action="index">Upload New Document</g:link></li>
					<li><g:link class="create" controller="user" action="user">Create User</g:link></li>
				</ul>
				
			</div>
			<div class="content scaffold-create" role="main">
			</div>
		
	</body>
</html>