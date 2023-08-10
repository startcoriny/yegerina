package com.jimini.yegerina.member.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jimini.yegerina.member.vo.MemberVO;

public interface MemberDAO {

	public MemberVO login(Map loginMap) throws DataAccessException;
	public void insertNewMember(MemberVO memberVO) throws DataAccessException;
	boolean selectcheckDuplicateId(String id) throws DataAccessException;
	
}
