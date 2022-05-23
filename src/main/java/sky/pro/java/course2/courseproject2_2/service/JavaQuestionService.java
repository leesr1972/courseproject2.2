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
public class JavaQuestionService implements QuestionService{
    private final QuestionRepository javaQuestionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(question, answer);
    }

    @Override
    public Question remove(String question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> listOfQuestions = new ArrayList<>(javaQuestionRepository.getAll());
        Random random = new Random();
        int numberOfQuestion = random.nextInt(listOfQuestions.size());
        return listOfQuestions.get(numberOfQuestion);
    }
}
