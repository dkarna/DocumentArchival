class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
			}
        }

        "/" (controller: "documentArchival",view:"/dashBoard")
        "500"(view:'/error')
		
	}
}
