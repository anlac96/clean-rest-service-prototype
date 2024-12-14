package org.github.anlac96.cleanrestserviceprototype.book.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.github.anlac96.cleanrestserviceprototype.book.model.Book;
import org.github.anlac96.cleanrestserviceprototype.book.restapi.converter.BookRequestConverter;
import org.github.anlac96.cleanrestserviceprototype.book.restapi.dto.CreateBookRequest;
import org.github.anlac96.cleanrestserviceprototype.book.restapi.dto.UpdateBookRequest;
import org.github.anlac96.cleanrestserviceprototype.book.service.BookService;

import java.util.List;
import java.util.Optional;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookApi {

    private final BookService bookService;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @POST
    public Response createBook(CreateBookRequest book) {
        Book bookEntity = BookRequestConverter.INSTANCE.toBook(book);
        Book createdBook = bookService.createBook(bookEntity);
        return Response.status(Response.Status.CREATED).entity(createdBook).build();
    }

    @GET
    @Path("/{bookId}")
    public Response getBookById(@PathParam("bookId") String bookId) {
        Optional<Book> book = bookService.getBookById(bookId);
        if (book.isPresent()) {
            return Response.ok(book.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Book not found with ID: " + bookId).build();
        }
    }

    @GET
    public Response getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return Response.ok(books).build();
    }

    @PUT
    @Path("/{bookId}")
    public Response updateBook(@PathParam("bookId") String bookId, UpdateBookRequest book) {
        try {
            Book bookEntity = BookRequestConverter.INSTANCE.toBook(book);
            bookEntity.setBookId(bookId);
            Book updatedBook = bookService.updateBook(bookEntity);
            return Response.ok(updatedBook).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{bookId}")
    public Response deleteBook(@PathParam("bookId") String bookId) {
        try {
            bookService.deleteBook(bookId);
            return Response.noContent().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
