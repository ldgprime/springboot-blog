package com.ldg.blog.model;

public interface ReturnCode {
	//interface 변수는 public static finally
	int 아이디중복 = -2;
	int 오류 = -1;
	int 성공 = 1;
	int 무반응 = 2;
	int 권한없음 = -3;
}
