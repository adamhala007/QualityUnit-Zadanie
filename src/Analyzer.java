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


}
