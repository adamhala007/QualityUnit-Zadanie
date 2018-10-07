import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Answer extends Data{

    public Service getService() {
        return service;
    }

    public Question getQuestion() {
        return question;
    }

    public String getAnswerType() {
        return answerType;
    }

    public Date getDate() {
        return date;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

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

    public Answer() {
        service = new Service();
        question = new Question();
    }

    @Override
    public void setData(String[] row) throws Exception {
        for (int i = 1; i < row.length; i++) {
            switch (i){

                case 1:
                    service.setData(row[i]);
                    break;
                case 2:
                    question.setData(row[i]);
                    break;
                case 3:
                    answerType = row[i];
                    break;
                case 4:
                    date = new SimpleDateFormat("dd.MM.yyyy").parse(row[i]);
                    break;
                case 5:
                    waitingTime = Integer.parseInt(row[i]);
                    break;

                default:
                    throw new Exception("Wrong Answer row");

            }
        }
    }

    public boolean matchesQuery(Query query){

        if (!service.matchesService(query.getService())){
            return false;
        }


        if (!question.matchesQuestion(query.getQuestion())){
            return false;
        }

        if (!answerType.equals(query.getAnswerType())){
            return false;
        }

        if (query.getDateFrom().after(date)){
            return false;
        }


        if (query.getDateTo() != null && query.getDateTo().before(date)){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "service=" + service +
                ", question=" + question +
                ", answerType='" + answerType + '\'' +
                ", date=" + date +
                ", waitingTime=" + waitingTime +
                '}';
    }
}
