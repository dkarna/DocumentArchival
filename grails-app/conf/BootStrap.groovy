import org.documentarchive.*

class BootStrap {

    def init = { servletContext ->
		SecUser admin = new SecUser(username:'admin', password:'admin', enabled:true).save()
		SecUser user = new SecUser(username:'user', password:'user', enabled:true).save()
		SecUser deepak = new SecUser(username:'deepak', password:'deepak', enabled:true).save()
		SecRole royalty = new SecRole(authority: 'ROLE_ROYALTY').save()
		SecRole common = new SecRole(authority: 'ROLE_COMMON').save()
		SecUserSecRole.create(admin, royalty)
		SecUserSecRole.create(admin, common)
		SecUserSecRole.create(user, common)
		SecUserSecRole.create(deepak, common)
    }
    def destroy = {
    }
}
