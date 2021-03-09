
public class Restaurant extends Location implements Classifiable{

    private int rank;

    Restaurant(){}

    @Override
    public int getRank() {
        return this.rank;
    }

    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }
}
