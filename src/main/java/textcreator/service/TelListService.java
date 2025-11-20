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
	
	public List<TelListEntity> findAll() {
		return telListRepository.findAll();
	}
}
