package org.example.callbacks;

import java.util.Random;

public class DataService {

    public void fetchData(AsyncCallback callback) {
        // Simulating fetching the data
        new Thread(() -> {
           try {
               System.out.println("Data fetching started!!");
               Thread.sleep(2000); // Simulating the delay!!
               int random = new Random().nextInt(10);
               if (random < 5) {
                   callback.onSuccessListener("Data fetched successfully!!");
               } else {
                   callback.onFailureListener("Error: Unable to fetch the data!!");
               }
           } catch(InterruptedException ex) {
               callback.onFailureListener("Failure: Interrupted while fetching the data");
           }
        }).start();
    }
}
