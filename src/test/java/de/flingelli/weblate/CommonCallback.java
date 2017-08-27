package de.flingelli.weblate;

import org.mockserver.mock.action.ExpectationCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.mockserver.model.Header.header;
import static org.mockserver.model.HttpResponse.notFoundResponse;
import static org.mockserver.model.HttpResponse.response;

public class CommonCallback implements ExpectationCallback  {

    @Override
    public HttpResponse handle(HttpRequest httpRequest) {
        String path = getPath(httpRequest);
        File file = new File("src/test/resources" + path + "/content.json");
        if (file.exists()) {
            return getHttpResponse(file);
        } else {
            return notFoundResponse();
        }
    }

    private String getPath(HttpRequest httpRequest){
        int index = httpRequest.getPath().getValue().indexOf("/api");
        if (index < 0) {
            return "/api";
        } else {
            return httpRequest.getPath().getValue().substring(index);
        }
    }

    private HttpResponse getHttpResponse(File file) {
        byte[] content;
        try {
            content = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            content = new byte[]{};
        }
        return response()
                .withStatusCode(200)
                .withHeaders(
                        header("Content-Length", "a_callback_response".getBytes().length),
                        header("Content-Type", "application/json"),
                        header("Authorization", "password"),
                        header("Allow", "GET, HEAD, OPTIONS"),
                        header("Vary", "Accept")
                )
                .withBody(new String(content));
    }
}
