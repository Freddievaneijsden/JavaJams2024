package com.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private final List<Restaurant> Restaurants = new ArrayList<>();
    private final Map<Restaurant, Restaurant> mismatchedRestaurants = new HashMap<>();
    List<String> listOfSurpriseExpressions = new ArrayList<>();

    public Model() {
        // Create restaurants
        Restaurant perspolis = new Restaurant("Perspolis", "Mölndalsvägen 95, 412 83 Göteborg", "Persiskt", "/com/example/javajams/images/Persiskmat.png.jpg", "https://perspolis.nu/");
        Restaurant lebaneseGrillhouse = new Restaurant("Lebanese Grillhouse", "Stampgatan 48", "Libanesiskt", "/com/example/javajams/images/Libanesiskt.png.png","https://www.lebanesgrillhouse.se/");
        Restaurant burgerKing = new Restaurant("Burger King", "Postgatan 47, 411 06 Göteborg", "Burgare", "/com/example/javajams/images/BurgerKing.png.png","https://burgerking.se/");
        Restaurant mcdonalds = new Restaurant("McDonalds", "Kungsportsavenyen 32, 411 36 Göteborg", "Burgare", "/com/example/javajams/images/McDonalds.png.png","https://www.mcdonalds.com/se/sv-se.html");
        Restaurant tacoBar = new Restaurant("Taco Bar", "Kyrkogatan 37, 411 08 Göteborg", "Mexikanskt", "/com/example/javajams/images/TacoBar.png","https://tacobar.se/");
        Restaurant lillaIstanbul = new Restaurant("Lilla Istanbul", "Färgfabriksgatan 1, 417 05 Göteborg", "Turkiskt", "/com/example/javajams/images/TurkiskMat.png","https://www.lilla-istanbul.se/");
        Restaurant pizzaHut = new Restaurant("Pizza Hut", "Postgatan 47, 411 06 Göteborg", "Pizza", "/com/example/javajams/images/PizzaHut.png","https://www.pizzahut.se/");
        Restaurant dominos = new Restaurant("Dominos", "Frida Hjertbergs Gata 10, 412 81 Göteborg", "Pizza", "/com/example/javajams/images/Domios.png","https://www.dominos.se/");
        Restaurant arojjDii = new Restaurant("Arojj Dii", "Viktor Rydbergsgatan 42, 412 57 Göteborg", "Thaimat", "/com/example/javajams/images/ThaiMat.png","https://order.happyorder.io/o/1581");
        Restaurant pho88 = new Restaurant("Pho88", "Fredriksdalsgatan 4A, 412 65 Göteborg", "Vietnamesiskt", "/com/example/javajams/images/Vietnameese.png","https://www.pho88.se/");
        Restaurant feskekorka = new Restaurant("Feskekorka", "Fisktorget 4, 411 20 Göteborg", "Svenskt", "/com/example/javajams/images/SurStrömming.png","");

        // Add restaurants to the list
        Restaurants.addAll(List.of(
                perspolis, lebaneseGrillhouse, burgerKing, mcdonalds, tacoBar,
                lillaIstanbul, pizzaHut, dominos, arojjDii, pho88, feskekorka
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
        mismatchedRestaurants.put(feskekorka, feskekorka);

        listOfSurpriseExpressions.add("Surprise! Utmana dina smaklökar med något oväntat!");
        listOfSurpriseExpressions.add("Tråkigt! Du borde testa det här istället!");
        listOfSurpriseExpressions.add("Det har du ätit 5 dagar i rad, dags att byta!");
        listOfSurpriseExpressions.add("Du verkar tveksam, låt oss välja mat åt dig!");
        listOfSurpriseExpressions.add("Lite nytt har ingen dött av!");
        listOfSurpriseExpressions.add("Vi tror du är sugen på något annat!");
        listOfSurpriseExpressions.add("Fortsätt inte i samma hjulspår, testa något nytt!");
        listOfSurpriseExpressions.add("Enligt vårt medium borde du äta detta för framtida lycka!");
        listOfSurpriseExpressions.add("Ska du verkligen äta detta igen? Här är ett annat förslag!");
        listOfSurpriseExpressions.add("Upptäck nya smaker med en oväntad överraskning!");
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

    public Restaurant getMismatchedRestaurant(Restaurant restaurant) {
        return mismatchedRestaurants.getOrDefault(restaurant, restaurant); // Return mismatched or the same if no mismatch exists
    }

    public String getRandomSurpriseLabel() {
        return listOfSurpriseExpressions.get((int) (Math.random() * listOfSurpriseExpressions.size()));
    }

}
