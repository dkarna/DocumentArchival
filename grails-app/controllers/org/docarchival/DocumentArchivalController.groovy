package org.docarchival

import org.documentarchive.*
//import org.junit.internal.runners.statements.FailOnTimeout;

import grails.plugin.springsecurity.SpringSecurityService.*;
import grails.plugin.springsecurity.annotation.Secured

class DocumentArchivalController {

	@Secured(['IS_AUTHENTICATED_FULLY'])
	def index() {
		//render "Welcome to Document Archival Controller!!!"
	}


	def springSecurityService
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def showUser() {
		def user = springSecurityService.currentUser
		render user['username']
	}



	@Secured(['IS_AUTHENTICATED_FULLY'])
	def upload() {
		def user = springSecurityService.currentUser
		def custName = params.custName
		def formNo = params.formNo
		def panNo = params.panNo
		def ownerName = params.ownerName
		def workPhone = params.workPhone
		def mobilePhone = params.mobilePhone
		def regNo = params.regNo
		def citizenshipNo = params.citizenshipNo
		def bankName = params.bankName
		def bankBranch = params.bankBranch
		def accountName = params.accountName
		def accountNo = params.accountNo
		def docPurpose = params.docPurpose
		//render accountName
		def file = request.getFile('file')
		//render file.originalFilename
		if(file.empty) {
			flash.message = "File cannot be empty"
		}
		else {
			def documentInstance = new DocumentDetail()

			// Parent table data save
			documentInstance.docName = file.originalFilename
			documentInstance.docPurpose = docPurpose
			documentInstance.filePath = grailsApplication.config.uploadFolder + documentInstance.docName
			file.transferTo(new File(documentInstance.filePath))
			documentInstance.createdBy = user['username']
			documentInstance.createdDate = new Date()
			documentInstance.modifiedBy = user['username']
			documentInstance.modifiedDate = new Date()

			documentInstance.save(flush: true)

			//child table data save
			// customer name
			def documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue= custName
			documetaInstance.colName = "Customer Name"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// form number
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue= formNo
			documetaInstance.colName = "Form Number"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			////DocumentDetail di = DocumentDetail.get(params.id)
			//render di.docName


			// pan no

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = panNo
			documetaInstance.colName = "Pan Number"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// Owner of company

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = ownerName
			documetaInstance.colName = "Owner Name"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// work phone

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = workPhone
			documetaInstance.colName = "Work Phone"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// mobile phone

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = mobilePhone
			documetaInstance.colName = "Mobile Phone"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// registration number

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = regNo
			documetaInstance.colName = "Registration Number"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// citizenship number

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = citizenshipNo
			documetaInstance.colName = "Citizenship Number"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// bank name

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = bankName
			documetaInstance.colName = "Bank Name"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// branch name of bank

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = bankBranch
			documetaInstance.colName = "Branch Name"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)

			// account holder name

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = accountName
			documetaInstance.colName = "Account Name"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save()

			// account number

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = accountNo
			documetaInstance.colName = "Account Number"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save()

			// purpose of this document

			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = docPurpose
			documetaInstance.colName = "Document Purpose"
			documetaInstance.createdBy = user['username']
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = user['username']
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save()

		}
		flash.message = "Your information has been submitted successfully"
		redirect(action: 'index')
		//return

	}

	@Secured(['IS_AUTHENTICATED_FULLY'])
	def list() {
		params.max = 10
		[documentInstanceList: DocumentDetail.list(params), documentInstanceTotal: DocumentDetail.count()]
	}


	@Secured(['IS_AUTHENTICATED_FULLY'])
	def showPayload(long id) {
		DocumentDetail documentInstance = DocumentDetail.get(id)
		File file = new File(documentInstance.filePath)
		response.outputStream << file.newInputStream()
		response.outputStream.flush()
	}

	// method for dashboard
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def dashBoard() {

	}

	// Edit document upload
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def uploadEdit(){
		[documentInstanceList: DocumentDetail.get(params.id)]
		//def documetaInstanceList = DocumentMetadata.executeQuery("Select dm.colName,dm.metaValue from DocumentMetadata dm Where dm.id=1")
		//[documentInstanceList: DocumentDetail.get(params.id)]
		//[documetaInstanceList: DocumentMetadata.get(params.id)]
		//render documentInstanceList.docPurpose
		//render documentInstanceList.documentmetadata[0].metaValue
		//render documentInstanceList.documentmetadata.size();
		//render documetaInstanceList.colName
	}

	// Save edited uploads
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def editUpdate(){
		def user = springSecurityService.currentUser
		def documentInstance = DocumentDetail.get(params.id)
		def custName = params.custName
		def formNo = params.formNo
		def panNo = params.panNo
		def ownerName = params.ownerName
		def workPhone = params.workPhone
		def mobilePhone = params.mobilePhone
		def regNo = params.regNo
		def citizenshipNo = params.citizenshipNo
		def bankName = params.bankName
		def bankBranch = params.bankBranch
		def accountName = params.accountName
		def accountNo = params.accountNo

		def file = request.getFile('file')
		if(file.empty){
			file = new File(documentInstance.filePath)
		}
		else
		{
			def file2 = new File(documentInstance.filePath)
			file2.delete()
			documentInstance.docName = file.originalFilename
		}

		documentInstance.docPurpose = params.docPurpose
		documentInstance.filePath = grailsApplication.config.uploadFolder + documentInstance.docName
		//render documentInstance.filePath
		file.transferTo(new File(documentInstance.filePath))
		documentInstance.modifiedBy = user['username']
		documentInstance.modifiedDate = new Date()
		documentInstance.save flush: true, failOnError: true



		def documetaInstance = new DocumentMetadata()
		documetaInstance.executeUpdate("Update DocumentMetadata set metaValue=? where colName=?", [custName, "Customer Name"])
		redirect action: "list"
	}

	// Delete selected uploads
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def deleteUpload(){
		def documentInstance = DocumentDetail.get(params.id)
		documentInstance.delete flush: true, FailOnError: true
		redirect(action:'list')
	}

}

