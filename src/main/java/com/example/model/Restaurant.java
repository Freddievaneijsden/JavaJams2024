package com.example.model;

public class Restaurant {
        private final String name;
        private final String address;
        private final String cuisine;
        private final String backgroundImage;
        private final String website;

        public Restaurant(String name, String address, String cuisine, String backgroundImage, String website) {
            this.name = name;
            this.address = address;
            this.cuisine = cuisine;
            this.backgroundImage = backgroundImage;
            this.website = website;
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

        public String getBackgroundImage() {return backgroundImage;}

        public String getWebsite() {return website;}


    }
