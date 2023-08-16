package com.jimini.yegerina.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;

import com.jimini.yegerina.member.vo.MemberVO;

public interface AdminMemberDAO {
	public ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException;
}
