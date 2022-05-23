package sky.pro.java.course2.courseproject2_2.data;

import org.springframework.stereotype.Repository;
import sky.pro.java.course2.courseproject2_2.exceptions.NotFoundException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private Set<Question> javaQuestions = new HashSet<>();

    @PostConstruct
    public void init() {
                add("Что такое цикл?", "Это когда много раз.");
                add("Что такое массив?", "Это хранилище.");
                add("Что такое мок?", "Это заглушка.");
                add("Что такое метод?", "Это подпрограмма.");
                add("Что такое рекурсия?", "Это когда сам себя.");
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        javaQuestions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question) {
        Question removedQuestion = null;
        for (Question q : javaQuestions) {
            if (q.getQuestion().equals(question)) {
                removedQuestion = q;
            }
        }
        if (removedQuestion == null) {
            throw new NotFoundException("Такого вопроса нет.");
        }
        javaQuestions.remove(removedQuestion);
        return removedQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestions;
    }
}
