package com.dbeloper.member.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.dbeloper.member.controller.DBeloper_Controller;
import com.dbeloper.member.model.dto.DBeloper_Member_DTO;
import com.dbeloper.member.model.dto.DBeloper_NonMembers_DTO;
import com.dbeloper.member.model.dto.DBeloper_Output_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Review_DTO;

public class DBeloper_NonMember_View {

		Scanner sc = new Scanner(System.in);
		private DBeloper_Controller controller = new DBeloper_Controller();
		private DBeloper_Member_DTO member = null;
		private DBeloper_Output_Order_History_DTO ouputordernonmemberno = null;
		private DBeloper_Member_View memberview = new DBeloper_Member_View();
		private DBeloper_Member_Join_View memberjoinview = new DBeloper_Member_Join_View();
		private DBeloper_NonMembers_DTO nonmember = new DBeloper_NonMembers_DTO();
		private DBeloper_Result_View drv = new DBeloper_Result_View();
		
		public void nonMemberView() {
			do {
				System.out.println("===== 비회원용 로그인 메뉴 뷰 도착 =====" + "\n");
				System.out.println("반갑습니다. 떡잎마을 문고입니다.");
				
				System.out.println();
				System.out.println("원하는 메뉴의 번호를 선택하세요");
				System.out.println();
				System.out.println("1. 도서 조회");
				System.out.println("2. 도서 주문");
				System.out.println("3. 이전 메뉴로 돌아가기");
				
				int inputNum = sc.nextInt();
				
				switch(inputNum) {
					case 1:
						int repeat = 0;
						do {
							repeat = controller.searchBook(inputSearchInfo());
						} while(repeat == 1);
						
						System.out.println("원하는 메뉴의 번호를 선택하세요.");
						System.out.println("1. 도서 리뷰 조회");
						System.out.println("2. 도서 주문");
						System.out.println("3. 메인 메뉴로 돌아가기");
						int choice = sc.nextInt();
						
						if(choice == 1) {
							controller.selectReview(selectReviewInfo());
							break;
						} else if(choice == 2){
							
						} else if(choice == 3) {
							break;
						} else {
							System.out.println("존재하지 않는 메뉴입니다. 메인 메뉴로 돌아갑니다.");
							break;
						}
					case 2:
						System.out.println("주문방식을 선택해주세요(숫자만 눌러주세요)");
						System.out.println("1. 비회원 주문");
						System.out.println("2. 회원 주문");
						System.out.println("3. 회원가입");
						int orderNumber = sc.nextInt();
						if(orderNumber == 1) {
							sc.nextLine();
							System.out.println("비회원용 주문 메뉴");
							System.out.println("----------------------");
							System.out.println("상품 배송을 위한 정보가 필요합니다.");
							System.out.print("이름을 입력해주세요");
							String nonmemberName = sc.nextLine();
							System.out.print("전화번호를 입력해주세요");
							String nonmemberPhone = sc.nextLine();
							System.out.print("주소를 입력해주세요");
							String nonmemberAddress = sc.nextLine();
							
							System.out.println("입력한 정보들을 확인해 주세요");
							System.out.println("이름:" + nonmemberName + " 전화번호:" + nonmemberPhone + " 주소:" + nonmemberAddress);
							System.out.println("정보들이 모두 일치한다면 1번, 다시 입력하고 싶으시다면 2번을 눌러주세요");
							int agreementcode = sc.nextInt();
							if (agreementcode == 1) {
								
								Map<String, String> nonmemberJoin = new HashMap<>();
								nonmemberJoin.put("NONMEMBERS_NAME", nonmemberName);
								nonmemberJoin.put("NONMEMBERS_PHONE", nonmemberPhone);
								nonmemberJoin.put("NONMEMBERS_ADDRESS", nonmemberAddress);
								
								
								controller.nonmemberjoin(nonmemberJoin);			 	
								nonmember = controller.selectNonMemberInfO(nonmemberJoin);
								controller.nonmemberPurchaseBook(nonmemberInputPurchaseInfo(nonmember));
							}else {
								System.out.println("처음으로 돌아갑니다.");
								sc.nextLine();
								continue;
							}
						} else if (orderNumber == 2) {
							memberview.member_View();
							
						} else if (orderNumber == 3) {
							memberjoinview.memberJoinView();
						}
						break;		
					case 3:
						return;
					default : drv.displayResultMessage("unExistMenu");	
				}
		 	} while(true);	
		}	
		
		/* 리뷰를 조회하고 싶은 책의 도서 번호를 입력하는 메소드 - 준혁 */
		private DBeloper_Review_DTO selectReviewInfo() {
			DBeloper_Review_DTO reviewInfo = new DBeloper_Review_DTO();
			
			System.out.println("검색하고 싶은 책의 도서번호를 입력하세요 : ");
			reviewInfo.setReviewBookNo(sc.nextInt());
			
			return reviewInfo;
		}
		
		/* (비회원일 때)구매할 책의 정보를 입력 받음 - 준혁 */
		private DBeloper_Output_Order_History_DTO nonmemberInputPurchaseInfo(DBeloper_NonMembers_DTO nonmember1) {
			DBeloper_Output_Order_History_DTO purchaseInfo = new DBeloper_Output_Order_History_DTO();
			
			System.out.print("구매하실 도서의 번호를 입력해주세요 : ");
			int bookNo = sc.nextInt();
			purchaseInfo.setOutputBookNo(bookNo);
			System.out.print("몇 권을 구매하시겠습니까? : ");
			int numberOfBooks = sc.nextInt();
			purchaseInfo.setOutputNumberOfBooks(numberOfBooks);
			purchaseInfo.setOutputNonmembersNo(nonmember1.getNonmembersNo());
			
			return purchaseInfo;
		}

		/* 조회할 책의 정보 입력받는 메소드 - 준혁 */
		private Map<String, String> inputSearchInfo() {
			
			/* 조회 메뉴를 선택하도록 한다. */
			System.out.println("---- 조회 방식을 선택하세요 ----");
			System.out.println("1. 도서명으로 조회");
			System.out.println("2. 카테고리 조회");
			System.out.println("3. 작가 조회");
			System.out.println("4. 판매량 TOP3 조회");
			System.out.println("5. 종류별 책(전자책/종이책) 조회");
			System.out.println("6. 조회 종료");
			
			int menuNum = sc.nextInt();
			
			/* 조회할 책의 정보를 HashMap에 입력받는다. */
			Map<String, String> searchInfo = new HashMap<>();
			
			searchInfo.put("menuNum", Integer.valueOf(menuNum).toString());
			
			switch(menuNum) {
				case 1: 
					System.out.print("조회하고 싶은 도서명을 입력하세요 : ");
					sc.nextLine();
					searchInfo.put("bookName", sc.nextLine());
					break;
				case 2:
					System.out.println("카테고리 목록");
					System.out.println("소설  장르소설  만화책  에세이  철학/종교  인문학/사회/역사");
					System.out.println("자기계발/교재  과학/IT  잡지  수험서  기타");
					System.out.print("조회하고 싶은 도서의 카테고리를 입력하세요 : ");
					sc.nextLine();
					searchInfo.put("categoryName", sc.nextLine());
					break;
				case 3:
					System.out.print("조회하고 싶은 작가 이름을 입력하세요 : ");
					sc.nextLine();
					searchInfo.put("author", sc.nextLine());
					break;
				case 4: break;
				case 5:
					System.out.print("전자책과 종이책 중 어떤 것을 조회하시겠습니까? : ");
					sc.nextLine();
					searchInfo.put("kindOfBook", sc.nextLine());
					break;
				case 6:
					System.out.println("조회를 종료합니다.");
					break;
			}
			
			return searchInfo;
		}
	}
