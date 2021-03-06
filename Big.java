import java.util.Scanner;
import java.lang.Math;

public class Big {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();

		int max = Math.max(a.length(), b.length()); // 두개의 숫자 중에 긴 숫자의 자릿수 반환
		int array[] = new int[max + 1]; // 크기를 1 증가시킨 a 배열 생성
		int array2[] = new int[max + 1];
		int carry = 0; // 캐리

		for (int index = 0, i = a.length() - 1; i >= 0; index++, i--) { 
			array[index] = a.charAt(i) - '0'; // charAt : 특정 인덱스에 위치하는 유니코드 단일문자 반환
		}

		for (int index = 0, i = b.length() - 1; i >= 0; index++, i--) {
			array2[index] = b.charAt(i) - '0';
		}

		for (int i = 0; i < max + 1; i++) {
			int sum = array[i] + array2[i] + carry; // 캐리 포함 총합 변수
			if (sum >= 10) {
				array[i] = (array[i] + array2[i] + carry) - 10;
				carry = 1; // 캐리 1
			} else {
				array[i] = (array[i] + array2[i] + carry);
				carry = 0; // 캐리 0
			}
		}

		if (array[max] != 0) { // array 배열 마지막 인덱스 값이 0이 아니면
			for (int i = max; i >= 0; i--) // max 값부터 역순으로 출력
				System.out.print(array[i]);
		} else { // array 배열 마지막 인덱스 값이 0이면
			for (int i = max - 1; i >= 0; i--) // max-1 값부터 역순으로 출력
				System.out.print(array[i]);
		}
	}
}
