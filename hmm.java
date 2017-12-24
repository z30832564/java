package hm;
import java.io.*;
import java.util.*;
public class hmm {
   public static void main(String args[]){
	 File p = new File("D:\\goods.txt");
		       File q = new File("D:\\goodsVolume.txt");
	   try{
		   FileReader inOne = new FileReader("D:\\goods.txt");
		   BufferedReader inTwo = new BufferedReader(inOne);
		   FileWriter tofile=new FileWriter("D:\\goodsVolume.txt");
		   BufferedWriter out = new BufferedWriter(tofile);
		   String s = null;
		   double tj=0;
		   while((s=inTwo.readLine())!=null)
		   {
			   tj = Jisuan.getVolume(s);
			   out.write(s + "Με»ύ£Ί" + tj +"cm^3");
			   out.newLine();
		   }
		   out.flush();
		   out.close();
		   tofile.close();
		   inOne=new FileReader("D:\\goodsVolume.txt");
		   inTwo=new BufferedReader(inOne);
		   while((s=inTwo.readLine())!=null){
			   System.out.println(s);
		   }
		   inOne.close();
		   inTwo.close();
	   }catch(IOException e){
		   System.out.println(e);
	   }
   }
}






class Jisuan{ 
	public static double getVolume(String s){ 
		Scanner scanner=new Scanner(s); 
		scanner.useDelimiter("[^0123456789.]+"); 
		double volume=1; 
		while(scanner.hasNext()){  
			try
			{
				double distance=scanner.nextDouble(); 
				volume=volume*distance; 
			 } catch(InputMismatchException exp)
			{ 
				 	String t=scanner.next();
			 }
			}
		return volume; 
			} 
		}


