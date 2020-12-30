package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.BoardCommand;

//SqlSessionDaoSupport 상속받는 이유 -> SqlSession객체를 자동으로 반환 getSqlSession() 이용
//@Component, @Repository, @Service -> 공통점(빈즈클래스로 등록)

//@Component(빈즈로 등록) <bean name="com.board.dao.BoardDaoImpl" /> (X)
//@Repository -> DAO(DB에 접속, DB관리) 역할을 하는 클래스라는 것을 알려주는 역할(명시적) 빈즈로 등록
//@Service -> 컨트롤러와 DB사이의 중간역할을 하는 서비스역할
//@Component > @Service("빈즈구분자") > @Repository
@Service("boardDaoImpl")
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	//@Autowired
	//SqlSession sqlSession;
	//검색분야에 따른 검색어까지 조회(페이징 처리)
	public List<BoardCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BoardCommand> list=getSqlSession().selectList("selectList", map);
		return list;//ListActionController
	}

	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCount", map);
	}
	
	public int getNewSeq() {
		// TODO Auto-generated method stub
		//Object -> Integer -> int
		int newseq=(Integer)getSqlSession().selectOne("getNewSeq");
		return newseq;
		//return (Integer)getSqlSession().selectOne("getNewSeq")
	}
	
	public void insert(BoardCommand board) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertBoard", board);
	}
	
	public void updateHit(Integer seq) {//update id="updateHit" ~>
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit", seq);//#{seq}
	}
	
	public BoardCommand selectBoard(Integer seq) {
		// TODO Auto-generated method stub
		return (BoardCommand)getSqlSession().selectOne("selectBoard", seq);
	}
	
	public void update(BoardCommand board) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateBoard", board);
	}
	
	public void delete(Integer seq) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteBoard", seq);
	}
}