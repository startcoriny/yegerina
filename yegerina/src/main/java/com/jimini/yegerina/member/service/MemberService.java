package com.jimini.yegerina.member.service;

import java.util.Map;

import com.jimini.yegerina.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(Map  loginMap) throws Exception;
	public void addMember(MemberVO memberVO) throws Exception;
	boolean checkDuplicateId(String id) throws Exception;
}
