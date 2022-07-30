package com.dbeloper.member.view;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dbeloper.member.controller.DBeloper_Controller;
import com.dbeloper.member.model.dto.DBeloper_Book_DTO;
import com.dbeloper.member.model.dto.DBeloper_Input_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Manager_DTO;
import com.dbeloper.member.model.dto.DBeloper_Output_Order_History_DTO;
import com.dbeloper.member.model.dto.DBeloper_Store_Sales_History_DTO;

public class DBeloper_Manager_View {
	private DBeloper_Controller controller = new DBeloper_Controller();
	private DBeloper_Result_View drv = new DBeloper_Result_View();

	private Scanner sc = new Scanner(System.in);
	public void manager_View() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====[ 관리자용 로그인 페이지 ] =====" + "\n");
		System.out.println("반갑습니다. [ 떡잎마을 문고 ]입니다.");
		System.out.print("로그인을 위해 아이디를 입력하세요." + "\n" + ">>> ");
		String managerId = sc.nextLine().toUpperCase();
		System.out.print("로그인을 위해 비밀번호를 입력하세요." + "\n"+ ">>> ");
		String managerPwd = sc.nextLine().toUpperCase();
		
		Map<String, String> managerNameManagerGrade = controller.loginManager(managerId, managerPwd);
		
		if(managerNameManagerGrade.get("managerName") == null) {
			drv.displayResultMessage("FailedLogin");
			System.out.println();
			return;
		} else { 
			System.out.println("\n" + "반갑습니다. " + "[ "+ managerNameManagerGrade.get("managerName") + "님" + " ]");
			
			/* 관리자 메뉴 조회 */
			do {
				Scanner sc1 = new Scanner(System.in);
				System.out.println();
				System.out.println("=== 원하는 메뉴의 번호를 선택하세요 ===" + "\n");
				System.out.println("1. 서점 재산 조회");
				System.out.println("2. 전 직원 월급 지급");
				System.out.println("3. 직원 관리");
				System.out.println("4. 입고 조회 및 승인");
				System.out.println("5. 판매 대기 조회 및 승인"); 
				System.out.println("6. 일매출 조회");
				System.out.println("7. 상품 조회");
				System.out.println("8. 회원 조회");
				System.out.println("9. 도서재고 확인 후 도서 추가 기능");
				System.out.println("10. 퇴사자 조회 및 복직 승인");
				System.out.print("11. 로그아웃" + "\n" + ">>> ");
				
					int inputNum = 0;
					try {
						inputNum = sc1.nextInt();
					} catch (java.util.InputMismatchException e) {
						drv.displayResultMessage("notcorrectNum");
						System.out.println();
						continue;
					}
					
				/*매출조회 및 매장보유금액 조회*/
				switch (inputNum) {
				case 1:
					/* 서점 재산 조회 */
					if(managerNameManagerGrade.get("managerGrade").equals("MASTER")) {
						/* 매장 입출금 내역 조회 */
						drv.displayselectAllSalesHistory(controller.selectStoreSalesHistory());
						/*매장 보유금액 조회*/
						drv.storeSumMoneyAmountResult(controller.selectSumMoneyAmount());
						break;
					} else {
						drv.displayResultMessage("NotEnouhtGrade"); 
						break;
					}
				case 2:
					/* 전 직원 월급 지급 */
					if(managerNameManagerGrade.get("managerGrade").equals("MASTER")) {
						controller.insertSalary();
						break;
					} else {
						drv.displayResultMessage("NotEnouhtGrade"); 
						break;
					}
				case 3: 
					/* 지영 - 직원 관리 */
					if(managerNameManagerGrade.get("managerGrade").equals("MASTER")) {
					
						controller.selectManager(inputSelectManager());
								
					} else {
						drv.displayResultMessage("NotEnouhtGrade"); 
						break;
						
					}
					break; 
				case 4:
					/* 입고 조회 및 승인 */
					if(managerNameManagerGrade.get("managerGrade").equals("MASTER") || managerNameManagerGrade.get("managerGrade").equals("SUBMASTER")) {

						int result = 0;
						do {
							System.out.println();
							System.out.println("=====입고 승인=====");
							System.out.println("1. 기존 도서 입고 승인");
							System.out.println("2. 신규 도서 입고 승인");
							System.out.println("3. 이전메뉴로 돌아가기");
							System.out.println("입력: ");
							String answer = sc.nextLine();
							if(answer.equals("1")) {
								/* 기존도서 입고요청 처리 */
								result = acceptBookInputOrderHistory();
							}else if(answer.equals("2")){
								/*신규 도서 입고요청 처리 - 수목*/
								result = selectInsertUpdateinputNewbooks();
							}else if(answer.equals("3")) {
								System.out.println("[메인 메뉴로 돌아갑니다.]");
								result = 2;
							}else {
								System.out.println("[정확히 입력해주세요]");
								result = -1;
							}
						}while(!(result == 2));
						
					} else {
						drv.displayResultMessage("NotEnouhtGrade"); 
						break;
					}
					break;
				case 5:
					/* 판매 대기 조회 및 승인 */
                    selectUpdateOutputOrderHistory();
					break;
				
				case 6: 
					/* 일매출 조회 */
					if(managerNameManagerGrade.get("managerGrade").equals("MASTER") || managerNameManagerGrade.get("managerGrade").equals("SUBMASTER")) {
						Scanner sc2 = new Scanner(System.in);
						System.out.println("조회할 년도(YYYY): ");
						String inputYear = sc2.nextLine();
						System.out.println("조회할 월(MM): ");
						String inputMonth = sc2.nextLine();
						System.out.println("조회할 날짜(DD): ");
						String inputday = sc2.nextLine();
						
						controller.selectDaySalesHistory(inputYear, inputMonth, inputday);
						
						
					} else {
						drv.displayResultMessage("NotEnouhtGrade"); 
						break;
					}
					break;
				case 7: 
					/* 상품 조회 */
					controller.searchBook(inputSearchInfo()); 
					break;
				case 8:
					/* 회원 조회 */
					if(managerNameManagerGrade.get("managerGrade").equals("MASTER")) {
						controller.selectMember(inputSelectMember());
						break;
					} else {
						drv.displayResultMessage("NotEnouhtGrade");
						break;
					}
				case 9 :
					/* 도서재고 확인 후 도서 추가 기능 */
					if(managerNameManagerGrade.get("managerGrade").equals("MASTER")) {
						updateBookStock();
					} else {
						drv.displayResultMessage("NotEnouhtGrade");
						break;
					}
						break;
					
				case 10 :
					/* 퇴사자 조회 및 복직 승인 */
					if(managerNameManagerGrade.get("managerGrade").equals("MASTER")) {
					Map<String, String> selectRetireManager = new HashMap<>();
					System.out.println("============ 퇴사한 사원의 목록 ============");
					controller.selectRetireManager();
					
					
					System.out.println("복직 처리 실행을 원하신다면 1을 입력해주세요.");
					int selectReturnNum = sc.nextInt();
					sc.nextLine();
					
				    if(selectReturnNum == 1) {
				    	
				    	System.out.println("복직 처리 하고자 하는 퇴사한 관리자의 번호를 입력해주세요. ");
						String updateReturnNum = sc.nextLine();
						controller.modifyManagerReturn(updateReturnNum);
						break;
				    }else {
				    	System.out.println("복직 처리를 취소하였습니다. ");
				    	break;
				    }
				}

					
				case 11: 
					/* 로그아웃 */
				System.out.println("\n" + "고생하셨습니다. 안녕히 가세요.");
				return;
				
				default : drv.displayResultMessage("unExistMenu"); break;
				}// switch 문 종료
			} while (true); 
				
			} //if 문 종료
	}// view main 메소드 종료

	/* 조회할 책의 정보를 입력 받는 메소드 - 준혁 */
	private Map<String, String> inputSearchInfo() {
		
		/* 조회 메뉴를 선택하도록 한다. */
		Scanner sc = new Scanner(System.in);
		System.out.println("---- 조회 방식을 선택하세요 ----");
		System.out.println("1. 도서명으로 조회");
		System.out.println("2. 카테고리 조회");
		System.out.println("3. 작가 조회");
		System.out.println("4. 판매량 TOP3 조회");
		System.out.println("5. 종류별 책(전자책/종이책) 조회");
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
			default : drv.displayResultMessage("unExistMenu"); break;
		}
		
		
		return searchInfo;
	}
	
	/* 지영 - 관리자 정보 조회 */

	private Map<String, String> inputSelectManager() {
		
		Scanner sc = new Scanner(System.in);
		
		DBeloper_Manager_DTO managerDTO = new DBeloper_Manager_DTO();
		
		System.out.println("---- [ 어떤 정보로 조회하시겠습니까? ] ----");
		System.out.println("1. 관리자 번호");
		System.out.println("2. 관리자명");
		System.out.println("3. 관리자 직급");
		System.out.print("4. 관리자 퇴사 여부 조회" + "\n" + ">>> ");
		
		
		int inputNum = sc.nextInt();
		
		Map<String, String> selectManager = new HashMap<>();
		
		selectManager.put("inputNum", Integer.valueOf(inputNum).toString());
		
		switch(inputNum)
		{
			case 1:
				/* 관리자 번호 */
				System.out.print("조회할 관리자 번호를 입력하세요 (1 ~ 10번): ");
				sc.nextLine();
				selectManager.put("managerNum", sc.nextLine());
				break;
				
			case 2:
				/* 관리자명 */
				System.out.print("조회할 관리자명을 입력하세요 : ");
				sc.nextLine();
				selectManager.put("managerName", sc.nextLine());
				break;
			case 3:
				/* 관리자 직급 */
				System.out.print("조회할 관리자 직급을 입력하세요 : ");
				sc.nextLine();
				selectManager.put("managerGrade", sc.nextLine().toUpperCase());
				break;
			case 4:
				/* 관리자 퇴사 여부 조회 */
				System.out.println("관리자의 퇴사 여부 조회를 하시겠습니까? (Y/N) : ");
				System.out.println("퇴사 직원들은 Y를, 고용중인 직원들은 N을 입력하세요.");
				sc.nextLine();
				selectManager.put("managerDropYN", sc.nextLine().toUpperCase());
				break;
		}
		return selectManager;
	}
	

	/* 회원 조회 - 다영 */
	private Map<String, String> inputSelectMember() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("---- [ 회원 조회 ] ----");
		System.out.println("1. 회원번호로 조회");
		System.out.println("2. 회원명으로 조회");
		System.out.println("3. 회원 아이디로 조회");
		System.out.print("4. 회원 등급별 조회" + "\n" + ">>> ");
		
		
		int menuNum = sc.nextInt();
		
		Map<String, String> selectMember = new HashMap<>();
		
		selectMember.put("menuNum", Integer.valueOf(menuNum).toString());
		
		switch(menuNum) {
			case 1:
				/* 회원번호로 조회 */
				System.out.println("조회할 회원의 회원번호를 입력하세요 : ");
				sc.nextLine();
				selectMember.put("memberNo", sc.nextLine());
				break;
			case 2:
				/* 회원명으로 조회 */
				System.out.println("조회할 회원의 이름을 입력하세요 : ");
				sc.nextLine();
				selectMember.put("memberName", sc.nextLine());
				break;
			case 3:
				/* 회원 아이디로 조회 */
				System.out.println("조회할 회원의 아이디를 입력하세요 : ");
				sc.nextLine();
				selectMember.put("memberId", sc.nextLine().toUpperCase());
				break;
			case 4:
				/* 회원 등급별 조회 */
				System.out.println("조회할 회원 등급을 입력하세요 : ");
				sc.nextLine();
				selectMember.put("memberGradeNo", sc.nextLine().toUpperCase());
				break;
			default : System.out.println("존재하지 않는 기능입니다.");
				break;
		}
		return selectMember;
	}
	
	/* 큰솔 출고 대기 목록 조회  */
	private void selectUpdateOutputOrderHistory() {
		String managerInput = "";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("현재 대기 중인 판매 상품 목록입니다. ");
			System.out.println();
			List<DBeloper_Output_Order_History_DTO> list = new ArrayList();
			list = drv.selectOrderOutputHistory(controller.selectOutputOrderHistory());
			System.out.println();
			
			if(list.isEmpty()) {
				drv.displayResultMessage("emptyOutputOrder");
				break;
			} 
			
			System.out.println("판매를 원하시는 물품의 주문 번호를 누르세요.");
			System.out.println("출고 서비스 종료는 " + " \"종료\"  를 입력하세요");
			
			managerInput = sc.nextLine();
			String ouputOrderNo = "";
			int i = 0;
				if(managerInput.equals("종료")) {
					drv.displayResultMessage("backtothebefore");
					System.out.println();
					break;
				}
			
				for(DBeloper_Output_Order_History_DTO outputOrderNoList : list) {
					ouputOrderNo = outputOrderNoList.getOutputOrderNo();
					if(ouputOrderNo.equals(managerInput)) {
						controller.updateOutputOrderHistory(managerInput);
					} else {
						if(i == list.size() - 1) {
							drv.displayResultMessage("outputList");
						} else {
							i++;
							continue;
						}
					}
				}
			
		} while(true);
		
	}

	
	/* 신규 도서 입고 조회 - 수목 */
	private int selectInsertUpdateinputNewbooks() {
		/*도서 요청 목록 출력 결과 값 담을 변수*/
		int selectresult = 0;
		/*최종 결과 값을 담을 변수*/
		int result = 0;
		
		do {
			/*신규도서 요청 목록 출력(selectresult) / 목록 있음 ->1: 입고신청 계속 받아야지 / 없음 -1 : 메뉴로 돌아가야지*/
			selectresult = drv.selectOrderNewInputbooksHistory(controller.selectInputOrderHistory());
		
			/* 입고 주문 목록이 있다면 입고신청으로 이동할것임.*/
			if(selectresult == 1) {
				/*입고 신청으로 나온 결과 값을 저장할 것임.result 입고승인성공 1 실패 0
				 * 
				 * 그 외 이전 화면으로 돌아가기 했다면 result 값은 9 */
				result = approvalInputOrderNewBook();

				if(result == 0) {
					/*입고승인 실패 메세지*/
					drv.displayResultMessage("displayInputOrderResultFailed");
				}else if(result == 1) {
					/*입고 승인 성공 메세지*/
					drv.displayResultMessage("displayInputOrderResultSuccess");
				}else if(result == 9) {
					/*이전 메뉴로 돌아감을 알리는 메세지*/
					drv.displayResultMessage("backtothebefore");
				}else {
					System.out.println();
				}
			/* 입고 주문 목록이 없을경우 출력될 메세지*/
			}else {
				drv.displayResultMessage("noHaveOrderlist");
			}
			/* 목록이 계속 있고 이전으로 돌아가지 않겠다고 했을때는 계속 신청을 받을 것임. */
		}while(selectresult == 1 && !(result == 9));
		
		return result;
	}
	
	/* 신규 도서 입고 주문 번호 받기 및 승인 - 수목 */
	private int approvalInputOrderNewBook() {
		Scanner sc = new Scanner(System.in);
		String answer = "";
		/*최종 결과값을 받을 변수 커밋 1 롤백 0 이전메뉴 9*/
		int result = 0;
		
		do {
		System.out.println();
		System.out.println("[신규 입고 하실 물품의 주문번호를 입력하세요(이전으로 -> 0): ]");
		answer = sc.nextLine();
		
		/*이전 메뉴로 돌아감 입력시 */
		if(answer.equals("0")) {
			result = 9;
			break;
		/*그 외 주문 번호 입력 시*/
		}else {
			/*주문번호 입력시*/
			result = controller.approvalInputOrderNewBook(controller.selectInputOrderHistory(),answer);
		}
		
		
		/* 올바르지 않은 주문번호 입력시 출력될 문구 및 반복 */
		if(result == 2) {
			drv.displayResultMessage("notcorrectNum");
		}
		}while(result == 2);
		
		
		return result;
	}

	
	/* 기존도서 입고 신청 승인시 실행할 메소드 - 다영 */
	private int acceptBookInputOrderHistory() {
		String acceptBookNo = "";
		int result = 0;
		int bookResult = 0;
		do {
			Scanner sc = new Scanner(System.in);
			/* 입고 신청 책 조회 (기존도서) */
			System.out.println("=== 입고 신청된 도서들을 조회합니다 (기존도서들만) ===");
			bookResult= drv.selectBookInputOrderHistory(controller.selectBookInputOrderHistory());
			if (bookResult == 1) {
				System.out.println("승인할 도서의 입고주문번호를 입력해주세요");
				System.out.println("프로그램 종료는 종료를 입력하세요");
				acceptBookNo = sc.nextLine();
				if(acceptBookNo.equals("종료")) {
					break;
				} else {
					System.out.println();
					result = controller.acceptBookInputOrderHistory(acceptBookNo);
					if (result == 1) {
						drv.displayResultMessage("displayInputOrderResultSuccess");
						System.out.println("처음으로 돌아갑니다");
					} else if (result == 0) {
						drv.displayResultMessage("displayInputOrderResultFailed");
						System.out.println("처음으로 돌아갑니다");
					}
	
				}
			} else {
					System.out.println("주문 목록이 없습니다.");
					result = 2;
					break;
			 }
		} while(true);
		
		return result;
	
	}
	
	/* 큰솔 도서 재고 확인 후 추가 입고  */
	private void updateBookStock() {
	
		do {
			System.out.println();
			System.out.println("현재 떡잎마을 문고의 도서 재고 현황은 아래와 같습니다.");
			System.out.println();
			List<DBeloper_Book_DTO> list = new ArrayList<>();
			list = controller.booklistByBookStock();
			System.out.print("\n" + "추가 도서 입고를 원하시는 책의 번호를 입력하세요." + "\n");
			System.out.print("추가적인 출고가 필요 없으시다면, 0번을 누르세요." + "\n");
			Scanner sc = new Scanner(System.in);
			int bookNo = 0;
			
			try {
				bookNo = sc.nextInt();
			} catch (java.util.InputMismatchException e) {
				drv.displayResultMessage("notcorrectNum");
				System.out.println();
				continue;
			}
			
			if(bookNo == 0) {
				drv.displayResultMessage("backtothebefore");
				break;
			} else if(bookNo > list.size() || bookNo < 0 ) {
				drv.displayResultMessage("outOfbookList");
				continue;
			}  else {
				System.out.print("입고를 원하시는 수량을 입력하세요.");
				int bookAmount = 0;
				
				try {
					bookAmount = sc.nextInt();
				} catch (java.util.InputMismatchException e) {
					drv.displayResultMessage("notcorrectNum");
					System.out.println();
					continue;
				}
				
				if(bookAmount <= 0) {
					drv.displayResultMessage("notcorrectNum");
					continue;
				} 
				
				controller.updateBookStockByUserInput(bookNo, bookAmount);
				break;
			}
		} while(true);
		
	}
	
	
}
