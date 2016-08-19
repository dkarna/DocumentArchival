package org.docarchival

import org.documentarchive.*

import grails.plugin.springsecurity.SpringSecurityService;
import grails.plugin.springsecurity.SpringSecurityService.*;
import grails.plugin.springsecurity.annotation.Secured

class UserController {
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def index() {
		//render "Welcome to user controller!!!"
		redirect(action: 'user')
	}

	// User creation view redirection

	@Secured(['ROLE_ROYALTY'])
	def user(){

	}

	// New user creation method

	@Secured(['ROLE_ROYALTY'])
	def register(){
		def user = new SecUser()
		user.username = params.username
		user.password = params.password
		if(params.activate==null)
			user.enabled = false
		else
			user.enabled = params.activate
		user.save()

		def addeduser = SecUser.findByUsername(params.username)
		def role = SecRole.findByAuthority('ROLE_COMMON')
		SecUserSecRole.create(addeduser, role, true)

		redirect(controller:'documentArchival',action:'dashBoard')
	}

	//method to list the users
	@Secured(['ROLE_ROYALTY'])
	def listUser()
	{
		params.max = 10
		[userInstanceList: SecUser.list(params), userInstanceTotal: SecUser.count()]
	}

	//method to deactivate the user (equivalent to delete)
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def deleteUser(){
		if(params.username == "admin")
		{
			flash.message = "admin can't be changed!!"
		}
		else
		{
			def userInstance = SecUser.get(params.id)
			userInstance.enabled = false
			userInstance.save(flush:true)
		}

		redirect(action:'listUser')
	}

	//method to redirect to the form with values to edit the users
	@Secured(['ROLE_ROYALTY'])
	def editUser()
	{
		def userInstance = SecUser.get(params.id)
		[userInstance: userInstance]
	}

	//method to save the changed values during editing
	def springSecurityService
	@Secured(['ROLE_ROYALTY'])
	def userEdit()
	{
		
		def userInstance = SecUser.get(params.id)
		//render params.id
		//render userInstance.password
		if (params.password) {
			userInstance.password = params.password
		}

		if(params.activate=="on")
			userInstance.enabled = true
		else
			userInstance.enabled = false

		userInstance.save(flush: true)

		redirect(action:'listUser')
	}

}
