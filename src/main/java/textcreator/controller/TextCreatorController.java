package textcreator.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import textcreator.service.TelListService;

@Controller
public class TextCreatorController {
	// セッション準備
	@Autowired
	HttpSession session;
	// サービスクラス準備
	@Autowired
	TelListService telListService;
	
	/**
	 * トップページ(main.html)へのリクエスト
	 * @return
	 */
	@GetMapping("/")
	public String main(Model model) {
		// 相手先情報全件をmodelにセット
		model.addAttribute("telList", telListService.findAllByOrderByCompanyNameAsc());
		return "main";
	}
	
	
}
