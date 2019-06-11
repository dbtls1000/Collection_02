package com.biz.controller;

import java.util.Random;

import com.biz.model.ScoreVO;

public class Score_Exec_04 {
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
			sVOs[i].setNumber("" + (i+1));//Integer.toString(i+1));
			sVOs[i].setKor(rnd.nextInt(50)+51);
			sVOs[i].setEng(rnd.nextInt(50)+51);
			sVOs[i].setMath(rnd.nextInt(50)+51);
			
			intTotal = sVOs[i].getKor();
			intTotal += sVOs[i].getEng();
			intTotal += sVOs[i].getMath();
			
			sVOs[i].setTotal(intTotal);
			sVOs[i].setAverage(intTotal/3);
			sVOs[i].setRank(i+1);
		}
		// 내용확인
		for(ScoreVO vo : sVOs) {
			System.out.println(vo.toString());
		}
		System.out.println("=====================================================");
		System.out.println("빅데이터반 성적 처리");
		System.out.println("=====================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("-----------------------------------------------------");
		for(ScoreVO vo : sVOs) {
			System.out.printf("%s\t%3d\t%3d\t%3d\t%3d\t%5d\t%3d\n",
					vo.getNumber(),
					vo.getKor(),
					vo.getEng(),
					vo.getMath(),
					vo.getTotal(),
					vo.getAverage(),
					vo.getRank()
			);
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("=====================================================");
	}
}
