import java.text.SimpleDateFormat;
import java.util.Date;

public class Query extends Data{
    public Service getService() {
        return service;
    }

    public Question getQuestion() {
        return question;
    }

    public String getAnswerType() {
        return answerType;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

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

    public Query() {
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
                    String[] dateInterval = row[i].split("-");

                    dateFrom = new SimpleDateFormat("dd.MM.yyyy").parse(dateInterval[0]);

                    if (dateInterval.length > 1){
                        dateTo = new SimpleDateFormat("dd.MM.yyyy").parse(dateInterval[1]);
                    }
                    else {
                        dateTo = null;
                    }

                    break;

                default:
                    throw new Exception("Wrong Query row");

            }
        }
    }

    @Override
    public String toString() {
        return "Query{" +
                "service=" + service +
                ", question=" + question +
                ", answerType='" + answerType + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
