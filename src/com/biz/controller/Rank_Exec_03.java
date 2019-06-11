package com.biz.controller;

import java.util.Random;

public class Rank_Exec_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intNum = new int[10];
		int[] intKor = new int[10];
		int[] intEng = new int[10];
		int[] intMath = new int[10];
		int[] intTotal = new int[10];
		Random rnd = new Random();
		
		for(int i = 0 ; i < intNum.length ; i++) {
			int kor = rnd.nextInt(50)+51;
			int eng = rnd.nextInt(50)+51;
			int math = rnd.nextInt(50)+51;
			
			intNum[i] = i+1;
			intKor[i] = kor; 
			intEng[i] = eng;
			intMath[i] = math;
			intTotal[i] = kor + eng + math;
			
		}
		System.out.println("     빅데이터반 학업평가 점수    ");
		System.out.println("====================================");
		System.out.printf("%s\t%s\t%s\t%s\t%s\t\n","학번","국어","영어","수학","총점");
		System.out.println("====================================");
		for(int i = 0 ; i <intNum.length ; i++) {
			System.out.printf("%s\t%s\t%s\t%s\t%s\t\n",intNum[i],intKor[i],intEng[i],intMath[i],intTotal[i]);	
		}
		
		for(int i= 0 ;i<intNum.length;i++) {
			for(int j = i+1 ; j<intNum.length;j++) {
				if(intTotal[i] > intTotal[j]) {
					int t = intTotal[i];
					intTotal[i] = intTotal[j];
					intTotal[j] = t;
					
					int t1 = intNum[i];
					intNum[i] = intNum[j];
					intNum[j] = t1;
					
					int t2 = intKor[i];
					intKor[i] = intKor[j];
					intKor[j] = t2;
					
					int t3 = intEng[i];
					intEng[i] = intEng[j];
					intEng[j] = t3;
					
					int t4 = intMath[i];
					intMath[i] = intMath[j];
					intMath[j] = t4;
				}
			}
		}
		System.out.println("====================================");
		for(int i = 0 ; i <intNum.length ; i++) {
			System.out.printf("%s\t%s\t%s\t%s\t%s\t\n",intNum[i],intKor[i],intEng[i],intMath[i],intTotal[i]);	
		}
	
		
		
		
		
	}

}
