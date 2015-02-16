package com.vivelabhuila

import grails.rest.*

@Resource(uri='/items', formats=['json'])
class Item {

	String name
	Double price

    static constraints = {
    	name blank: false
    	price blank: false
    }
}
