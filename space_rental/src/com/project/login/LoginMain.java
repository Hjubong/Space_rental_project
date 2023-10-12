package com.project.login;

import java.util.HashMap;
import java.util.Scanner;

import com.project.auth.Auth;
import com.project.main.MainService;
import com.project.user.User;
import com.project.user.UserData;

public class LoginMain {
	public static void main(String[] args) {
		MainService.dataLoad();

		loginMain();
	}

	public static void loginMain() {
		Scanner scan = new Scanner(System.in);

		boolean outerFlag = true;
		boolean innerFlag = true;

		while (outerFlag) {
			innerFlag = true;

			// 로그인 메인 화면 출력
			LoginView.controlLogin();

			while (innerFlag) {
				String n = scan.nextLine();
				LoginView.line();
				System.out.println();

				// n 유효성 검사
				// 0~3까지의 숫자만 허용한다.
				n = LoginService.checkValidNum(n);

				if (n == null) {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("다시 입력해주세요.");
					System.out.println();

					// 다시 입력받기
					LoginView.line();
					System.out.print("번호를 입력하세요. : ");

				} else if (n.equals("0")) { // 뒤로가기
					// 메인화면으로 이동

					System.out.println("이전 화면으로 돌아갑니다.");
					System.out.println("엔터키를 입력해주세요.");
					scan.nextLine();

					innerFlag = false;
					outerFlag = false;
				} else if (n.equals("1")) { // 로그인

					if (LoginService.login()) {
						// 로그인 성공 시 메인 화면으로 넘어가기
						System.out.println("로그인이 완료되었습니다.");
						System.out.println("환영합니다. " + Auth.authId + " 님!");

						// 로그인 성공했으니 해당 페이지로 이동
						// 관리자페이지와 일반회원 페이지가 다르다.
						
						// 전체 회원 목록 불러오기
						HashMap<String, User> uMap = UserData.getUserMap();
						
						// 현재 회원의 객체 가져오기
						User user = uMap.get(Auth.authId);
						
						// 현재 회원의 등급 가져오기
						int level = user.getLevel();
						
						if (level == 0) { // 관리자
							System.out.println("관리자 로그인 후 화면입니다.");
							
						} else { // 일반 회원
							System.out.println("일반 회원 로그인 후 화면입니다.");
							
						}
						
						innerFlag = false;
						outerFlag = false;
					} else {
						// 로그인 실패 시 현재, 로그인 메인 페이지로 오기
						System.out.println("유효하지 않은 아이디 혹은 비밀번호입니다.");
						System.out.println("다시 시도해주세요.");
						System.out.println();

						// (재입력 받거나) 이전 화면으로 돌아간다.
						innerFlag = false;
					}

				} else if (n.equals("2")) { // 아이디 찾기
					LoginService.findId();

					innerFlag = false;

				} else if (n.equals("3")) { // 비밀번호 재설정
					LoginService.resetPw();

					innerFlag = false;
				}
			}
		}
	}

}
