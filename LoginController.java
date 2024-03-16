import org.springframework  .beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
public class LoginController {

    private UserService userService;

    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String phoneNumber = request.get("phoneNumber");
        String password = request.get("password");

        // 檢查請求是否包含必要的資訊
        if (phoneNumber == null || password == null) {
            return ResponseEntity.badRequest().body("請提供手機號碼和密碼");
        }

        // 使用 UserService 進行登入驗證
        boolean isValidUser = userService.validateUser(phoneNumber, password);
        if (isValidUser) {
            // 登入成功
            return ResponseEntity.ok("登入成功");
        } else {
            // 登入失敗
            return ResponseEntity.badRequest().body("手機號碼或密碼不正確");
        }
    }
}
