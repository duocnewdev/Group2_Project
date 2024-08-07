/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.*;
import com.sun.jdi.IntegerType;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Duoc Shin
 */
public class DAO_SanPham {
    public ArrayList<SanPham> getListSP (){
        ArrayList<SanPham> listSP = new ArrayList<>();
        String sql = "Select * From SanPham";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String masp = rs.getString("masp");
              String tensp= rs.getString("tensp");
              String thongso= rs.getString("thongso");
              int gianiemyet= rs.getInt("gianiemyet");
              int giaban= rs.getInt("giaban");
              String math= rs.getString("math");
              String madm= rs.getString("madm");
              String makm= rs.getString("makm");
      
              SanPham sp = new SanPham(masp, tensp, thongso, gianiemyet,giaban, math, madm, makm);
              listSP.add(sp);
            }
        } catch (Exception e) {
        }
        return listSP;
    
    }
    
    public int getCountSP(){
        int Sl_SanPham=8;
    String sql = "Select COUNT(masp) as slsp From SanPham ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               Sl_SanPham= rs.getInt("slsp");
               
              
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return Sl_SanPham;
    }
   public SanPham getsp(String tensp1){
   String sql = "Select * From SanPham Where tensp ='"+tensp1+"' OR masp ='"+tensp1+"'";
   SanPham result = null;
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String masp = rs.getString("masp");
              String tensp= rs.getString("tensp");
              String thongso= rs.getString("thongso");
              int gianiemyet= rs.getInt("gianiemyet");
              int giaban= rs.getInt("giaban");
              String math= rs.getString("math");
              String madm= rs.getString("madm");
              String makm= rs.getString("makm");
        
              result = new SanPham(masp, tensp, thongso, gianiemyet,giaban, math, madm, makm);
                
            }
        }catch (Exception e)
        {
              e.printStackTrace();
        }
        
        return  result;
   }
   
   public ArrayList<SanPham> getSPTK (String tensptk){
      ArrayList<SanPham> listSP = new ArrayList<>();
        String sql = "Select * From SanPham Where tensp like '"+tensptk+"%' ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String masp = rs.getString("masp");
              String tensp= rs.getString("tensp");
              String thongso= rs.getString("thongso");
              int gianiemyet= rs.getInt("gianiemyet");
              int giaban= rs.getInt("giaban");
              String math= rs.getString("math");
              String madm= rs.getString("madm");
              String makm= rs.getString("makm");
    
              SanPham sp = new SanPham(masp, tensp, thongso, gianiemyet,giaban, math, madm, makm);
              listSP.add(sp);
            }
        } catch (Exception e) {
        }
        return listSP;
   }
   
   public ArrayList<SanPham> getSPCbb (String danhmuc, String thuonghieu){
    
    ArrayList<SanPham> listSP = new ArrayList<>();
    
        String sql = "Select * From SanPham Where madm ='"+danhmuc+"' and math = '"+thuonghieu+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String masp = rs.getString("masp");
              String tensp= rs.getString("tensp");
              String thongso= rs.getString("thongso");
              int gianiemyet= rs.getInt("gianiemyet");
              int giaban= rs.getInt("giaban");
              String math= rs.getString("math");
              String madm= rs.getString("madm");
              String makm= rs.getString("makm");
       
              SanPham sp = new SanPham(masp, tensp, thongso, gianiemyet,giaban, math, madm, makm);
              listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return listSP;
   }
   public boolean InsertSanPham(String masp,String tensp, String math, String madm, String thongso, int  gianiemyet,int giaban){
       String sql = "INSERT INTO dbo.SanPham(masp,tensp,thongso,gianiemyet,giaban,math,madm,makm)VALUES('"+masp+"','"+tensp+"','"+thongso+"',"+gianiemyet+","+giaban+",'"+math+"','"+madm+"',NULL)";
    try {
        int rs = DataProvider.executeUpdate(sql);
        if(rs>0){
        return true;
        }
        else{
        return false;
        }
    
            
    }catch(Exception e){
        
      e.printStackTrace();
      return false;
    }
   }
   
   public boolean UpdateSanPham(String masp,String tensp, String math, String madm, String thongso, int  gianiemyet,int giaban){
       String sql ="UPDATE dbo.SanPham SET tensp = '"+tensp+"' , thongso = N'"+thongso+"', gianiemyet ="+gianiemyet+" , giaban ="+giaban+" , math = '"+math+"', madm= '"+madm+"' where masp ='"+masp+"'";
     try {
        int rs = DataProvider.executeUpdate(sql);
        if(rs>0){
        return true;
        }
        else{
        return false;
        }
    
            
    }catch(Exception e){
        
      e.printStackTrace();
      return false;
    }  
   
   }
   public boolean DeleteSanPham(String masp){
       String sql ="DELETE dbo.SanPham  where masp ='"+masp+"'";
     try {
        int rs = DataProvider.executeUpdate(sql);
        if(rs>0){
        return true;
        }
        else{
        return false;
        }
    
            
    }catch(Exception e){
        
      e.printStackTrace();
      return false;
    }  
   }
   public int sl_spban(){
       int sl = 0;
       String sql= "SELECT Sum(sl) as sl FROM DonHang dh JOin HoaDon hd ON hd.mahd = dh.mahd and hd.trangthai=1";
       try {
             ResultSet rs = DataProvider.executeQuery(sql);
             while (rs.next()){
                  sl = rs.getInt("sl");
             }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return sl;
   }
      public String get_Tensp(String masp){
       String ten = "";
       String sql= "SELECT tensp From SanPham where masp ='"+masp+"'";
       try {
             ResultSet rs = DataProvider.executeQuery(sql);
             while (rs.next()){
                  ten = rs.getString("tensp");
             }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return ten;
   }
      
}
