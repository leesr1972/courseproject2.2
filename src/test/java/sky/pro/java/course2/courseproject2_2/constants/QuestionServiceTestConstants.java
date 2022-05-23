package sky.pro.java.course2.courseproject2_2.constants;

import sky.pro.java.course2.courseproject2_2.data.Question;

import java.util.HashSet;
import java.util.Set;

public class QuestionServiceTestConstants {
    public static final Set<Question> JAVA_QUESTIONS_TEST = new HashSet<>(Set.of(
            new Question("Что такое цикл?", "Это когда много раз."),
            new Question("Что такое массив?", "Это хранилище."),
            new Question("Что такое мок?", "Это заглушка."),
            new Question("Что такое метод?", "Это подпрограмма."),
            new Question("Что такое рекурсия?", "Это когда сам себя.")
    ));

    public static final Question JAVA_QUESTION_TEST = new Question("Что такое цикл?",
            "Это когда много раз.");

    public static final Set<Question> MATH_QUESTIONS_TEST = new HashSet<>(Set.of(
            new Question("5 + 7 = ", "13."),
            new Question("25 - 20 = ", "5."),
            new Question("3 * 8 = ", "24."),
            new Question("36 / 6 = ", "6."),
            new Question("7 / 0 = ", "На ноль делить нельзя.")
    ));

    public static final Question MATH_QUESTION_TEST = new Question("7 / 0 = ",
            "На ноль делить нельзя.");
}
