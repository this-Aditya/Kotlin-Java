package org.example.callbacks;

interface AsyncCallback {
    void onSuccessListener(String result);
    void onFailureListener(String errorMessage);
}


