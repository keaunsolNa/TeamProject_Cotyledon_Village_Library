package com.dbeloper.member.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.dbeloper.member.controller.DBeloper_Controller;

public class DBeloper_Member_Join_View {

	private DBeloper_Controller dc = new DBeloper_Controller();
	private DBeloper_Result_View resultView = new DBeloper_Result_View();
	
	/* 회원 가입 View 큰솔 */
	public void memberJoinView() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("감사합니다. 고객님");
		System.out.println("현재 떡잎마을 문고는 현재 가입시 1000원 상당의 마일리지를 지급하고 있습니다.");
		System.out.println("또한, 원하시는 도서 신청 등의 서비스가 지원되고 있습니다.");
		System.out.print("우선, 성함을 입력하세요. : ");
		String joinName = sc.nextLine();
		System.out.print("연락처를 입력하세요. - 를 포함합니다. : ");
		String joinPhone = sc.nextLine();
		System.out.print("주소를 입력하세요. : ");
		String joinAddress = sc.nextLine();
		System.out.print("아이디를 입력하세요. : ");
		String joinId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요. : ");
		String joinPwd = sc.nextLine();
		
		Map<String, String> memberJoin = new HashMap<>();
		memberJoin.put("MEM_NAME", joinName);
		memberJoin.put("MEM_PHONE", joinPhone);
		memberJoin.put("MEM_ADDRESS", joinAddress);
		memberJoin.put("MEM_ID", joinId);
		memberJoin.put("MEM_PWD", joinPwd);
		
		dc.memberjoin(memberJoin);
		
	}
	
	/* 휴먼게정 재가입을 받는 View 큰솔 */
	public void memberRejoinView(String string) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("현재 휴먼계정인 아이디입니다. 다시 활성화하시겠습니까?");
		System.out.println("1. 예.");
		System.out.println("2. 아니오.");
		int answer = sc.nextInt();
		
		if(answer == 1) {
			System.out.print("본인 확인을 위해 비밀번호를 입력해 주세요.");
			sc.nextLine();
			String userPwd = sc.nextLine();
			Map<String, String> memberReJoin = new HashMap<>();
			memberReJoin.put("memberID", string);
			memberReJoin.put("memberPWD", userPwd);
			dc.memberRejoin(memberReJoin);
			return;
		} else if(answer == 2){
			resultView.displayResultMessage("DuplicationMemberId");
			return;
		} else {
			resultView.displayResultMessage("notcorrectNum");		
			return;
		}
	}

}	// class 종료
