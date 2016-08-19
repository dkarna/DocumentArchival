class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
			}
        }

        "/" (view:"/dashBoard")
        "500"(view:'/error')
		
	}
}
