package com.example.model;

public class Surstromming {
    private final String Judgement;
    private final String Message;
    private final String BackGroundImage;

    public Surstromming(String Judgement, String Message, String BackGroundImage) {
        this.Judgement = Judgement;
        this.Message = Message;
        this.BackGroundImage = BackGroundImage;
    }

    public String getJudgement() { return Judgement; }
    public String getMessage() { return Message; }
    public String getBackGroundImage() { return BackGroundImage; }

}

