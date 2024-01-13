package org.example.callbacks;

public class AsyncCaller {
    public static void main(String[] args) {
        DataService dataService = new DataService();
        FileProcessor fileProcessor = new FileProcessor();

        // Example 1: Using callback with DataService
        dataService.fetchData(new AsyncCallback() {
            @Override
            public void onSuccessListener(String result) {
                System.out.println("DataService Callback: " + result);
            }

            @Override
            public void onFailureListener(String errorMessage) {
                System.err.println("DataService Callback Error: " + errorMessage);
            }
        });

        System.out.println("Some Work in caller executing asynchronously after making data service request.");

        // Example 2: Using callback with FileProcessor
        fileProcessor.processFile("example.txt", new AsyncCallback() {
            @Override
            public void onSuccessListener(String result) {
                System.out.println("FileProcessor Callback: " + result);
            }

            @Override
            public void onFailureListener(String errorMessage) {
                System.err.println("FileProcessor Callback Error: " + errorMessage);
            }
        });
        System.out.println("Some Work in caller executing asynchronously after making file processor request.");
    }
}
