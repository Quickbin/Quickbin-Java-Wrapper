package pw.quickbin.main.api;

import pw.quickbin.main.exceptions.InvalidRequestException;
import pw.quickbin.main.exceptions.RateLimitedException;

import java.util.concurrent.CompletableFuture;

public interface QuickBin {

    /**
     * Edits a bin if it exists and is also owned by your token.
     * @throws InvalidRequestException when the request is invalid.
     * @throws RateLimitedException when you are rate-limited (1,000 requests a day).
     * @param bin the bin to edit.
     * @param content the new contents of the bin.
     * @param language the new language of the bin.
     * @return CompletableFuture<Void>
     */
    CompletableFuture<Void> editBin(String bin, String content, String language);

    /**
     * Edits a bin if it exists and is also owned by your token.
     * @throws InvalidRequestException when the request is invalid.
     * @throws RateLimitedException when you are rate-limited (1,000 requests a day).
     * @param bin the bin to edit.
     * @param content the new contents of the bin.
     * @return CompletableFuture<Void>
     */
    CompletableFuture<Void> editBin(String bin, String content);


    /**
     * Deletes a bin if it exists and is also owned by your token.
     * @throws InvalidRequestException when the request is invalid.
     * @throws RateLimitedException when you are rate-limited (1,000 requests a day).
     * @param bin the bin to delete.
     * @return CompletableFuture<Void>
     */
    CompletableFuture<Void> deleteBin(String bin);

    /**
     * Creates a new bin with your token and user-agent.
     * @throws InvalidRequestException when the request is invalid.
     * @throws RateLimitedException when you are rate-limited (1,000 requests a day).
     * @param content the content of the bin.
     * @param language the language of the bin.
     * @return CompletableFuture<Bin>
     */
    CompletableFuture<Bin> createBin(String content, String language);

}
