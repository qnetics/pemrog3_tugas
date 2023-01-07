/**
 * Bank Java
 *
 * @author Al-fariqy Raihan Azhwar (NPM : 202143501514)
 * @version 1.0
 * 
 */


import java.util.HashMap;



public interface Entities {

    /*
     *  Main Features
     */

    public HashMap<String, Integer>  AddModel    (int UserId, int BookId, int BookAmount);
    public HashMap<String, Integer>  EditModel   (int Id, int UserId, int BookId, int BookAmount);
    public HashMap<String, Integer>  DeleteModel (int Id);
}
