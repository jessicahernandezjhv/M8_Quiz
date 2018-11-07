package com.m8.jessica_hernandez.quizy;

public class QuestionList {

    private static final Question[] questions = new Question[] {
            new Question("Madrid es la capital de España?", true,
                    R.drawable.ic_dashboard_black_24dp),
            new Question("Francia esta en Europa?", true,
                    R.drawable.ic_home_black_24dp),
            new Question("Los pirineos estan en el reino unido?", false,
                    R.drawable.ic_launcher_background),
            new Question("Sudafrica esta en el emisferio norte.", false,
                    R.drawable.ic_launcher_foreground),
            new Question("Cataluña esta en españa?", true,
                    R.drawable.ic_notifications_black_24dp),
            new Question("España es un estado de los estados unidos\n de america(EUA).", false,
                    R.drawable.ic_notifications_black_24dp),
            new Question("El instituto Joan de Áustria esta en Barcelona?", true,
                    R.drawable.ic_launcher_foreground),
    };

    private static int nextQuestion = 0;

    public static boolean next(){
        if (++nextQuestion < questions.length) {
            return true;
        } else {
            nextQuestion--;
            return false;
        }
    }

    public static boolean checkAnswere(boolean answere) {
        return questions[nextQuestion].getAnswere() == answere;
    }

    public static void reset() {
        nextQuestion = 0;
    }

    public static String getCurrentQuestionText() {
        return questions[nextQuestion].getText();
    }

    public static int getCurrentQuestionHint() {
        return questions[nextQuestion].getHint();
    }

    public static int getNumQuestions() {
        return questions.length;
    }

    public static int getIndex() {
        return nextQuestion;
    }

    public static void setIndex(int index) {
        if (index < questions.length) {
            nextQuestion = index;
        } else {
            nextQuestion = questions.length - 1;
        }
    }
}
