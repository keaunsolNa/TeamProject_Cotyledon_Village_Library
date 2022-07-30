package com.dbeloper.member.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dbeloper.member.controller.DBeloper_Controller;
import com.dbeloper.member.model.dto.DBeloper_Book_DTO;
import com.dbeloper.member.model.dto.DBeloper_Member_DTO;
import com.dbeloper.member.model.dto.DBeloper_Review_DTO;

public class DBeloper_Member_View {

	private Scanner sc = new Scanner(System.in);
	private DBeloper_Controller controller = new DBeloper_Controller();
	private DBeloper_Member_DTO member = null;
	private DBeloper_Result_View drv = new DBeloper_Result_View();
	private DBeloper_Book_DTO book = new DBeloper_Book_DTO();

	public void member_View() {

		Scanner sclogin = new Scanner(System.in);
		
		System.out.println("===== 고객용 로그인 메뉴 뷰 도착 =====" + "\n");
		System.out.println("반갑습니다. [ 떡잎마을 문고 ]입니다." + "\n");

		System.out.print("로그인을 위해 아이디를 입력하세요." + "\n" + ">>> ");
		String memberId = sclogin.nextLine().toUpperCase();

		System.out.print("로그인을 위해 비밀번호를 입력하세요." + "\n" + ">>> ");
		String memberPwd = sclogin.nextLine().toUpperCase();
		;

		/* 로그인시 멤버의 정보 중 필요한 것만 Member DTO에 받아온다. - 준혁 수정 */
		member = controller.loginMember(memberId, memberPwd);
		if (member.getMemberName() == null) {
			drv.displayResultMessage("FailedLogin");
			System.out.println();
		} else {
			boolean flag = false;
			do {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("반갑습니다. " + "[ " + member.getMemberName() + " ]"+ "님");

				System.out.println();
				System.out.println("원하는 메뉴의 번호를 선택하세요" + "\n");
				System.out.println("1. 도서 조회");
				System.out.println("2. 도서 주문");
				System.out.println("3. 회원정보 조회");
				System.out.println("4. 회원 탈퇴");
				System.out.println("5. 도서 입고 요청");
				System.out.println("6. 구매 도서 리뷰 작성");
				System.out.println("7. 작성한 리뷰 조회");
				System.out.println("8. 마일리지로 상품 구매");
				System.out.println("9. 잔여 마일리지 조회");
				System.out.print("10. 로그아웃" + "\n" + ">>> ");

				int inputNum = 0;
				
				try {
					inputNum = sc.nextInt();
				} catch (java.util.InputMismatchException e) {
					System.out.println("메뉴의 번호만 눌러 주세요." + "\n");
					continue;
				}
				
				switch (inputNum) {
				case 1:
					/* 도서 조회 */
					int repeat = 0;
					do {
						repeat = controller.searchBook(inputSearchInfo());
					} while(repeat == 1);
					
					System.out.println("-- 원하는 메뉴의 번호를 선택하세요 --");
					System.out.println("1. 도서 리뷰 조회");
					System.out.println("2. 도서 주문");
					System.out.println("3. 도서 입고 신청");
					System.out.println("4. 메인 메뉴로 돌아가기");
					int choice = sc.nextInt();
					
					if(choice == 1) {
						controller.selectReview(selectReviewInfo());
						break;
					} else if(choice == 2) {
						
					} else if(choice == 3){
						
						/* 기존 도서 및 신규 도서 입고 요청서 - 시원 */
						System.out.println("기존 도서를 입고 요청하고 싶으시다면 1번을 신규 도서를 입고 요청하고 싶으시다면 2번을 입력해주세요.");
						int inputOrderMenu = sc.nextInt();
						
								/* 기존 도서 입고 요청 */
			                    if (inputOrderMenu == 1) {
			                    	    	
			                    	controller.selectBookStockView();
									
		                            Map<String, String> existBookMap = displayInputOrderExistBook();
		                            if(existBookMap.isEmpty()) {
										break;
									}
		                            controller.registInputOrderExist(existBookMap);
		                            
		                      
		                    /* 신규 도서 입고 요청 */        
		                    }else if(inputOrderMenu == 2){
		                        Map<String, String> NewBookMap = displayInputOrderNewBook();
		                        if(NewBookMap.isEmpty()) {
									break;
								}
		                        controller.registInputOrderNew(NewBookMap);
		                    }
			                    
						break;
					} else if(choice == 4) {
						break;
					} else {
						System.out.println("존재하지 않는 메뉴입니다. 메인 메뉴로 돌아갑니다.");
						break;
					}
				case 2:
					/* 도서 주문 */
					controller.purchaseBook(inputPurchaseInfo());
					break;
				case 3:
					/* 회원정보 조회 */
					inquireMemberInfo();
					break;
				case 4:
					/* 회원 탈퇴 */
					controller.cancelMembership(checkMember());
					return;
				case 5:
					/* 도서 입고 요청 */
					System.out.println("기존 도서를 입고 요청하고 싶으시다면 1번을 신규 도서를 입고 요청하고 싶으시다면 2번을 입력해주세요.");
					int inputOrderMenu = sc.nextInt();

					if (inputOrderMenu == 1) {

						controller.selectBookStockView();
						
							Map<String, String> existBookMap = displayInputOrderExistBook();
							if(existBookMap.isEmpty()) {
								break;
							}
							controller.registInputOrderExist(existBookMap);
						
					}else if(inputOrderMenu == 2){
						Map<String, String> NewBookMap = displayInputOrderNewBook();
						if(NewBookMap.isEmpty()) {
							break;
						}
						controller.registInputOrderNew(NewBookMap);
						
					}
					break;
				case 6:
					/* 구매 도서 리뷰 작성 */
					insertReview();
					break;
				case 7:
					/* 작성한 리뷰 조회 */
					controller.selectReview(myReviewInfo());
					break;
				case 8:
					/* 마일리지로 상품 구매 */
					controller.updateUseMemberMileage(updateUseMemberMileage());
					return;
				case 9 :
					/* 잔여 마일리지 조회 */
					controller.updateUseMemberMileage2(member.getMemberNo());
					break;
				case 10 :
					/* 로그아웃 */
					System.out.println("로그아웃합니다.");
					System.out.println();
					return;
				default:
					drv.displayResultMessage("unExistMenu");
					break;
				}
				if(flag) break;
			} while (true);
		}

	}

	/* 본인 작성 리뷰를 조회하기 위해 회원 번호를 넘겨주기 위한 메소드 - 준혁 */
	private DBeloper_Review_DTO myReviewInfo() {
		DBeloper_Review_DTO review = new DBeloper_Review_DTO();
		
		review.setReviewMemNo(member.getMemberNo());
		
		return review;
	}

	/* 리뷰를 조회하고 싶은 책의 도서 번호를 입력하는 메소드 - 준혁 */
	private DBeloper_Review_DTO selectReviewInfo() {
		DBeloper_Review_DTO reviewInfo = new DBeloper_Review_DTO();
		
		System.out.println("검색하고 싶은 책의 도서번호를 입력하세요 : ");
		reviewInfo.setReviewBookNo(sc.nextInt());
		
		return reviewInfo;
	}
	
	/* (회원일 때)구매할 책의 정보를 입력 받음 - 준혁*/
	private Map<String, Integer> inputPurchaseInfo() {
		Map<String, Integer> purchaseInfo = new HashMap<>();

		System.out.print("구매하실 도서의 번호를 입력해주세요 : ");
		int bookNo = sc.nextInt();
		purchaseInfo.put("bookNo", bookNo);
		System.out.print("몇 권을 구매하시겠습니까? : ");
		int numberOfBooks = sc.nextInt();
		purchaseInfo.put("numberOfBooks", numberOfBooks);

		/* 회원 번호의 경우는 Member DTO에서 받아오도록 한다. */
		purchaseInfo.put("memberNo", Integer.parseInt(member.getMemberNo()));

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

	/* 회원정보 조회 메소드(본인 정보 조회) -> controller로 넘어갈 필요없이 로그인시 받아온 데이터로 처리함 - 준혁 */
	private void inquireMemberInfo() {
		System.out.println("------ 회원정보 ------");
		System.out.println("회원번호 : " + member.getMemberNo());
		System.out.println("이름 : " + member.getMemberName());
		System.out.println("전화번호 : " + member.getMemberPhone());
		System.out.println("주소 : " + member.getMemberAddress());
		System.out.println("등급 : " + member.getMemberGradeNo());
		System.out.println("총 구매 금액 : " + member.getMemberSumMoney());
	}

	/* 회원 탈퇴 시 확인용 데이터를 받는 메소드 - 준혁 */
	private Map<String, String> checkMember() {

		/* 입력받은 정보들은 여기에 담아서 넘겨줄 것 */
		/*
		 * checkResult에는 입력받은 정보에 따라 상태를 담을 것 0 : 정상 입력 -> 탈퇴 진행 1 : 정말 진행하냐고 다시 물었을 때 N
		 * 선택한 것 2 : id를 잘못 입력 3 : pwd를 잘못 입력
		 */
		Map<String, String> checkList = new HashMap<>();

		System.out.print("정말로 회원 탈퇴를 진행하시겠습니까?(Y/N) : ");

		if ("Y".equals(sc.nextLine())) {
			System.out.println("확인을 위해 아이디와 비밀번호를 다시 입력해주세요");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			if (member.getMemberId().equals(id)) {
				checkList.put("memberId", id);
				System.out.print("비밀번호 : ");
				String pwd = sc.nextLine();

				if (member.getMemberPwd().equals(pwd)) {
					System.out.println("탈퇴를 진행하겠습니다.");
					checkList.put("memberPwd", pwd);
					checkList.put("checkResult", "0");
				} else {
					checkList.put("checkResult", "3");
				}
			} else {
				checkList.put("checkResult", "2");
			}
		} else {
			checkList.put("checkResult", "1");
		}

		return checkList;
	}

	/* 기존 도서 입고 요청 View - 시원 */
	public Map<String, String> displayInputOrderExistBook() {

		Map<String, String> existBookOrder = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("===============================================================================");
		System.out.println("기존 도서 입고를 신청하시겠습니까? 신청하시겠다면 1을, 아니라면 2를 입력해주세요.");

		String inputBookName = null;
		String inputBookAuthor = null;
		String inputPublisherName = null;

		int inputNum = sc.nextInt();
		do {
			switch (inputNum) {
			case 1:
				System.out.println("======================================================================");
				System.out.print("입고 신청하실 책의 번호를 입력해주세요 : ");
				sc.nextLine();
				String inputBookNo = sc.nextLine();

				List<DBeloper_Book_DTO> BookStockZeroList = controller.selectBookStock();
				for (int i = 0; i < BookStockZeroList.size(); i++) {
					DBeloper_Book_DTO bookStockZero = BookStockZeroList.get(i);
					if (bookStockZero.getBookNo().toString().equals(inputBookNo)) {

						inputBookName = bookStockZero.getBookName();
						inputBookAuthor = bookStockZero.getBookAuthor();
						inputPublisherName = bookStockZero.getBookPublisherName();
					}
				}
				System.out.println("도서명 : " + inputBookName + "| 작가명 : " + inputBookAuthor + "| 출판사명 : "
						+ inputPublisherName + " 을 확인해주세요.");
				System.out.println("도서 정보가 일치한다면 1번, 일치하지 않는다면 2번을 눌러주세요");
				int agreementcode = sc.nextInt();
				if (agreementcode == 1) {

					existBookOrder.put("bookNo", inputBookNo);
					existBookOrder.put("bookName", inputBookName);
					existBookOrder.put("authorName", inputBookAuthor);
					existBookOrder.put("publisherName", inputPublisherName);
					
					inputNum = 2;
					
					break;
					
				} else if (agreementcode != 1){
					System.out.println("다시 입력해주세요.");
					inputNum = 1;
					break;
				}
				
			default : System.out.println("입고 요청을 취소하였습니다.");
			}if(inputNum == 2) {
				break;
			}
		} while (inputNum == 1);
		return existBookOrder;
	}

	/* 신규 도서 입고 요청 View - 시원 */
	public Map<String, String> displayInputOrderNewBook() {

		Map<String, String> newBookOrder = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("==============================================================");
		System.out.println("신규 도서 입고를 신청하시겠습니까? 신청하시겠다면 1을, 아니라면 2를 입력해주세요.");

		int inputNum = sc.nextInt();
		do {
			switch (inputNum) {
			case 1:

				System.out.println("==============================================================");
				sc.nextLine();
				System.out.print("입고 신청하실 책의 이름을 입력해주세요 : ");
				String inputBookName = sc.nextLine();

				System.out.print("입고 신청하실 책의 작가명을 입력해주세요 : ");
				String inputBookAuthor = sc.nextLine();

				System.out.print("입고 신청하실 책의 출판사명을 입력해주세요 : ");
				String inputPublisherName = sc.nextLine();

				System.out.println("도서명:" + inputBookName + "| 작가명:" + inputBookAuthor + "| 출판사명:" + inputPublisherName
						+ " 을 확인해주세요.");
				System.out.println("도서 정보가 일치한다면 1번, 일치하지 않는다면 2번을 눌러주세요");
				int agreementcode = sc.nextInt();
				if (agreementcode == 1) {
					newBookOrder.put("bookName", inputBookName);
					newBookOrder.put("authorName", inputBookAuthor);
					newBookOrder.put("publisherName", inputPublisherName);
					
					inputNum = 2;
					break;

				} else if (agreementcode != 1){
					System.out.println("다시 입력해주세요.");
					inputNum = 1;
					break;
				}
			default : System.out.println("입고 요청을 취소하였습니다.");
			}
			if(inputNum == 2) {
				break;
			}
		} while (inputNum == 1);

		return newBookOrder;
	}

	/* 리뷰 작성용 method */
	public void insertReview() {
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("현재 DB문고는 리뷰 작성시 마일리지 500원을 적립해드리는 서비스가 제공되고 있습니다.");
			System.out.println("리뷰 작성을 원하시면 1번을");
			System.out.print("취소하시려면 2번을 입력하세요.");
			int userInput = 0;
			
			try {
				userInput = sc.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println();
				drv.displayResultMessage("notcorrectNum");
				System.out.println();
				continue;
			}
			
			switch (userInput) {
			case 1:
				System.out.println("현재 구매하신 책의 목록은 아래와 같습니다.");
				System.out.println("단, 동일한 도서를 구매하셔도 리뷰 작성은 한 번만 가능합니다.");
				System.out.println();
				int result = controller.selectMemberByBook(member.getMemberNo());
				if (result > 0) {
					System.out.println();
					System.out.print("리뷰를 작성하실 책의 번호를 눌러주세요.");
					int bookNo = 0;
					
					try {
						bookNo = sc.nextInt();
					} catch (java.util.InputMismatchException e) {
						System.out.println();
						drv.displayResultMessage("notcorrectNum");
						System.out.println();
						continue;
					}
					
					System.out.println("리뷰를 작성하세요. ");
					sc.nextLine();
					String reviewContents = sc.nextLine();
					
					controller.insertReview(bookNo, reviewContents, member.getMemberNo());
					
					break;
					
				} else {
					drv.displayResultMessage("notcorrectNum");
					System.out.println();
					break;
				}
			case 2:
				drv.displayResultMessage("backtothebefore");
				System.out.println();
				return;
			default:
				System.out.println();
				drv.displayResultMessage("unExistMenu");
				System.out.println();
			}
		} while(true);
	}

	/* 지영 - 마일리지로 상품 구매 (마일리지 사용) */
	public Map<String, String> updateUseMemberMileage() {
		
		Map<String, String> userProductNo = new HashMap<>();
		
		System.out.print("===== 마일리지 사용 뷰 도착 =====" + "\n");
		System.out.println("[ 마일리지 상점 뷰 ]" + "\n" + "마일리지 구매 페이지에 오신 것을 환영합니다.");
		System.out.print("마일리지로 상품을 구매하시겠습니까?(Y/N)" + "\n" + ">>> ");
		String userNo = member.getMemberNo();
		String productno = "";
		String answer = sc.nextLine().toUpperCase();
		if ("Y".equals(answer)) {
			System.out.println("다음은 마일리지로 구매 가능한 상품입니다.");
			System.out.print("1.북스탠드(1000 마일리지) 2.책갈피(2000 마일리지) 3. 모르모트 노트(3000 마일리지) 4.하이미디어 초청권(4000 마일리지)" + "\n" + ">>> ");
			productno = sc.nextLine();
			if ("1".equals(productno)) {
				System.out.println("1번 북스탠드가 구매되었습니다.");

			} else if ("2".equals(productno)) {
				System.out.println("2번 책갈피가 구매되었습니다.");

			} else if ("3".equals(productno)) {
				System.out.println("3번 모르모트 노트가 구매되었습니다.");

			} else if ("4".equals(productno)) {
				System.out.println("4번 하이미디어 초청권이 구매되었습니다.");

			} else {
				System.out.println("마일리지 상품 구매에 실패하였습니다.");
				userProductNo.put("userNO", userNo);
				userProductNo.put("productNo", productno);
				System.out.println("마일리지 구매 페이지를 종료합니다.");
			}
			
			userProductNo.put("userNO", userNo);
			userProductNo.put("productNo", productno);
			
		} else {
			System.out.println("상품 구매에 실패하셨습니다.");
			userProductNo.put("userNO", userNo);
			userProductNo.put("productNo", productno);
		}

		return userProductNo;
	}

}
