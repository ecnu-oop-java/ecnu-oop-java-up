import java.util.*;

public class Library {
    private final Map<Integer, Book> books = new LinkedHashMap<>();
    private int nextId = 1;

    public synchronized int addBook(String title, String author) {
        int id = nextId++;
        Book b = new Book(id, title, author);
        books.put(id, b);
        return id;
    }

    public synchronized boolean borrowBook(int id) {
        Book b = books.get(id);
        if (b == null) return false;
        if (!b.isAvailable()) return false;
        b.setAvailable(false);
        return true;
    }

    public synchronized boolean returnBook(int id) {
        Book b = books.get(id);
        if (b == null) return false;
        if (b.isAvailable()) return false;
        b.setAvailable(true);
        return true;
    }

    public synchronized List<Book> listAll() {
        return new ArrayList<>(books.values());
    }

    public synchronized List<Book> listAvailable() {
        List<Book> res = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.isAvailable()) res.add(b);
        }
        return res;
    }

    public synchronized Optional<Book> getBook(int id) {
        return Optional.ofNullable(books.get(id));
    }
}
