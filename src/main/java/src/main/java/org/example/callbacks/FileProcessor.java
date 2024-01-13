package org.example.callbacks;

public class FileProcessor {

    void processFile(String filePath, AsyncCallback callback) {
        // Simulating processing the file asynchronously
        new Thread(() -> {
            try {
                System.out.println("File processing started!!");
                Thread.sleep(3000);
                callback.onSuccessListener("File processed successfully!!"+ filePath);
            } catch (InterruptedException e) {
                callback.onFailureListener("Failure: Interrupted while accessing file!!");
            }
        }).start();
    }
}
