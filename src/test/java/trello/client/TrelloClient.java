package trello.client;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TrelloClient {
    private final RequestSpecification spec;

    public TrelloClient() {
        String key = System.getenv("TRELLO_KEY");
        String token = System.getenv("TRELLO_TOKEN");
        if (key == null || token == null) {
            throw new IllegalStateException("TRELLO_KEY / TRELLO_TOKEN bulunamadı. Run Config'e ekleyin.");
        }
        this.spec = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1")
                .setContentType(ContentType.JSON)
                .addQueryParam("key", key)
                .addQueryParam("token", token)
                .build();
    }

    protected RequestSpecification givenAuth() {
        return given().spec(spec);
    }
}
