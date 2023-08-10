<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<head>
</head>
<body>
여기는 주문 결과 페이지

	<h1> 주문 결과</h1>
	<table class="orderResultInfo">
	
		<tr class="orderResultHead">
			<td>주문번호</td>
			<td>주문상품명</td>
			<td></td>
			<td>수량</td>
			<td>주문금액</td>
			<td>배송비</td>
			<td>주문금액합계</td>
		</tr>
		
		
		<tr class="orderResultlist">
			<c:forEach var="item" items="${myOrderList }">
				<td>${item.orderId }</td>
				<td>
					<a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goodsId }">
						<img src="${contextPath}/thumbnails.do?goods_id=${item.goodsId}&fileName=${item.goodsFileName}" >
					</a> <br>
					
				</td>
				<td align="left" style="width: 100px">
					<h5 align="left" ">					
						<a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goodsId }">
							${item.goodsTitle }					
						</a>
					</h5>				
				</td>				
				<td>
					<h5>${item.orderGoodsQty }</h5>
				</td>		
				<td>
					<fmt:formatNumber  value="${item.orderGoodsQty*(item.goodsSalesPrice*0.9)}" type="number" var="Discounted_Price" />
					<h5>${Discounted_Price}원(10%할인)</h5>
				</td>		
				<td>
					<h5>0원</h5>
				</td>		
				<td>
					<h5>${item.orderGoodsQty*(item.goodsSalesPrice*0.9)}원</h5>
				</td>		
			</c:forEach>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<br>
	
	<h1>배송지</h1>
	<div>
		<table>
			<tr>
				<td>받으실분</td>
				<td>
					${myOrderInfo.receiver_name }
				</td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td>
					${myOrderInfo.receiver_hp1 }
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					${myOrderInfo.delivery_address }
				</td>
			</tr>
			<tr>
				<td>배송 메시지</td>
				<td>
					${myOrderInfo.delivery_message }
				</td>
			</tr>
		
		</table>

	</div>
	<br>
	<br>
	<br>
	<br>
	<div>
		<h1>주문고객</h1>
		<table>
			<tr>
				<td><h5>이름</h5></td>
				<td>
					<input type="text" value="${myOrderInfo.receiver_name}" size="15" disabled >
				</td>
			</tr>
			<tr>
				<td><h5>핸드폰</h5></td>
				<td>
					<input type="text" value="${myOrderInfo.receiver_hp1}" size="15" disabled >
				</td>
			</tr>
		
		</table>
	</div>

	<br>
	<br>
	<br>
	<br>
	<div>
		<h1>결제정보</h1>
		<table>
			<tr>
				<td><h5>결제방법</h5></td>
				<td>
					${myOrderInfo.pay_method}
				</td>
			</tr>
			<tr>
				<td><h5>결제카드</h5></td>
				<td>
					${myOrderInfo.card_com_name}
				</td>
			</tr>
			<tr>
				<td><h5>할부기간</h5></td>
				<td>
					${myOrderInfo.card_pay_month}
				</td>
			</tr>

		
		</table>
	</div>
	
	<br>
	<br>
	<br>
	<a href="${contextPath}/main/main.do"> 쇼핑계속하기 </a>
		
</body>
