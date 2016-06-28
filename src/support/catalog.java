package support;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by mac on 16/6/27.
 */
public abstract class Catalog implements FileAccessable{
    protected ArrayList<Object> catalog;
    private String catalogID;
    private String name;

    public Catalog(String n){
        this.name = n;
        newCatalog();
    }

    public Catalog(String n,String ID){
        catalogID = ID;
        this.name = n;
        catalog = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("/"+name+"/"+catalogID+".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object i = ois.readObject();
            while (i != null) {
                catalog.add(i);
                i = ois.readObject();
            }
            ois.close();
        }
        catch (EOFException eofe){

        }
        catch (FileNotFoundException fnf){
            System.out.print(fnf.getMessage());
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            System.out.print(ioe.getMessage());
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnf){
            System.out.print(cnf.getMessage());
            cnf.printStackTrace();
        }
    }

    public void newCatalog(){
        try {
            FileReader fr = new FileReader("/"+name+"/index.txt");
            BufferedReader bf = new BufferedReader(fr);
            Integer id = bf.read()-48;
            if (id > 0) id++;
            catalogID = id.toString();
            catalog = new ArrayList<>();
        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("/"+name+"/"+catalogID+".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Object i : catalog) {
                oos.writeObject(i);
            }
            oos.close();
        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public ArrayList<Object> getCatalog(){
        return catalog;
    }

    public boolean isFull(){
        return catalog.size() < 100;
    }

    public String getCatalogID() {
        return catalogID;
    }

    public String getName() {
        return name;
    }
}
