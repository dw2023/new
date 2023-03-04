package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.util.HashMap;
import java.util.Map;

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
           } else if (command.startsWith("삭제")) { // 명령어: '삭제?id=1&authorName=홍길동'
               // 정리 시작

               String[] commandBits = command.split("\\?", 2);
               // ? 앞에는 "\\"를 써줘야 함
               // limit: 2 = 최대 두 개까지 나눈다
               String actionCode = commandBits[0];
               Map<String, String> params= new HashMap<>(); // Map에 'id=1&authorName=홍길동' 저장
               String[] paramsBits = commandBits[1].split("&"); // 'id=1&authorName=홍길동'을 "&"로 나누기

               for ( String paramStr : paramsBits ) {
                   String[] paramStrBits = paramStr.split("=", 2); // "id=1" 을 "="기준으로 나누기
                   String key = paramStrBits[0];
                   String value = paramStrBits[1];

                   params.put(key, value);
               }
               System.out.printf("actionCode : %s\n", actionCode);
               System.out.printf("params : %s\n", params);

               // 정리 끝
               wiseSayingController.remove(); // command 넘겨주기
           }
       }
    }
}

