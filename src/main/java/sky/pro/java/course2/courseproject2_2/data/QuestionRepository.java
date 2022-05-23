package sky.pro.java.course2.courseproject2_2.data;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);
    Question remove(String question);
    Collection<Question> getAll();
}
