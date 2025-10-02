package trello.tests;

import org.junit.jupiter.api.Test;
import trello.endpoints.BoardService;
import trello.endpoints.CardService;


public class TrelloFlowTest {

    @Test
    void e2e_board_cards_update_delete() {
        BoardService boards = new BoardService();
        CardService cards  = new CardService();

        String boardId = null, listId, c1 = null, c2 = null;
        try {
            // 1) Board
            boardId = boards.createBoard("case-study-board");
            // 2) List
            var lists = boards.getLists(boardId);
            listId = lists.get(0).get("id").toString();

            // 3) 2 Kart
            c1 = cards.createCard(listId, "ilk kart");
            c2 = cards.createCard(listId, "ikinci kart");

            // 4) Random birini güncelle
            String toUpdate = trello.util.RandomUtil.pickOne(java.util.List.of(c1, c2));

            cards.updateCardName(toUpdate, "guncellenmis kart");

        } finally {
            // 5) Kartları sil
            if (c1 != null) cards.deleteCard(c1);
            if (c2 != null) cards.deleteCard(c2);
            // 6) Board'u sil
            if (boardId != null) boards.deleteBoard(boardId);
        }
    }

}
