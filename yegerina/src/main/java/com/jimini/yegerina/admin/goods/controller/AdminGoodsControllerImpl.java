package com.jimini.yegerina.admin.goods.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jimini.yegerina.admin.goods.service.AdminGoodsService;
import com.jimini.yegerina.common.base.BaseController;
import com.jimini.yegerina.goods.vo.GoodsVO;
import com.jimini.yegerina.goods.vo.ImageFileVO;
import com.jimini.yegerina.member.vo.MemberVO;

@Controller("adminGoodsController")
@RequestMapping(value="/admin/goods")
public class AdminGoodsControllerImpl extends BaseController  implements AdminGoodsController{
	private static final String CURR_IMAGE_REPO_PATH = "C:\\yegerina\\file_repo";
	@Autowired
	private AdminGoodsService adminGoodsService;
	
	
	
	@RequestMapping(value="/adminGoodsMain.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dateMap,
			                           HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session=request.getSession();
		session=request.getSession();
//		session.setAttribute("side_menu", "admin_mode"); //마이페이지 사이드 메뉴로 설정한다.
		
		String fixedSearchPeriod = dateMap.get("fixedSearchPeriod");
		String section = dateMap.get("section");
		String pageNum = dateMap.get("pageNum");
		String beginDate=null,endDate=null;
		
		String [] tempDate=calcSearchPeriod(fixedSearchPeriod).split(",");
		beginDate=tempDate[0];
		endDate=tempDate[1];
		dateMap.put("beginDate", beginDate);
		dateMap.put("endDate", endDate);
		
		Map<String,Object> condMap=new HashMap<String,Object>();
		if(section== null) {
			section = "1";
		}
		condMap.put("section",section);
		if(pageNum== null) {
			pageNum = "1";
		}
		condMap.put("pageNum",pageNum);
		condMap.put("beginDate",beginDate);
		condMap.put("endDate", endDate);
		List<GoodsVO> newGoodsList=adminGoodsService.listNewGoods(condMap);
		mav.addObject("newGoodsList", newGoodsList);
		
		String beginDate1[]=beginDate.split("-");
		String endDate2[]=endDate.split("-");
		mav.addObject("beginYear",beginDate1[0]);
		mav.addObject("beginMonth",beginDate1[1]);
		mav.addObject("beginDay",beginDate1[2]);
		mav.addObject("endYear",endDate2[0]);
		mav.addObject("endMonth",endDate2[1]);
		mav.addObject("endDay",endDate2[2]);
		
		mav.addObject("section", section);
		mav.addObject("pageNum", pageNum);
		return mav;
		
	}
	
	
	/*
	 * @RequestMapping(value="/addNewGoods.do" ,method={RequestMethod.POST}) public
	 * ResponseEntity addNewGoods(MultipartHttpServletRequest multipartRequest,
	 * HttpServletResponse response) throws Exception {
	 * multipartRequest.setCharacterEncoding("utf-8");
	 * response.setContentType("text/html; charset=UTF-8"); String
	 * imageFileName=null;
	 * 
	 * 
	 * 
	 * Map newGoodsMap = new HashMap(); Enumeration
	 * enu=multipartRequest.getParameterNames();
	 * 
	 * System.out.println(enu.toString() + " : 상품추가하는파라미터 네임");
	 * 
	 * while(enu.hasMoreElements()){ String name=(String)enu.nextElement(); String
	 * value=multipartRequest.getParameter(name); newGoodsMap.put(name,value); }
	 * System.out.println(newGoodsMap.toString() + "정리된 상품 추가 내용");
	 * 
	 * HttpSession session = multipartRequest.getSession(); MemberVO memberVO =
	 * (MemberVO) session.getAttribute("memberInfo"); String reg_id =
	 * memberVO.getMemberId(); System.out.println(reg_id + " : 작성자 id");
	 * 
	 * List<ImageFileVO> imageFileList =upload(multipartRequest);
	 * 
	 * 
	 * if(imageFileList!= null && imageFileList.size()!=0) { for(ImageFileVO
	 * imageFileVO : imageFileList) { imageFileVO.setRegId(reg_id); }
	 * newGoodsMap.put("imageFileList", imageFileList); }
	 * 
	 * String message = null; ResponseEntity resEntity = null; HttpHeaders
	 * responseHeaders = new HttpHeaders(); responseHeaders.add("Content-Type",
	 * "text/html; charset=utf-8"); try { int goodsId =
	 * adminGoodsService.addNewGoods(newGoodsMap); if(imageFileList!=null &&
	 * imageFileList.size()!=0) { for(ImageFileVO imageFileVO:imageFileList) {
	 * imageFileName = imageFileVO.getFileName(); File srcFile = new
	 * File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName); File destDir = new
	 * File(CURR_IMAGE_REPO_PATH+"\\"+goodsId);
	 * FileUtils.moveFileToDirectory(srcFile, destDir,true); } } message=
	 * "<script>"; message += " alert('새상품을 추가했습니다.');"; message
	 * +=" location.href='"+multipartRequest.getContextPath()+
	 * "/admin/goods/addNewGoodsForm.do';"; message +=("</script>");
	 * }catch(Exception e) { if(imageFileList!=null && imageFileList.size()!=0) {
	 * for(ImageFileVO imageFileVO:imageFileList) { imageFileName =
	 * imageFileVO.getFileName(); File srcFile = new
	 * File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName); srcFile.delete();
	 * } }
	 * 
	 * message= "<script>"; message += " alert('오류가 발생했습니다. 다시 시도해 주세요');"; message
	 * +=" location.href='"+multipartRequest.getContextPath()+
	 * "/admin/goods/addNewGoodsForm.do';"; message +=("</script>");
	 * e.printStackTrace(); } resEntity =new ResponseEntity(message,
	 * responseHeaders, HttpStatus.OK); return resEntity; }
	 */
	
	// 상품추가
	@RequestMapping(value = "/addNewGoods.do", method = { RequestMethod.POST })
	public ResponseEntity addNewGoods(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String imageFileName = null;
		
		//form 값을 받아 newGoodsMap에 put
		Map newGoodsMap = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			newGoodsMap.put(name, value);
		}

		//세션에서 get한 memberInfo가 reg_id, 수정한이가 됨.
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
		String reg_id = memberVO.getMemberId();

		//baseController upload
		List<ImageFileVO> imageFileList = upload(multipartRequest);
		System.out.println(imageFileList.toString() + " : 이미지 파일리스트");
		System.out.println(imageFileList.get(1) + " : 이미지 파일리스트2");
		//imageFileList를 받아 setReg_id해 newGoodsMap에 put
		if (imageFileList != null && imageFileList.size() != 0) {
			for (ImageFileVO imageFileVO : imageFileList) {
				imageFileVO.setRegId(reg_id);
			}
			newGoodsMap.put("imageFileList", imageFileList);
		}

		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			//상품, 파일정보가 들어있는 newGoodsMap으로 addNewGoods 수행
			int goods_id = adminGoodsService.addNewGoods(newGoodsMap);
			
			System.out.println(goods_id + " : 상품번호");
			//imageFileList가 있을 경우 
			if (imageFileList != null && imageFileList.size() != 0) {
				for (ImageFileVO imageFileVO : imageFileList) {
					
					//temp안에 imageFileName 이름으로 파일 생성,
					imageFileName = imageFileVO.getFileName();
					
					System.out.println(imageFileName + " : 이미지파일vo의 파일이름");
					File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + imageFileName);
					
					
					//이후 goods_id가 폴더명인 폴더를 하나 만들어 
					File destDir = new File(CURR_IMAGE_REPO_PATH + "\\" + goods_id);
					
					//이동한다.
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
			
			//위의 절차가 완료되면 안내하며, adminGoodsMain 상품목록 페이지를 reload한다.
			message = "<script>";
			message += " alert('새상품을 추가했습니다.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/admin/goods/adminGoodsMain.do';";
			message += ("</script>");
		
		
		} catch (Exception e) {
			//예외발생의 경우 
			//이미 파일이 생성되어 있는 이후 에러가 발생시 대비한다.
			if (imageFileList != null && imageFileList.size() != 0) {
				for (ImageFileVO imageFileVO : imageFileList) {
					imageFileName = imageFileVO.getFileName();
					File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + imageFileName);
					//만들어진 temp경로안의 파일들을 삭제한다.
					srcFile.delete();
				}
			}
			//삭제를 완료한 이후 안내하며, adminGoodsMain 상품목록 페이지를 reload한다.
			message = "<script>";
			message += " alert('오류가 발생했습니다. 다시 시도해 주세요');";
			message += " location.href='" + multipartRequest.getContextPath() + "/admin/goods/adminGoodsMain.do';";
			message += ("</script>");
			e.printStackTrace();
		}
		
		
		//각 경우에 따른 message를 가지고 resEntity 리턴한다.
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}	
	
	
	@Override
	public ResponseEntity modifyGoodsInfo(String goods_id, String mod_type, String value, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void removeGoodsImage(int goods_id, int image_id, String imageFileName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addNewGoodsImage(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modifyGoodsImageInfo(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}