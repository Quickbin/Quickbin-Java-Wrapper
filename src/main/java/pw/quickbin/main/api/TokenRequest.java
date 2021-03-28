package pw.quickbin.main.api;

import java.util.concurrent.CompletableFuture;

public interface TokenRequest {

    /**
     * Requests a token and user-agent to be sent towards your email.
     * @return a confirmation.
     */
    CompletableFuture<Void> request();

}
