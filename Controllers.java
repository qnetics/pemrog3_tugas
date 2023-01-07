/**
 * Bank Java
 *
 * @author Al-fariqy Raihan Azhwar (NPM : 202143501514)
 * @version 1.0
 * 
 */

import java.util.HashMap;


public class Controllers extends Models {
    
    private Views views;
    private Repositories repositories;


    Controllers() {

        this.views = new Views();
        this.repositories = new Repositories();
    }



    public void MainController () throws Exception {

        while (true) {

            boolean IsExit = false;
            int MainViewOutput = this.views.MainViews();

            switch (MainViewOutput) {

                case 1 :
                    this.ShowBorrowerController();
                    break;

                case 2 :
                    this.AddBorrowerController();
                    break;

                case 3 :
                    this.EditBorrowerController();
                    break;

                case 4 :
                    this.DeleteBorrowerController();
                    break;

                case 5 :
                    IsExit = true;
                    break;
            }

            if (IsExit) { break; }
            else { continue; }
        }
    }



    public void ShowBorrowerController () throws Exception {

        this.views.ShowBorrowerViews(
            this.repositories.ShowBorrowerRepo()
        );
    }



    public void AddBorrowerController () throws Exception {

        HashMap<String, Integer> AddViewOutput = this.views.AddBorrowerViews();

        boolean AddBorrowerData = this.repositories.AddBorrowerRepo(

            this.AddModel(
                AddViewOutput.get("user_id"), 
                AddViewOutput.get("book_id"), 
                AddViewOutput.get("book_amount")
            )
        );

        if (AddBorrowerData) {

            System.out.println("\n[ Data Berhasil Dimasukan ]");
        } else {

            System.out.println("\n[ Data Gagal Dimasukan ]");
        }

        Thread.sleep(3000);
    }



    public void EditBorrowerController () throws Exception {

        HashMap<String, Integer> EditViewOutput = this.views.EditBorrowerViews();

        boolean EditBorrowerData = this.repositories.EditBorrowerRepo(

            this.EditModel(
                EditViewOutput.get("id"),
                EditViewOutput.get("user_id"), 
                EditViewOutput.get("book_id"), 
                EditViewOutput.get("book_amount")
            )
        );

        if (EditBorrowerData) {

            System.out.println("\n[ Data Berhasil Di edit ]");
        } else {

            System.out.println("\n[ Data Gagal Di edit ]");
        }

        Thread.sleep(3000);
    }



    public void DeleteBorrowerController () throws Exception {

        HashMap<String, Integer> DeleteViewOutput = this.views.DeleteBorrowerViews();

        boolean DeleteBorrowerData = this.repositories.DeleteBorrowerRepo(

            this.DeleteModel(
                DeleteViewOutput.get("id")
            )
        );

        if (DeleteBorrowerData) {

            System.out.println("\n[ Data Berhasil Di hapus ]");
        } else {

            System.out.println("\n[ Data Gagal Di hapus ]");
        }

        Thread.sleep(3000);
    }
}