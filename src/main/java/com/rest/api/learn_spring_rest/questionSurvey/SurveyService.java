package com.rest.api.learn_spring_rest.questionSurvey;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SurveyService {

    public List<Survey> getSurveys() {
        List<Survey> surveys = new ArrayList<>();

        Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));

        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);
        return surveys;
    }

    public Survey getSurveyById(String id) {
       return getSurveys().stream().filter(survey -> survey.getId().equalsIgnoreCase(id)).toList().get(0);
    }

    public List<Question> getSurveyQuestions() {
        return new ArrayList<>(getSurveys().get(0).getQuestions());
    }
}
