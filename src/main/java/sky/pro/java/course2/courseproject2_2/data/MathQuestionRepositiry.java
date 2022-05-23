package sky.pro.java.course2.courseproject2_2.data;

import org.springframework.stereotype.Repository;
import sky.pro.java.course2.courseproject2_2.exceptions.NotFoundException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepositiry implements QuestionRepository{
    private final Set<Question> mathQuestions = new HashSet<>();

    @PostConstruct
    public void init() {
        add("5 + 7 = ", "13.");
        add("25 - 20 = ", "5.");
        add("3 * 8 = ", "24.");
        add("36 / 6 = ", "6.");
        add("7 / 0 = ", "На ноль делить нельзя.");
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        mathQuestions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question) {
        Question removedQuestion = null;
        for (Question q: mathQuestions) {
            if (q.getQuestion().equals(question)) {
                removedQuestion = q;
            }
        }
        if (removedQuestion == null) {
            throw new NotFoundException("Такого вопроса нет.");
        }
        mathQuestions.remove(removedQuestion);
        return removedQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions;
    }
}
