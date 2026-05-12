package com.ticketbooking.models;

public class Rating {
    private String userName;
    private int score; // 1 to 5
    private String feedback;

    public Rating(String userName, int score, String feedback) {
        this.userName = userName;
        this.score = score;
        this.feedback = feedback;
    }

    public int getScore() { return score; }

    @Override
    public String toString() {
        return "User: " + userName + " | Rating: " + score + "/5 | Feedback: " + feedback;
    }
}
