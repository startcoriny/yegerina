package com.jimini.yegerina.mypage.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jimini.yegerina.member.vo.MemberVO;
import com.jimini.yegerina.mypage.dao.MyPageDAO;
import com.jimini.yegerina.order.vo.OrderVO;

@Service("myPageService")
@Transactional(propagation=Propagation.REQUIRED)
public class MyPageServiceImpl  implements MyPageService{
	@Autowired
	private MyPageDAO myPageDAO;

	
	public List<OrderVO> listMyOrderGoods(String member_id) throws Exception{
		return myPageDAO.selectMyOrderGoodsList(member_id);
	}

	@Override
	public List findMyOrderInfo(String order_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> listMyOrderHistory(Map dateMap) throws Exception {
		return myPageDAO.selectMyOrderHistoryList(dateMap);
	}

	@Override
	public MemberVO modifyMyInfo(Map memberMap) throws Exception {
		 String memberId=(String)memberMap.get("memberId");
		 System.out.println(memberId + " : 서비스로 넘어온 아이디");
		 myPageDAO.updateMyInfo(memberMap);
		 return myPageDAO.selectMyDetailInfo(memberId);
	}

	@Override
	public void cancelOrder(String orderId) throws Exception {
		myPageDAO.updateMyOrderCancel(orderId);
	}
	
	
	//반품
	public void returnOrder(String orderId) throws Exception{
		myPageDAO.updateMyOrderReturn(orderId);
	}
	
	//교환
	public void exchangeOrder(String orderId) throws Exception{
		myPageDAO.updateMyOrderExchange(orderId);
	}
	
	

	@Override
	public MemberVO myDetailInfo(String member_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public void deleteMember(String memberId) throws Exception {
		myPageDAO.deleteMember(memberId);
	}
	
	
	public List orderdetail(String orderId)  throws Exception{
			
		List receiverMap =  myPageDAO.orderdetail(orderId);
		System.out.println("@@@@@마이페이지DAO에서 넘어온 주문자 상세 정보"+receiverMap.toString());
		return receiverMap;
		
	}
	
	
	
}
