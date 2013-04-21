package webrover1

import grails.converters.JSON
import groovy.util.logging.Log4j

@Log4j
class WebRoverApiController {

	def robotService
	
    def command() {
		println params.direction
		println params.duration
		action(params.direction, params.duration as int)
		def result = [result:'OK']
		render result as JSON
	}

	def sense() {
		def result = robotService.sense()
		render result as JSON
	}
	
	protected action(direction, duration) {
		robotService.action(direction, duration)
	}
	
	def delay() {
		robotService.delay = params.delay as int
		def result = [delay:robotService.delay]
		render result as JSON
	}

}
