package com.biz.controller;

import java.util.Random;

import com.biz.model.ScoreVO;

public class ScoreRankExec_01 {
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
		
		// 부등호의 방향 > : 오름차순 정렬
		// 부등호의 방향 < : 내림차순 정렬
		for(int i = 0 ; i < sVOs.length ; i++) {
			for(int j = i + 1 ; j< sVOs.length ; j++) {
				if(sVOs[i].getTotal() < sVOs[j].getTotal()) {
					
					ScoreVO _score = sVOs[i];
					sVOs[i] = sVOs[j];
					sVOs[j] = _score;
				}
			}
		}
		
		// 내림차순 정렬된 상태에서 rank 필드에 석차를 추가
		for(int i = 0 ; i < sVOs.length; i++) {
			sVOs[i].setRank(i+1);
		}
		
		// 석차를 추가한 후에 다시 학번순으로 정렬
		for(int i = 0 ; i < sVOs.length ; i++) {
			for(int j = i + 1 ; j< sVOs.length ; j++) {
				
				// number필드가 String형이므로
				// 숫자로 변경한 다음 비교한다
				if(Integer.valueOf(sVOs[i].getNumber()) > Integer.valueOf(sVOs[j].getTotal())) {
					
					ScoreVO _score = sVOs[i];
					sVOs[i] = sVOs[j];
					sVOs[j] = _score;
				}
			}
		}
		
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
