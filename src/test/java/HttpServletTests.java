import com.example.practice.command.Command;
import com.example.practice.command.impl.alien.ViewAlienCommand;
import com.example.practice.command.impl.alien.add.ForwardAlienCommand;
import com.example.practice.command.impl.review.ForwardReviewCommand;
import com.example.practice.command.impl.user.LoginCommand;
import com.example.practice.command.impl.user.ViewCommand;
import com.example.practice.exception.CommandException;
import org.junit.jupiter.api.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HttpServletTests {
    Command view = new ViewCommand();
    Command login = new LoginCommand();
    Command forwardReview = new ForwardReviewCommand();
    Command viewAlien = new ViewAlienCommand();

    @Test
    void testViewAlienShouldReturnAdminPage() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("page")).thenReturn("admin");
        try {
            String execute = viewAlien.execute(request);
            assertThat(execute).isEqualTo("pages/admin/views/alien-page.jsp");
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testForwardReviewShouldReturnReviewPage() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("page")).thenReturn("admin");
        try {
            String execute = forwardReview.execute(request);
            assertThat(execute).isEqualTo("pages/admin/views/review-page.jsp");
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testViewCommandShouldViewUsers() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("block")).thenReturn("0");
        try {
            String execute = view.execute(request);
            assertThat(execute).isEqualTo("pages/admin/views/view-users.jsp");
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testLoginCommandWrongLoginAndPassWordParamShouldResultInLoginErrorPage() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("Mockito");
        when(request.getParameter("password")).thenReturn("Test");

        try {
            String execute = login.execute(request);
            assertThat(execute).isEqualTo("pages/errors/login-error.jsp");
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
    }
}
