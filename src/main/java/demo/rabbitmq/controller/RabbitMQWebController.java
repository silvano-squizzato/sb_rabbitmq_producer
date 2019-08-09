package demo.rabbitmq.controller;

import demo.rabbitmq.model.Employee;
import demo.rabbitmq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("name") String name,
						   @RequestParam("id") String id) {
	
	Employee employer = new Employee();
		employer.setId(id);
		employer.setName(name);
		rabbitMQSender.send(employer);

		return "Message sent to RabbitMQ successfully";
	}

}

