package textcreator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import textcreator.entity.TelListEntity;

@Repository
public interface TelListRepository extends JpaRepository<TelListEntity, Integer> {

}
