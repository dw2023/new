package org.example;

import java.util.ArrayList;
import java.util.List;
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

        long lastWiseSayingId = 0; // while문 안에 넣으면 계속 0으로 초기화됨
        List<WiseSaying> wiseSayings = new ArrayList<>(); // 없어지지 않게 while문 밖에 만들기

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
               long id = lastWiseSayingId + 1;
               System.out.print("명언 : ");
               String content = sc.nextLine().trim();
               System.out.print("작가 : ");
               String authorName = sc.nextLine().trim();

               // WiseSaying 객체 만들기
               WiseSaying wiseSaying = new WiseSaying(id, content, authorName);

               // WiseSaying 객체를 List나 배열에 저장하지 않으면 이 중괄호가 끝나고 사라짐.
               // 명언을 무한히 입력할 수 있게 WiseSaying 객체를 List에 저장
               wiseSayings.add(wiseSaying);

               System.out.printf("%d번 명언이 등록되었습니다.\n", id);
               lastWiseSayingId = id; // lastWiseSayingId를 1 증가
           } else if (command.equals("목록")) {
               System.out.println("번호 / 작가 / 명언");
               System.out.println("-".repeat(22));

               for (int i = wiseSayings.size() - 1; i >= 0 ; i--) {
                   WiseSaying wiseSaying = wiseSayings.get(i);
                   System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
               }
           }
       }
    }
}

