package com.dbeloper.member.model.service;

import static com.dbeloper.common.JDBCTemplate.close;
import static com.dbeloper.common.JDBCTemplate.commit;
import static com.dbeloper.common.JDBCTemplate.getConnection;
import static com.dbeloper.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.dbeloper.member.model.dao.DBeloper_DAO;
import com.dbeloper.member.model.dto.DBeloper_Book_DTO;
import com.dbeloper.member.model.dto.DBeloper_Input_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Manager_DTO;
import com.dbeloper.member.model.dto.DBeloper_Member_DTO;
import com.dbeloper.member.model.dto.DBeloper_NonMembers_DTO;
import com.dbeloper.member.model.dto.DBeloper_Output_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Review_DTO;
import com.dbeloper.member.model.dto.DBeloper_Review_Insert_DTO;
import com.dbeloper.member.model.dto.DBeloper_Store_Sales_History_DTO;

public class DBeloper_Service {

	private DBeloper_DAO dbeloperDAO = new DBeloper_DAO();
	
	/* 큰솔, 준혁 관리자 로그인용 Service */
	public Map<String, String> loginManager(Map<String, String> map) {
		
		Connection con = getConnection();
		
		Map<String, String> managerNameManagerGrade = dbeloperDAO.managerLogin(map, con);
		
		close(con);
		
		return managerNameManagerGrade;
	}


	/* 큰솔 고객 로그인용 Service (수정 사항 : 기존에 이름만 받아왔는데 필요한 정보를 DTO 형태로 다 받아오도록 수정 - 준혁) */
	public DBeloper_Member_DTO loginMamber(Map<String, String> map) {

		Connection con = getConnection();
		
		DBeloper_Member_DTO member = dbeloperDAO.memberLogin(map, con);
		close(con);
		return member;
	}
	

	
	/* 회원 조회용 Service - 다영 */
	public List<DBeloper_Member_DTO> selectMemberService(DBeloper_Member_DTO memberDTO){
	    Connection con = getConnection();
	      
	    List<DBeloper_Member_DTO> memberList = dbeloperDAO.selectMember(con, memberDTO);
	      
	    close(con);
	      
	    return memberList;
	}

	
	/* 관리자 조회용 Service */
	public List<DBeloper_Manager_DTO> selectManagerService(DBeloper_Manager_DTO managerDTO){
		Connection con = getConnection();
		
		List<DBeloper_Manager_DTO> managerList = dbeloperDAO.selectManager(con, managerDTO);
		
		close(con);
		
		return managerList;
	}


	/* 매출 조회용 메소드 - 수목 */
	public List<DBeloper_Store_Sales_History_DTO> selectStoreSalesHistory() {

		Connection con = getConnection();
		
		List<DBeloper_Store_Sales_History_DTO> SalesHistoryList = dbeloperDAO.selectStoreSalesHistory(con);
		
		close(con);
		return SalesHistoryList;
	}


	/*매장 보유내역 조회 - 수목  */
	public int selectStoreSumMoney() {
		Connection con = getConnection();
		
		int StoreSumMoney = dbeloperDAO.selectStoreSumMoney(con);
		return StoreSumMoney;
	}

	/* 도서 조회 메스드(Service) - 준혁 */
	public List<DBeloper_Book_DTO> searchBook(int menuNum, DBeloper_Book_DTO bookInfo) {
		Connection con = getConnection();
		
		List<DBeloper_Book_DTO> bookList = dbeloperDAO.searchBook(con, menuNum, bookInfo);
		
		close(con);
		
		return bookList;
	}
	
	/* 큰솔 직원 월급 지급용 Service */
	public int insertSalary() {
		Connection con = getConnection();
		
		int result  = dbeloperDAO.insertSalary(con);
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	/* 큰솔 직원 총 월급 조회용 Service */
	public int selectManagerSumSalary() {
		Connection con = getConnection();
		
		int sumSalary = dbeloperDAO.managerSumSalary(con);
		
		close(con);
		
		return sumSalary;
	}
	

	/* 도서 신청 대기 Service - 시원 -> 이수목 사용중(아마 시원님이 만드심) */
	public List<DBeloper_Input_Order_History_DTO> selectInputOrderHistory(){
		
		Connection con = getConnection();
		
		List<DBeloper_Input_Order_History_DTO> dbInputOrderHistory = dbeloperDAO.selectInputOrderHistory(con);
		
		close(con);
		
		return dbInputOrderHistory ;

	}
	
	/* 주문 내역 조회 Service - 시원 */
	public List<DBeloper_Output_Order_History_DTO> selectOutputOrderHistory(){
		
		Connection con = getConnection();
		
		List<DBeloper_Output_Order_History_DTO> dbOutputOrderHistory = dbeloperDAO.selectOutputOrderHistory(con);
		
		close(con);
		
		return dbOutputOrderHistory;
	}
	

	/* 회원 도서 구매 신청용 Service - 준혁*/
	public int purchaseBook(DBeloper_Output_Order_History_DTO outputOrder) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = dbeloperDAO.purchaseBook(con, outputOrder);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	/* 비회원 도서 구매 신청 메소드 - 준혁 */
	public int nonmemberPurchaseBook(DBeloper_Output_Order_History_DTO purchaseInfo) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = dbeloperDAO.nonmemberPurchaseBook(con, purchaseInfo);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	/* 큰솔 가입시 중복 여부 확인을 위한 Service */
	public Map<String, String> selectMemberForCheck(Map<String, String> memberJoin) {

		Connection con = getConnection();
		
		return dbeloperDAO.selectMemberForCheck(con, memberJoin);
	}

	/* 큰솔 회원 가입용 Service */
	public int memberJoin(Map<String, String> memberJoin) {
		Connection con = getConnection();
		
		int result = dbeloperDAO.memberJoin(con, memberJoin);
		
		if(result >0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}
	
	/* 비회원 정보 입력 Service - 다영 */
	public int nonmemberjoin(Map<String, String> nonmemberJoin) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = dbeloperDAO.nonmemberJoin(con, nonmemberJoin);
		
		if(result >0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	/* 큰솔 휴먼 계정 활성화용 Service */
	public int memberRejoin(Map<String, String> memberReJoin) {
		
		Connection con = getConnection();
		
		int result = dbeloperDAO.memberRejoin(con, memberReJoin);
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}
	
	/* 회원 탈퇴 메소드 - 준혁 */
	public int cancelMembership(Map<String, String> checkMember) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = dbeloperDAO.cancelMembership(con, checkMember);
		
		if(result >0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}


	/* 지정 날짜 매출 조회 Service - 수목 */
	public List<DBeloper_Store_Sales_History_DTO> selectDaySalesHistory(Date inputDate) {
		Connection con = getConnection();
		List<DBeloper_Store_Sales_History_DTO> SalesHistoryList = dbeloperDAO.selectDaySalesHistory(con,inputDate);
		return SalesHistoryList;
	}
	
	/* 기존 도서 입고 요청 service - 시원 */
	public int registInputOrderExist(DBeloper_Input_Order_History_DTO inputOrderExist) {
			
			Connection con = getConnection();
			
			int result = dbeloperDAO.registInputOrderExist(con, inputOrderExist);
	
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			close(con);
			
			return result;
}
	
	/* 신규 도서 입고 요청 service - 시원 */
	public int registInputOrderNew(DBeloper_Input_Order_History_DTO inputOrderNew) {
			
			Connection con = getConnection();
			
			int result = dbeloperDAO.registInputOrderNew(con, inputOrderNew);
	
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			close(con);
			
			return result;
}
	

	/* 입고 요청 전 재고 없는 도서 확인용 Service - 시원 */
	public List<DBeloper_Book_DTO> selectBookStock(){
			
			Connection con = getConnection();
			
			List<DBeloper_Book_DTO> zeroStockBookDTO = dbeloperDAO.selectBookStock(con);
			
			close(con);
			
			return zeroStockBookDTO;
		}

	/* 비회원 정보를 받아오는 메소드(책 주문 위해서) - 준혁 */
	public DBeloper_NonMembers_DTO selectNonMemberInfo(Map<String, String> nonmemberJoin) {
		
		Connection con = getConnection();
		
		DBeloper_NonMembers_DTO nonmember = dbeloperDAO.selectNonMemberInfo(con, nonmemberJoin);
		
		close(con);
		
		return nonmember;
	}
	/* 입고(고객 책 요청) 주문 전체 승인 메소드 - 수목 */
	public int updateInputOrderAllAdmin() {
		Connection con = getConnection();
		
		int result = dbeloperDAO.updateInputOrderAllAdmin(con);
		
		if(result > 0) {
			commit(con);
			System.out.println("승인이 완료 되었습니다.");
		}else {
			System.out.println("승인이 거부되었습니다.");
		}
		close(con);
		return result;
	}
	
	/* 입고(고객 책 요청) 주문 부분 승인 메소드 - 수목 */
	public int updateInputOrderSelectAdim(String oderNum) {
		
		Connection con = getConnection();
		
		int result = dbeloperDAO.updateInputOrderSelectAdmin(con,oderNum);
		
		if(result > 0) {
			commit(con);
			System.out.println("승인이 완료 되었습니다.");
		}else {
			System.out.println("승인이 거부되었습니다.");
		}
		close(con);
		
		return result;
		
	}

	/* 큰솔 책 구매목록 확인 Service */
	public List<DBeloper_Book_DTO> selectMemberByingBook(String memberNo) {

		Connection con = getConnection();
		
		List<DBeloper_Book_DTO> purchaseBook = dbeloperDAO.selectByingBook(con, memberNo);
		
		close(con);
		return purchaseBook;
	}

	/* 큰솔 리뷰 작성용 service */
	public int insertReview(DBeloper_Review_Insert_DTO reviewInsert) {
		
		Connection con = getConnection();
		
		int result = dbeloperDAO.insertReview(reviewInsert, con);
		int resultMileage = dbeloperDAO.updateMemberMileage(reviewInsert, con);
		
		if(result == 1 && resultMileage == 1) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);
		
		return result;
	}

	/* 큰솔 도서재고와 출고수량 비교 -> 판매 상품 승인 -> 도서매출관리 INSERT -> 고객 총 소모금액 UPDATE -> 
	 * 고객 등급 UPDATE -> 고객 마일리지 부여 UPDATE (Transaction) Service */
	public int updateOutputOrderHistory(String managerInput) {
		
		Connection con = getConnection();

		/* 큰솔 OutputNo로 memberNo select */
		String memberNo = dbeloperDAO.selectMemNoByOutputOrderNo(managerInput, con);
			
		/* 큰솔 outputNo로 NumberOfBooks select (주문하는 도서 수량) */
		int numberOfBooks = dbeloperDAO.selectNumberOfBoosByOutputNo(con, managerInput);
		
		/* 큰솔 outputNo로 Book_Stock select (주문하려는 도서의 재고) */ 
		int numberOfBookStock = dbeloperDAO.selectBookStockByOutputNo(con, managerInput);
		
		/* 큰솔 비회원일 경우 출고 수량과 재고 비교*/
		if(memberNo == null) {
				if(numberOfBooks > numberOfBookStock) {
					close(con);
					return -1;
				} else {
					
					/* 큰솔 (출고 승인) OutputOrderHistory outputApproval N -> Y */ 
					int result = dbeloperDAO.updateOutputOrderHistory(managerInput, con);
					
					/* 큰솔 가게 매출 내역 INSERT */
					int result1 = dbeloperDAO.insertStoreSalesHistory(managerInput, con);
					
					/* 큰솔 출고번호로 도서 재고  UPDATE */
					int result2 = dbeloperDAO.updateBookStockByOutput(managerInput, numberOfBooks, con);
					
					/* 큰솔 도서 판매량 UPDATE */
					int result3 = dbeloperDAO.updateBookSalesRate(managerInput, numberOfBooks, con);
					
					/* 큰솔 결과값으로 커밋 결정 */
					if(result1 == 1 && result2 == 1 && result3 == 1) {
						
						commit(con);
						result = 1;
						return result;
						
					} else {
						
						rollback(con);
						result = 0;
						return result;
						
					}
				}
		}
		
		/* 큰솔 재고와 주문 수량 비교 */
		/* 회원일 때 */
		if(numberOfBooks > numberOfBookStock) {
			close(con);
			return -1;
			
		} else {

			/* 큰솔 (출고 승인) OutputOrderHistory outputApproval N -> Y */
			int result = dbeloperDAO.updateOutputOrderHistory(managerInput, con);
			
				/* 큰솔 가게 매출 내역 INSERT */
				int result2 = dbeloperDAO.insertStoreSalesHistory(managerInput, con);

				/* 큰솔 고객 총 소비 금액 UPDATE */
				int result3 = dbeloperDAO.updateMemberSumMoney(managerInput, memberNo, con);
								
				/* 큰솔 UPDATE한 고객 총 소비 금액 SELECT */
				int memberSumMoney = dbeloperDAO.selectMemberSumMoneyByMemNo(memberNo, con);
				
				/* 큰솔 고객 총 소비 금액으로 고객 등급 UPDATE */
				int result4 = dbeloperDAO.updateMemberGrade(con, memberNo, memberSumMoney);
				
				/* 큰솔 고객 등급과 고객 총 소비금액으로 고객 마일리지 UPDATE */
				int result5 = dbeloperDAO.updateMemberMileageByPurchase(managerInput, memberNo, con);
				
				/* 큰솔 출고번호로 도서 재고  UPDATE */
				int result6 = dbeloperDAO.updateBookStockByOutput(managerInput, numberOfBooks, con);
				
				/* 큰솔 도서 판매량 UPDATE */
				int result7 = dbeloperDAO.updateBookSalesRate(managerInput, numberOfBooks, con);
				
				/* 큰솔 결과값으로 커밋 결정 */
				if(result == 1 && result2 == 1 && result3 == 1 && result4 == 1 && result5 == 1 && result6 == 1 && result7 ==1) {
					
					commit(con);
					result = 1;
					
				} else {
					
					rollback(con);
					result = 0;

				}
				
			close(con);
			return result;
		}
	}
	
	/* 지영 - 고객 잔여 마일리지 조회용 Service */
	public int selectMemberMileage(String memberNo) {
		
		Connection con = getConnection();
		
		int result = dbeloperDAO.selectMemberMileage(memberNo, con);
		
		close(con);
		
		return result;
		
	}
	
	/* 지영 - 마일리지 상품 가격 조회용 Service */
	public int selectMileagePrice(String productNo) {
		
		Connection con = getConnection();
		
		int Productresult = dbeloperDAO.selectMemberMileage(productNo, con);
		
		close(con);
		return Productresult;
		
		
	}

	/* 지영 - 마일리지 사용 Service                                           */
	public int updateuseMemberMileageService(Map<String, String> product){
	    Connection con = getConnection();
	    int result2 = dbeloperDAO.purchaseMileageProduct(con, product);
	    
		if(result2 > 0) {
			commit(con);
		}else {
			rollback(con);
		}
	    close(con);
	      
	    return result2;
	}

	/* 입고 신청 책 조회 (기존도서) Service - 다영 */
	public List<DBeloper_Input_Order_History_DTO> selectBookInputOrderHistory(){
		
		Connection con = getConnection();
		
		List<DBeloper_Input_Order_History_DTO> selectBook = dbeloperDAO.selectBookInputOrderHistory(con);
		
		close(con);
		
		return selectBook;
	}
	
	/* 기존 도서 입고 승인 - 다영 */
	public int acceptBookInputOrderHistory(String acceptBookNo) {
		
		Connection con = getConnection();
		
		/* N를 Y로 바꿈 */
		int result = dbeloperDAO.acceptBookInputOrderHistory(acceptBookNo, con);
		
		/* 도서번호 SELECT */
		int bookNo = dbeloperDAO.selectBookNoByInputOrderNo(acceptBookNo, con);
		
		/* 책 재고 업데이트로 +(수량 추가) 해주기 , JOIN으로 도서번호 씀 */
		int result2 = dbeloperDAO.updateBookStock(acceptBookNo, bookNo, con);
				
		/* 매장 매출내역 -(출금)해주기 */
		int result3 = dbeloperDAO.WithdrawStoreInputOrderHistory(acceptBookNo, bookNo, con);
		
		if(result > 0 && result2 > 0 && result3 > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
	
	/*신규 책 입고 Service - 수목
	 *
	 * 도서내역 insert -> 매출 insert -> 주문승인 업데이트
	 */
	public int insertUpdateNewInputbooks(String answer, DBeloper_Book_DTO book) {
		int resultInsertBook = 0;
		int resultInsertSales = 0;
		int resultUpdateInputApro = 0;
		Connection con = getConnection();
		
		/*도서 내역 인서트*/
		resultInsertBook = dbeloperDAO.insertNewBook(con,book);
		
		
		if(resultInsertBook > 0) {
			/*매장 매출 내역 인서트*/
			resultInsertSales = dbeloperDAO.insertInputStoreSalesHistory(con);
			
			if(resultInsertSales > 0) {
				/*주문승인 업데이트*/
				resultUpdateInputApro = dbeloperDAO.updateInputApro(answer,con);
				if(resultUpdateInputApro > 0) {
					commit(con);
				}
			}
		}
		
		
		if(resultUpdateInputApro == 0) {
			rollback(con);
		}
		
		/* 도서 내역을 잘 못 입력 받을 경우 */
		if(resultInsertBook == 0) {
			resultUpdateInputApro = 2;
		}
		
		return resultUpdateInputApro;
	}
	
	/* 큰솔 도수 수량으로 ORDER BY 후 도서 조회용 Service */
	public List<DBeloper_Book_DTO> selectBookByStock(){
		
		Connection con = getConnection();
		
		List<DBeloper_Book_DTO> booklist = dbeloperDAO.booklistByBookStock(con);
		
		close(con);
		
		return booklist;
	}

	/* 큰솔 도서 번호로 도서 재고 업데이트 */
	public int updateBookStockByUserInput(int bookNo, int bookAmount) {
		
		Connection con = getConnection();
		int result = 0;
		
		/* 큰솔 매장 총 재산 SELECT */
		int selectStoreSumMoney = dbeloperDAO.selectStoreSumMoney(con);

		/* 소비 금액 SELECT */
		int sumBookPrice = dbeloperDAO.selectSumBookPrice(con, bookNo, bookAmount);

		/* 소비 금액과 매장 재산 비교 */
		if(selectStoreSumMoney < sumBookPrice) {
			result = -1;
		} else {
			
			/* 도서 재고 변경 */
			result = dbeloperDAO.updateBookStockByManager(con, bookNo, bookAmount);

			/* 매장 매출 내역 INSERT */
			int result2 = dbeloperDAO.UpdateStoreSalesHistoryByInput(con, sumBookPrice);
			
				if(result == 1 && result2 == 1) {
					commit(con);
					result = 1;
				} else {
					rollback(con);
					result = 0;
				}
				close(con);
			}
		return result;
	}
	

		/* 도서 주문시 참고하기 위한 책들의 재고 조회 메소드 - 준혁 */
	public Map<Integer, Integer> selectAllBookStock() {
		Connection con = getConnection();
		
		Map<Integer, Integer> bookStock = dbeloperDAO.selectAllBookStock(con);
		
		close(con);
		
		return bookStock;
	}

	/* 특정 회원이 작성하거나 특정 도서에 대한 리뷰를 조회하는 메소드 - 준혁 */
	public List<Map<String, String>> selectReview(DBeloper_Review_DTO selectReviewInfo) {
		Connection con = getConnection();
		
		List<Map<String, String>> reviewList = dbeloperDAO.selectReview(con, selectReviewInfo);
		
		close(con);
		
		return reviewList;
	}
	
	/* 관리자 복직 Service - 시원 */
	public int updateManagerReturn(String managerNum) {

		Connection con = getConnection();
		
		int result = 0;
		
		result = dbeloperDAO.updateManagerReturn(con, managerNum);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}
	
	/* 복직이 가능한 관리자 조회용 Service - 시원 */
	public List<DBeloper_Manager_DTO> selectManagerRetireService(){
		Connection con = getConnection();
		
		List<DBeloper_Manager_DTO> managerRetireList = dbeloperDAO.selectRetireManager(con);
		
		close(con);
		
		return managerRetireList;
	}


	/* 큰솔 고객 번호 중복값 체크용 Service */
	public Map<String, String> selectMemberPhoneForCheck(Map<String, String> memberJoin) {
		
		Connection con = getConnection();
		
		return dbeloperDAO.selectMemberPhoneForCheck(con, memberJoin);
		
	}
	
}
