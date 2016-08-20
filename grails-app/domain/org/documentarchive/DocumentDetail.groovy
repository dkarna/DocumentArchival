package org.documentarchive

import java.utils.*

class DocumentDetail {
	//List metadata
	static hasMany = [documentmetadata: DocumentMetadata]
	String docName
	String docPurpose
	String filePath
	String createdBy
	Date createdDate
	String modifiedBy
	Date modifiedDate
	
	static constraints = {	
		documentmetadata cascade: "all-delete-orphan"
    }
}
