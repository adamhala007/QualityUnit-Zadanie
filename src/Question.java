public class Question {

    private String type;
    private String category;
    private String subCategory;


    public Question(String type, String category, String subCategory) {
        this.type = type;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Question(String type, String category) {
        this(type, category, null);
    }

    public Question(String type) {
        this(type, null, null);
    }

    public Question() {
        this(null, null, null);
    }


    public void setData(String data){
        String[] splittedData = data.split("\\.");
        type = splittedData[0];
        if (splittedData.length>1){
            category = splittedData[1];

            if (splittedData.length>2){
                subCategory = splittedData[2];
            }
        }
    }

    public boolean matchesQuestion(Question question){

        if (question.type.equals("*")){
            return true;
        }

        if (question.type.equals(this.type)){
            if (question.category != null){
                if (question.category.equals(this.category)){
                    if (question.subCategory != null){
                        if (question.subCategory.equals(this.subCategory)){
                            return true;
                        }
                    }else {
                      return true;
                    }
                }
            }else{
                return true;
            }

        }

        return false;
    }

    @Override
    public String toString() {
        return "Question(" + type + "." + category + "." + subCategory + ")";
    }
}
