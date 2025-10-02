package trello.endpoints;

import trello.client.TrelloClient;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardService extends TrelloClient {

    public String createBoard(String name) {
        Response res = givenAuth()
                .queryParam("name", name)
                .post("/boards");
        assertEquals(200, res.statusCode(), "Board create failed");
        return res.jsonPath().getString("id");
    }

    public List<Map<String, Object>> getLists(String boardId) {
        Response res = givenAuth().get("/boards/{id}/lists", boardId);
        assertEquals(200, res.statusCode(), "Get board lists failed");
        return res.jsonPath().getList("$");
    }

    public void deleteBoard(String boardId) {
        int code = givenAuth().delete("/boards/{id}", boardId).statusCode();
        assertEquals(200, code, "Delete board failed");
    }
}
