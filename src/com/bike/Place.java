package com.bike;

//dodanie dwoch nowych pol - latitude, longtitude
//modyfikacja konstruktora o te dwa nowe pola
//dodanie getterow do tych pol
public class Place {

    private String name;

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
