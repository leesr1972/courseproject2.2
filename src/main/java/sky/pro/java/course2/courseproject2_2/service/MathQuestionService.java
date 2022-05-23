package sky.pro.java.course2.courseproject2_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sky.pro.java.course2.courseproject2_2.data.Question;
import sky.pro.java.course2.courseproject2_2.data.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService{
    private final QuestionRepository mathQuestionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepositiry") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(question, answer);
    }

    @Override
    public Question remove(String question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> listOfQuestions = new ArrayList<>(mathQuestionRepository.getAll());
        Random random = new Random();
        int numberOfQuestion = random.nextInt(listOfQuestions.size());
        return listOfQuestions.get(numberOfQuestion);
    }
}
