package com.example.kmpcustomviews;


public interface ApplicationInitializationListener {
    public void onInitializationSuccess();
    public void onInitializationError(String err);
    public void appAlreadyInitiated();
    enum InitializationStatus{
        ERROR,
        SUCCESS
    }
}
