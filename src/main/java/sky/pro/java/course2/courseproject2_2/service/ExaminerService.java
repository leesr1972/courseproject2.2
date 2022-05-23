package sky.pro.java.course2.courseproject2_2.service;

import sky.pro.java.course2.courseproject2_2.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
