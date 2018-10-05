import java.util.Date;

public class Answer {

    private Service service;
    private Question question;
    private String answerType;
    private Date date;
    private Integer waitingTime;


    public Answer(Service service, Question question, String answerType, Date date, Integer waitingTime) {
        this.service = service;
        this.question = question;
        this.answerType = answerType;
        this.date = date;
        this.waitingTime = waitingTime;
    }
}
