package com.vivelabhuila

class UserController {

    static scaffold = true

    def login() {
    	def username = params.username
    	def password = params.password
    	if(username != null && !username.equals("")){
    		def user = User.findByUsernameAndPassword(username, password)
    		if(user!=null){
    			render user as grails.converters.JSON
    		} else {
    			def map = [
    				msg : 'User not found'
    			]
    			render map as grails.converters.JSON
    		}
    	} else {
    		def map = [
				msg : 'Username or password can not be blank'
			]
			render map as grails.converters.JSON
    	}
    }

}
