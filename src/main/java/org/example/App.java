package org.example;

import java.util.Scanner;

public class App {
    private final Scanner sc; // final: 딱 한 번만 값을 대입할 수 있음 (수정불가)

    // 생성자
    // Main 클래스가 만든 Scanner를 App 클래스도 쓸 수 있도록 객체를 생성자를 통해 넘겨줬다.
    public App(Scanner sc) {
        this.sc = sc;
    }
    public void run() {
        System.out.println("== 명언 앱 ==");

        // '종료'가 입력될 때는 제외하고 계속 반복해야 함 -> while
        // 그렇지 않으면 enter만 쳐도 종료됨
       while (true) {
           System.out.print("명령) ");
           String command = sc.nextLine().trim();
           // .trim() : (혹시 있을지도 모를) 문자열의 좌우공백을 없앤 새로운 문자열을 리턴
           // "  종료 "가 입력되도 종료시키기 위해서

           if ( command.equals("종료")) {
               break;
           } else if (command.equals("등록")) {
               System.out.print("명언 : ");
               String content = sc.nextLine().trim();
               System.out.print("작가 : ");
               String authorName = sc.nextLine().trim();

               System.out.println("1번 명언이 등록되었습니다.");
           }
       }
    }
}

