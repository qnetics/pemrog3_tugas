/**
 * Bank Java
 *
 * @author Al-fariqy Raihan Azhwar (NPM : 202143501514)
 * @version 1.0
 * 
 */


 
import java.util.HashMap;



public class Models implements Entities {


    /*
     *  Model for deposit feature
     */
    public HashMap<String, Integer> AddModel (int UserId, int BookId, int BookAmount) {

        /**
         *  user_id
         *  book_id
         *  book_amount
         */
        HashMap<String, Integer> AddBorrower = new HashMap<String, Integer>();

        AddBorrower.put("user_id", UserId);
        AddBorrower.put("book_id", BookId);
        AddBorrower.put("book_amount", BookAmount);

        return AddBorrower;
    }



    /*
     *  Model for transfer feature
     */
    public HashMap<String, Integer> EditModel (int Id, int UserId, int BookId, int BookAmount) {

        HashMap<String, Integer> EditBorrower = this.AddModel(
            UserId, BookId, BookAmount);

        EditBorrower.put("id", Id);

        return EditBorrower;
    }



    /*
     *  Model for mutation feature
     */
    public HashMap<String, Integer>  DeleteModel (int Id) {

        // User Token
        HashMap<String, Integer> DeleteBorrower = new HashMap<String, Integer>();

        DeleteBorrower.put("id", Id);
        
        return DeleteBorrower;
    }
}
