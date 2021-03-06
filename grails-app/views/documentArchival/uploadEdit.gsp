<%@ page import="org.documentarchive.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mytheme">
		<title>Edit Upload</title>
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
					<li><g:link class="create" controller="user" action="index">Create User</g:link></li>
				</ul>
			</div>
			<div class="content scaffold-create" role="main">
				<h1>Edit Uploaded Document</h1>
				<g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
				<g:form action="editUpdate" method="post" enctype='multipart/form-data'>
				<input type="hidden" name="id" value="${documentInstanceList.id}" />
				<table style="background-color:window;">
				<g:each in="${documentInstanceList.documentmetadata}" status="i" var="documetaInstance">
					<tr>
						<th><label for="${documetaInstance.colName}">${documetaInstance.colName}</label></th>
						<td><input type="text" name="${documetaInstance.colName}" value="${documetaInstance.metaValue}"/></td>
					</tr>
				</g:each>
				<tr>	
					
					<th><label for="docPurpose">Purpose</label></th>
	                <td><input type="text" name="docPurpose" required="required" value="${documentInstanceList.docPurpose}"/></td>
					
				</tr>
				<tr>	
					
					<th><label for="file">File Upload:</label></th>
	                 <td><input type="file" name="file" value="${documentInstanceList.filePath}"/></td>
					
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