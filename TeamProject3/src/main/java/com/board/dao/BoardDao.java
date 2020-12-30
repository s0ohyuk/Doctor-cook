package com.board.dao;

//List(레코드 여러개 담을 객체), Map(검색분야, 검색어)
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;//@Delete 어노테이션

import com.board.domain.BoardCommand;

public interface BoardDao {
	//1. 글목록보기
	public List<BoardCommand> list(Map<String, Object> map);
	
	//2. 총레코드수(검색어에 맞는 레코드수 까지 포함)
	public int getRowCount(Map<String, Object> map);
	
	//3. 최대값 구하기
	public int getNewSeq();
	
	//4. 글쓰기 -> 
	public void insert(BoardCommand board);
	
	//5. 조회수 증가
	public void updateHit(Integer seq);//~updateHit(int sql); -> Integer
	
	//6. 게시물번호에 해당되는 레코드
	public BoardCommand selectBoard(Integer seq);
	
	//7. 글수정하기
	//@Update(" ") ->BoardDaoInpl, BoardMapper.xml이 작성X
	public void update(BoardCommand board);
	
	//8. 글삭제하기
	//@Delete("delete from springboard2 where seq=#{seq}")
	public void delete(Integer seq);//~(int seq);
}