/**
 * Bank Java
 *
 * @author Al-fariqy Raihan Azhwar (NPM : 202143501514)
 * @version 1.0
 * 
 */

import java.util.HashMap;
import java.util.ArrayList;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Views {
    
    private BufferedReader bufferedReader;


    Views() {

        this.bufferedReader = new BufferedReader(
            new InputStreamReader(
                System.in
            )
        );
    }



    public int MainViews () throws IOException {

        System.out.println('\u000C');

        System.out.print(
            "+---------------------------------------+\n\n" +
            "| Nama  : Al-fariqy Raihan Azhwar       |\n" +
            "| NPM   : 202143501514                  |\n" +
            "| Kelas : R3Q                           |\n\n" +
            "+------ Tugas Akhir Pemrograman 3 ------+\n\n" +
            "|   [ 1 ]   Lihat Data Peminjam         |\n" +
            "|   [ 2 ]   Tambah Data Peminjam        |\n" +
            "|   [ 3 ]   Ubah Data Peminjam          |\n" +
            "|   [ 4 ]   Hapus Data Peminjam         |\n" +
            "|   [ 5 ]   keluar                      |\n" +
            "+---------------------------------------+\n\n" +
            "[ ? ] Masukan Pilihan Anda > "
        );

        return Integer.parseInt(
            this.bufferedReader.readLine()
        );
    }



    public void ShowBorrowerViews (
        ArrayList<HashMap<String, String>> ShowUserDatas) throws IOException {

        int MutationPage = 1;
        int PaginationLength = 3;

        int TotalPage = (int) Math.ceil(
            (double) ShowUserDatas.size() /
            (double) PaginationLength
        );

        int PageLength = 3;

        while (true) {

            System.out.println('\u000C');

            if ( ShowUserDatas.size() < 3 ) {

                for (int UserData = (MutationPage - 1) * PaginationLength; ShowUserDatas.size() > UserData; UserData++) {

                    System.out.println("--[ Data ke - " + Integer.toString(UserData + 1) + " ]----------------------------");
        
                    System.out.println(
                        " [ Antrean ] : " +
                        ShowUserDatas.get(UserData).get("id")
                    );
        
                    System.out.println(
                        " [ ID Anggota ] : " +
                        ShowUserDatas.get(UserData).get("user_id")
                    );
        
                    System.out.println(
                        " [ Nama Anggota ] : " +
                        ShowUserDatas.get(UserData).get("user_name")
                    );
        
                    System.out.println(
                        " [ ID Buku ] : " +
                        ShowUserDatas.get(UserData).get("book_id")
                    );
        
                    System.out.println(
                        " [ Nama Buku ] : " +
                        ShowUserDatas.get(UserData).get("book_name")
                    );
        
                    System.out.println(
                        " [ Jumlah Buku ] : " +
                        ShowUserDatas.get(UserData).get("book_amount") + "\n"
                    );
                    
                }
            

            } else if (ShowUserDatas.size() < 1) {

                    System.out.println("Data Peminjaman Kosong");

            } else {

                for (int UserData = (MutationPage - 1) * PaginationLength; PageLength > UserData; UserData++) {

                    System.out.println("--[ Data ke - " + Integer.toString(UserData + 1) + " ]----------------------------");
        
                    System.out.println(
                        " [ Antrean ] : " +
                        ShowUserDatas.get(UserData).get("id")
                    );
        
                    System.out.println(
                        " [ ID Anggota ] : " +
                        ShowUserDatas.get(UserData).get("user_id")
                    );
        
                    System.out.println(
                        " [ Nama Anggota ] : " +
                        ShowUserDatas.get(UserData).get("user_name")
                    );
        
                    System.out.println(
                        " [ ID Buku ] : " +
                        ShowUserDatas.get(UserData).get("book_id")
                    );
        
                    System.out.println(
                        " [ Nama Buku ] : " +
                        ShowUserDatas.get(UserData).get("book_name")
                    );
        
                    System.out.println(
                        " [ Jumlah Buku ] : " +
                        ShowUserDatas.get(UserData).get("book_amount") + "\n"
                    );
                    
                }
            }

            System.out.println("\n[ "+ MutationPage +" ] [ dari ] [ "+ TotalPage +" ]");

            System.out.print("\n[ PILIH / KELUAR ]  +--->  ");
            String Choice = this.bufferedReader.readLine();

            if (
                Choice.equalsIgnoreCase("keluar") |
                Choice.equalsIgnoreCase("exit")
                ) {

                    break;
            } else {

                if ( (Integer.parseInt(Choice) * PaginationLength) >= ShowUserDatas.size() ) {

                    PageLength -= PageLength;
                    PageLength += ShowUserDatas.size();

                    MutationPage -= MutationPage;
                    MutationPage += Integer.parseInt(Choice);

                } else {

                    PageLength -= PageLength;
                    PageLength += Integer.parseInt(Choice) * PaginationLength;

                    MutationPage -= MutationPage;
                    MutationPage += Integer.parseInt(Choice);

                }
            }
        }
           
    }



    public HashMap<String, Integer> AddBorrowerViews () throws IOException {

        HashMap<String, Integer> UserInputDatas = new HashMap<String, Integer>();

        System.out.println('\u000C');

        System.out.println("+------------------ Tambah Data Peminjam ------------------+\n");

        System.out.print("   [ Masukan ID anggota ] : ");
        UserInputDatas.put(
            "user_id", Integer.parseInt(
                this.bufferedReader.readLine()
            )
        );

        System.out.print("   [ Masukan ID buku ] : ");
        UserInputDatas.put(
            "book_id", Integer.parseInt(
                this.bufferedReader.readLine()
            )
        );

        System.out.print("   [ Masukan jumlah buku ] : ");
        UserInputDatas.put(
            "book_amount", Integer.parseInt(
                this.bufferedReader.readLine()
            )
        );

        return UserInputDatas;
    }



    public HashMap<String, Integer> EditBorrowerViews () throws IOException {

        HashMap<String, Integer> UserInputDatas = new HashMap<String, Integer>();

        System.out.println('\u000C');

        System.out.println("+------------------ Edit Data Peminjam ------------------+\n");

        System.out.print("   [ Masukan Antrean ] : ");
        UserInputDatas.put(
            "id", Integer.parseInt(
                this.bufferedReader.readLine()
            )
        );

        System.out.print("   [ Edit ID anggota ] : ");
        UserInputDatas.put(
            "user_id", Integer.parseInt(
                this.bufferedReader.readLine()
            )
        );

        System.out.print("   [ Edit ID buku ] : ");
        UserInputDatas.put(
            "book_id", Integer.parseInt(
                this.bufferedReader.readLine()
            )
        );

        System.out.print("   [ Edit jumlah buku ] : ");
        UserInputDatas.put(
            "book_amount", Integer.parseInt(
                this.bufferedReader.readLine()
            )
        );

        return UserInputDatas;
    }



    public HashMap<String, Integer> DeleteBorrowerViews () throws IOException {

        HashMap<String, Integer> UserInputDatas = new HashMap<String, Integer>();

        System.out.println('\u000C');

        System.out.println("+------------------ Hapus Data Peminjam ------------------+\n");

        System.out.print("   [ Masukan Antrean ] : ");
        UserInputDatas.put(
            "id", Integer.parseInt(
                this.bufferedReader.readLine()
            )
        );

        return UserInputDatas;
    }

}