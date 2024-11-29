package com.example.modul;

public class Restaurant {
        private final String name;
        private final String address;
        private final String cuisine;

        public Restaurant(String name, String address, String cuisine) {
            this.name = name;
            this.address = address;
            this.cuisine = cuisine;
        }

        // Getters and setters...
        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getCuisine() {
            return cuisine;
        }


    }
