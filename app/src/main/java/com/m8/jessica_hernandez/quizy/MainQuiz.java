package com.m8.jessica_hernandez.quizy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class MainQuiz extends AppCompatActivity
        implements QuestionsFragment.QuestionsFragmentListener{

    private int answers = 0;
    private boolean gameFinished = false;

    private SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        sharedPreferences();

        QuestionsFragment questionsFragment = QuestionsFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, questionsFragment)
                .commit();
    }

    private void sharedPreferences() {
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.my_preferences), Context.MODE_PRIVATE);

        answers = preferences.getInt(getString(R.string.saved_answeres), 0);

        gameFinished = preferences.getBoolean(getString(R.string.saved_game_state), false);

        QuestionListDual.setIndex(
                preferences.getInt(getString(R.string.saved_next_question), 0));

        prefEditor = preferences.edit();
    }

    private void saveSharedPreferences() {
        prefEditor.putInt(getString(R.string.saved_answeres), answers);
        prefEditor.putBoolean(getString(R.string.saved_game_state), gameFinished);
        prefEditor.putInt(getString(R.string.saved_next_question), QuestionListDual.getIndex());
        prefEditor.commit();
    }

    public String compareAnswere(boolean answerGiven){
        String res = "Game Finished (" + answers + " answers of " +
                QuestionListDual.getNumQuestions() + " questions).";

        if (!gameFinished) {

            String toastMessage = getString(R.string.toast_incorrect);
            if (QuestionListDual.checkAnswere(answerGiven)) {
                toastMessage = getString(R.string.toast_correct);
                answers++;
            }

            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

            gameFinished = !QuestionListDual.next();

            if (!gameFinished)
                res = QuestionListDual.getCurrentQuestionText();
        }

        saveSharedPreferences();
        return res;
    }

    @Override
    public void restartGame() {
        answers = 0;
        gameFinished = false;
        saveSharedPreferences();
    }

    @Override
    public void startHint() {
        if (!gameFinished) {
            DialogFragment hint = new HintDialog();

            hint.show(getSupportFragmentManager(), "Hint");
        }
    }
}
