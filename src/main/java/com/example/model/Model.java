package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Restaurant> Restaurants = new ArrayList<Restaurant>();

    public Model() {
        Restaurants.add(new Restaurant("Perspolis", "Mölndalsvägen 95, 412 83 Göteborg", "Persiskt"));
        Restaurants.add(new Restaurant("Roku Sushi", "Falkenbergsgatan 4E, 412 84 Göteborg", "Sushi"));
        Restaurants.add(new Restaurant("Lilla Istanbul"," Färgfabriksgatan 1, 417 05 Göteborg","Turkiskt"));
        Restaurants.add(new Restaurant("Burger King", "Postgatan 47, 411 06 Göteborg", "Burgare"));
        Restaurants.add(new Restaurant("Taco Bar"," Kyrkogatan 37, 411 08 Göteborg","Mexikanskt"));
        Restaurants.add(new Restaurant("Pizza Hut"," Postgatan 47, 411 06 Göteborg","Amerikanskt"));
        Restaurants.add(new Restaurant("Arojj Dii","Viktor Rydbergsgatan 42, 412 57 Göteborg","Thaimat"));
        Restaurants.add(new Restaurant("Lebanese Grillhouse","Stampgatan 48","Libanesiskt"));


    }

    @Override
    public String toString() {
        return "Model{" +
                "Restaurants=" + Restaurants +
                '}';
    }

    public List<Restaurant> getRestaurants() {
        return Restaurants;
    }

    public Restaurant getRestaurantByIndex(int index) {
        if (index >= 0 && index < Restaurants.size()) {
            return Restaurants.get(index);
        } else {
            return null;  // Index out of bounds
        }
    }
}
