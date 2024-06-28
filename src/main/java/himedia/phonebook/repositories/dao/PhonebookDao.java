package himedia.phonebook.repositories.dao;

import java.util.List;

import himedia.phonebook.repositories.vo.PhonebookVo;

public interface PhonebookDao {

			public List<PhonebookVo> getList(); // 전체

			public int insert(PhonebookVo phonebookVo); // 삽입

			public int delete(Long id); // 삭제

			public PhonebookVo get(Long id); // 검색

		
	}


