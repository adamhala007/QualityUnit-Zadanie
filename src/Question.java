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
        this.type = type;
        this.category = category;
        this.subCategory = null;
    }

    public Question(String type) {
        this.type = type;
        this.category = null;
        this.subCategory = null;
    }

    public Question() {
    }


    public void setData(String data){
        String[] splittedData = data.split(".");
        type = splittedData[0];
        if (splittedData.length>1){
            category = splittedData[1];

            if (splittedData.length>2){
                subCategory = splittedData[2];
            }
        }
    }
}
