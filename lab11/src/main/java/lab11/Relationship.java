package lab11;

public class Relationship {
    private int idFriend1;
    private int idFriend2;

    public Relationship(int idFriend1, int idFriend2) {
        this.setIdFriend1(idFriend1);
        this.setIdFriend2(idFriend2);
    }

    @Override
    public String toString() {
        return "Relationship=" +
                "idFriend1=" + getIdFriend1() +
                ", idFriend2=" + getIdFriend2();
    }

    public int getIdFriend1() {
        return idFriend1;
    }

    public void setIdFriend1(int idFriend1) {
        this.idFriend1 = idFriend1;
    }

    public int getIdFriend2() {
        return idFriend2;
    }

    public void setIdFriend2(int idFriend2) {
        this.idFriend2 = idFriend2;
    }
}
