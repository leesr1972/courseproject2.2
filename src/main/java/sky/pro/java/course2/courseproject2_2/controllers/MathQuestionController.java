package sky.pro.java.course2.courseproject2_2.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.course2.courseproject2_2.data.Question;
import sky.pro.java.course2.courseproject2_2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question) {
        return questionService.remove(question);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
