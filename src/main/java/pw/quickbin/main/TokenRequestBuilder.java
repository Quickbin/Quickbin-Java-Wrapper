package pw.quickbin.main;

import pw.quickbin.main.api.TokenRequest;
import pw.quickbin.main.impl.TokenRequestFactory;

import java.util.concurrent.ExecutorService;

public class TokenRequestBuilder {

    private String email;
    private ExecutorService service;

    /**
     * Sets the email where the token and user-agent will be sent.
     * @param email the email address.
     * @return builder for chain requests.
     */
    public TokenRequestBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    /**
     * Sets the executor service for the requests, can be null.
     * @param service the executor service to use (can be null).
     * @return builder for chain requests.
     */
    public TokenRequestBuilder setExecutorService(ExecutorService service){
        this.service = service;
        return this;
    }

    public TokenRequest build(){
        return new TokenRequestFactory(email, service);
    }

}
