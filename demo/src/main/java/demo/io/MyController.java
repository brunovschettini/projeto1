package demo.io;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
	
	public String hello() {
		System.out.println("Entrei aqui");
		return "Hello World!";
	}
	

}
