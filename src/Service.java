public class Service {

    private String type;
    private String variation;


    public Service(String type, String variation) {
        this.type = type;
        this.variation = variation;
    }

    public Service(String type) {
        this.type = type;
        this.variation = null;
    }

    public Service() {
    }


    public void setData(String data){
        String[] splittedData = data.split(".");
        type = splittedData[0];
        if (splittedData.length>1){
            variation = splittedData[1];
        }
    }
}
