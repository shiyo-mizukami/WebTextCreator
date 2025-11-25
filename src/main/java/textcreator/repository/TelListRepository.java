package textcreator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import textcreator.entity.TelListEntity;

@Repository
public interface TelListRepository extends JpaRepository<TelListEntity, Integer> {

    // 社名昇順で全件取得
    List<TelListEntity> findAllByOrderByCompanyNameAsc();

    // サジェスト用部分一致検索
    List<TelListEntity> findByCompanyNameContainingAndPersonNameContainingAndTelNumberContaining(
            String companyName, String personName, String telNumber);
}
