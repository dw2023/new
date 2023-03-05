package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    private long lastWiseSayingId; // while문 안에 넣으면 계속 0으로 초기화됨
    private final List<WiseSaying> wiseSayings; // 없어지지 않게 while문 밖에 만들기
    // final: ArrayList를 한 번만 만들면 되기 때문

    // 생성자 추가 (생성자 안에서 위 2개의 값 대입)
    public WiseSayingController() {
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void write() {
        long id = lastWiseSayingId + 1;
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String authorName = Container.getScanner().nextLine().trim();

        // WiseSaying 객체 만들기
        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);

        // WiseSaying 객체를 List나 배열에 저장하지 않으면 이 중괄호가 끝나고 사라짐.
        // 명언을 무한히 입력할 수 있게 WiseSaying 객체를 List에 저장
        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        lastWiseSayingId = id; // lastWiseSayingId를 1 증가
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(22));

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
        }
    }

    public void remove(Rq rq) {
        // "id"의 value를 정수화해서 리턴해주는 메서드 (실패 시 -1 리턴)
        int id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        WiseSaying wiseSaying = findById(id);

        // 찾은 명언객체를 List에서 제거
        wiseSayings.remove(wiseSaying);

        /* wiseSayings.remove(id - 1);
        안되는 이유: 중간에 삭제된 명언이 있을 경우 index가 'id-1'이 아니다 */

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    private WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }
}
