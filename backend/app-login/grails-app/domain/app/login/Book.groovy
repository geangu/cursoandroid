package app.login

import grails.rest.*

@Resource(uri='/books', formats=['json'])
class Book {

	String title

    static constraints = {
    }
}
