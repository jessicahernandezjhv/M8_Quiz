package com.m8.jessica_hernandez.quizy;

public class QuestionListMulti {

    private static final QuestionDual[] questions = new QuestionDual[] {
            new QuestionDual("Madrid es la capital de España?", true,
                    R.drawable.ic_dashboard_black_24dp),
            new QuestionDual("Francia esta en Europa?", true,
                    R.drawable.ic_home_black_24dp),
            new QuestionDual("Los pirineos estan en el reino unido?", false,
                    R.drawable.ic_launcher_background),
            new QuestionDual("Sudafrica esta en el emisferio norte.", false,
                    R.drawable.ic_launcher_foreground),
            new QuestionDual("Cataluña esta en españa?", true,
                    R.drawable.ic_notifications_black_24dp),
            new QuestionDual("España es un estado de los estados unidos\n de america(EUA).", false,
                    R.drawable.ic_notifications_black_24dp),
            new QuestionDual("El instituto Joan de Áustria esta en Barcelona?", true,
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
        return questions[nextQuestion].getCorrectAnswer() == answere;
    }

    public static void reset() {
        nextQuestion = 0;
    }

    public static String getCurrentQuestionText() {
        return questions[nextQuestion].getQuestionText();
    }

    public static int getCurrentQuestionHint() {
        return questions[nextQuestion].getClue();
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