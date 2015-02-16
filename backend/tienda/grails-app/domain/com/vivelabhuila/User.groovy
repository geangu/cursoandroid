package com.vivelabhuila

import grails.rest.*

@Resource(uri='/users', formats=['json'])
class User {

	String username
	String password

    static constraints = {
    	username blank: false
    	password blank: false, password: true
    }
}
