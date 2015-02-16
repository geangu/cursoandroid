package com.vivelabhuila

class UploadController {

	def PATH_TO_PHOTO = "/opt/upload/photos/"

	def photo() {
		println "/upload/photo"
		println params as grails.converters.JSON
//		def f = request.getFile('photo')
//		f.transferTo( PATH_TO_PHOTO + f.getOriginalFilename())
//		def map = [ok:true]
		render map as grails.converters.JSON
	}

	def show(){
		println "/upload/photo"
		println params as grails.converters.JSON
		def path= PATH_TO_PHOTO + params.file
		render (file:new File(path), contentType:"image/*")	
	}

}
