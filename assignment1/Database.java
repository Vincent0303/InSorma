package com.example.assignment1;

import android.provider.ContactsContract;
import android.view.SurfaceControl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Database {
        public static ArrayList<User> dataUser;
        public ArrayList<Product> dataProduct;
        public static ArrayList<Transaksi> dataTransaksi;

        public Database()
        {
                // User
                dataUser=new ArrayList<>();
                dataUser.add(new User(1,"user1.com","user1", "00000000", "user"));
//                dataUser.add(new User(2,"test1@gmail.com", "Test1", "123456789", "Test1"));

                // Product
                dataProduct = new ArrayList<>();
                dataProduct.add(new Product("Weston Nakas", 4.9F, 2750000,R.drawable.weston_nakas,"Simpan barang-barang pribadi di kamar dengan menghadirkan Weston nakas persembahan dari Informa. Dilengkapi dengan dua tingkat laci penyimpanan yang dapat digunakan untuk menyimpan berbagai aksesoris kamar tidur. Bagian atasnya dapat Anda gunakan untuk meletakkan jam weker ataupun smartphone agar mudah dijangkau. Terbuat dari material kayu MDF berkualitas yang kuat dan kokoh. Memiliki desain elegan dan minimalis, cocok dipadukan dengan beragam dekorasi kamar tidur Anda."));
                dataProduct.add(new Product("Operose Chair", 4.5F, 25565421,R.drawable.operose_chair, "This Operose Chair is upholstered in soft Velvet with a decorative and chic design giving this chair a modern flair."));
                dataProduct.add(new Product("Marietta Coffee Table", 4.3F, 2000000,R.drawable.marietta_coffee_table, " Our handmade Shaker and Mission furniture is produced in the United States using quality materials known for their tremendous strength and durability. The Amishoutletstore.com uses northern kiln dried hardwoods in our furniture. Red oak and Cherry are widely used in furniture production, however, we offer many of our products in various types of hardwoods, such as Maple, White Oak, Walnut and beautiful Hickory. Each furniture piece is made to order, using quality materials and proven construction techniques. You and your family will enjoy our custom Amish furniture for years to come."));
                dataProduct.add(new Product("Volcanic Gray Ceni", 4.8F, 16507000,R.drawable.volcanic_gray_ceni, "Take a load off. Intentionally designed to sit low to the ground, the Ceni Sofa is a contemporary take on a vintage silhouette. Designed with loose cushions, track arm rests, and a solid wood base, the Ceni features a firmly padded back cushion and medium-firm seat composed of sinuous springs and foam for a deep-seated lounge experience. A bit of bounce relaxes for increased comfort overtime."));
                dataProduct.add(new Product("Luceo Sofa", 4.7F, 16800000,R.drawable.luceo_sofa, "Sofa kain Luceo L-shape adalah salah satu bagian dari seri pencocokan yang mencakup rak pajangan, konsol tv, dan set sofa ruang tamu. Hangat dan nyaman dengan warna kontemporer dari elemen kilap hitam, esensinya adalah desain asimetris yang memadukan estetika modern dan alam. Basis kursi lebar sofa kain bentuk L Luceo menawarkan nuansa luas yang mewah bahkan di ruang sempit. Dengan sandaran tangan yang berfungsi ganda sebagai rak - penghemat ruang yang cerdas."));
                dataProduct.add(new Product("Stark Sofa", 4.9F, 6178000,R.drawable.stark_sofa, "When it comes to flexibility, our Stark sofa with reversible chaise is an ace. Streamlined and sophisticated, the design allows you to dictate the direction you lounge in thanks to a movable ottoman. Whether you’re unwinding on the left or right, you’ll love having the option to switch sides."));


                // Transaction
                dataTransaksi = new ArrayList<>();
//                dataTransaksi.add(new Transaksi(dataUser.get(1), dataProduct.get(1), 1, "4", ));

//
//
//
        }

        public void addUser(String UserEmailAddress,String UserPassword, String UserPhoneNumber, String UserUsername, Integer UserID)
        {
                dataUser.add(new User(UserID,UserEmailAddress,UserPassword, UserPhoneNumber, UserUsername));
        }

        public void addTransaction(User user, Product product, Integer transactionID, Integer quantity, Date transactionDate){

                dataTransaksi.add(new Transaksi(user, product, transactionID, quantity, transactionDate));

        }

        public void setDataUser(Integer id, String Username, String Email, String Phone){

                for (int i=0;i<dataUser.size();i++)
                {
                        if (dataUser.get(i).getUserID()==id)
                        {
                                dataUser.get(i).UserUsername=Username;
                                dataUser.get(i).UserEmailAddress=Email;
                                dataUser.get(i).UserPhoneNumber=Phone;
                        }
                }
                //dataUser.set(id, new User(LoginScreen.usr.UserID, Email, Phone, Username));
        }

        public static boolean checklogin(String UserEmailAddress,String UserPassword)
        {
//                User user= new User();
                for (int i=0;i<dataUser.size();i++)
                {
                        if (dataUser.get(i).UserEmailAddress.equals(UserEmailAddress) && dataUser.get(i).UserPassword.equals(UserPassword))
                        {
//                               user=dataUser.get(i);
                                LoginScreen.usr = dataUser.get(i);
                                return true;

                        }
                }
                return false;
        }

        public static Boolean checkUnique(String UserEmailAddress,String UserUsername){
                Boolean param = true;
                for (int i=0;i<dataUser.size();i++)
                {
                        if (dataUser.get(i).UserEmailAddress.equals(UserEmailAddress) || dataUser.get(i).UserUsername.equals(UserUsername))
                        {
                                param = false;
                        }
                }
                return param;
        }

        public  Integer getIndex(String UserEmailAddress,String UserPassword)
        {
                Integer index = 0;
                for (int i=0;i<dataUser.size();i++)
                {
                        if (dataUser.get(i).UserEmailAddress.equals(UserEmailAddress) && dataUser.get(i).UserPassword.equals(UserPassword))
                        {
                                index = i;
                        }
                }
                return index;
        }

        public static Boolean checkUni(String UserEmailAddress,String UserUsername, Integer index){
                Boolean param = true;
                for (int i=0;i<dataUser.size();i++)
                {
                        if (dataUser.get(i).UserEmailAddress.equals(UserEmailAddress) || dataUser.get(i).UserUsername.equals(UserUsername))
                        {
                                param = false;
                                if(dataUser.get(i).getUserID()==index){
                                        param = true;
                                }
                        }

                }
                return param;
        }

//        public Boolean remove(String UserEmailAddress, String UserPassword){
//
////                Integer Index = getIndex(UserEmailAddress,UserPassword);
//                dataUser.remove(LoginScreen.usr.UserID);
//                LoginScreen.usr = null;
//                return true;
//        }
        /*
        static class Users{

            String[] UserID = {"UID001"};
            String[] UserEmailAddress = {"vincent@gmail.com"};
            String[] UserUsername = {"Vincent"};
            String[] UserPhoneNumber = {"08111111111"};
            String[] UserPassword = {"Vincent"};


        }

        static class Product{

            String[] ProductName;
            int[] ProductRating;
            int[] ProductPrice;
            String[] ProductImage;
            String[] ProductDescription;

        }

        static class Transaction{

            int[] TransactionID;
            int[] quantity;
        }


        */
}
