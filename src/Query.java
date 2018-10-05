import java.util.Date;

public class Query {
    private Service service;
    private Question question;
    private String answerType;
    private Date dateFrom;
    private Date dateTo;

    public Query(Service service, Question question, String answerType, Date dateFrom, Date dateTo) {
        this.service = service;
        this.question = question;
        this.answerType = answerType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
