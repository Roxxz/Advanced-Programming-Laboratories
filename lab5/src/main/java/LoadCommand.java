public class LoadCommand extends Commands{

    LoadCommand(Catalog c){
        this.catalog = c;
    }

    public void loadItem(Catalog c) {
        try {
            CatalogUtil.load( c.getPath() );
        }catch(InvalidCatalogException inv){
            System.out.println(inv.getMessage());
        }
    }
}
