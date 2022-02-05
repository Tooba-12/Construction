/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tooba
 */
import java.io.*;
import java.sql.*;
import java.util.*;

public class InsertFileData{
public static void main(String[]args){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "root");
Statement st=con.createStatement();

FileInputStream fstream = new FileInputStream("C:\\emplyoee.txt");
DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
String strLine;
ArrayList list=new ArrayList();
while ((strLine = br.readLine()) != null){
list.add(strLine);
}
Iterator itr;
for (itr=list.iterator(); itr.hasNext(); ){
String str=itr.next().toString();
String [] splitSt =str.split(" ");
String id="",name="",address="",CNIC="";
for (int i = 0 ; i < splitSt.length ; i++) {
id=splitSt[0];
name=splitSt[1];
address=splitSt[2];
CNIC=splitSt[3];
}

int k=st.executeUpdate("insert into emplyoee(id,name,address,CNIC) values('"+id+"','"+name+"','"+address+"','"+CNIC+"')");

}
}
catch(Exception e){}
}
}