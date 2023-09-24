package main;
import java.util.Scanner;
import java.util.regex.Pattern;

public class sign_up {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        String username;
	        String password;
	        String confirmPassword;
	        String phoneNumber;
	        String birthdate;
	        String name;
	        
	        // 회원 정보 입력 받기
	        while (true) {
	            System.out.print("아이디를 입력하세요 (6-16자, 영어 소문자와 숫자만 가능): ");
	            username = scanner.nextLine();
	            
	            // 아이디 유효성 검사
	            if (isValidUsername(username)) {
	                break;
	            } else {
	                System.out.println("올바른 형식의 아이디를 입력하세요.");
	            }
	        }

	        
	        while (true) {
	            System.out.print("비밀번호를 입력하세요 (8-16자, 영어 대/소문자, 숫자, 특수문자 중 2가지 이상 조합 필요): ");
	            password = scanner.nextLine();
	            
	            // 비밀번호 유효성 검사
	            if (isValidPassword(password)) {
	                break;
	            } else {
	                System.out.println("올바른 형식의 비밀번호를 입력하세요.");
	            }
	        }

	        
	        do {
	            System.out.print("비밀번호를 다시 입력하세요: ");
	            confirmPassword = scanner.nextLine();
	            
	            if (!confirmPassword.equals(password)) {
	                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
	            }
	        } while (!confirmPassword.equals(password));

	        
	        while (true) {
	            System.out.print("전화번호를 입력하세요 (010-XXXX-XXXX 형식): ");
	            phoneNumber = scanner.nextLine();
	            
	            // 전화번호 유효성 검사
	            if (isValidPhoneNumber(phoneNumber)) {
	                break;
	            } else {
	                System.out.println("올바른 형식의 전화번호를 입력하세요.");
	            }
	        }

	        
	        while (true) {
	            System.out.print("생년월일을 입력하세요 (YYYYMMDD): ");
	            birthdate = scanner.nextLine();
	            
	            // 생년월일 유효성 검사
	            if (isValidBirthdate(birthdate)) {
	                break;
	            } else {
	                System.out.println("올바른 형식의 생년월일을 입력하세요.");
	            }
	        }

	       
	        while (true) {
	            System.out.print("이름을 입력하세요 (한글 이름만 가능): ");
	            name = scanner.nextLine();
	            
	            // 이름 유효성 검사
	            if (isValidKoreanName(name)) {
	                break;
	            } else {
	                System.out.println("올바른 형식의 이름을 입력하세요.");
	            }
	        }

	        // 입력 받은 정보 출력하여 확인
	        System.out.println("\n입력한 회원 정보:");
	        System.out.println("아이디: " + username);
	        System.out.println("비밀번호: " + password);
	        System.out.println("전화번호: " + phoneNumber);
	        System.out.println("생년월일: " + birthdate);
	        System.out.println("이름: " + name);

	        scanner.close();
	    }

	    // 아이디 유효성 검사(6-16자, 영어 소문자와 숫자만 가능)
	    private static boolean isValidUsername(String username) {
	        String regex = "^[a-z0-9]{6,16}$";
	        return Pattern.matches(regex, username);
	    }

	    // 비밀번호 유효성 검사(8-16자, 영어 대/소문자, 숫자, 특수문자 중 2가지 이상 조합 필요)
	    private static boolean isValidPassword(String password) {
	    	String regex = "^(?=(.*[A-Z]){1,})(?=(.*[a-z]){1,})(?=(.*[0-9]){1,})(?=(.*[@$%^&+=!]){1,}).{8,16}$";
	        return Pattern.matches(regex, password);
	    }

	    // 전화번호 유효성 검사(010-XXXX-XXXX 형식)
	    private static boolean isValidPhoneNumber(String phoneNumber) {
	        String regex = "^010-[0-9]{4}-[0-9]{4}$";
	        return Pattern.matches(regex, phoneNumber);
	    }

	    // 생년월일 유효성 검사(YYYYMMDD)
	    private static boolean isValidBirthdate(String birthdate) {
	        String regex = "^[0-9]{8}$";
	        return Pattern.matches(regex, birthdate);
	    }

	    // 이름 유효성 검사(한글 이름만 허용)
	    private static boolean isValidKoreanName(String name) {
	        String regex = "^[가-힣]*$";
	        return Pattern.matches(regex, name);
	    }
	

}
