package org.docarchival

import org.documentarchive.*

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
		render accountName
		def file = request.getFile('file')
		render file.originalFilename
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
			documentInstance.createdBy = "Deepak"
			documentInstance.createdDate = new Date()
			documentInstance.modifiedBy = "Deepak"
			documentInstance.modifiedDate = new Date()
			
			documentInstance.save(flush: true)
			
			//child table data save
			// customer name
			def documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue= custName
			documetaInstance.colName = "Customer Name"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// form number
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue= formNo
			documetaInstance.colName = "Form Number"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			////DocumentDetail di = DocumentDetail.get(params.id)
			//render di.docName
		
			
			 // pan no
			 
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = panNo
			documetaInstance.colName = "Pan Number"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// Owner of company
			 
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = ownerName
			documetaInstance.colName = "Owner Name"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// work phone
			 
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = workPhone
			documetaInstance.colName = "Work Phone"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// mobile phone
			
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = mobilePhone
			documetaInstance.colName = "Mobile Phone"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// registration number
			
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = regNo
			documetaInstance.colName = "Registration Number"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// citizenship number
			
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = citizenshipNo
			documetaInstance.colName = "Citizenship Number"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// bank name
			
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = bankName
			documetaInstance.colName = "Bank Name"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// branch name of bank
			
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = bankBranch
			documetaInstance.colName = "Branch Name"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save(flush: true)
			
			// account holder name
			
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = accountName
			documetaInstance.colName = "Account Name"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save()
			
			// account number
			
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = accountNo
			documetaInstance.colName = "Account Number"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save()
			
			// purpose of this document
			
			documetaInstance = new DocumentMetadata()
			documetaInstance.metaValue = docPurpose
			documetaInstance.colName = "Document Purpose"
			documetaInstance.createdBy = "Deepak"
			documetaInstance.createdDate = new Date()
			documetaInstance.modifiedBy = "Deepak"
			documetaInstance.modifiedDate = new Date()
			documentInstance.addToDocumentmetadata(documetaInstance)
			documetaInstance.save()
			
		}
	//	forward action: "index"
		//return
		
	}
	
}
