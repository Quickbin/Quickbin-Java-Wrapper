package pw.quickbin.main.impl;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pw.quickbin.main.api.TokenRequest;
import pw.quickbin.main.exceptions.InvalidRequestException;
import pw.quickbin.main.exceptions.RateLimitedException;
import pw.quickbin.main.factory.ThreadFactory;
import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;

public class TokenRequestFactory implements TokenRequest {

    private final String email;
    private final ExecutorService service;
    private final OkHttpClient httpClient = new OkHttpClient();
    private final String BASE_URL = "https://quickbin.pw/api/v1/bot.php";

    public TokenRequestFactory(String email, ExecutorService service) {
        if (email == null || email.isEmpty())
            throw new InvalidParameterException("The email address cannot be empty or null, otherwise we have no way of sending the token to you.");

        this.service = (service == null ? new ThreadFactory().executorService : service);
        this.email = email;
    }

    /**
     * Creates a new bin with your token and user-agent.
     * @throws InvalidRequestException when the request is invalid.
     * @throws RateLimitedException when you are rate-limited (1,000 requests a day).
     * @return CompletableFuture<Void>
     */
    @Override @Nullable
    public CompletableFuture<Void> request() {
        return CompletableFuture.supplyAsync(() -> {
            Request request = new Request.Builder().url(BASE_URL).post(new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("email", email).addFormDataPart("method", "request").build()).build();

            // Parse response accordingly.
            try {
                    Response response = httpClient.newCall(request).execute();
                    if (!(Objects.isNull(response.body()))) {
                        if (response.code() != 200) {
                            throw (response.code() == 429 ? new RateLimitedException(true) : new InvalidRequestException(new JSONObject(response.body().string()).getString("response")));
                        }
                    }
            } catch (Exception exception) {
                throw new CompletionException(exception);
            }
            return null;
        }, service);
    }

}
