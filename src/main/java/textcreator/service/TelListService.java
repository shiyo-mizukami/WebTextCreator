package textcreator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import textcreator.entity.TelListEntity;
import textcreator.repository.TelListRepository;

@Service
public class TelListService {

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
}
