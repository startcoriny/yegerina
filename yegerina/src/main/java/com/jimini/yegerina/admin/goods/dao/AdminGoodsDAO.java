package com.jimini.yegerina.admin.goods.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jimini.yegerina.goods.vo.GoodsVO;
import com.jimini.yegerina.goods.vo.ImageFileVO;
import com.jimini.yegerina.order.vo.OrderVO;

public interface AdminGoodsDAO {
	public int insertNewGoods(Map newGoodsMap) throws DataAccessException;
	public List<GoodsVO>selectNewGoodsList(Map condMap) throws DataAccessException;
	public GoodsVO selectGoodsDetail(int goods_id) throws DataAccessException;
	public List selectGoodsImageFileList(int goods_id) throws DataAccessException;
	public void insertGoodsImageFile(List fileList)  throws DataAccessException;
	public List<OrderVO> selectOrderGoodsList(Map condMap) throws DataAccessException;
	public void  modifyGoods(String goods_id, Map newGoodsMap) throws Exception;
	public void  modifyImages(List imageFileList) throws Exception;
	
	public void deleteGoods(int goods_id);
	public void updateGoodsFileName(ArrayList<ImageFileVO> imageFileList);
}
