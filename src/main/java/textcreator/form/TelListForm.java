package textcreator.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TelListForm {
	@Min(value = 1)
	private Integer listId;
	
	@NotBlank(message = "社名を入力してください")
	private String companyName;
	
	@NotBlank(message = "氏名を入力してください")
	private String personName;
	
	@NotBlank(message = "役職を入力してください")
	private String honolific;
	
	@NotBlank(message = "電話番号を入力してください")
	private String telNumber;
	
	// 電話メモが表示されるtextarea
	private String result;
	
	// 登録処理の方法を格納 1→手動、2→自動
	private Integer registMode;

	public Integer getListId() {
		return listId;
	}

	public void setListId(Integer listId) {
		this.listId = listId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getHonolific() {
		return honolific;
	}

	public void setHonolific(String honolific) {
		this.honolific = honolific;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public Integer getRegistMode() {
		return registMode;
	}

	public void setRegistMode(Integer registMode) {
		this.registMode = registMode;
	}
}
