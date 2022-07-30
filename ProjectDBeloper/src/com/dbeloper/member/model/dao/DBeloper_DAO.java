package com.dbeloper.member.model.dao;

import static com.dbeloper.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
import com.dbeloper.member.view.DBeloper_Result_View;

	
public class DBeloper_DAO {

	private Properties prop = new Properties();

	
	public DBeloper_DAO() {

		try {
			prop.loadFromXML(new FileInputStream("mapper/DBeloper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 큰솔, 준혁 매니저 로그인용 DAO */
	public Map<String, String> managerLogin(Map<String, String> map, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectLoginManager");
		Map<String, String> managerNameManagerGrade = new HashMap<>();

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, map.get("managerId"));
			pstmt.setString(2, map.get("managerPwd"));

			rset = pstmt.executeQuery();
			if (rset.next()) {
				managerNameManagerGrade.put("managerName", rset.getString("MANAGER_NAME"));
				managerNameManagerGrade.put("managerGrade", rset.getString("MANAGER_GRADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return managerNameManagerGrade;
	}

	/* 큰솔 고객 로그인용 DAO(수정 사항 : 기존에 이름만 받아왔는데 필요한 정보를 DTO 형태로 다 받아오도록 수정 - 준혁) */
	public DBeloper_Member_DTO memberLogin(Map<String, String> map, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectLoginMember");
		DBeloper_Member_DTO member = new DBeloper_Member_DTO();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, map.get("memberId"));
			pstmt.setString(2, map.get("memberPwd"));

			rset = pstmt.executeQuery();

			if (rset.next()) {
				member.setMemberNo(rset.getString("MEM_NO"));
				member.setMemberName(rset.getString("MEM_NAME"));
				member.setMemberPhone(rset.getString("MEM_PHONE"));
				member.setMemberAddress(rset.getString("MEM_ADDRESS"));
				member.setMemberGradeNo(rset.getString("MEM_GRADE_NO"));
				member.setMemberSumMoney(rset.getInt("MEM_SUM_MONEY"));
				member.setMemberId(rset.getString("MEM_ID"));
				member.setMemberPwd(rset.getString("MEM_PWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}


	/* 회원 조회 메소드 - 다영 */ 
	public List<DBeloper_Member_DTO> selectMember(Connection con, DBeloper_Member_DTO memberDTO) {
	   PreparedStatement pstmt = null;
	   ResultSet rset = null;

	   List<DBeloper_Member_DTO> memberList = new ArrayList<>();

	   String query = prop.getProperty("selectMember");

	   try {
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, memberDTO.getMemberNo());
	        pstmt.setString(2, memberDTO.getMemberName());
	        pstmt.setString(3, memberDTO.getMemberId());
	        pstmt.setString(4, memberDTO.getMemberGradeNo());
	        
	        rset = pstmt.executeQuery();

	        while (rset.next()) {
	           DBeloper_Member_DTO member = new DBeloper_Member_DTO();

	           member.setMemberNo(rset.getString("MEM_NO"));
	           member.setMemberName(rset.getString("MEM_NAME"));
	           member.setMemberMileage(rset.getInt("MEM_MILEAGE"));
	           member.setMemberId(rset.getString("MEM_ID"));
	           member.setMemberGradeNo(rset.getString("MEM_GRADE_NO"));
	           member.setMemberDropYN(rset.getString("MEM_DROP_YN"));
	           member.setMemberSumMoney(rset.getInt("MEM_SUM_MONEY"));

	            memberList.add(member);
	        }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         close(rset);
	         close(pstmt);
	      }
	   
	      return memberList;
	   }

	/* 지영 - 관리자 조회 메소드 */
	public List<DBeloper_Manager_DTO> selectManager(Connection con, DBeloper_Manager_DTO managerDTO) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<DBeloper_Manager_DTO> managerList = new ArrayList<>();
		
		String query = prop.getProperty("selectManager");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, managerDTO.getManagerNum());
			pstmt.setString(2, managerDTO.getManagerName());
			pstmt.setString(3, managerDTO.getManagerGrade());
			pstmt.setString(4, managerDTO.getManagerDropYN());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DBeloper_Manager_DTO manager = new DBeloper_Manager_DTO();
				
				manager.setManagerNum(rset.getString("MANAGER_NUM"));
				manager.setManagerName(rset.getString("MANAGER_NAME"));
				manager.setManagerGrade(rset.getString("MANAGER_GRADE"));
				manager.setManagerPhone(rset.getString("MANAGER_PHONE"));
				manager.setManagerAddress(rset.getString("MANAGER_ADDRESS"));
				manager.setManagerSalary(rset.getString("MANAGER_SALARY"));
				manager.setManagerDropYN(rset.getString("MANAGER_DROP_YN"));
				
				managerList.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return managerList;
	}
	

	/* 매출 조회용 메소드 - 수목 */
	public List<DBeloper_Store_Sales_History_DTO> selectStoreSalesHistory(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;

		List<DBeloper_Store_Sales_History_DTO> salesHistoryList = new ArrayList<>();

		String query = prop.getProperty("selectStoreSalesHistory");
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				DBeloper_Store_Sales_History_DTO salesHistory = new DBeloper_Store_Sales_History_DTO();
				salesHistory.setStoreDbeloperDate(rset.getDate("SSH_DBELOPER_DATE"));
				salesHistory.setStoreIncomeStatement(rset.getString("SSH_INCOME_STATEMENT"));
				salesHistory.setStoreSalesMoney(rset.getInt("SSH_MONEY"));

				salesHistoryList.add(salesHistory);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return salesHistoryList;
	}

	/* 매장 보유 금액 조회 - 수목 */
	public int selectStoreSumMoney(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectStoreSumMoney");

		int result = 0;

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				result = rset.getInt("STORE_SUM_MONEY");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return result;
	}

	/* 도서 조회 메소드(DAO) - 준혁 */
	public List<DBeloper_Book_DTO> searchBook(Connection con, int menuNum, DBeloper_Book_DTO bookInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String searchQuery = prop.getProperty("selectBook");
		String Top3Query = prop.getProperty("selectTop3Book");
		
		List<DBeloper_Book_DTO> bookList = new ArrayList<>();
		
		try {
			if(menuNum == 4) {
				pstmt = con.prepareStatement(Top3Query);
				rset = pstmt.executeQuery();
				
				while (rset.next()) {
					DBeloper_Book_DTO book = new DBeloper_Book_DTO();

					book.setBookNo(rset.getInt("BOOK_NO"));
					book.setBookName(rset.getString("BOOK_NAME"));
					book.setBookAuthor(rset.getString("BOOK_AUTHOR"));
					book.setBookPrice(rset.getInt("BOOK_PRICE"));
					book.setBookSalesRate(rset.getInt("BOOK_SALES_RATE"));
					book.setBookStock(rset.getInt("BOOK_STOCK"));
					book.setBookPublisherName(rset.getString("BOOK_PUBLISHER_NAME"));
					book.setBookCategoryNumber(rset.getInt("BOOK_CATEGORY_NUMBER"));

					bookList.add(book);
				}
			} else {
				
				pstmt = con.prepareStatement(searchQuery);
				pstmt.setString(1, bookInfo.getBookName());
				pstmt.setString(2, bookInfo.getBookAuthor());
				pstmt.setInt(3, bookInfo.getBookCategoryNumber());
				pstmt.setInt(4, bookInfo.getBookEbNumber());
				
				rset = pstmt.executeQuery();
				
				while (rset.next()) {
					DBeloper_Book_DTO book = new DBeloper_Book_DTO();

					book.setBookNo(rset.getInt("BOOK_NO"));
					book.setBookName(rset.getString("BOOK_NAME"));
					book.setBookAuthor(rset.getString("BOOK_AUTHOR"));
					book.setBookPrice(rset.getInt("BOOK_PRICE"));
					book.setBookSalesRate(rset.getInt("BOOK_SALES_RATE"));
					book.setBookStock(rset.getInt("BOOK_STOCK"));
					book.setBookPublisherName(rset.getString("BOOK_PUBLISHER_NAME"));
					book.setBookCategoryNumber(rset.getInt("BOOK_CATEGORY_NUMBER"));

					bookList.add(book);
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		return bookList;
	}

	/* 큰솔 전 직원 월급 지급용 DAO */
	public int insertSalary(Connection con) {
		Statement stmt = null;
		int result = 0;

		String query = prop.getProperty("insertsalary");

		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}

	/* 큰솔 직원 총 월급 조회용 DAO */
	public int managerSumSalary(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int sumManagerSalary = 0;
		String query = prop.getProperty("selectSumManagerSalary");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				sumManagerSalary = rset.getInt("SUM(MANAGER_SALARY)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return sumManagerSalary;
	}
	

	/* 도서 신청 대기 목록 조회 DAO - 시원 -> 이수목 사용중 (아마 시원님이 만드심)*/
	public List<DBeloper_Input_Order_History_DTO> selectInputOrderHistory(Connection con){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<DBeloper_Input_Order_History_DTO> inputOrderList = new ArrayList<>();
		
		String query = prop.getProperty("selectInputOrderHistory");

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DBeloper_Input_Order_History_DTO dbInputOrderHistory = new DBeloper_Input_Order_History_DTO();
				
				dbInputOrderHistory.setInputOrderNo(rset.getString("INPUT_ORDER_NO"));
				dbInputOrderHistory.setInputBookNo(rset.getInt("INPUT_BOOK_NO"));
				dbInputOrderHistory.setInputBookname(rset.getString("INPUT_BOOK_NAME"));
				dbInputOrderHistory.setInputBookAuthor(rset.getString("INPUT_BOOK_AUTHOR"));
				dbInputOrderHistory.setInputBookPublisherName(rset.getString("INPUT_BOOK_PUBLISHER_NAME"));
				dbInputOrderHistory.setNewBook(rset.getString("INPUT_NEWBOOK"));
				
				inputOrderList.add(dbInputOrderHistory);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return inputOrderList;
	}

	/* 주문 내역 조회 메소드 DAO - 시원 */
	public List<DBeloper_Output_Order_History_DTO> selectOutputOrderHistory(Connection con){
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			List<DBeloper_Output_Order_History_DTO> OutputOrderList = new ArrayList<>();
			
			String query = prop.getProperty("selectOutputOrderHistory");
	
			try {
				pstmt = con.prepareStatement(query);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					DBeloper_Output_Order_History_DTO dbOutputOrderHistory = new DBeloper_Output_Order_History_DTO();
					
					dbOutputOrderHistory.setOutputOrderNo(rset.getString("OUTPUT_ORDER_NO"));
			  	    dbOutputOrderHistory.setOutputNumberOfBooks(rset.getInt("OUTPUT_NUMBER_OF_BOOKS"));
			  	    dbOutputOrderHistory.setOutputOrderDate(rset.getDate("OUTPUT_ORDER_DATE"));
			  	    dbOutputOrderHistory.setOutputBookNo(rset.getInt("OUTPUT_BOOK_NO"));
			  	    dbOutputOrderHistory.setOutputMemberNo(rset.getString("OUTPUT_MEMBER_NO"));
			  	    dbOutputOrderHistory.setOutputNonmembersNo(rset.getString("OUTPUT_NONMEMBERS_NO"));
					
					OutputOrderList.add(dbOutputOrderHistory);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return OutputOrderList;
	}
	
	/* 회원 도서 구매 신청용 DAO - 준혁 */
	public int purchaseBook(Connection con, DBeloper_Output_Order_History_DTO outputOrder) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query1 = prop.getProperty("insertOutputOrderHistory");
		String query2 = prop.getProperty("selectMaxBookNo");
		
		try {
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(query2);
			
			int maxBookNo = 0;
			
			if(rset.next()) {
				maxBookNo = rset.getInt("MAX(BOOK_NO)");
			}
			
			if(outputOrder.getOutputBookNo() > maxBookNo || outputOrder.getOutputBookNo() < 1) {
				result = -1;
				return result;
			}
			
			pstmt = con.prepareStatement(query1);
			pstmt.setInt(1, outputOrder.getOutputBookNo());
			pstmt.setInt(2, outputOrder.getOutputNumberOfBooks());
			pstmt.setString(3, outputOrder.getOutputMemberNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			close(stmt);
		}
		
		
		return result;
	}
	
	/* 비회원 도서 구매 신청 메소드 - 준혁 */
	public int nonmemberPurchaseBook(Connection con, DBeloper_Output_Order_History_DTO purchaseInfo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query1 = prop.getProperty("insertNonmemberOutputOrderHistory");
		String query2 = prop.getProperty("selectMaxBookNo");
		
		try {
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(query2);
			
			int maxBookNo = 0;
			
			if(rset.next()) {
				maxBookNo = rset.getInt("MAX(BOOK_NO)");
			}
			
			if(purchaseInfo.getOutputBookNo() > maxBookNo || purchaseInfo.getOutputBookNo() < 1) {
				result = -1;
				return result;
			}
			
			pstmt = con.prepareStatement(query1);
			pstmt.setInt(1, purchaseInfo.getOutputBookNo());
			pstmt.setInt(2, purchaseInfo.getOutputNumberOfBooks());
			pstmt.setString(3, purchaseInfo.getOutputNonmembersNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/* 큰솔 가입시 중복 체크를 위한 DAO */
	public Map<String, String> selectMemberForCheck(Connection con, Map<String, String> memberJoin) {

		PreparedStatement pstmt = null;
		ResultSet rest = null;
		
		String query = prop.getProperty("selectMemberForCheck");
		Map<String, String> memberForCheck = new HashMap<>();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberJoin.get("MEM_ID"));
			rest = pstmt.executeQuery();
			while(rest.next()) {
				
				memberForCheck.put("memberID", rest.getString("MEM_ID"));
				memberForCheck.put("memberDropYN", rest.getString("MEM_DROP_YN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rest);
			close(pstmt);
		}
		return memberForCheck;
	}

	/* 큰솔 고객 가입용 DAO */
	public int memberJoin(Connection con, Map<String, String> memberJoin) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMemberJoin");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberJoin.get("MEM_NAME"));
			pstmt.setString(2, memberJoin.get("MEM_PHONE"));
			pstmt.setString(3, memberJoin.get("MEM_ADDRESS"));
			pstmt.setString(4, memberJoin.get("MEM_ID"));
			pstmt.setString(5, memberJoin.get("MEM_PWD"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 비회원 정보 입력 DAO - 다영 */
	public int nonmemberJoin(Connection con, Map<String, String> nonmemberJoin) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNonmemberJoin");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nonmemberJoin.get("NONMEMBERS_NAME"));
			pstmt.setString(2, nonmemberJoin.get("NONMEMBERS_PHONE"));
			pstmt.setString(3, nonmemberJoin.get("NONMEMBERS_ADDRESS"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 큰솔 휴먼계정 활성화 용 DAO */
	public int memberRejoin(Connection con, Map<String, String> memberReJoin) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMemberDropYN");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberReJoin.get("memberID"));
			pstmt.setString(2, memberReJoin.get("memberPWD"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 회원 탈퇴 메소드 - 준혁 */
	public int cancelMembership(Connection con, Map<String, String> checkMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMemberDrop");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, checkMember.get("memberId"));
			pstmt.setString(2, checkMember.get("memberPwd"));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 지정 날짜 매출 조회 DAO - 수목 */
	public List<DBeloper_Store_Sales_History_DTO> selectDaySalesHistory(Connection con, Date inputDate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<DBeloper_Store_Sales_History_DTO> daySalesList = new ArrayList<>();
		
		String query = prop.getProperty("selectDaySalesHistory");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, inputDate);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				DBeloper_Store_Sales_History_DTO daySalesDTO = new DBeloper_Store_Sales_History_DTO();
				daySalesDTO.setStoreDbeloperDate(rset.getDate("SSH_DBELOPER_DATE"));
				daySalesDTO.setStoreIncomeStatement(rset.getString("SSH_INCOME_STATEMENT"));
				daySalesDTO.setStoreSalesMoney(rset.getInt("SSH_MONEY"));
				
				daySalesList.add(daySalesDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return daySalesList;
	}

	/* 기존 도서 입고 요청 DAO - 시원 */
	public int registInputOrderExist(Connection con, DBeloper_Input_Order_History_DTO  inputOrderExist) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOrderExist");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, inputOrderExist.getInputBookNo());
			pstmt.setString(2, inputOrderExist.getInputBookname());
			pstmt.setString(3, inputOrderExist.getInputBookAuthor());
			pstmt.setString(4, inputOrderExist.getInputBookPublisherName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/* 신규 도서 입고 요청 DAO - 시원 */
	public int registInputOrderNew(Connection con, DBeloper_Input_Order_History_DTO  inputOrderNew) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOrderNew");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, inputOrderNew.getInputBookname());
			pstmt.setString(2, inputOrderNew.getInputBookAuthor());
			pstmt.setString(3, inputOrderNew.getInputBookPublisherName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	/* 입고 신청 전 재고 없는 도서 정보 조회용 DAO - 시원 */
	public List<DBeloper_Book_DTO> selectBookStock(Connection con){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<DBeloper_Book_DTO> BookStockZeroList = new ArrayList<>();
		
		String query = prop.getProperty("selectBookStock");
	
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DBeloper_Book_DTO zeroStockBookDTO = new DBeloper_Book_DTO();
				
				zeroStockBookDTO.setBookNo(rset.getInt("BOOK_NO"));
				zeroStockBookDTO.setBookName(rset.getString("BOOK_NAME"));
				zeroStockBookDTO.setBookAuthor(rset.getString("BOOK_AUTHOR"));
				zeroStockBookDTO.setBookPublisherName(rset.getString("BOOK_PUBLISHER_NAME"));
				zeroStockBookDTO.setBookPrice(rset.getInt("BOOK_PRICE"));
				
				BookStockZeroList.add(zeroStockBookDTO);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return BookStockZeroList;
	}
	
	/* 큰솔 고객 마일리지 부여용 DAO */
	public int memberMileage(Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMemberMileageByPurchaseBook");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "memberGradeNo");
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/* 비회원 정보 불러오기 - 준혁 */
	public DBeloper_NonMembers_DTO selectNonMemberInfo(Connection con, Map<String, String> nonmemberJoin) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	
		DBeloper_NonMembers_DTO nonmember = new DBeloper_NonMembers_DTO();
		
		String query = prop.getProperty("selectNonMemberInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nonmemberJoin.get("NONMEMBERS_NAME"));
			pstmt.setString(2, nonmemberJoin.get("NONMEMBERS_PHONE"));
			pstmt.setString(3, nonmemberJoin.get("NONMEMBERS_ADDRESS"));
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				nonmember.setNonmembersNo(rset.getString("NONMEMBERS_NO"));
				nonmember.setNonmembersName(rset.getString("NONMEMBERS_NAME"));
				nonmember.setNonmembersPhone(rset.getString("NONMEMBERS_PHONE"));
				nonmember.setNonmembersAddress(rset.getString("NONMEMBERS_ADDRESS"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return nonmember;
	}
	
	/* 입고(고객 책 요청) 주문 전체 승인 메소드 - 수목 */
	public int updateInputOrderAllAdmin(Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateInputOrderAdim");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "N");
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/* 입고(고객 책 요청) 주문 승인 메소드 - 수목 */
	public int updateInputOrderSelectAdmin(Connection con, String oderNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateInputOrderSelectAdim");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, oderNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/* 큰솔 책 구매목록 확인용 DAO */
	public List<DBeloper_Book_DTO> selectByingBook(Connection con, String memberNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<DBeloper_Book_DTO> purchaseBook = new ArrayList<>();
			
			String query = prop.getProperty("selectpurchaseBook");
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, memberNo);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					DBeloper_Book_DTO booklist = new DBeloper_Book_DTO();
					booklist.setBookNo(rset.getInt("BOOK_NO"));
					booklist.setBookName(rset.getString("BOOK_NAME"));
					
					purchaseBook.add(booklist);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		return purchaseBook;
	}

	/* 큰솔 리뷰 작성용 DAO */
	public int insertReview(DBeloper_Review_Insert_DTO reviewInsert, Connection con) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReview");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reviewInsert.getUserNo());
			pstmt.setInt(2, reviewInsert.getBookNo());
			pstmt.setString(3, reviewInsert.getReviewContents());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/* 리뷰 작성 후 마일리지 지급용 DAO */
	public int updateMemberMileage(DBeloper_Review_Insert_DTO memberNo, Connection con) {

		PreparedStatement pstmt = null;
		int result = 0 ;
		
		String query = prop.getProperty("updateMemberMileageByReview");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberNo.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 큰솔 판매 대기 품목 업데이트용 DAO */
	public int updateOutputOrderHistory(String managerInput, Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateOutputOrderHistoryByOrderNo");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, managerInput);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/* 큰솔 도서 판매 승인시 서점 입출고 내역 insert DAO */
	public int insertStoreSalesHistory(String managerInput, Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertStoreSalesHistoryByOutput");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, managerInput);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/* 큰솔 판매 번호로 고객 번호 SELECT 하는 DAO */
	public String selectMemNoByOutputOrderNo(String managerInput, Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String userNo = "";
		
		String query = prop.getProperty("selectMemNoByOutputHistory");
		
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, managerInput);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					userNo = rset.getString("OUTPUT_MEMBER_NO");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
		return userNo;
		
	}
	
	/* 큰솔 판매 승인 후 고객 총 소모 금액 내역 Update DAO */
	public int updateMemberSumMoney(String managerInput, String memberNo, Connection con) {

		PreparedStatement pstmt = null;

		int result = 0;
		
		String query = prop.getProperty("updateMemberSumMoney");

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, managerInput);
			pstmt.setString(2, memberNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 큰솔 고객 번호로 고객 총 소모 금액 SELECT */
	public int selectMemberSumMoneyByMemNo(String memberNo, Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int memberSumMoney = 0;
		
		String query = prop.getProperty("selectMemSumMoney");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberSumMoney = rset.getInt("MEM_SUM_MONEY");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberSumMoney;
		
	}
	
	/* 큰솔 고객 총 소모 금액으로 고객 등급 Update DAO */
	public int updateMemberGrade(Connection con, String memberNo, int memberSumMoney) {
		
		PreparedStatement pstmt = null;
		DBeloper_Result_View drv = new DBeloper_Result_View(); 
		ResultSet rset = null;
		int result = 0;
		String userGrade = "";
		
		String query = prop.getProperty("updateMemberGrade");
		try {
			
			pstmt = con.prepareStatement(query);

			if(memberSumMoney >300000 && memberSumMoney < 500000) {
				userGrade = "B";
			} else if(memberSumMoney > 500000 && memberSumMoney < 1000000) {
				userGrade = "S";
			} else if(memberSumMoney > 1000000) {
				userGrade = "G";
			}

			drv.displayResultMessage(userGrade);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userGrade);
			pstmt.setString(2, memberNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/* 큰솔 도서 구매 후 고객에게 마일리지 부여 DAO */
	public int updateMemberMileageByPurchase(String managerInput, String memberNo, Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatememberMileageByPurchase");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, managerInput);
			pstmt.setString(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 지영 - 회원 마일리지 잔액 조회 DAO */
	public int selectMemberMileage(String memberNo, Connection con){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int memberMileage = 0;
		String query = prop.getProperty("selectMemMileage");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberNo);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				memberMileage = rset.getInt("MEM_MILEAGE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberMileage;
	}

	/* 지영 - 회원 마일리지로 마일리지 상품 구매 DAO */
	public int purchaseMileageProduct(Connection con, Map<String, String> product) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateUseMileage");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, product.get("productNo"));
			pstmt.setString(2, product.get("userNO"));

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	

	/* 입고 신청 책 조회 (기존도서) - 다영  */
	public List<DBeloper_Input_Order_History_DTO> selectBookInputOrderHistory(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<DBeloper_Input_Order_History_DTO> selectBookInputOrderHistoryList = new ArrayList<>();
		
		String query = prop.getProperty("selectBookInputOrderHistory");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				DBeloper_Input_Order_History_DTO BookInputOrderHistory = new DBeloper_Input_Order_History_DTO();
				
				BookInputOrderHistory.setInputOrderNo(rset.getString("INPUT_ORDER_NO"));
				BookInputOrderHistory.setInputBookname(rset.getString("INPUT_BOOK_NAME"));
				BookInputOrderHistory.setInputBookAuthor(rset.getString("INPUT_BOOK_AUTHOR"));
				BookInputOrderHistory.setInputBookPublisherName(rset.getString("INPUT_BOOK_PUBLISHER_NAME"));
				BookInputOrderHistory.setInputBookNo(rset.getInt("INPUT_BOOK_NO"));
				
				selectBookInputOrderHistoryList.add(BookInputOrderHistory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return selectBookInputOrderHistoryList;
	}
	
	/* 기존 도서 입고 승인 - 다영 */
	public int acceptBookInputOrderHistory(String acceptBookNo, Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("acceptBookInputOrderHistory");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, acceptBookNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/* 입고 번호에 맞는 도서 번호 select - 다영 */
	public int selectBookNoByInputOrderNo(String acceptBookNo, Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int inputNo = 0;
		
		String query = prop.getProperty("selectBookNoByInputOrderHistory");
		
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, acceptBookNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					inputNo = rset.getInt("INPUT_BOOK_NO");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
		return inputNo;
		
	}
	
	/* 입고 완료 처리시 book update - 다영 */ 
	public int updateBookStock(String acceptBookNo, int bookNo, Connection con) {

		PreparedStatement pstmt = null;

		int result = 0;
		
		String query = prop.getProperty("updateBookStockByInputOrder");

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, acceptBookNo);
			pstmt.setInt(2, bookNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 입고 신청 완료시 매장 매출내역 -(출금)해주기 - 다영 */
	public int WithdrawStoreInputOrderHistory(String acceptBookNo, int bookNo, Connection con) {
		PreparedStatement pstmt = null;

		int result = 0;
		
		String query = prop.getProperty("WithdrawStoreInputOrderHistory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, acceptBookNo);
		
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/* 신규 도서 입고 인서트 DAO - 수목 */
	public int insertNewBook(Connection con, DBeloper_Book_DTO book) {
		Scanner sc = new Scanner(System.in);
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertNewBook");
		
		
		try {			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, book.getBookName()); 
			pstmt.setString(2, book.getBookAuthor());
			pstmt.setInt(3, book.getBookPrice());
			pstmt.setString(4, book.getBookPublishingDate().toString());
			pstmt.setInt(5, book.getBookStock());
			pstmt.setString(6, book.getBookPublisherName());
			pstmt.setInt(7, book.getBookEbNumber());
			pstmt.setInt(8, book.getBookCategoryNumber());
			
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			result = 0;
		}catch (NullPointerException e) {
			result = 0;
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/* 신규 도서 입고 매장매출 인서트 DAO - 수목 */
	public int insertInputStoreSalesHistory(Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertBuyNewbookInSalesHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "출금");
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	
	/* 신규 도서 입고 주문 내역 업데이트 DAO - 수목 */
	public int updateInputApro(String answer, Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateInputOrderSelectAdim");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, answer);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	
	/* 큰솔 출고번호로 출고 수량 조회용 DAO */
	public int selectNumberOfBoosByOutputNo(Connection con, String outputNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int numberOfBooks = 0;
		
		String query = prop.getProperty("selectMemNoByOutputHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, outputNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				numberOfBooks = rset.getInt("OUTPUT_NUMBER_OF_BOOKS");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return numberOfBooks;
		
	}

	/* 큰솔 출고번호로 도서 수량 조회용 DAO */
	public int selectBookStockByOutputNo(Connection con, String outputNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bookStock = 0;
		
		String query = prop.getProperty("slectBookStockByOutputOrderNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, outputNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bookStock = rset.getInt("BOOK_STOCK");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return bookStock;
	}
	
	/* 큰솔 도서 수량으로 ORDERBY 후 도서 리스트 조회용 DAO */
	public List<DBeloper_Book_DTO> booklistByBookStock(Connection con){
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<DBeloper_Book_DTO> selectBookByStock = new ArrayList<>();
		String query = prop.getProperty("selectBookByBookStockRowNum");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				DBeloper_Book_DTO booklist = new DBeloper_Book_DTO();
				
				booklist.setBookNo(rset.getInt("BOOK_NO"));
				booklist.setBookName(rset.getString("BOOK_NAME"));
				booklist.setBookStock(rset.getInt("BOOK_STOCK"));
				
				selectBookByStock.add(booklist);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return selectBookByStock;
		
	}

	/* 큰솔 원하는 도서의 총 가격 조회용 DAO */
	public int selectSumBookPrice(Connection con, int bookNo, int bookAmount) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bookSumPrice = 0;
		
		String query = prop.getProperty("selectSumBookPrice");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bookAmount);
			pstmt.setInt(2, bookNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bookSumPrice = rset.getInt("총액");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return bookSumPrice;
	}

	/* 큰솔 도서 수량 추가용 DAO */
	public int updateBookStockByManager(Connection con, int bookNo, int bookAmount) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query  = prop.getProperty("updateBookStockByManager");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bookAmount);
			pstmt.setInt(2, bookNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	/* 큰솔 관리자에 의해 입고 완료 후 매장 매출 내역 INSERT DAO */
	public int UpdateStoreSalesHistoryByInput(Connection con, int sumBookPrice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("InsertStoreSalesHistoryByInput");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sumBookPrice);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	/* 큰솔 출고번호로 도서 재고 UPDATE */
	public int updateBookStockByOutput(String managerInput, int numberOfBooks, Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("UpdateBookStock");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, numberOfBooks);
			pstmt.setString(2, managerInput);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 도서 주문시 참고하기 위한 책들의 재고 조회 메소드 - 준혁 */
	public Map<Integer, Integer> selectAllBookStock(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		Map<Integer, Integer> bookStock = new HashMap<>();
		
		String query = prop.getProperty("selectAllBookStock");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				bookStock.put(rset.getInt("BOOK_NO"), rset.getInt("BOOK_STOCK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return bookStock;
	}

	/* 특정 회원이 작성하거나 특정 도서에 대한 리뷰를 조회하는 메소드 - 준혁 */
	public List<Map<String, String>> selectReview(Connection con, DBeloper_Review_DTO selectReviewInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectReview");
		
		List<Map<String, String>> reviewList = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, selectReviewInfo.getReviewBookNo());
			pstmt.setString(2, selectReviewInfo.getReviewMemNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Map<String, String> review = new HashMap<>();
				
				review.put("bookName", rset.getString("BOOK_NAME"));
				review.put("reviewContent", rset.getString("REVIEW"));
				
				reviewList.add(review);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reviewList;
	}


	/* 큰솔 도서 판매량 UPDATE용 DAO */
	public int updateBookSalesRate(String managerInput, int numberOfBooks, Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBookSalesRate");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, numberOfBooks);
			pstmt.setString(2, managerInput);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	
	/* 관리자 복직 처리 DAO - 시원 */
	public int updateManagerReturn(Connection con, String managerNum) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateManagerReturn");
		
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, managerNum);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
	}
	
	/* 퇴사 관리자 조회 - 시원 */
	public List<DBeloper_Manager_DTO> selectRetireManager(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<DBeloper_Manager_DTO> managerRetireList = new ArrayList<>();
		
		String query = prop.getProperty("selectReturnManager");
		
		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DBeloper_Manager_DTO managerRetire = new DBeloper_Manager_DTO();
				
				managerRetire.setManagerNum(rset.getString("MANAGER_NUM"));
				managerRetire.setManagerName(rset.getString("MANAGER_NAME"));
				managerRetire.setManagerGrade(rset.getString("MANAGER_GRADE"));
				managerRetire.setManagerPhone(rset.getString("MANAGER_PHONE"));
				managerRetire.setManagerAddress(rset.getString("MANAGER_ADDRESS"));
				managerRetire.setManagerSalary(rset.getString("MANAGER_SALARY"));
				managerRetire.setManagerDropYN(rset.getString("MANAGER_DROP_YN"));
				
				managerRetireList.add(managerRetire);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return managerRetireList;
	}

	/* 휴대폰 번호 중복값 확인 위한 DAO */
	public Map<String, String> selectMemberPhoneForCheck(Connection con, Map<String, String> memberJoin) {

		PreparedStatement pstmt = null;
		ResultSet rest = null;
		
		String query = prop.getProperty("selectMemberPhoneForCheck");
		Map<String, String> memberForCheck = new HashMap<>();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberJoin.get("MEM_PHONE"));
			rest = pstmt.executeQuery();
			while(rest.next()) {
				
				memberForCheck.put("memberID", rest.getString("MEM_ID"));
				memberForCheck.put("memberDropYN", rest.getString("MEM_DROP_YN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rest);
			close(pstmt);
		}
		return memberForCheck;
	}
	
} // main class 종료
