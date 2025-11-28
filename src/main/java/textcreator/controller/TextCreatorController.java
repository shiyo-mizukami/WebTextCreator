package textcreator.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import textcreator.form.TelListForm;
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
		
		model.addAttribute("input", new TelListForm());
		return "main";
	}

	/**
	 * データ削除リクエスト
	 */
	@PostMapping("delete")
	public String delete(@RequestParam Integer listId, Model model) {
		// 削除実行
		telListService.delete(listId);
		// 相手先情報全件をmodelにセット
		model.addAttribute("telList", telListService.findAllByOrderByCompanyNameAsc());
		return "redirect:/";
	}
	
	/**
	 * リストに登録リクエスト
	 */
	@PostMapping("regist")
	public String resist(@ModelAttribute("regist") TelListForm telListForm,
			RedirectAttributes redirect, Model model) {
		if(telListForm.getRegistMode() == 1) {
			// 登録処理が手動の場合
			try {
				// DBに登録
				telListService.save(telListForm);
				// 登録処理成功の場合
				redirect.addFlashAttribute("registResult", 1);
			} catch (Exception e) {
				// 登録処理失敗の場合
				redirect.addFlashAttribute("registResult", 2);
			}
		} else {
			// 登録処理が自動の場合
			try {
				// DBに登録
				telListService.save(telListForm);
			} catch (Exception e) {
			} finally {
				// 失敗でも成功でも0
				redirect.addFlashAttribute("registResult", 0);
			}
		}
		
		// 入力値を保存、描画
		redirect.addFlashAttribute("result", telListForm.getResult());
		redirect.addFlashAttribute("companyName", telListForm.getCompanyName());
		redirect.addFlashAttribute("personName", telListForm.getPersonName());
		redirect.addFlashAttribute("telNumber", telListForm.getTelNumber());
		
		// 相手先情報全件をmodelにセット
		model.addAttribute("telList", telListService.findAllByOrderByCompanyNameAsc());
		return "redirect:/";
	}
	
	/**
	 * リスト編集リクエスト
	 */
	@PostMapping("edit")
	public String edit(@ModelAttribute TelListForm telListForm,
			RedirectAttributes redirect, Model model) {
		// 変更処理
		try {
			telListService.save(telListForm);
		} catch (Exception e) {
			// 変更失敗の場合
			redirect.addFlashAttribute("registResult", 2);
		}
		// 相手先情報全件をmodelにセット
		model.addAttribute("telList", telListService.findAllByOrderByCompanyNameAsc());
		return "redirect:/";
	}
}

