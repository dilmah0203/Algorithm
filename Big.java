package ch08;

import java.util.Scanner;
import java.lang.Math;

public class Big {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();

		int max = Math.max(a.length(), b.length()); // �ΰ��� ���� �߿� �� ������ �ڸ��� ��ȯ
		int array[] = new int[max + 1]; // ũ�⸦ 1 ������Ų a �迭 ����
		int array2[] = new int[max + 1];
		int carry = 0; // ĳ��

		for (int index = 0, i = a.length() - 1; i >= 0; index++, i--) { // �����ڸ�����(�ε����� length()-1����) ����
			array[index] = a.charAt(i) - '0'; // charAt : Ư�� �ε����� ��ġ�ϴ� �����ڵ� ���Ϲ��� ��ȯ
		}

		for (int index = 0, i = b.length() - 1; i >= 0; index++, i--) {
			array2[index] = b.charAt(i) - '0';
		}

		for (int i = 0; i < max + 1; i++) {
			int sum = array[i] + array2[i] + carry; // ĳ�� ���� ���� ����
			if (sum >= 10) {
				array[i] = (array[i] + array2[i] + carry) - 10;
				carry = 1; // ĳ�� 1
			} else {
				array[i] = (array[i] + array2[i] + carry);
				carry = 0; // ĳ�� 0
			}
		}

		if (array[max] != 0) { // array �迭 ������ �ε��� ���� 0�� �ƴϸ�
			for (int i = max; i >= 0; i--) // max ������ �������� ���
				System.out.print(array[i]);
		} else { // array �迭 ������ �ε��� ���� 0�̸�
			for (int i = max - 1; i >= 0; i--) // max-1 ������ �������� ���
				System.out.print(array[i]);
		}
	}
}
