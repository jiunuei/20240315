import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/borrow-book")
    public ResponseEntity<?> borrowBook(@RequestBody Map<String, String> request) {
        String isbn = request.get("isbn");
        String userId = request.get("userId");

        // 檢查請求是否包含必要的資訊
        if (isbn == null || userId == null) {
            return ResponseEntity.badRequest().body("請提供書籍 ISBN 和使用者 ID");
        }

        // 使用 BookService 進行書籍借閱
        boolean isSuccess = bookService.borrowBook(isbn, userId);
        if (isSuccess) {
            // 書籍借閱成功
            return ResponseEntity.ok("書籍借閱成功");
        } else {
            // 書籍借閱失敗
            return ResponseEntity.badRequest().body("書籍借閱失敗");
        }
    }
}
