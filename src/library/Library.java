package library;

import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();
    private Map<Integer, Member> members = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void deleteBook(int bookId) {
        boolean removed = books.removeIf(b -> b.getBookId() == bookId);
        if (removed) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("Member added successfully.");
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }

    public void issueBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && !book.isIssued()) {
                book.setIssued(true);
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && book.isIssued()) {
                book.setIssued(false);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid return request.");
    }
}
