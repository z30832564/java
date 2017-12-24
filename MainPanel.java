package hm;
/*
 autor:carter
 date:2017.12.24
 16������Ϸ
 */
import javax.swing.*;  
import java.util.*;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class MainPanel extends JFrame implements ActionListener {  
  
    //�������  
    JPanel jp1=new JPanel();
    JPanel jp2=new JPanel();
    JLabel jlb1=null;
    JButton jb0=new JButton("��ʼ");
    int num[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};//���ڳ�ʼ����
    JButton btn[]= new JButton[16];
    int num_A[]= new int[16];//num_A[] �൱��Ҫ���е� num[]
          
    //��ʼ�����棬��ʼǰ�Ľ��� 
    public void inital() {
    	int i,j;
    	for(j=0;j<16;j++)
    	{
    		btn[j]=new JButton(""+num[j]);
    	}
    	for(i=0;i<16;i++)
    	{
    		jp1.add(btn[i]);
    		btn[i].addActionListener(this);
    	}
    	for(i=0;i<16;i++)
    	{
    		if(num_A[i]==16)
    		{
    			btn[i].setVisible(false);
    		}
    	}
    	
    }
    
    //��ʼ�������������
    public void start() 
    {
    	Random r1 = new Random();
    	int count=0,i,j;
    	int sign[]= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    	while(count<16)
    	{
    		i = r1.nextInt(16);
    		if(sign[i] == 0)
    		{
    			sign[i]=1;
    			num_A[count]=i+1;
    			count++;
    		}
    	}
    	/*for(i=0;i<14;i++)
    	{
    		num_A[i]=i+1;
    	}
    	num_A[14]=16;
    	num_A[15]=15;*/
    	for(j=0;j<16;j++)
    	{
    		btn[j].setText(""+num_A[j]);
    	}
    	for(i=0;i<16;i++)
    	{
    		jp1.add(btn[i]);
    	}
    	for(i=0;i<16;i++) {
    		btn[i].setVisible(true);
    	}
    	for(i=0;i<16;i++)
    	{
    		if(num_A[i]==16)
    		{
    			btn[i].setVisible(false);
    		}
    	}
    	
    }
    
    
    //����������
    public MainPanel()  
    {  
    	inital();
    	jp2.add(jb0);
    	jb0.addActionListener(this);
        //���ò��ֹ�����
        jp1.setLayout(new GridLayout(4,4));
        this.setLayout(new GridLayout(2,1));
        this.add(jp1);
        this.add(jp2);
        //���������ñ���  
        this.setTitle("16����������Ϸ");  
        //���ô����С  
        this.setSize(400,300);
        //���ô����ʼλ��  
        this.setLocation(5, 5);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //��ʾ����  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }  
    
    
    //�ж�ʤ���ķ���
    public void judge() {
    	int flag=1,i;
    	for(i=0;i<16;i++)
    	{
    		if(num_A[i]!=num[i])
    			flag=0;
    	}
    	if(flag==1)
    	{
    		JOptionPane.showMessageDialog(null,"��ϲ�㣡","��Ϸ����",JOptionPane.WARNING_MESSAGE);
    	}
    }
    
    
    //�հ׼�ⷵ��  1-���  2-�ұ�  3-�ϱ�  4-�±�
    public int jiance(int i)
    {
    	int flag = 0;
    	if((i-1>=0) && (i%4 - (i-1)%4 ==1))
    	{
    		if(num_A[i-1]==16)
    			flag=1;//�� 
    	}
    	if((i+1<=15) && ((i+1)%4 - (i)%4 ==1))
    	{
    		if(num_A[i+1]==16)
    			{
    			flag=2;//��
    			}
    	}
    	if((i-4>=0))
    	{
    		if(num_A[i-4]==16)
    			flag=3;//��
    	}
    	if((i+4<=15))
    	{
    		if(num_A[i+4]==16)
    			flag=4;//��
    	}
    	return flag;
    }
    
    
    //�����¼�
	public void actionPerformed(ActionEvent e) {  
	    
	    if(e.getActionCommand()=="��ʼ")  
	    {
	    	start();
	    }
	    else {
	    	int i,index,direct,temp;
	    	JButton button = (JButton) e.getSource();
	    	String text = button.getText();
	    	i=Integer.valueOf(text).intValue();
	    	for(index =0;index<16;index++)
	    	{
	    		if(num_A[index]==i)
	    			break;
	    	}
	    	direct = jiance(index);
	    	if(direct!=0)
	    	{
	    		if(direct==1) {
	    			temp = num_A[index-1];
	    			num_A[index-1]=num_A[index];
	    			num_A[index]=temp;
	    			btn[index].setText(""+num_A[index]);
	    			btn[index-1].setText(""+num_A[index-1]);
	    			btn[index].setVisible(false);
	    			btn[index-1].setVisible(true);
	    		}
	    		if(direct==2) {
	    			temp = num_A[index+1];
	    			num_A[index+1]=num_A[index];
	    			num_A[index]=temp;
	    			btn[index].setText(""+num_A[index]);
	    			btn[index+1].setText(""+num_A[index+1]);
	    			btn[index].setVisible(false);
	    			btn[index+1].setVisible(true);
	    		}
	    		if(direct==3) {
	    			temp = num_A[index-4];
	    			num_A[index-4]=num_A[index];
	    			num_A[index]=temp;
	    			btn[index].setText(""+num_A[index]);
	    			btn[index-4].setText(""+num_A[index-4]);
	    			btn[index].setVisible(false);
	    			btn[index-4].setVisible(true);
	    		}
	    		if(direct==4) {
	    			temp = num_A[index+4];
	    			num_A[index+4]=num_A[index];
	    			num_A[index]=temp;
	    			btn[index].setText(""+num_A[index]);
	    			btn[index+4].setText(""+num_A[index+4]);
	    			btn[index].setVisible(false);
	    			btn[index+4].setVisible(true);
	    		}
	    		
	    	}
	    	judge();
	    }
	}
	
	
	//������
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        MainPanel  mp=new MainPanel();
    } 
    
}
