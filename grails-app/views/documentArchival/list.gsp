<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Document List</title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul><li><g:link class="create" action="index">Upload New Document</g:link></li></ul>
		</div>
		<div class="content scaffold-list" role="main">
			<h1>Document List</h1>
			<g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="filename" title="Filename" />
						<g:sortableColumn property="uploadDate" title="Upload Date" />
						<g:sortableColumn property="uploadBy" title="Uploaded By" />
						<g:sortableColumn property="purpose" title="Purpose" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${documentInstanceList}" status="i" var="documentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="showPayload" id="${documentInstance.id}" target="_blank">${documentInstance.docName}</g:link></td>
						<td><g:formatDate date="${documentInstance.createdDate}" /></td>
						<td>${documentInstance.createdBy}</td>
						<td>${documentInstance.docPurpose}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${documentInstanceTotal}" />
			</div>
		</div>
	</body>
</html>