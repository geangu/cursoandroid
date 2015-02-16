package com.vivelabhuila

class UserController {

	static scaffold = true

    def login() {

    	def map = [:]

    	def username = params.username
    	def password = params.password

    	if ( username != null && password != null ) {
    		def user = User.findByUsernameAndPassword(username, password);
    		if(user != null && user.id != null){
    			map += [ token: System.currentTimeMillis() ]
    		} else {
    			map += [
	    			msg: "User not found"
	    		]
    		}
    	} else {
    		map += [
    			msg: "Username or password can not be null"
    		]
    	}

    	render map as grails.converters.JSON

    }
}
