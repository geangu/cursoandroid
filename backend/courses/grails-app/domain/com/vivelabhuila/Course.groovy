package com.vivelabhuila

import grails.rest.*

@Resource(uri='/courses', formats=['json'])
class Course {

	String name
	String description
	String instructor
	String photo

    static constraints = {
    	name blank: false
    	description blank: false
    	instructor blank: false
    	photo blank: false
    }

}
