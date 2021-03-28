package pw.quickbin.main.api;

import java.util.concurrent.CompletableFuture;

public interface QuickBin {

    CompletableFuture<Void> editBin(String bin, String content, String language);
    CompletableFuture<Void> deleteBin(String bin);
    CompletableFuture<Bin> createBin(String content, String language);

}
