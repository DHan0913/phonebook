package himedia.phonebook.services;

import java.util.List;

import himedia.phonebook.repositories.vo.PhonebookVo;

public interface PhonebookService {
	public List<PhonebookVo> getMessageList();
	public boolean writeMessage(PhonebookVo vo);
	  boolean delete(Long id); // 메서드 이름을 delete로 수정
	
}
