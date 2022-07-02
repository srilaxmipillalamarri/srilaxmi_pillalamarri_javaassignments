package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/pqr")
	public String sayHi() {
		return "<h1> hi this is for spring boot example</h2>";
	}

}
