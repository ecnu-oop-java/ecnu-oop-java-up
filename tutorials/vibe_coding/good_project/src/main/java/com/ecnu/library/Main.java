package com.ecnu.library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("B001", "Java 核心技术", "Cay S. Horstmann", false);
        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch", false);
        Book b3 = new Book("B003", "重构", "Martin Fowler", false);

        System.out.println("=== 添加图书 ===");
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        printAvailableBooks(library.listAvailableBooks());

        System.out.println("\n=== 正常借阅与归还流程 ===");
        library.borrowBook("B001");
        System.out.println("借阅 B001 后可借图书:");
        printAvailableBooks(library.listAvailableBooks());

        library.returnBook("B001");
        System.out.println("归还 B001 后可借图书:");
        printAvailableBooks(library.listAvailableBooks());

        System.out.println("\n=== 异常边界情况演示 ===");

        try {
            library.addBook(new Book("B001", "重复 id 的书", "Unknown", false));
        } catch (IllegalArgumentException e) {
            System.out.println("添加重复 id 异常: " + e.getMessage());
        }

        try {
            library.borrowBook("B999");
        } catch (Exception e) {
            System.out.println("借阅不存在图书异常: " + e.getMessage());
        }

        try {
            library.borrowBook("B002");
            library.borrowBook("B002");
        } catch (Exception e) {
            System.out.println("重复借阅异常: " + e.getMessage());
        }

        try {
            library.returnBook("B003");
        } catch (Exception e) {
            System.out.println("归还未借出图书异常: " + e.getMessage());
        }

        try {
            library.returnBook("B999");
        } catch (Exception e) {
            System.out.println("归还不存在图书异常: " + e.getMessage());
        }
    }

    private static void printAvailableBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
