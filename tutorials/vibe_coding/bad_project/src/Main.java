import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();

    public static void main(String[] args) {
        seedSampleBooks();
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("请选择操作: ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            switch (line) {
                case "1" -> handleAdd(sc);
                case "2" -> handleBorrow(sc);
                case "3" -> handleReturn(sc);
                case "4" -> handleListAll();
                case "5" -> handleListAvailable();
                case "0" -> {
                    System.out.println("再见！");
                    sc.close();
                    return;
                }
                default -> System.out.println("无效选择，请重试。");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("==== 图书管理系统 ====");
        System.out.println("1. 添加图书");
        System.out.println("2. 借书");
        System.out.println("3. 还书");
        System.out.println("4. 列出所有图书");
        System.out.println("5. 列出可借图书");
        System.out.println("0. 退出");
    }

    private static void handleAdd(Scanner sc) {
        System.out.print("书名: ");
        String title = sc.nextLine().trim();
        if (title.isEmpty()) { System.out.println("书名不能为空。"); return; }
        System.out.print("作者: ");
        String author = sc.nextLine().trim();
        if (author.isEmpty()) author = "未知";
        int id = library.addBook(title, author);
        System.out.println("已添加: ID=" + id);
    }

    private static void handleBorrow(Scanner sc) {
        System.out.print("要借的书ID: ");
        String s = sc.nextLine().trim();
        try {
            int id = Integer.parseInt(s);
            boolean ok = library.borrowBook(id);
            if (ok) System.out.println("借书成功！");
            else System.out.println("借书失败：图书不存在或已被借出。");
        } catch (NumberFormatException e) {
            System.out.println("无效的ID。");
        }
    }

    private static void handleReturn(Scanner sc) {
        System.out.print("要还的书ID: ");
        String s = sc.nextLine().trim();
        try {
            int id = Integer.parseInt(s);
            boolean ok = library.returnBook(id);
            if (ok) System.out.println("还书成功！");
            else System.out.println("还书失败：图书不存在或未被借出。");
        } catch (NumberFormatException e) {
            System.out.println("无效的ID。");
        }
    }

    private static void handleListAll() {
        List<Book> all = library.listAll();
        if (all.isEmpty()) {
            System.out.println("没有图书。");
            return;
        }
        System.out.println("所有图书：");
        for (Book b : all) System.out.println(b);
    }

    private static void handleListAvailable() {
        List<Book> avail = library.listAvailable();
        if (avail.isEmpty()) {
            System.out.println("没有可借的图书。");
            return;
        }
        System.out.println("可借图书：");
        for (Book b : avail) System.out.println(b);
    }

    private static void seedSampleBooks() {
        library.addBook("Java 编程思想", "Bruce Eckel");
        library.addBook("算法导论", "CLRS");
        library.addBook("数据结构与算法", "作者A");
    }
}
