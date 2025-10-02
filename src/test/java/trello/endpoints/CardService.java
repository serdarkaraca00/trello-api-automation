package trello.endpoints;

import trello.client.TrelloClient;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardService extends TrelloClient {

    public String createCard(String listId, String name) {
        Response res = givenAuth()
                .queryParam("idList", listId)
                .queryParam("name", name)
                .post("/cards");
        assertEquals(200, res.statusCode(), "Create card failed");
        return res.jsonPath().getString("id");
    }

    public void deleteCard(String cardId) {
        int code = givenAuth().delete("/cards/{id}", cardId).statusCode();
        assertEquals(200, code, "Delete card failed");
    }

    public void updateCardName(String cardId, String newName) {
        int code = givenAuth()
                .queryParam("name", newName)
                .put("/cards/{id}", cardId)
                .statusCode();
        assertEquals(200, code, "Update card failed");
    }
}
