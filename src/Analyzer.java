import java.util.ArrayList;

public class Analyzer {

    private int rows;
    private ArrayList<String> input;
    private ArrayList<Data> dataList;

    public Analyzer() {
        dataList = new ArrayList<>();
    }

    public void analyze(ArrayList<String> input) throws Exception {
        this.input = input;

        if (isEmptyInput()){
            throw new Exception("Nothing to analyze");
        }

        rows = getRowNumber();

        if (rows == input.size()-1){
            readInput();
        }

        readAndEvaluateQueries();
    }



    private boolean isEmptyInput(){
        return this.input.isEmpty();
    }

    private Integer getRowNumber() throws Exception {
        try{
            return Integer.parseInt(input.get(0));
        }catch (NumberFormatException e){
            throw new Exception("Wrong row number");
        }
    }

    private void readInput() throws Exception {
        for (int row = 1; row < rows + 1; row++) {
            readRow(row);
        }
    }

    private void readRow(int row) throws Exception {
         String data = input.get(row);
         String[] dataArray = data.split(" ");

         if (dataArray[0].equals("C")){
             addAnswer(dataArray);
         }else if (dataArray[0].equals("D")){
             addQuery(dataArray);
         }else {
             throw new Exception("Unknown row input");
         }
    }

    private void addQuery(String[] dataArray) throws Exception {
        Query query = new Query();
        query.setData(dataArray);
        dataList.add(query);
    }

    private void addAnswer(String[] dataArray) throws Exception {
        Answer answer = new Answer();
        answer.setData(dataArray);
        dataList.add(answer);
    }

    private void readAndEvaluateQueries() {
        ArrayList<Answer> matchedAnswers;

        for (int i = 0; i < dataList.size(); i++) {
            if (isQuery(dataList.get(i))){
                matchedAnswers = processAnswersBeforeQuery(i);
                evaluateAnswers(matchedAnswers);
            }
        }
    }

    private boolean isQuery(Data data) {
        return data instanceof Query;
    }

    private void evaluateAnswers(ArrayList<Answer> matchedAnswers) {
        if (matchedAnswers.isEmpty()){
            System.out.println("-");
            return;
        }

        int sum = 0;

        for (int i = 0; i < matchedAnswers.size(); i++) {
            sum += matchedAnswers.get(i).getWaitingTime();
        }

        System.out.println(sum/matchedAnswers.size());
    }

    private boolean isAnswer(Data data) {
        return data instanceof Answer;
    }

    private ArrayList<Answer> processAnswersBeforeQuery(int queryNumber) {
        ArrayList<Answer> matchedAnswers = new ArrayList<>();
        Query query = (Query) dataList.get(queryNumber);

        for (int i = 0; i < queryNumber; i++) {
            if (isAnswer(dataList.get(i))){
                if (((Answer)dataList.get(i)).matchesQuery(query)){
                    matchedAnswers.add((Answer)dataList.get(i));
                }
            }
        }
        return matchedAnswers;
    }


}
