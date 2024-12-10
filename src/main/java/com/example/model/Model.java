package com.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private final List<Restaurant> Restaurants = new ArrayList<>();
    private final Map<Restaurant, Restaurant> mismatchedRestaurants = new HashMap<>();

    private final Surstromming surstromming = new Surstromming(
            "Nu skojar du med mig valde du SURSTRÖMMING",
            "Det måste ju vara något riktigt fel på dig",
            "/com/example/javajams/images/SurStrömming.png"
    );

    public Model() {
        // Create restaurants
        Restaurant perspolis = new Restaurant("Perspolis", "Mölndalsvägen 95, 412 83 Göteborg", "Persiskt", "/com/example/javajams/images/Persiskmat.png.jpg");
        Restaurant lebaneseGrillhouse = new Restaurant("Lebanese Grillhouse", "Stampgatan 48", "Libanesiskt", "/com/example/javajams/images/Libanesiskt.png.png");
        Restaurant burgerKing = new Restaurant("Burger King", "Postgatan 47, 411 06 Göteborg", "Burgare", "/com/example/javajams/images/BurgerKing.png.png");
        Restaurant mcdonalds = new Restaurant("McDonalds", "Kungsportsavenyen 32, 411 36 Göteborg", "Burgare", "/com/example/javajams/images/McDonalds.png.png");
        Restaurant tacoBar = new Restaurant("Taco Bar", "Kyrkogatan 37, 411 08 Göteborg", "Mexikanskt", "/com/example/javajams/images/TacoBar.png");
        Restaurant lillaIstanbul = new Restaurant("Lilla Istanbul", "Färgfabriksgatan 1, 417 05 Göteborg", "Turkiskt", "/com/example/javajams/images/TurkiskMat.png");
        Restaurant pizzaHut = new Restaurant("Pizza Hut", "Postgatan 47, 411 06 Göteborg", "Pizza", "/com/example/javajams/images/PizzaHut.png");
        Restaurant dominos = new Restaurant("Dominos", "Frida Hjertbergs Gata 10, 412 81 Göteborg", "Pizza", "/com/example/javajams/images/Domios.png");
        Restaurant arojjDii = new Restaurant("Arojj Dii", "Viktor Rydbergsgatan 42, 412 57 Göteborg", "Thaimat", "/com/example/javajams/images/ThaiMat.png");
        Restaurant pho88 = new Restaurant("Pho88", "Fredriksdalsgatan 4A, 412 65 Göteborg", "Vietnamesiskt", "/com/example/javajams/images/Vietnameese.png");
        Restaurant feskekorka = new Restaurant("Feskekorka", "Fisktorget 4, 411 20 Göteborg", "Svenskt", "/com/example/javajams/images/SurStrömming.png");
        Restaurant rokuSushi = new Restaurant("Roku Sushi", "Falkenbergsgatan 4E, 412 84 Göteborg", "Sushi", "/com/example/javajams/images/Sushi.png");

        // Add restaurants to the list
        Restaurants.addAll(List.of(
                perspolis, lebaneseGrillhouse, burgerKing, mcdonalds, tacoBar,
                lillaIstanbul, pizzaHut, dominos, arojjDii, pho88, feskekorka, rokuSushi
        ));

        // Create mismatched associations
        mismatchedRestaurants.put(perspolis, lebaneseGrillhouse);
        mismatchedRestaurants.put(lebaneseGrillhouse, perspolis);
        mismatchedRestaurants.put(mcdonalds, burgerKing);
        mismatchedRestaurants.put(burgerKing, mcdonalds);
        mismatchedRestaurants.put(lillaIstanbul, tacoBar);
        mismatchedRestaurants.put(tacoBar, lillaIstanbul);
        mismatchedRestaurants.put(dominos, pizzaHut);
        mismatchedRestaurants.put(pizzaHut, dominos);
        mismatchedRestaurants.put(pho88, arojjDii);
        mismatchedRestaurants.put(arojjDii, pho88);
        mismatchedRestaurants.put(feskekorka, rokuSushi);
        mismatchedRestaurants.put(rokuSushi, feskekorka);
        // You can add more mismatched logic as needed
    }

    @Override
    public String toString() {
        return "Model{" +
                "Restaurants=" + Restaurants +
                "Surströmming =" + surstromming +
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

    public Surstromming getSurstromming() {
        return surstromming;
    }

    public Restaurant getMismatchedRestaurant(Restaurant restaurant) {
        return mismatchedRestaurants.getOrDefault(restaurant, restaurant); // Return mismatched or the same if no mismatch exists
    }
}
