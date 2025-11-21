package textcreator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import textcreator.entity.TelListEntity;

@Repository
public interface TelListRepository extends JpaRepository<TelListEntity, Integer> {
	/**
	 * 社名の昇順で全件検索
	 * 昇順なのはアルファベットが先に取得でき、TBをリスト上部にするため
	 */
	public List<TelListEntity> findAllByOrderByCompanyNameAsc();
}
