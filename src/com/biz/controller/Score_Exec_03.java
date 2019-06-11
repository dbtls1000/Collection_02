package com.biz.controller;

import java.util.Random;

import com.biz.model.ScoreVO;

public class Score_Exec_03 {
	public static void main(String[] args) {
		
		// ScoreVO클래스를 이용해서 10개의 배열을 생성하고
		//번호는 순서대로 설정
		//이름은 입력하지 않고
		//kor,eng,math점수를 각각 난수로 생성해서 저장
		// 단 점수는 51~100
		//입력값을 콘솔에서 혹인
		//총점과평균계산
		ScoreVO[] sVOs = new ScoreVO[10];
		Random rnd = new Random();
		int intTotal = 0;
		for(int i = 0 ; i < 10 ; i++) {
			sVOs[i] = new ScoreVO();
			// number 필드를 private으로 선언했기때문에
			// 다음 코드는 사용 불가
			// sVOs[i].number = ?;
			
			// 때문에 number값을 저장할때 사용할 setter method를 만듬
			
			// number 필드는 String형인데 i 값은 int형이다
			// sVOs[i].setNumber(i); -> 오류
			// 1. i 값은 0부터 시작하므로 +1을 실행해서
			//      1부터 시작하도록 설정 해줘야 한다.
			// 2.따라서 number 필드에 값을 저장하기 위해서 int형을 String형으로 변환 시켜야 한다.
			// 기존의 자바 문법
			// sVOs[i].setNumber(Integer.toString(i+1));
			// int형을 String형으로 바꾸는 최근문법
			// sVOs[i].setNumber("" + (i+1));
			// -> 이코드는 모든숫자를 문자화 한 후 연결하여 01 11 21 31 형식으로 바뀌므로 괄호로 묶어서 문자열로 바꾼다.
			sVOs[i].setNumber("" + (i+1));//Integer.toString(i+1));
			
			// 1번방법
			int intKor = rnd.nextInt(50)+51;
			int intEng = rnd.nextInt(50)+51;
			int intMath = rnd.nextInt(50)+51;

			sVOs[i].setKor(intKor);
			sVOs[i].setEng(intEng);
			sVOs[i].setMath(intMath);
			// 1번방법 총점계산
			intTotal = intKor + intEng + intMath;
			
			// 2번방법
			sVOs[i].setKor(rnd.nextInt(50)+51);
			sVOs[i].setEng(rnd.nextInt(50)+51);
			sVOs[i].setMath(rnd.nextInt(50)+51);
			
			// 2번방법 총점계산
			intTotal = sVOs[i].getKor();
			intTotal += sVOs[i].getEng();
			intTotal += sVOs[i].getMath();
			
			sVOs[i].setTotal(intTotal);
			sVOs[i].setAverage(intTotal/3);
			
			System.out.println(sVOs[i].toString());
		}
		
		// 총점을 별도로 계산
		for(ScoreVO vo : sVOs) {
			int intKor = vo.getKor();
			int intEng = vo.getEng();
			int intMath = vo.getMath();
			
			intTotal = intKor + intEng + intMath;
		}
		
		for(ScoreVO vo : sVOs) {
			System.out.println(vo.toString());
		}
		
	}
}
