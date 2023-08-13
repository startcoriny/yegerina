package com.jimini.yegerina.admin.goods.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jimini.yegerina.admin.goods.dao.AdminGoodsDAO;
import com.jimini.yegerina.goods.vo.GoodsVO;
import com.jimini.yegerina.goods.vo.ImageFileVO;
import com.jimini.yegerina.order.vo.OrderVO;

@Service("adminGoodsService")
@Transactional(propagation=Propagation.REQUIRED)
public class AdminGoodsServiceImpl implements AdminGoodsService {
	@Autowired
	private AdminGoodsDAO adminGoodsDAO;
	
	
	@Override
	public List<GoodsVO> listNewGoods(Map condMap) throws Exception{
		return adminGoodsDAO.selectNewGoodsList(condMap);
	}
	
	
	@Override
	public int addNewGoods(Map newGoodsMap) throws Exception{
		System.out.println(newGoodsMap + " : 받아온 새로운상품정보서비스 ");
		int goodsId = adminGoodsDAO.insertNewGoods(newGoodsMap);
		System.out.println(goodsId + " : DAO에서 받아온 굿즈 아이디");
		ArrayList<ImageFileVO> imageFileList = (ArrayList)newGoodsMap.get("imageFileList");
		for(ImageFileVO imageFileVO : imageFileList) {
			imageFileVO.setGoodsId(goodsId);
		}
		adminGoodsDAO.insertGoodsImageFile(imageFileList);
		return goodsId;
	}
	
	
	
	
	@Override
	public Map goodsDetail(int goods_id) throws Exception {
		Map goodsMap = new HashMap();
		GoodsVO goodsVO=adminGoodsDAO.selectGoodsDetail(goods_id);
		List imageFileList =adminGoodsDAO.selectGoodsImageFileList(goods_id);
		goodsMap.put("goods", goodsVO);
		goodsMap.put("imageFileList", imageFileList);
		return goodsMap;
	}
	
	
	
	
	@Override
	public List goodsImageFile(int goods_id) throws Exception{
		List imageList =adminGoodsDAO.selectGoodsImageFileList(goods_id);
		return imageList;
	}
	
	
	@Override
	public List<OrderVO> listOrderGoods(Map condMap) throws Exception{
		return adminGoodsDAO.selectOrderGoodsList(condMap);
	}
	
	@Override
	public void deleteGoods(int goods_id) throws Exception{
		adminGoodsDAO.deleteGoods(goods_id);
	}
	
	@Override
	public void addNewGoodsImage(List imageFileList) throws Exception{
		adminGoodsDAO.insertGoodsImageFile(imageFileList);
	}

	@Override
	public void modifyGoods(String goods_id, Map newGoodsMap) throws Exception {
		int goods_id_toInt = Integer.parseInt(goods_id);

		adminGoodsDAO.modifyGoods(goods_id, newGoodsMap);
		
		ArrayList<ImageFileVO> imageFileList = (ArrayList) newGoodsMap.get("imageFileList");
		for (ImageFileVO imageFileVO : imageFileList) {
			imageFileVO.setGoodsId(goods_id_toInt);
		}
		
		for (ImageFileVO imageFileVO : imageFileList) {
			if (imageFileVO.getFileName() == "" || imageFileVO.getFileName() == null) {} 
			else {adminGoodsDAO.modifyImages(imageFileList);}
		}

	}
	

	
}
