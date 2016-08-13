package org.documentarchive

class DocumentDetail {
	static hasMany = [documentmetadata: DocumentMetadata]
	String docName
	String docPurpose
	String filePath
	String createdBy
	Date createdDate
	String modifiedBy
	Date modifiedDate
	
	static constraints = {
		docName(blank:false, nullable:false)
		//docPurpose(blank:false, nullable:false)
		filePath(blank:false, nullable:false)
		createdBy(blank:false, nullable:false)
		createdDate(blank:false, nullable:false)	
    }
}
