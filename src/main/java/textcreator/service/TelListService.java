package textcreator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import textcreator.entity.TelListEntity;
import textcreator.form.TelListForm;
import textcreator.repository.TelListRepository;

@Service
public class TelListService {

    private final TelListRepository repository;

    public TelListService(TelListRepository repository) {
        this.repository = repository;
    }

    // 全件取得（トップページ表示用）
    public List<TelListEntity> findAllByOrderByCompanyNameAsc() {
        return repository.findAllByOrderByCompanyNameAsc();
    }

    // 部分一致検索（サジェスト用）
    public List<TelListEntity> searchByFields(String companyName, String personName, String telNumber) {
        List<TelListEntity> results = repository
            .findByCompanyNameContainingAndPersonNameContainingAndTelNumberContaining(
                companyName, personName, telNumber
            );

        if (results.size() > 10) return results.subList(0, 10);
        return results;
    }
    
    /**
	 * 相手先リストから削除
	 */
	public void delete(Integer listId) {
		repository.deleteById(listId);
	}
	
	/**
	 * 相手先リストにデータを一件登録
	 */
	public void save(TelListForm telListForm) {
		// エンティティクラスを用意
		TelListEntity telListEntity = new TelListEntity();
		
		// 役職が空白か - の場合 ーを格納する
		if(telListForm.getHonolific().equals("") | telListForm.getHonolific().equals("-") | telListForm.getHonolific() == null) {
			telListForm.setHonolific("ー");
		}
		// 電話番号が空白か - の場合 ーを格納する
		if(telListForm.getTelNumber().equals("") | telListForm.getTelNumber().equals("-") | telListForm.getTelNumber() == null) {
			telListForm.setTelNumber("ー");
		}
		
		// listIdに現在の最大値+1の値を格納
		telListEntity.setListId(repository.findMaxByListId() + 1);
		// FormクラスからEntityクラスに変換
		telListEntity.setCompanyName(telListForm.getCompanyName());
		telListEntity.setPersonName(telListForm.getPersonName());
		telListEntity.setHonolific(telListForm.getHonolific());
		telListEntity.setTelNumber(telListForm.getTelNumber());
		
		repository.save(telListEntity);
	}

}