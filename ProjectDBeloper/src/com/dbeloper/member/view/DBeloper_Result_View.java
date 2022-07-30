package com.dbeloper.member.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dbeloper.member.model.dto.DBeloper_Book_DTO;
import com.dbeloper.member.model.dto.DBeloper_Input_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Manager_DTO;
import com.dbeloper.member.model.dto.DBeloper_Member_DTO;
import com.dbeloper.member.model.dto.DBeloper_Output_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Store_Sales_History_DTO;
import com.dbeloper.member.model.service.DBeloper_Service;

public class DBeloper_Result_View {
	
	private DBeloper_Service service = new DBeloper_Service();
	private Scanner sc = new Scanner(System.in);

	/* 초회된 책들의 정보 출력 - 준혁 */
	public void display(List<DBeloper_Book_DTO> bookList) {

		for (DBeloper_Book_DTO book : bookList) {
			System.out.println("----------------------");
			System.out.println("도서번호 : " + book.getBookNo());
			System.out.println("도서명 : " + book.getBookName());
			System.out.println("작가명 : " + book.getBookAuthor());
			System.out.println("가격 : " + book.getBookPrice());
			System.out.println("판매량 : " + book.getBookSalesRate());
			System.out.println("재고 : " + book.getBookStock());
			System.out.println("출판사 : " + book.getBookPublisherName());
			System.out.println("카테고리 번호 : " + book.getBookCategoryNumber());
		}
	}

	/* 결과문 출력 */
	public void displayResultMessage(String result) {
		switch (result) {
		case "NotEnoughMoney":
			System.out.println("서점의 총 재산이 필요 월급 지불금액보다 적습니다. "); break;
		case "SucessInsertSalary":
			System.out.println("월급 지불에 성공하셨습니다."); break;
		case "FailedInsertSalary":
			System.out.println("알 수 없는 오류 발생. 월급 지불에 실패하셨습니다."); break;
		case "FailedLogin":
			System.out.println("로그인에 실패하셨습니다. 아이디와 비밀번호를 확인하세요."); break;
		case "NotEnouhtGrade":
			System.out.println("권한이 부족합니다. 상급자에게 문의하세요."); break;
		case "DuplicationMemberId":
			System.out.println("동일한 아이디가 존재합니다. 다른 아이디를 선택해주세요"); break;
		case "sucessJoin":
			System.out.println("회원가입 성공!"); break;
		case "failedJoin":
			System.out.println("알 수 없는 오류로 가입이 실패했습니다."); break;
		case "sucessReJoin":
			System.out.println("휴먼계정이 복구되었습니다."); break;
		case "failedRejoin":
			System.out.println("계정 복구에 실패하셨습니다. 비밀번호를 확인해 주세요"); break;
		case "suessInsertReview":
			System.out.println("리뷰 작성에 성공하셨습니다. 마일리지 500원을 지급해드립니다."); break;
		case "failedInsertReview":
			System.out.println("알 수 없는 오류로 리뷰 작성에 실패하셨습니다."); break;
		case "failedInsertReview2" :
			System.out.println("구매하신 책이 아닙니다."); break;
		case "failedPurchaseBook": 
			System.out.println("구매하신 책이 없습니다."); break;
		case "suessUpdate"	:
			System.out.println("판매 승인 완료"); break;
		case "failedUpdate" :
			System.out.println("판매 승인 실패"); break;
		case "unExistMenu" :
			System.out.println("존재하지 않는 기능입니다."); break;
		case "successAccept" :
			System.out.println("도서 입고 승인 완료"); break;
		case "failedAccept" :
			System.out.println("도서 입고 승인 실패"); break;
		case "notEnoughBookStock" :
			System.out.println("도서 재고 부족으로 출고할 수 없습니다."); break;
		case "failedInput" :
			System.out.println("알 수 없는 오류로 도서 입고에 실패했습니다."); break;
		case "NotEnoughMoney2" :
			System.out.println("서점 보유 금액이 부족합니다."); break;
		case "SearchFailied" : 
			System.out.println("조회 실패"); break;
		case "SuccessCancelMembership" :
			System.out.println("회원 탈퇴에 성공하셨습니다."); break;
		case "FailCancelMembership" :
			System.out.println("회원 탈퇴에 실패하셨습니다."); break;
		case "displayInputOrderResultSuccess" :
			System.out.println("도서 입고 신청이 완료되었습니다."); break;
		case "displayInputOrderResultFailed" :
			System.out.println("도서 입고 신청에 실패하셨습니다. 다시 시도해주세요."); break;
		case "displayReviewSelectFailedMessage" :
			System.out.println("\"리뷰 조회에 실패했습니다.\""); break;
		case "B" :
			System.out.println("현재 고객님의 등급은 브론즈 등급입니다."); break;
		case "S" :
			System.out.println("현재 고객님의 등급은 실버 등급입니다."); break;
		case "G" :
			System.out.println("현재 고객님의 등급은 골드 등급입니다. "); break;
		case "outOfbookList" :
			System.out.println("존재하지 않는 도서입니다."); break;
		case "emptyOutputOrder" :
			System.out.println("출고 목록이 없습니다."); break;
		case "outputList" :
			System.out.println("목록에 없습니다. 입력값을 확인하세요");break;
		case "SuccessReturn" :
			System.out.println("복직 처리에 성공하였습니다."); break;
		case "failedReturn" :
			System.out.println("복직 처리에 실패하였습니다. 입력하신 관리자 번호를 다시 확인해주세요."); break;
		case "puchaseFailed":
			System.out.println("해당 책의 재고가 부족하여 주문에 실패했습니다."); break;
		case "notcorrectNum" : 
			System.out.println("[ 올바른 값을 입력해주세요. ]"); break;
		case "notcorrectBookInfo" : 
			System.out.println("[ 올바른 도서정보를 입력해주세요. ]"); break;
		case "backtothebefore" : 
			System.out.println("[ 이전 메뉴로 돌아갑니다. ]"); break;
		case "noHaveOrderlist" : 
			System.out.println("[ 신규 입고 요청이 존재하지 않습니다. 이전 메뉴로 돌아갑니다. ]"); break;
		case "NonExistSearchBookMenu":
			System.out.println("존재 하지 않는 메뉴입니다."); break;
		case "DuplicationMemberPhone" :
			System.out.println("동일한 핸드폰 번호가 존재합니다."); break;
		case "NonmemberJoinSuccess" :
			System.out.println("비회원 정보 입력 성공!"); break;
		case "NonmemberJoinFailed" :
			System.out.println("비회원 정보 입력 실패");	 break;
		}
	}
	/* 도서 조회 실패 메세지 출력  case문에 통합 진행 중. */

	public void displayFailMessage() {
		System.out.println("Search Failied");
	}


	/* 회원 정보 메시지 출력 */
	public void displayMember(List<DBeloper_Member_DTO> memberList) {

		for (DBeloper_Member_DTO member : memberList) {
			System.out.println("----------------------");
			System.out.println("회원번호 : " + member.getMemberNo());
			System.out.println("회원명 : " + member.getMemberName());
			System.out.println("회원 마일리지 : " + member.getMemberMileage());
			System.out.println("회원 아이디 : " + member.getMemberId());
			System.out.println("회원 등급 : " + member.getMemberGradeNo());
			System.out.println("회원 탈퇴여부 : " + member.getMemberDropYN());
			System.out.println("회원 누적금액 : " + member.getMemberSumMoney());
		}
	}

	/* 매니저 정보 메시지 출력 */
	public void displayManager(List<DBeloper_Manager_DTO> managerList) {

		for (DBeloper_Manager_DTO manager : managerList) {
			System.out.println("----------------------");
			System.out.println("관리자번호 : " + manager.getManagerNum());
			System.out.println("관리자명 : " + manager.getManagerName());
			System.out.println("관리자 직급 : " + manager.getManagerGrade());
			System.out.println("관리자 연락처 : " + manager.getManagerPhone());
			System.out.println("관리자 주소 : " + manager.getManagerAddress());
			System.out.println("관리자 급여 : " + manager.getManagerSalary());
			System.out.println("관리자 퇴사여부 : " + manager.getManagerDropYN() + "\n");
		}
	}

	/* 도서 구매 신청 성공 여부 출력 메소드 - 준혁 */
	public void displayPurchaseBookResult(int i) {
		if (i == 1) {
			System.out.println("구매 주문이 완료되었습니다.");
		} else if(i == -1) { 
			System.out.println("존재하지 않는 도서번호입니다. 다시 시도해주세요");
		} else if(i == -2){
			System.out.println("해당 책의 재고가 부족하여 주문에 실패했습니다.");
		} else {
			System.out.println("구매 주문에 실패하셨습니다. 다시 시도해주세요");
		}
	}

	/* 회원 탈퇴에서 확인차 입력한 정보가 잘못되었을 때 출력 메소드 - 준혁 */
	public void displayIncorrectInfo(int i) {
		switch (i) {
		case 1:
			System.out.println("탈퇴를 취소하셨습니다. 메인 메뉴로 돌아갑니다.");
			break;
		case 2:
			System.out.println("잘못된 아이디입니다.");
			break;
		case 3:
			System.out.println("잘못된 비밀번호입니다.");
			break;
		}
	}

	/* 일별 매출 조회 resultView - 수목 */
	public void selectDaySalesHistory(List<DBeloper_Store_Sales_History_DTO> daySalesHistory) {
		System.out.println("=============== 조회 내용 ===============");
		int result = -1;
		for (DBeloper_Store_Sales_History_DTO salesHistory : daySalesHistory) {
			System.out.println(salesHistory.getStoreDbeloperDate() + "  매장 입출금 내역: "
					+ salesHistory.getStoreIncomeStatement() + " " + salesHistory.getStoreSalesMoney() + "원 ");
			result = 1;
		}
		
		if(result < 0) {
			System.out.println("해당 날짜의 매출 내역이 없습니다. ");
		}
		System.out.println("========================================");

	}

	/* 도서 리뷰 작성 관련 resultView */
	public void purchaseBook(List<DBeloper_Book_DTO> booklist) {
		
		for(DBeloper_Book_DTO list : booklist) {
			System.out.println(list.getBookNo() +"번. " +list.getBookName());

		}
	}


	/* 비회원 정보 조회 결과 출력 메소드 - 준혁 */

	public void displayNonMemberSelectResult(int i) {
		if (i == 0) {
			System.out.println("도서 주문을 진행합니다.");
		} else {
			System.out.println("문제가 발생하여 메뉴로 돌아갑니다.");
		}
	}
	
	/*주문 승인내역 아니오, 오류 */
	public int answerNoOrelse(String answer) {
		int result = 0;
		if(answer.equals("아니오")) {
			System.out.println("메인메뉴로 돌아갑니다.");
			result = 1;
		}else {
			System.out.println("정확히 입력해주세요.");
			result = -1;
		}
		return result;
	}

	/* 재고 없는 도서 조회 */
	public List<DBeloper_Book_DTO> displayBookStockZeroList(List<DBeloper_Book_DTO> BookStockZeroListView){
	System.out.println();
	System.out.println("================================= 재고 없는 도서 목록 =================================");
	for (DBeloper_Book_DTO bookStockDTO : BookStockZeroListView) {
		System.out.print("도서 번호 : " + bookStockDTO.getBookNo() + " | ");
		System.out.print("도서명 : " + bookStockDTO.getBookName() + " | ");
		System.out.print("작가명 : " + bookStockDTO.getBookAuthor() + " | ");
		System.out.print("출판사명 : " + bookStockDTO.getBookPublisherName() + " | ");
		System.out.println("도서 가격 : " + bookStockDTO.getBookPrice() + " | ");
	}
	return null;
}
	
	/* 도서 판매 대기 목록 출력 - 시원 */
	public List<DBeloper_Output_Order_History_DTO> selectOrderOutputHistory(List<DBeloper_Output_Order_History_DTO> list) {
		System.out.println();
		System.out.println("=========================== 도서 입고 신청 내역 ===========================");
		for(DBeloper_Output_Order_History_DTO dbOutputOrderHistoryDTO : list) {
			System.out.print("주문 번호 : " + dbOutputOrderHistoryDTO.getOutputOrderNo() + " | ");
			System.out.print("주문 수량 : " + dbOutputOrderHistoryDTO.getOutputNumberOfBooks() + " | ");
			System.out.print("주문일 : " + dbOutputOrderHistoryDTO.getOutputOrderDate() + " | ");
			System.out.print("책 번호 : " + dbOutputOrderHistoryDTO.getOutputBookNo() + " | ");
			System.out.print("주문자 회원 번호 : " + dbOutputOrderHistoryDTO.getOutputMemberNo() + " | ");
			System.out.println("주문자 비회원 번호 : " + dbOutputOrderHistoryDTO.getOutputNonmembersNo());
		}
		return list;
	}
	
	/* 신규 도서 입고 대기 목록 출력 - 수목 */
	public int selectOrderNewInputbooksHistory(List<DBeloper_Input_Order_History_DTO> list){
		int result = -1;
		System.out.println();
		System.out.println("================ 신규 도서 요청 내역 ================");
		for(DBeloper_Input_Order_History_DTO inputOrderHistoryDTO : list) {
			if(inputOrderHistoryDTO.getNewBook().equals("Y")) {
				System.out.println("주문 번호: " + inputOrderHistoryDTO.getInputOrderNo());
				System.out.println("책 이름: " + inputOrderHistoryDTO.getInputBookname());
				System.out.println("작가 이름: " + inputOrderHistoryDTO.getInputBookAuthor());
				System.out.println("출판사: " + inputOrderHistoryDTO.getInputBookPublisherName());
				System.out.println("=============================================");
				result = 1 ;
			}
			
		}

		return result;
	}
   
	/* 입고 신청 책 조회 (기존도서) */
	public int selectBookInputOrderHistory(List<DBeloper_Input_Order_History_DTO> selectBookInputOrderHistoryList) {
		int result = 0;
		for(DBeloper_Input_Order_History_DTO selectBookInputOrderHistoryDTO: selectBookInputOrderHistoryList) {
			System.out.print("입고 주문 번호 : " + selectBookInputOrderHistoryDTO.getInputOrderNo() + " | ");
			System.out.print("도서 이름 : " + selectBookInputOrderHistoryDTO.getInputBookname() + " | ");
			System.out.print("작가 : " + selectBookInputOrderHistoryDTO.getInputBookAuthor() + " | ");
			System.out.print("출판사 : " + selectBookInputOrderHistoryDTO.getInputBookPublisherName() + " | ");
			System.out.print("도서 번호 : " + selectBookInputOrderHistoryDTO.getInputBookNo());
			System.out.println();
			result = 1;
		}
		return result;
	}
	
	/* 도서 수량으로 도서 목록 조회 */
	public void booklistByBookStock(List<DBeloper_Book_DTO> booklistByBookStock) {
		for(DBeloper_Book_DTO list : booklistByBookStock) {
			System.out.println("도서 번호 : " + list.getBookNo() + ", 도서 이름 : " + list.getBookName() + ", 도서 재고 : " + list.getBookStock());
		}
	}

	/* 조회된 리뷰 출력 - 준혁 */
	public void displayReview(List<Map<String, String>> reviewList) {
		for(Map<String, String> review : reviewList) {
			System.out.println("========================");
			System.out.println("도서 이름 : " + review.get("bookName"));
			System.out.println("리뷰 내용 : " + review.get("reviewContent"));
		}
		
	}

	/* 리뷰 조회 실패 메세지 출력 - 준혁 */
	public void displayReviewSelectFailedMessage() {
		System.out.println("리뷰가 존재하지 않습니다. 리뷰 조회에 실패했습니다.");
	}
	
	/* 퇴사자 복직 기능에 필요한 퇴사자 리스트 조회 - 시원 */
	public void displayRetireManager(List<DBeloper_Manager_DTO> managerRetireList) {

		for (DBeloper_Manager_DTO retireManager : managerRetireList) {
			System.out.println("----------------------");
			System.out.println("관리자번호 : " + retireManager.getManagerNum());
			System.out.println("관리자명 : " + retireManager.getManagerName());
			System.out.println("관리자 직급 : " + retireManager.getManagerGrade());
			System.out.println("관리자 연락처 : " + retireManager.getManagerPhone());
			System.out.println("관리자 주소 : " + retireManager.getManagerAddress());
			System.out.println("관리자 급여 : " + retireManager.getManagerSalary() + "\n");
			System.out.println("관리자 퇴사여부 : " + retireManager.getManagerDropYN() + "\n");
		}
	}
	
	/* 마일리지 조회 - 지영 */
	public void displayuseMileageResult(int useMileageResult) {
		System.out.println();
	    System.out.println("고객님의 남은 마일리지 잔액은 " + useMileageResult + "마일리지 입니다.");
	}
	
	/* 매장 전체 판매 내역 조회 결과 - 수목*/
	public void displayselectAllSalesHistory(List<DBeloper_Store_Sales_History_DTO> storeSalesHistoryList) {
		for(DBeloper_Store_Sales_History_DTO salesHistory : storeSalesHistoryList) {
			System.out.println(salesHistory.getStoreDbeloperDate() + "  매장 입출금 내역: " + salesHistory.getStoreIncomeStatement() + " " + salesHistory.getStoreSalesMoney()+"원 " );
		}
		System.out.println("-----------------------------------------");
	}
	
	/* 매장 보유금액 조회 결과 - 수목*/
	public void storeSumMoneyAmountResult(int storeSumMoneyAmount ) {
		System.out.println("현재 총 매장 보유금액: " + storeSumMoneyAmount);
	}
	
	/*신규 책 입고시 입력 받을 것.- 수목*/
	public DBeloper_Book_DTO inputBookinfo() {
		Scanner sc = new Scanner(System.in);
		DBeloper_Book_DTO book = new DBeloper_Book_DTO();
		
		try {
		
		System.out.println("========== 해당 도서 등록 ===========");
		System.out.println("책 이름을 입력해주세요: ");
		String bookName = sc.nextLine();
		
		System.out.println("작가명을 입력해주세요: ");
		String bookAuthor = sc.nextLine();
		
		System.out.println("출판사 이름을 입력해주세요: ");
		String bookPublisherName = sc.nextLine();
		
		System.out.println("가격을 입력해주세요: ");
		int bookPrice = sc.nextInt();
		sc.nextLine();
		
		System.out.println("출판년도를 입력해주세요(YYYY-MM-DD): ");
		String bookPubDate = sc.nextLine();
		java.util.Date bookPublishingDate = java.sql.Date.valueOf(bookPubDate);
		
		
		System.out.println("입고 수량 입력해주세요: ");
		int bookStock = sc.nextInt();
		sc.nextLine();
		
		
		System.out.println("도서 구분번호를 입력해주세요(1,2): ");
		int bookEBNum = sc.nextInt();
		sc.nextLine();
		
		System.out.println("도서 장르 번호를 입력해주세요(1~11): ");
		int bookCateNum = sc.nextInt();
		sc.nextLine();
		
		book = new DBeloper_Book_DTO(bookName, bookAuthor, bookPrice, bookPublishingDate, bookStock, bookPublisherName, bookEBNum, bookCateNum);
		}catch (InputMismatchException e) {
			displayResultMessage("notcorrectBookInfo");
			book = new DBeloper_Book_DTO();
		}catch(IllegalArgumentException e) {
			displayResultMessage("notcorrectBookInfo");
			book = new DBeloper_Book_DTO();
		}catch(NullPointerException e) {
			displayResultMessage("notcorrectBookInfo");
			book = new DBeloper_Book_DTO();
		}
	
		return book;
	}
	
	
}
