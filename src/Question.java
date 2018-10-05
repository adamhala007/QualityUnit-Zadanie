public class Question {

    private int type;
    private Integer category;
    private Integer subCategory;


    public Question(int type, Integer category, Integer subCategory) {
        this.type = type;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Question(int type, Integer category) {
        this.type = type;
        this.category = category;
        this.subCategory = null;
    }

    public Question(int type) {
        this.type = type;
        this.category = null;
        this.subCategory = null;
    }

    public Question() {
    }


    public void setData(String data){
        //TODO
    }
}
