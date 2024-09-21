package com.rest.api.learn_spring_rest.questionSurvey.controller;

import com.rest.api.learn_spring_rest.questionSurvey.Question;
import com.rest.api.learn_spring_rest.questionSurvey.Survey;
import com.rest.api.learn_spring_rest.questionSurvey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SurveyController {

/*
    -   All the request first goes to the Dispatcher Servlet, and
        it will map the respective right controller(if there is many controller)
    -   Dispatcher servlet is configured by DispatcherAutoConfiguration
    -   Auto configuration is the main feature of Spring boot
    -   JacksonHttpMessageConverterConfiguration is responsible for sending APIs response as JSON format
    -   ErrorMvcAutoConfiguration is responsible for configuring error
*/

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping("/surveys")
    public List<Survey> getSurvey() {
        return surveyService.getSurveys();
    }

    @RequestMapping("/surveys/{id}")
    public Survey getSurveyById(@PathVariable String id) {
        Survey survey = surveyService.getSurveyById(id);
        if(survey==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return survey;
    }

    @RequestMapping("/surveys/questions")
    public List<Question> getSurveyQuestions() {
        return surveyService.getSurveyQuestions();
    }
}
