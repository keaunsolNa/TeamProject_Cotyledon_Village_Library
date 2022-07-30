package com.dbeloper.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dbeloper.member.model.dto.DBeloper_Book_DTO;
import com.dbeloper.member.model.dto.DBeloper_Input_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Manager_DTO;
import com.dbeloper.member.model.dto.DBeloper_Member_DTO;
import com.dbeloper.member.model.dto.DBeloper_NonMembers_DTO;
import com.dbeloper.member.model.dto.DBeloper_Output_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Review_DTO;
import com.dbeloper.member.model.dto.DBeloper_Review_Insert_DTO;
import com.dbeloper.member.model.dto.DBeloper_Store_Sales_History_DTO;
import com.dbeloper.member.model.service.DBeloper_Service;
import com.dbeloper.member.view.DBeloper_Member_Join_View;
import com.dbeloper.member.view.DBeloper_Result_View;

public class DBeloper_Controller {
	private DBeloper_Service service = new DBeloper_Service();
	private DBeloper_Result_View resultView = new DBeloper_Result_View();
	private Scanner sc = new Scanner(System.in);
	private List<DBeloper_Book_DTO> booklist;
	
	/*  큰솔, 준혁 관리자 로그인용 Controller */
	public Map<String, String> loginManager(String managerId, String managerPwd) {

		Map<String, String> map = new HashMap<>();
		map.put("managerId", managerId);
		map.put("managerPwd", managerPwd);
		
		return service.loginManager(map);
	}

	/* 큰솔  고객 로그인용 Controller (수정 사항 : 기존에 이름만 받아왔는데 필요한 정보를 DTO 형태로 다 받아오도록 수정 - 준혁) */
	public DBeloper_Member_DTO loginMember(String memberId, String memberPwd) {
		
		Map<String, String> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("memberPwd", memberPwd);
		
		return service.loginMamber(map);
	}

	
	/* 회원 조회용 Controller - 다영 */
	public void selectMember(Map<String, String> selectMember) {
	      
	      List<DBeloper_Member_DTO> memberList = null;

	      int selectNum = Integer.valueOf(selectMember.get("menuNum"));
	      DBeloper_Member_DTO memberDTO = new DBeloper_Member_DTO();
	      
	      switch(selectNum) {
	         case 1:
	            memberDTO.setMemberNo(selectMember.get("memberNo"));
	            memberList = service.selectMemberService(memberDTO);
	         case 2:
	            memberDTO.setMemberName(selectMember.get("memberName"));
	            memberList = service.selectMemberService(memberDTO);
	            break;
	         case 3:
	            memberDTO.setMemberId(selectMember.get("memberId"));
	            memberList = service.selectMemberService(memberDTO);
	            break;
	         case 4:
	            memberDTO.setMemberGradeNo(selectMember.get("memberGradeNo"));
	            memberList = service.selectMemberService(memberDTO);
	            break;   
	         default:
	            System.out.println("존재하지 않는 기능입니다.");  
	            break;
	      }
	      if(memberList == null) {
	    	  resultView.displayResultMessage("SearchFailied");     
		  } else if(memberList.isEmpty()) {
			  resultView.displayResultMessage("SearchFailied");
		  } else {
			  resultView.displayMember(memberList);
		  }
	   }

	
	/* 관리자 조회용 Controller */
	public void selectManager(Map<String, String> selectManager) {
		
		int selectNum = Integer.valueOf(selectManager.get("inputNum"));
		DBeloper_Manager_DTO managerDTO = new DBeloper_Manager_DTO();
		
		switch(selectNum) {
			case 1:
				/* 관리자 번호 */
				managerDTO.setManagerNum(selectManager.get("managerNum"));
				break;
			case 2:
				/* 관리자명 */
				managerDTO.setManagerName(selectManager.get("managerName"));
				break;							
			case 3:
				/* 관리자 등급 */
				managerDTO.setManagerGrade(selectManager.get("managerGrade"));
				break;
			case 4:
				/* 관리자 퇴사여부 */
				managerDTO.setManagerDropYN(selectManager.get("managerDropYN"));
				break;
			default:
				System.out.println("존재하지 않는 기능입니다.");	
		}
		
		List<DBeloper_Manager_DTO> managerList = service.selectManagerService(managerDTO);
		
		if(!managerList.isEmpty()) {
			resultView.displayManager(managerList);			
		} else {
			resultView.displayResultMessage("SearchFailied");
		}
	}
	
	/* 매장 입출금 내역 Controller - 수목 */
	public List<DBeloper_Store_Sales_History_DTO> selectStoreSalesHistory() {
		
		List<DBeloper_Store_Sales_History_DTO> storeSalesHistoryList = service.selectStoreSalesHistory();
		return storeSalesHistoryList;
	}
	
	/*매장 총 보유금액 내역 Controller - 수목*/
	public int selectSumMoneyAmount() {
		int storeSumMoneyAmount = service.selectStoreSumMoney();
		return storeSumMoneyAmount;
	}



	/* 도서 조회 메소드(Controller) - 준혁  */
	public int searchBook(Map<String, String> searchInfo) {
		
		List<DBeloper_Book_DTO> bookList = null;
		DBeloper_Book_DTO bookInfo = new DBeloper_Book_DTO();
		
		int menuNum = Integer.parseInt(searchInfo.get("menuNum"));
		int repeat = 1;
		
		switch(menuNum) {
			case 1: 
				bookInfo.setBookName(searchInfo.get("bookName"));
				break;
			case 2:
				int categoryCode = 0;
				switch(searchInfo.get("categoryName")) {
					case "소설": categoryCode = 1; break;
					case "장르소설": categoryCode = 2; break;
					case "만화책": categoryCode = 3; break;
					case "에세이": categoryCode = 4; break;
					case "철학/종교": categoryCode = 5; break;
					case "인문학/사회/역사": categoryCode = 6; break;
					case "자기계발/교재": categoryCode = 7; break;
					case "과학/IT": categoryCode = 8; break;
					case "잡지": categoryCode = 9; break;
					case "수험서": categoryCode = 10; break;
					case "기타": categoryCode = 11; break;
					default: resultView.displayResultMessage("NonExistCategory");
				}
				bookInfo.setBookCategoryNumber(categoryCode);;
				break;
			case 3: 
				bookInfo.setBookAuthor(searchInfo.get("author"));
				break;
			case 4: break;
			case 5:
				int ebNum = 0;
				switch(searchInfo.get("kindOfBook")) {
					case "종이책":
						ebNum = 1;
						break;
					case "전자책":
						ebNum = 2;
						break;
					default:
						resultView.displayResultMessage("NonExistEB");
				}
				bookInfo.setBookEbNumber(ebNum);
				break;
			case 6:
				repeat = 0;
				return repeat;
			default:
				resultView.displayResultMessage("NonExistSearchBookMenu");
		}
		
		bookList = service.searchBook(menuNum, bookInfo);
		
		if(!bookList.isEmpty()) {
			resultView.display(bookList);			
		} else {
			resultView.displayResultMessage("SearchFailied");
		}
		
		return repeat;
	}
	
	/* 도서 신청 대기 Controller -> 이수목 사용중(아마 시원님이 만드심)*/
	public List<DBeloper_Input_Order_History_DTO> selectInputOrderHistory() {
		 return service.selectInputOrderHistory();
	}
	
	/* 주문 내역 조회 Controller - 시원 -> 이수목 사용중(아마 시원님이 만드심)*/
	public List<DBeloper_Output_Order_History_DTO> selectOutputOrderHistory(){
		return service.selectOutputOrderHistory();
	}

	/* 큰솔 직원 월급 지급 용 Controller */
	public void insertSalary() {

		int sumMoney = service.selectStoreSumMoney();
		int sumSalary = service.selectManagerSumSalary();
		
		if(sumMoney < sumSalary) {
			resultView.displayResultMessage("NotEnoughMoney");
		} else {
			int result = service.insertSalary();
			if(result >= 1) {
				resultView.displayResultMessage("SucessInsertSalary");
			} else {
				resultView.displayResultMessage("FailedInsertSalary");
			}
		}
		
	}
	

	/* 회원 도서 구매 신청용 Controller - 준혁  */
	public void purchaseBook(Map<String, Integer> purchaseInfo) {
		
		Map<Integer, Integer> bookStock = selectAllBookStock();
		
		DBeloper_Output_Order_History_DTO outputOrder = new DBeloper_Output_Order_History_DTO();
		
		outputOrder.setOutputBookNo(purchaseInfo.get("bookNo"));
		outputOrder.setOutputNumberOfBooks(purchaseInfo.get("numberOfBooks"));
		outputOrder.setOutputMemberNo(purchaseInfo.get("memberNo").toString());
		
		int result = service.purchaseBook(outputOrder);
		
		if(result == -1) {
			resultView.displayPurchaseBookResult(-1);
		} else {
			if(purchaseInfo.get("numberOfBooks") > bookStock.get(purchaseInfo.get("bookNo"))) {
				result = -2;
				resultView.displayPurchaseBookResult(-2);
			} else if(result >= 1) {
				resultView.displayPurchaseBookResult(1);
			} else {
				resultView.displayPurchaseBookResult(0);
			}
		}
		
	}

	/* 비회원 도서 구매 신청 메소드 - 준혁 */
	public void nonmemberPurchaseBook(DBeloper_Output_Order_History_DTO purchaseInfo) {
		
		Map<Integer, Integer> bookStock = selectAllBookStock();
		
		int result = service.nonmemberPurchaseBook(purchaseInfo);
		
		if(result == -1) {
			resultView.displayPurchaseBookResult(-1);
		} else {
			if(purchaseInfo.getOutputNumberOfBooks() > bookStock.get(purchaseInfo.getOutputBookNo())) {
				result = -2;
				resultView.displayPurchaseBookResult(-2);
			} else if(result >= 1) {
				resultView.displayPurchaseBookResult(1);
			} else {
				resultView.displayPurchaseBookResult(0);
			}
		}
		
	}


	/* 큰솔 회원 가입용 Controller */
	public void memberjoin(Map<String, String> memberJoin) {
		
		/* 아이디 중복 값 체크 */
		Map<String, String> memberForCehck = service.selectMemberForCheck(memberJoin);
		Map<String, String> memberPhoneForCheck = service.selectMemberPhoneForCheck(memberJoin);
		
		if(!(memberForCehck.isEmpty())){
			
			/* 휴먼계정일 시 계정 활성화 여부 탐색 */
			if(memberForCehck.get("memberDropYN").equals("Y")) {
				DBeloper_Member_Join_View jv = new DBeloper_Member_Join_View();
				jv.memberRejoinView(memberJoin.get("MEM_ID"));
			} else {
				resultView.displayResultMessage("DuplicationMemberId");
				return;
			}
		
			/* 고객 번호 중복값 확인 */
		} else if(!(memberPhoneForCheck.isEmpty())) {
			System.out.println();
			resultView.displayResultMessage("DuplicationMemberPhone");
			System.out.println();
			return;
			
			/* 중복 아이디 없을 시 가입 진행 */
		} else {
			int result = service.memberJoin(memberJoin);
			if(result >=1) {
				resultView.displayResultMessage("sucessJoin"); 
				return;
			} else {
				resultView.displayResultMessage("failedJoin");
				return;
			}
		}
	}
	
	/* 비회원 정보 입력 Controller - 다영 */
	public void nonmemberjoin(Map<String, String> nonmemberjoin) {
		
		int result = service.nonmemberjoin(nonmemberjoin);
		if(result >=1) {
			resultView.displayResultMessage("NonmemberJoinSuccess"); 
			return;
		} else {
			resultView.displayResultMessage("NonmemberJoinFailed");
			return;
		}
	}

	/* 큰솔 휴먼 계정 활성화용 Controller */
	public void memberRejoin(Map<String, String> memberReJoin) {
		
		int result = service.memberRejoin(memberReJoin);
		
		if(result > 0) {
			resultView.displayResultMessage("sucessReJoin");
			return;
		} else {
			resultView.displayResultMessage("failedRejoin");
			return;
		}
	}
	
	/* 회원 탈퇴 메소드 - 준혁 */
	public void cancelMembership(Map<String, String> checkMember) {
		
		int checkResult = Integer.parseInt(checkMember.get("checkResult"));
		int result = 0;
		
		if(checkResult == 0) {
			result = service.cancelMembership(checkMember);
		} else {
			resultView.displayIncorrectInfo(checkResult);
		}
		
		if(result >= 1) {
			resultView.displayResultMessage("SuccessCancelMembership");
		} else{
			resultView.displayResultMessage("FailCancelMembership");
		}
	}

	
	
	/* 기존 도서 입고 요청 Controller - 시원 */
	public void registInputOrderExist(Map<String, String> existBookOrder) {

		int bookNo = Integer.parseInt(existBookOrder.get("bookNo"));
	
		DBeloper_Input_Order_History_DTO inputOrderDTO = new DBeloper_Input_Order_History_DTO();
		inputOrderDTO.setInputBookNo(bookNo);
		inputOrderDTO.setInputBookname(existBookOrder.get("bookName"));
		inputOrderDTO.setInputBookAuthor(existBookOrder.get("authorName"));
		inputOrderDTO.setInputBookPublisherName(existBookOrder.get("publisherName"));
		
		int inputOrderResult = service.registInputOrderExist(inputOrderDTO);
	
		if(inputOrderResult > 0) {
			resultView.displayResultMessage("displayInputOrderResultSuccess");
		}else {
			resultView.displayResultMessage("displayInputOrderResultFailed");
		}
		
	}

	/* 신규 도서 입고 요청 Controller - 시원 */
	public void registInputOrderNew(Map<String, String> newBookOrder) {
		
	
		DBeloper_Input_Order_History_DTO inputOrderDTO = new DBeloper_Input_Order_History_DTO();

		inputOrderDTO.setInputBookname(newBookOrder.get("bookName"));
		inputOrderDTO.setInputBookAuthor(newBookOrder.get("authorName"));
		inputOrderDTO.setInputBookPublisherName(newBookOrder.get("publisherName"));
	
		int inputOrderResult = service.registInputOrderNew(inputOrderDTO);
	
		if(inputOrderResult > 0) {
			resultView.displayResultMessage("displayInputOrderResultSuccess");
		}else {
			resultView.displayResultMessage("displayInputOrderResultFailed");
		} 
		
	}

	
	/* 재고 없는 도서 목록에서 입력한 도서번호로 도서 정보 가져오는 Controller  - 시원 */
	public List<DBeloper_Book_DTO> selectBookStock(){
		
		DBeloper_Book_DTO bookDTO = new DBeloper_Book_DTO();
		
		List<DBeloper_Book_DTO> BookStockZeroList = service.selectBookStock();	
		
		
		return BookStockZeroList;
		
	}
	
	/* 도서 입고 전 재고 없는 도서 목록 조회 Controller - 시원 */
	public List<DBeloper_Book_DTO> selectBookStockView(){
			
			DBeloper_Book_DTO bookDTO = new DBeloper_Book_DTO();
			
			List<DBeloper_Book_DTO> BookStockZeroListView = service.selectBookStock();	
			
			resultView.displayBookStockZeroList(BookStockZeroListView);
			
			return BookStockZeroListView;
			
		}

	

	/*일매출 조회 Controller - 수목*/
	public List<DBeloper_Store_Sales_History_DTO> selectDaySalesHistory(String inputYear, String inputMonth, String inputday) {
		
		String inputDate = inputYear + "-" + inputMonth + "-" + inputday;
		List<DBeloper_Store_Sales_History_DTO> daySalesHistory = new ArrayList<DBeloper_Store_Sales_History_DTO>();
		
		try {
		java.sql.Date selectDate = java.sql.Date.valueOf(inputDate);
		daySalesHistory = service.selectDaySalesHistory(selectDate);
		resultView.selectDaySalesHistory(daySalesHistory);
		}catch(IllegalArgumentException e) {
			resultView.displayResultMessage("notcorrectNum");
		}
		
		
		return daySalesHistory;
	}

	/* 비회원 정보 받아오는 메소드(책 주문 할 때 비회원 번호 위해서) - 준혁 */
	public DBeloper_NonMembers_DTO selectNonMemberInfO(Map<String, String> nonmemberJoin) {
		
		DBeloper_NonMembers_DTO nonmember = service.selectNonMemberInfo(nonmemberJoin);
		
		int i = 0;
		
		if(nonmember.getNonmembersNo() != null) {
			resultView.displayNonMemberSelectResult(i);		
		} else {
			resultView.displayNonMemberSelectResult(i);	
		}
		
		return nonmember;
	}

	/* 큰솔 구매한 도서 목록 확인용 Controller */
	public int selectMemberByBook(String memberNo) {
		booklist = service.selectMemberByingBook(memberNo);
		
		int result = 0;
		if(booklist.isEmpty()) {
			resultView.displayResultMessage("failedPurchaseBook");
			result = 0;
		} else {
			resultView.purchaseBook(booklist);
			result = 1;
			
		}
		return result;
	}

	/* 큰솔 리뷰 작성용 Controller */
	public void insertReview(int bookNo, String reviewContents, String userNo) {

		DBeloper_Review_Insert_DTO reviewInsert = new DBeloper_Review_Insert_DTO();
		reviewInsert.setBookNo(bookNo);
		reviewInsert.setReviewContents(reviewContents);
		reviewInsert.setUserNo(userNo);

		for(DBeloper_Book_DTO list : booklist) {
			if(reviewInsert.getBookNo() == list.getBookNo()) {
				int result = service.insertReview(reviewInsert);
				if(result > 0) {
					resultView.displayResultMessage("suessInsertReview");
				} else {
					resultView.displayResultMessage("failedInsertReview");
				}
				break;
			} else {
				resultView.displayResultMessage("failedInsertReview2");
			} break;
		}
		
	}

	/* 큰솔 판매 대기 승인용 Controller */
	public void updateOutputOrderHistory(String managerInput) {
		int result = service.updateOutputOrderHistory(managerInput);
			if(result > 0) {
				resultView.displayResultMessage("suessUpdate");
			} else if(result == -1) {
				resultView.displayResultMessage("notEnoughBookStock");
			} else {
				resultView.displayResultMessage("failedUpdate");
			}
	}
	
	/* 지영 - 마일리지 사용 Controller */
	public void updateUseMemberMileage(Map<String, String> mapproductNo) {
		
		/* 고객이 가지고 있는 마일리지 잔액 조회 */
		String productNo = mapproductNo.get("productNo");
		if(!(productNo.equals("1") || productNo.equals("2") || productNo.equals("3") || productNo.equals("4"))){
			System.out.println("메뉴에 없습니다");
		} else {
			int useMileageResult = service.selectMemberMileage(mapproductNo.get("userNO"));
			
			/* 지영 - update */
			int result = service.updateuseMemberMileageService(mapproductNo);
			if(result > 0) {
				resultView.displayResultMessage("suessUpdate");
			} else {
				resultView.displayResultMessage("failedUpdate");
			}
}
		
	
	}
	
	/* 지영 - 고객 마일리지 잔액 조회 Controller */
	public void updateUseMemberMileage2(String userNO) {
		
		int useMileageResult = service.selectMemberMileage(userNO);
		
		resultView.displayuseMileageResult(useMileageResult);
		
	}
	/* 신규 도서 입고 등록 및 승인 - 수목 */
	public int approvalInputOrderNewBook(List<DBeloper_Input_Order_History_DTO> list, String answer) {
		int result = 0;
		
		
			for(DBeloper_Input_Order_History_DTO inputOrderHistoryDTO : list) {
				if(inputOrderHistoryDTO.getNewBook().equals("Y")) {
					if(answer.equals(inputOrderHistoryDTO.getInputOrderNo())) {
						/*주문 번호가 일치할때 실행되는 부분*/
						do {
						
						DBeloper_Book_DTO book = resultView.inputBookinfo();
						
						
						result = service.insertUpdateNewInputbooks(answer,book); 
						
						/* 도서 정보가 잘못 되었을 경우 반복을 위한 조건문 */
						}while(result == 2);
						
					
					}
				}
			}
			
			/* 주문 번호가 일치 하지 않을 때 result에 2를 담아 이전 메소드에 반환. */	
			if(result == 0) {
				for(DBeloper_Input_Order_History_DTO inputOrderHistoryDTO : list) {
					if(inputOrderHistoryDTO.getNewBook().equals("Y")) {
						if(! answer.equals(inputOrderHistoryDTO.getInputOrderNo())) {
							result = 2;
						}
					}
				}
			}
		return result;
	}
	
	
	/* 입고 신청 책 조회 (기존도서) Controller - 다영 */
	public List<DBeloper_Input_Order_History_DTO> selectBookInputOrderHistory(){
		return service.selectBookInputOrderHistory();
	}
	
	/* 기존 도서 입고 승인 - 다영 */
	public int acceptBookInputOrderHistory(String acceptBookNo) {
		int result = service.acceptBookInputOrderHistory(acceptBookNo);
		
			if(result > 0) {
				resultView.displayResultMessage("successAccept");
			} else {
				resultView.displayResultMessage("failedAccept");
			}
			return result;
	}
	
	
	/* 큰솔 도서 수량으로 도서 목록 조회용 Controller */
	public List<DBeloper_Book_DTO> booklistByBookStock(){
		
		List<DBeloper_Book_DTO> booklistByBookStock = service.selectBookByStock();
		
		resultView.booklistByBookStock(booklistByBookStock);
		
		return booklistByBookStock;

		
	}

	/* 큰솔 도서 번호로 도서 재고 추가용 Controller */
	public void updateBookStockByUserInput(int bookNo, int bookAmount) {
		int result = service.updateBookStockByUserInput(bookNo, bookAmount);
			
			if(result > 0) {
				resultView.displayResultMessage("successAccept");
			} else if(result == -1) {
				resultView.displayResultMessage("NotEnoughMoney2");
			} else {
				resultView.displayResultMessage("failedInput");
			}
			
	}
	
	/* 도서 주문시 참고하기 위한 책들의 재고 조회 메소드 - 준혁 */
	public Map<Integer, Integer> selectAllBookStock() {
		
		Map<Integer, Integer> bookStock = service.selectAllBookStock();
		
		if(bookStock.isEmpty()) System.out.println("재고 조회에 실패했습니다.");
		
		return bookStock;
	}

	/* 특정 회원이 작성하거나 특정 도서에 대한 리뷰를 조회하는 메소드 - 준혁 */
	public void selectReview(DBeloper_Review_DTO selectReviewInfo) {
		
		List<Map<String, String>> reviewList = service.selectReview(selectReviewInfo);
		
		if(!reviewList.isEmpty()) {
	         resultView.displayReview(reviewList);         
	      } else {
	         resultView.displayReviewSelectFailedMessage();
	      }
	}
	
	/* 입력받은 아이디와 일치하는 관리자의 DROP_YN(퇴사여부) 변경 - 시원*/
	public void modifyManagerReturn(String managerNum) {
		
		int registResult = service.updateManagerReturn(managerNum);
		
		if(registResult > 0) {
			resultView.displayResultMessage("SuccessReturn");
		}else {
			resultView.displayResultMessage("failedReturn");
		}
	}
	
	/* 퇴사여부 변경을 위한 퇴사자 조회 - 시원*/
	public void selectRetireManager() {
	
		DBeloper_Manager_DTO managerDTO = new DBeloper_Manager_DTO();
		
		List<DBeloper_Manager_DTO> managerRetireList = service.selectManagerRetireService();
		
		resultView.displayRetireManager(managerRetireList);			
		
}
	
} // main 종료
