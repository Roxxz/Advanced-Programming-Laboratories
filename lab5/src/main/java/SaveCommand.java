public class SaveCommand extends Commands{

    SaveCommand(Catalog c){
        this.catalog = c;
    }

    public void saveItems(){
        CatalogUtil.save( catalog );
    }
}
