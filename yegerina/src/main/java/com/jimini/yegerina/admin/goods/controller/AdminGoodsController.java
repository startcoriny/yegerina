package com.jimini.yegerina.admin.goods.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface AdminGoodsController {
	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dateMap,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ResponseEntity addNewGoods(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)  throws Exception;
	public ResponseEntity modifyGoodsInfo( @RequestParam("goods_id") String goods_id,
			MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response)  throws Exception;

	/*
	 * public void addNewGoodsImage(MultipartHttpServletRequest multipartRequest,
	 * HttpServletResponse response) throws Exception;
	 */
//	public void modifyGoodsImageInfo(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)  throws Exception;
	ModelAndView deleteGoods(int goods_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
