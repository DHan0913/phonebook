package himedia.phonebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.phonebook.repositories.dao.PhonebookDao;
import himedia.phonebook.repositories.vo.PhonebookVo;

@Service
public class PhonebookServiceImpl implements PhonebookService {
	@Autowired
	PhonebookDao phonebookDao;

	@Override
	public List<PhonebookVo> getMessageList() {
		List<PhonebookVo> list = phonebookDao.getList();
		return list;
	}

	@Override
	public boolean writeMessage(PhonebookVo vo) {
		int insertedCount = phonebookDao.insert(vo);
		return insertedCount == 1;
	}


    @Override
    public boolean delete(Long id) { 
    return 1 == phonebookDao.delete(id); 
    }
}
