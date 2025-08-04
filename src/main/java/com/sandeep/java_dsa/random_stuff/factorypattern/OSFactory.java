package com.sandeep.java_dsa.random_stuff.factorypattern;

public class OSFactory {
    public OS getInstance(String s){
        return switch (s) {
            case "Open-source" -> new LinuxOS();
            case "Secure" -> new IOS();
            case "popular" -> new WindowsOS();
            default -> null;
        };
    }
}
