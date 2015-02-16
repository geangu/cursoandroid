import com.vivelabhuila.User
import com.vivelabhuila.Item

class BootStrap {
    def init = { servletContext ->

    	def user = new User(username:'admin', password:'admin')
		user.save(flush:true)

		def item1 = new Item(name:'lapiz', price: 700D);
		def item2 = new Item(name:'cuaderno', price: 1000D);

		item1.save(flush: true)
		item2.save(flush: true)

    }
    def destroy = {
    }
}
