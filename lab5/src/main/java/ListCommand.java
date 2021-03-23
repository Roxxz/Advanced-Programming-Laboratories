public class ListCommand extends Commands{

    ListCommand(Catalog c){
        this.catalog = c;
    }

    public void listItems(){
        this.catalog.list();
    }
}
