<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

        <nav class="sectionNav">
            <label>
                <div class="kind_container">
                    <input class="toggle" type="checkbox" onclick="toggle()">
                    <div class="shop_kindList_button"></div>
                </div>
            </label>
            <ul class="menu">
                <li class="Top" ><a href="${contextPath}/goods/menuGoods.do?menuGoods=Top">Top
                        <ul class="top_list dpNone">
                            <li class="t_shirt"><a href="${contextPath}/goods/menuGoodsitem.do?menuGoodsitem=티셔츠">티셔츠</a></li>
                            <li class="slive"><a href="${contextPath}/goods/menuGoodsitem.do?menuGoodsitem=블라우스/셔츠">블라우스/셔츠</a></li>
                            <li class="t_shirt"><a href="#">니트</a></li>
                            <li class="shirt"><a href="#">롱슬리브</a></li>
                            <li class="slive"><a href="#">후드티</a></li>
                            <li class="slive"><a href="#">맨투맨</a></li>
                        </ul>
                    </a>
                </li>
                <li class="Bottom"><a href="${contextPath}/goods/menuGoods.do?menuGoods=Bottom">Bottom
                        <ul class="bottom_list dpNone">
                            <li><a href="#">긴바지</a></li>
                            <li><a href="#">반바지</a></li>
                            <li><a href="#">슬랙스</a></li>
                            <li><a href="#">레깅스</a></li>
                            <li><a href="#">멜빵</a></li>
                            <li><a href="#">츄리닝</a></li>
                        </ul>
                    </a>
                </li>
                <li class="Outer"><a href="${contextPath}/goods/menuGoods.do?menuGoods=Outer">Outer
                        <ul class="outer_list dpNone">
                            <li><a href="#">가디건</a></li>
                            <li><a href="#">점퍼</a></li>
                            <li><a href="#">야상</a></li>
                            <li><a href="#">코트</a></li>
                            <li><a href="#">자켓</a></li>
                            <li><a href="#">패딩</a></li>
                        </ul>
                    </a>
                </li>
                <li class="Skirt"><a href="${contextPath}/goods/menuGoods.do?menuGoods=Skirt">Skirt
                        <ul class="skirt_list dpNone">
                            <li><a href="#">롱치마</a></li>
                            <li><a href="#">스커트</a></li>
                            <li><a href="#">원피스</a></li>
                        </ul>
                    </a>
                </li>
                <li class="sale"><a href="${contextPath}/goods/menuGoods.do?menuGoods=sale">Sale</a></li>
                <li class="best"><a href="#">Best 20</a></li>
            </ul>
        </nav>
		<hr>
        <div class="all_list_container dpNone .fixed">
            <ul class="all_list">
                <li class="Top" >
                    <a href="${contextPath}/goods/menuGoods.do?menuGoods=Top">Top
                        <ul class="top_list ">
                            <li><a href="${contextPath}/goods/menuGoodsitem.do?menuGoodsitem=티셔츠">티셔츠</a></li>
                            <li><a href="${contextPath}/goods/menuGoodsitem.do?menuGoodsitem=블라우스/셔츠">블라우스/셔츠</a></li>
                            <li><a href="#">니트</a></li>
                            <li><a href="#">롱슬리브</a></li>
                            <li><a href="#">후드티</a></li>
                            <li><a href="#">맨투맨</a></li>
                        </ul>
                    </a>
                </li>
                <li class="Bottom">
                    <a href="${contextPath}/goods/menuGoods.do?menuGoods=Bottom">Bottom
                        <ul class="bottom_list ">
                            <li><a href="#">긴바지</a></li>
                            <li><a href="#">반바지</a></li>
                            <li><a href="#">슬랙스</a></li>
                            <li><a href="#">레깅스</a></li>
                            <li><a href="#">멜빵</a></li>
                            <li><a href="#">츄리닝</a></li>
                        </ul>
                    </a>
                </li>
                <li class="Outer">
                    <a href="${contextPath}/goods/menuGoods.do?menuGoods=Outer">Outer
                        <ul class="outer_list ">
                            <li><a href="#">가디건</a></li>
                            <li><a href="#">점퍼</a></li>
                            <li><a href="#">야상</a></li>
                            <li><a href="#">코트</a></li>
                            <li><a href="#">자켓</a></li>
                            <li><a href="#">패딩</a></li>
                        </ul>
                </a>
                </li>
                <li class="Skirt">
                    <a href="${contextPath}/goods/menuGoods.do?menuGoods=Skirt">Skirt
                        <ul class="skirt_list ">
                            <li><a href="#">롱치마</a></li>
                            <li><a href="#">스커트</a></li>
                            <li><a href="#">원피스</a></li>
                        </ul>
                    </a>
                </li>
                <li class="sale">
                    <a href="${contextPath}/goods/menuGoods.do?menuGoods=sale">Sale
                        <ul>
                            <li><a href="#">SALE</a></li>
                        </ul>
                    </a>
                </li>
                <li class="best">
                    <a href="#">BEST 20</a>
                </li>

                <li class="coumunity">
                    <a href="#">커뮤니티
                        <ul>
                            <li><a href="#">공지사항</a></li>
                            <li><a href="#">Q & A</a></li>
                            <li><a href="#">REVIEW</a></li>

                        </ul>
                    </a>
                </li>
            </ul>

        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	
	function toggle() {
	    const allListContainer = document.querySelector('.all_list_container');
	    allListContainer.classList.toggle('dpNone');
	}
	
	window.addEventListener('scroll', scroll);

	function scroll() {
	    var scrollFix_nav = document.querySelector('.sectionNav');
	    var all_list_container = document.querySelector('.all_list_container');

	    if (window.scrollY > 200) {
	        scrollFix_nav.classList.add('fixed');
	        all_list_container.classList.add('fixed');
	    } else {
	        scrollFix_nav.classList.remove('fixed');
	        all_list_container.classList.remove('fixed');
	    }
	}

</script>
