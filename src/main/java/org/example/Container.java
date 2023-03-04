package org.example;

import java.util.Scanner;

// sc를 누구나 접근할 수 있는 공간에 두기 위해 Container 클래스 생성
public class Container {
    private static Scanner sc;

    /* static 변수 전용 생성자 : Container 객체생성 안해도 프로그램 실행 시 자동실행
    static {
        init();
    } */

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    // 다른 클래스들이 모두 접근가능하도록 static 메서드 생성
    // static 메서드는 static에만 접근가능하므로 7번 코드에도 static 붙임
    public static Scanner getScanner() {
        return sc;
    }
}
