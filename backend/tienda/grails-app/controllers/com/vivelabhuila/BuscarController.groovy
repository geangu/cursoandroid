package com.vivelabhuila

class BuscarController {

    def index() { 

    	def item = params.elemento
    	def items = Item.findAllByName(item)

    	render view: 'index', model: [items: items]

    }
}
