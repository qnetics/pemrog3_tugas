/**
 * Bank Java
 *
 * @author Al-fariqy Raihan Azhwar (NPM : 202143501514)
 * @version 1.0
 * 
 */



import java.util.HashMap;
import java.util.ArrayList;

import java.sql.Statement;
import java.sql.ResultSet;

 
public class Repositories extends Configurations implements Services {

    public ArrayList<HashMap<String, String>> ShowBorrowerRepo () {

        ArrayList<HashMap<String, String>> BorrowerDatas = new ArrayList<HashMap<String, String>>();

        try {

            final String Query = (
                "SELECT " +
                    "peminjam.id, " +
                    "peminjam.id_anggota, " +
                    "anggota.nama_anggota, " +
                    "peminjam.id_buku, " +
                    "buku.nama_buku, " +
                    "peminjam.jumlah_buku " +
                "FROM data_peminjam peminjam " +
                "INNER JOIN " +
                    "data_anggota anggota " +
                        "ON peminjam.id_anggota = anggota.id " +
                "INNER JOIN " +
                    "data_buku buku " +
                        "ON peminjam.id_buku = buku.id;"
            );

            Statement statement = SqliteConfigurationStatement();

            ResultSet QueryResult = statement.executeQuery(Query);

            while (QueryResult.next()) {

                HashMap<String, String> SingleQueryData = new HashMap<String, String>();

                SingleQueryData.put(
                    "id", Integer.toString(
                        QueryResult.getInt("id")
                    )
                );

                SingleQueryData.put(
                    "user_id", Integer.toString(
                        QueryResult.getInt("id_anggota")
                    )
                );

                SingleQueryData.put(
                    "user_name",
                    QueryResult.getString("nama_anggota")
                );

                SingleQueryData.put(
                    "book_id", Integer.toString(
                        QueryResult.getInt("id_buku")
                    )
                );

                SingleQueryData.put(
                    "book_name",
                    QueryResult.getString("nama_buku")
                );

                SingleQueryData.put(
                    "book_amount", Integer.toString(
                        QueryResult.getInt("jumlah_buku")
                    )
                );

                BorrowerDatas.add(SingleQueryData);
            }

            return BorrowerDatas;

        } catch (Exception e) {
            
            return BorrowerDatas;

        }
    }



    public Boolean AddBorrowerRepo (HashMap<String, Integer> AddRequestModel) {

        try {

            /**
             *  user_id
             *  book_id
             *  book_amount
             */

            int UserId      = AddRequestModel.get("user_id");
            int BookId      = AddRequestModel.get("book_id");
            int BookAmount  = AddRequestModel.get("book_amount");

            Statement statement = SqliteConfigurationStatement();

            String Query = (
                "INSERT INTO data_peminjam (id_anggota, id_buku, jumlah_buku) " +
                "VALUES (%d, %d, %d);"
            );

            statement.executeUpdate(
                String.format(Query, UserId, BookId, BookAmount)
            );

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }



    public Boolean EditBorrowerRepo (HashMap<String, Integer> EditRequestModel) {

        try {

            /**
             *  user_id
             *  book_id
             *  book_amount
             */

            int Id          = EditRequestModel.get("id");
            int UserId      = EditRequestModel.get("user_id");
            int BookId      = EditRequestModel.get("book_id");
            int BookAmount  = EditRequestModel.get("book_amount");

            Statement statement = SqliteConfigurationStatement();

            String Query = (
                "UPDATE data_peminjam SET " +
                    "id_anggota = %d, " +
                    "id_buku = %d, " +
                    "jumlah_buku = %d " +
                "WHERE id = %d;"
            );

            statement.executeUpdate(
                String.format(Query, UserId, BookId, BookAmount, Id)
            );

            return true;

        } catch (Exception e) {return false;}
    }



    public Boolean DeleteBorrowerRepo (HashMap<String, Integer> DeleteRequestModel) {

        try {

            /**
             *  user_id
             *  book_id
             *  book_amount
             */

            int Id = DeleteRequestModel.get("id");

            Statement statement = SqliteConfigurationStatement();

            String Query = "DELETE FROM data_peminjam WHERE id = %d";

            statement.executeUpdate(
                String.format(Query, Id)
            );

            return true;

        } catch (Exception e) {return false;}
    }

}
