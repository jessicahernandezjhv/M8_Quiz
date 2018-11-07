package com.dam.oscargf.geoquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsFragment extends Fragment {

    public static final String TAG = "QuestionFragment";

    private QuestionsFragmentListener listener;

    private TextView questionText;
    private Button true_btn;
    private Button false_btn;
    private Button restart_btn;
    private ImageButton hint_btn;

    public QuestionsFragment() {
        // Required empty public constructor
    }

    public static QuestionsFragment newInstance() {
        return new QuestionsFragment();
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tag = getArguments().getString(TAG);
        }
    }*/

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View questionsView = inflater.inflate(R.layout.questions_fragment, container,false);

        questionText = questionsView.findViewById(R.id.message);
        questionText.setText("");

        true_btn = questionsView.findViewById(R.id.true_btn);
        true_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionText.setText(listener.compareAnswere(true));
            }
        });

        false_btn = questionsView.findViewById(R.id.false_btn);
        false_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionText.setText(listener.compareAnswere(false));
            }
        });

        restart_btn = questionsView.findViewById(R.id.restart_btn);
        restart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionList.reset();
                listener.restartGame();

                true_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        questionText.setText(listener.compareAnswere(true));
                    }
                });

                false_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        questionText.setText(listener.compareAnswere(false));
                    }
                });
                Toast.makeText(listener.getApplicationContext(),
                        "Quiz Restarted", Toast.LENGTH_SHORT)
                        .show();

                questionText.setText(QuestionList.getCurrentQuestionText());
            }
        });

        hint_btn = questionsView.findViewById(R.id.hint_btn);
        hint_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.startHint();
            }
        });

        return questionsView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof QuestionsFragmentListener) {
            listener = (QuestionsFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface QuestionsFragmentListener {
        String compareAnswere(boolean answereGiven);
        Context getApplicationContext();
        void restartGame();
        void startHint();
    }

}
