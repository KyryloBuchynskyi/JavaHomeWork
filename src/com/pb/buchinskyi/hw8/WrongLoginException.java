package com.pb.buchinskyi.hw8;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String s) {
        super(s);
    }
}
