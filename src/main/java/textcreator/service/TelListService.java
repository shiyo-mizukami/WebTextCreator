package textcreator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import textcreator.entity.TelListEntity;
import textcreator.repository.TelListRepository;

@Service
public class TelListService {

<<<<<<< HEAD
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

        if (results.size() > 20) return results.subList(0, 20);
        return results;
    }
=======
	@Autowired
	TelListRepository telListRepository;
	
	/**
	 * 社名の昇順で全件検索
	 * 昇順なのはアルファベットが先に取得でき、TBをリスト上部にするため
	 */
	public List<TelListEntity> findAllByOrderByCompanyNameAsc() {
		return telListRepository.findAllByOrderByCompanyNameAsc();
	}
	
	/**
	 * 相手先リストから削除
	 */
	public void delete(Integer listId) {
		telListRepository.deleteById(listId);
	}
>>>>>>> branch 'master' of https://github.com/shiyo-mizukami/WebTextCreator.git
}
