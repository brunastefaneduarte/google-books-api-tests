package google_api_test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
public class GoogleBooksServiceTest {

    @Autowired
    private GoogleBooksService googleBooksService;

    @Test
    void testGetBooks() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("Harry Potter"), "Resposta não contém o termo esperado no título ou subtítulo");
                })
                .expectComplete()
                .verify();
    }

    @Test
    void testBookTitle() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("Animais Fantásticos e Onde Habitam"), "O título do livro não está correto");
                })
                .expectComplete()
                .verify();
    }

    @Test
    void testBookAuthors() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("J.K. Rowling"), "O autor J.K. Rowling não está presente");
                    assertTrue(result.contains("Newt Scamander"), "O autor Newt Scamander não está presente");
                })
                .expectComplete()
                .verify();
    }

    @Test
    void testBookDescription() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("Um livro-texto aprovado da Escola de Magia e Bruxaria de Hogwarts"), "A descrição não está correta");
                })
                .expectComplete()
                .verify();
    }

    @Test
    void testBookPrice() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("14.9"), "O preço do livro não está correto");
                })
                .expectComplete()
                .verify();
    }

    @Test
    void testBookCoverImage() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("http://books.google.com/books/content?id=NEm4DgAAQBAJ"), "A URL da capa do livro não está correta");
                })
                .expectComplete()
                .verify();
    }

    @Test
    void testTotalItems() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("totalItems"), "A chave totalItems não foi encontrada na resposta");
                })
                .expectComplete()
                .verify();
    }

    @Test
    void testBookBuyLink() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("https://play.google.com/store/books/details?id=NEm4DgAAQBAJ"), "A URL de compra do livro não está presente");
                })
                .expectComplete()
                .verify();
    }

    @Test
    void testBookPublishedDate() {
        var response = googleBooksService.getBooks("harry potter");

        StepVerifier.create(response)
                .assertNext(result -> {
                    assertNotNull(result);
                    assertTrue(result.contains("2017-05-20"), "A data de publicação não está correta");
                })
                .expectComplete()
                .verify();
    }
}
