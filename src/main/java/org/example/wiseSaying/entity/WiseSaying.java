package org.example.wiseSaying.entity;

public class WiseSaying {
    private long id;
    private String content;
    private String authorName;

    // alt + insert -> constructor : 생성자 만들기
    public WiseSaying(long id, String content, String authorName) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }

    // alt + insert -> Getter 메서드 만들기
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }
}
