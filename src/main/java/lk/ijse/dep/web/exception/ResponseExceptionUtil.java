package lk.ijse.dep.web.exception;

import lk.ijse.dep.web.dto.ErrorDTO;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseExceptionUtil {

    public static void handle(Throwable t, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        Jsonb jsonb = JsonbBuilder.create();
        ErrorDTO dto = new ErrorDTO();
        dto.setError("Internal server error");
        dto.setMessage(t.getMessage());

        if (t instanceof HttpResponseException) {
            HttpResponseException ex = (HttpResponseException) t;
            dto.setStatus(ex.getStatusCode());
            resp.setStatus(ex.getStatusCode());
            switch (ex.getStatusCode()) {
                case 400:
                    dto.setError("Bad request");
                    dto.setMessage(ex.getMessage());
                    break;
                case 404:
                    dto.setError("Not found");
                    dto.setMessage(ex.getMessage());
                    break;
                case 500:
                    ex.printStackTrace();
                    break;
                default:
                    // We are good here :)
            }
        } else {
            resp.setStatus(500);
            t.printStackTrace();
        }
        resp.getWriter().println(jsonb.toJson(dto));

    }

}
