package textcreator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import textcreator.entity.TelListEntity;
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

        if (results.size() > 20) return results.subList(0, 20);
        return results;
    }
}