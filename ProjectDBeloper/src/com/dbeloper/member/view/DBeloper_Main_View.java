package com.dbeloper.member.view;

import java.util.Scanner;

public class DBeloper_Main_View {

	private DBeloper_Manager_View managerView = new DBeloper_Manager_View();
	private DBeloper_Member_View member_View = new DBeloper_Member_View();
	private DBeloper_NonMember_View nonMemberView = new DBeloper_NonMember_View();
	private DBeloper_Member_Join_View memberJoinView = new DBeloper_Member_Join_View();
	private DBeloper_Result_View drv = new DBeloper_Result_View();
	
	
	
	public void display_menu() {
		do {
			Scanner sc = new Scanner(System.in);
			int userinput = 0;
			System.out.println("어서오세요. 떡잎마을 문고입니다.");
			System.out.println("사용하실 기능에 맞춰 로그인이 필요합니다.");
			System.out.println("1. 관리자 로그인");
			System.out.println("2. 고객 로그인");
			System.out.println("3. 비회원 이용");
			System.out.println("4. 회원 가입");
			System.out.print("5. 프로그램 종료" + "\n" + ">>> ");

			try {
				userinput = sc.nextInt();
			} catch (java.util.InputMismatchException e) {
				drv.displayResultMessage("notcorrectNum");
				System.out.println();
				continue;
			}
			
			switch(userinput) {
			case 1: managerView.manager_View(); break;
			case 2: member_View.member_View(); break;
			case 3: nonMemberView.nonMemberView(); break;
			case 4: memberJoinView.memberJoinView(); break;
			case 5: System.out.println("안녕히 가세요~"); return;
			default : drv.displayResultMessage("unExistMenu");
			}
			
		} while(true);
	}

}
