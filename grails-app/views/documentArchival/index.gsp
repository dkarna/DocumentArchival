<%@ page import="org.documentarchive.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mytheme">
		<title>Upload Document</title>
	</head>
	<body>
	
<%--	<p align="right" style="padding-right:40px; padding-top:5px;">--%>
<%--		<sec:ifLoggedIn>--%>
<%--			Welcome --%>
<%--		</sec:ifLoggedIn>--%>
<%--		--%>
<%--		<b><sec:loggedInUserInfo field="username"/>!!!</b> | <g:link controller="logout">Logout</g:link>--%>
<%--	</p>--%>
	
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
				<g:uploadForm controller="documentArchival" action="upload" method="post" enctype='multipart/form-data'>
				<table style="background-color:window;">
				<tr>
					
					<th><label for="custName">Customer Name:</label></th>
	                 <td><input type="text" name="custName" /></td>
					
				</tr>
				<tr>
					
					<th><label for="formNo">Form No:</label></th>
	                <td><input type="text" name="formNo" /></td>
					
				</tr>
				<tr>	
					
					<th><label for="panNo">Pan No:</label></th>
	                <td><input type="text" name="panNo" /></td>
					
				</tr>
				<tr>	
					
					<th><label for="ownerName">Owner:</label></th>
	                 <td><input type="text" name="ownerName" /></td>
					
				</tr>
				<tr>
					
					<th><label for="workPhone">Work Phone:</label></th>
	                <td><input type="text" name="workPhone" /></td>
					
				</tr>
				<tr>
					
					<th><label for="mobilePhone">Mobile Phone:</label></th>
	                 <td><input type="text" name="mobilePhone" /></td>
					
				</tr>
				<tr>
					
					<th><label for="regNo">Registration No:</label></th>
	                <td><input type="text" name="regNo" /></td>
					
				</tr>
				<tr>
					
					<th><label for="citizenshipNo">Citizenship No:</label></th>
	                <td><input type="text" name="citizenshipNo" /></td>
					
				</tr>
				<tr>
					
					<th><label for="bankName">Bank Name:</label></th>
	                <td><input type="text" name="bankName" /></td>
					
				</tr>
				<tr>
					
					<th><label for="bankBranch">Bank Branch:</label></th>
	                <td><input type="text" name="bankBranch" /></td>
					
				</tr>
				<tr>
					
					<th><label for="accountName">Account Name:</label></th>
	                 <td><input type="text" name="accountName" /></td>
					
				</tr>
				<tr>	
					
					<th><label for="accountNo">Account No:</label></th>
	                <td><input type="text" name="accountNo" /></td>
					
				</tr>
				<tr>	
					
					<th><label for="docPurpose">Purpose</label></th>
	                <td><input type="text" name="docPurpose" required="required"/></td>
					
				</tr>
				<tr>	
					
					<th><label for="file">File Upload:</label></th>
	                 <td><input type="file" name="file" required /></td>
					
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