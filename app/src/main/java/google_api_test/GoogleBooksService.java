package google_api_test;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GoogleBooksService {
    public static final String URL = "https://www.googleapis.com/books/v1/volumes";
    private final WebClient webClient;

    public GoogleBooksService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(URL).build();
    }

    public Mono<String> getBooks(String query) {
        return this.webClient.get()
                .uri("?q=" + query)
                .retrieve()
                .bodyToMono(String.class);
    }
}
