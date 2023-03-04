package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        // 리팩토링하기 위해 SystemController, WiseSayingController 클래스 객체 생성
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        // '종료'가 입력될 때는 제외하고 계속 반복해야 함 -> while
        // 그렇지 않으면 enter만 쳐도 종료됨
       while (true) {
           System.out.print("명령) ");
           String command = Container.getScanner().nextLine().trim();
           // Container.getScanner(): 클래스 Container에서 sc 가져오기

           if ( command.equals("종료")) {
               systemController.exit();
               break;
           } else if (command.equals("등록")) {
               wiseSayingController.write();
           } else if (command.equals("목록")) {
               wiseSayingController.list();
           }
       }
    }
}

