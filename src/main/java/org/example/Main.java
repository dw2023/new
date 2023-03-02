package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new App(sc).run();
        // run()을 실제로 구현하기 전에 ctrl + 1하면, run()이 클래스 App에 자동생성됨
        // Main 클래스가 만든 Scanner를 App 클래스도 쓸 수 있도록 객체를 생성자를 통해 넘겨줬다.

        sc.close();
    }
}