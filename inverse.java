package hm;
import java.io.*;
public class inverse {

   public static void main(String args[]) {
      RandomAccessFile inAndOut=null;
      int data[]={1,2,3,4,5,6,7,8,9,10};
      try{ 
    	  inAndOut=new RandomAccessFile("inverse.txt","rw");
           for(int i=0;i<data.length;i++) {
              inAndOut.writeInt(data[i]);
           } 
           for(long i=data.length-1;i>=0;i--) { 
//һ��int������ռ4���ֽڣ�inAndOut�� �ļ��ĵ�36���ֽڶ�
//ȡ������һ�������� ÿ��4���ֽ���ǰ��ȡһ������
              inAndOut.seek(i*4);          
              System.out.printf("%d",inAndOut.readInt()); 
           }
           inAndOut.close();
      }
      catch(IOException e){} 
   }

}

