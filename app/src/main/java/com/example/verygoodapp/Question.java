package com.example.verygoodapp;

public class Question {

    private String mQuestions [] = {
            "W którym roku zaczęto produkcję BMW E39?",
            "Who's the best?",
            "Chrzest Polski odbył się w roku:",
            "W jakiej wsi rozgrywa się akcja powieści Władysława Rejmonta pt. 'Chłopi'?",
            "2+2*2(3+4)",
            "Jak oceniesz tę aplikację?",
            ""
    };

    private String mChoices [][] = {
            {"1993", "1995", "2000", "1999"},
            {"dr Mariusz Kralewski", "dr Dariusz Krasucki", "dr O.Ngal", "dr Dariusz Kralewski"},
            {"669", "420", "966", "997"},
            {"Kamieniec", "Krasy", "Lipce", "Druskienna"},
            {"56", "30", "42", "Za mało danych"},
            {"5", "5", "5", "5"},
            {"", "", "", ""}
    };

    private String mCorrectAnswers[] = {"1995","dr Dariusz Kralewski","966","Lipce","30","5",""};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
