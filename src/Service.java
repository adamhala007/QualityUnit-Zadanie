public class Service {

    private int type;
    private Integer variation;


    public Service(int type, int variation) {
        this.type = type;
        this.variation = variation;
    }

    public Service(int type) {
        this.type = type;
        this.variation = null;
    }
}
