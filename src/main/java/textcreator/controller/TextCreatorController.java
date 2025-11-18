package textcreator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextCreatorController {

	@GetMapping("/")
	public String main() {
		return "main";
	}
}
