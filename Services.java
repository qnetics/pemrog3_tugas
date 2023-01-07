/**
 * Bank Java
 *
 * @author Al-fariqy Raihan Azhwar (NPM : 202143501514)
 * @version 1.0
 * 
 */


import java.util.HashMap;
import java.util.ArrayList;


public interface Services {
    
    public ArrayList<HashMap<String, String>> ShowBorrowerRepo ();
    public Boolean AddBorrowerRepo (HashMap<String, Integer> AddRequestModel);
    public Boolean EditBorrowerRepo (HashMap<String, Integer> EditRequestModel);
}
