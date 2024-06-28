package himedia.phonebook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.phonebook.repositories.vo.PhonebookVo;

@Repository("phonebookDao")
public class PhonebookDaoImpl implements PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PhonebookVo> getList() {
		List<PhonebookVo> list = sqlSession.selectList("phonebook.selectAll");
		return list;
	}

	@Override
	public int insert(PhonebookVo phonebookVo) {
		int insertedCount = sqlSession.insert("phonebook.insert", phonebookVo);
		return insertedCount;
	}

	@Override
	public int delete(Long id) {
	    return sqlSession.delete("phonebook.deleteByUserNo", id);
	}

	@Override
	public PhonebookVo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
