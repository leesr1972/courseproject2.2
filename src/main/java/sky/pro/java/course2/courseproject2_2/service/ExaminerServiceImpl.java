package sky.pro.java.course2.courseproject2_2.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.courseproject2_2.data.Question;
import sky.pro.java.course2.courseproject2_2.exceptions.BadRequestException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final List<Question> listOfQuestions = new ArrayList<>();

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new BadRequestException("Запрошено слишком много вопросов.");
        }
        int quantityOfJavaQuestions;
        Random random = new Random();
        if (amount <= javaQuestionService.getAll().size()) {
            quantityOfJavaQuestions = random.nextInt(amount - 1) + 1;
        } else {
            quantityOfJavaQuestions = random.nextInt(javaQuestionService.getAll().size() -
                    amount/2) + amount/2;
        }
        Question addedQuestion;
        while (listOfQuestions.size()<quantityOfJavaQuestions){
            addedQuestion = javaQuestionService.getRandomQuestion();
            if (!(listOfQuestions.contains(addedQuestion))) {
                listOfQuestions.add(addedQuestion);
            }
        }
        while (listOfQuestions.size()<amount){
            addedQuestion = mathQuestionService.getRandomQuestion();
            if (!(listOfQuestions.contains(addedQuestion))) {
                listOfQuestions.add(addedQuestion);
            }
        }
        return listOfQuestions;
    }
}
