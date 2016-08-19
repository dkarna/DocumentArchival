<%@ page import="org.documentarchive.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Edit Upload</title>
	</head>
	<body>
	
	<p align="right" style="padding-right:40px; padding-top:5px;">
		<sec:ifLoggedIn>
			Welcome 
		</sec:ifLoggedIn>
		
		<b><sec:loggedInUserInfo field="username"/>!!!</b> | <g:link controller="logout">Logout</g:link>
	</p>
	
			<div class="nav" role="navigation">
				<ul>
					<li><g:link class="list" action="list">Document List</g:link></li>
					<li><g:link class="create" action="index">Upload New Document</g:link></li>
					<li><g:link class="create" controller="user" action="index">Create User</g:link></li>
				</ul>
			</div>
			<div class="content scaffold-create" role="main">
				<h1>Upload New Document</h1>
				<g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
				<g:uploadForm action="editUpdate" method="post" enctype='multipart/form-data'>
				<table style="background-color:window;">
				<!--tr>
					
					<th><label for="custName">Customer Name:</label></th>
	                 <td><input type="text" name="custName" value="${documentInstanc}"/></td>
					
				</tr-->
				<tr>	
					
					<th><label for="docPurpose">Purpose</label></th>
	                <td><input type="text" name="docPurpose" required="required" value="${documentInstance?.docPurpose}"/></td>
					
				</tr>
				<tr>	
					
					<th><label for="file">File Upload:</label></th>
	                 <td><input type="file" name="file" value="${docuMeta?.filePath}"/>${documentInstance?.filePath}</td>
					
				</tr>
				<tr>	
					<fieldset class="buttons">
					<th></th>
					<td><g:submitButton name="upload" class="save" value="Upload" /></td>
					
				</tr>
				</table>
				</g:uploadForm>
			</div>
		
	</body>
</html>