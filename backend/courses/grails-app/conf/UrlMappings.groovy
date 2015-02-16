class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/photo/$file"(controller:"upload", action:"show")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
