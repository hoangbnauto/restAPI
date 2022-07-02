package ThreadLocal;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeWithAllData {
    public static void main(String[] args) throws JsonProcessingException {
        Book book = new Book();

        book.setBookName("halo");
        book.setAuthor("halo2");

        ObjectMapper objectMapper = new ObjectMapper();
        String bookObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);

        System.out.println(bookObject);

        Book book1 = objectMapper.readValue(bookObject, Book.class);
        System.out.println(book1.getBookName());
        System.out.println(book1.getAuthor());



    }
}
