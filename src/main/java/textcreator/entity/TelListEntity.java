package textcreator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "list")
public class TelListEntity {
	@Id
	@Column(name = "list_id")
	private Integer listId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "person_name")
	private String personName;
	
	@Column(name = "honolific")
	private String honolific;
	
	@Column(name = "tel_number")
	private String telNumber;
}