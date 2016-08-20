package org.documentarchive

class DocumentMetadata {
	static belongsTo = [documentdetails: DocumentDetail]
	String metaValue
	String colName
	String createdBy
	Date createdDate
	String modifiedBy
	Date modifiedDate

	static constraints = {
	}
}
