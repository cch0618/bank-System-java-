import java.util.Scanner;
import java.util.Random;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Account // ����Ŭ����
{
   // private �� accountNumber, name, password, 
   private String accountNumber;         //����


   private String name;                  //����� �̸�
   private String password;              //���� ��й�ȣ
   private int accountBalance;           //�����ܾ�
   private String jumin;                 //�ֹε�Ϲ�ȣ
  
   String savingName;                    //�����̸�
   private String savingNum;             //���� ���� 
   private double savingBalance;         //���� �ܾ�
   double savingLastBalance;             //���� �����ܾ�
   
   private int point;                    //��������Ʈ

   int deposit;                          //�Ա�
   int withdraw;                   //���
   


   //setter()
   public void setaccountNumber(String accountNumber) {this.accountNumber = accountNumber;}
   public void setname(String name) {this.name = name;}
   public void setpassword(String password) {this.password = password;}
   public void setaccountBalance(int accountBalance) {this.accountBalance = accountBalance;}
   public void setjumin(String jumin) {this.jumin = jumin;}
   public void setsavingNum(String savingNum) {this.savingNum = savingNum;}
   public void setsavingBalance(double savingBalance) {this.savingBalance = savingBalance;}

   //getter()
   public String getaccountNumber() { return accountNumber;}
   public String getname() { return name;}
   public String getpassword() {return password;}
   public int getaccountBalance() {return accountBalance;}
   public String getjumin() {return jumin;}
   public String getsavingNum() {return savingNum;}
   public double getsavingBalance() {return savingBalance;}

}




public class Manage2
{
   Scanner sc= new Scanner(System.in);
   Calendar ca = Calendar.getInstance();

   double RateEnhwa = 1120.0;
   double Ratedollar = 1200.0;
   double RateWean = 1000.0;
   double RateEuro = 2200.0;

   Account[] acArray=new Account[100];
   String pname;                  // ����ڰ� �Է��� �̸��� ����� ����
   String pAccountNum;            // ����ڰ� �Է��� ���¹�ȣ�� ����� ����
   String ppw;                    // ����ڰ� �Է��� ��й�ȣ�� ����� ����
   int inM, outM;
   int a;
   int inwon;                
  

   
   // ���� �޼ҵ�
   public void help()
   {
      System.out.println();
      System.out.println("          �� ���� �̿�ð� ��");
      System.out.println("=========================================");
      System.out.println("             24�ð� 365��");
      System.out.println("( 00:00 ~ 00:30 ���̿��� �ý��� ��������");
      System.out.println("         ���� �̿� �Ұ��մϴ�.");
      System.out.println();
      System.out.println("            �� �̿�ȳ� ��");
      System.out.println("=========================================");
      System.out.println("  1. ù ȭ�鿡�� ���Ͻô� ��ư�� ����");
      System.out.println("  2. [ ���� (����, ��ȸ, ����) ���� ]");
      System.out.println("  3. [  �׸� ���� �� ���� �Է�  ]");
      System.out.println();
      System.out.println("           �� ��� ������ ��");
      System.out.println("=========================================");
      System.out.println("      ���� ���� ��ü�� : ������ ����.");
      System.out.println("      Ÿ�� ���� ��ü�� : ������ 500��.");
      System.out.println();
      System.out.println("            �� ���ǻ��� ��");
      System.out.println("=========================================");
      System.out.println(" �� ���� ��ȸ & ����� & ���� ��ü ��,");
      System.out.println("    ����, ���¹�ȣ, ��й�ȣ�� �ʿ��մϴ�.");
      System.out.println(" �� �������� ���� ���Ϳ��� ��й�ȣ �䱸��");
      System.out.println("    �����ͷ� �ݵ�� ���� �ٶ��ϴ�.");
      System.out.println(" �� ���¹�ȣ, ��й�ȣ �н� ��");
      System.out.println("    �����ͷ� ���� �ٶ��ϴ�.");
      System.out.println();
      System.out.println("           �� ���޼��� ��");
      System.out.println("=========================================");
      System.out.println("    �Ϲݰ� : ���� �ܾ� ~ 500����");
      System.out.println(" vip �� : ���� �ܾ� 500���� ~ 5000����");
      System.out.println("    vvip �� : ���� �ܾ� 5000����~5��");
      System.out.println();
      System.out.println("     �΢� ������ : 02) 336 - 8546 ");
      System.out.println();
   }
      

    // ���� ���� �޼ҵ�
   public void openAccount()
   { 

      // �ֹε�Ϲ�ȣ ��ȿ�� �˻翡 �ʿ��� ������
      int sum=0;
      int[] num = {2,3,4,5,6,7,0,8,9,2,3,4,5};
      int namuji;

      int n,a;   

      Scanner sc= new Scanner(System.in);

     // AccountŬ���� ��� �ν��Ͻ��� inwonũ�� ��ŭ ����
      acArray[inwon] = new Account();
   
     try
     {
      // �̸� �Է¹ޱ�
      System.out.print("�� �̸��� �Է��ϼ���: ");
      acArray[inwon].setname(sc.next());
       
      // �ֹε�Ϲ�ȣ �Է¹ޱ�
      System.out.print("�� �ֹε�Ϲ�ȣ�� �Է��ϼ���: ");
      acArray[inwon].setjumin(sc.next());

      // �ֹε�Ϲ�ȣ ��ȿ�� �˻�
      if(acArray[inwon].getjumin().length() != 14)
         System.out.println(">>�Է� ����~!!!");
         
      for(int i=0; i<num.length;i++)
      {
         if(i==6)
            continue;
         sum += num[i] * Integer.parseInt(acArray[inwon].getjumin().substring(i,i+1));
      }   

      namuji = (11-sum%11)%10;

      // �ֹε�Ϲ�ȣ�� ��ȿ�� ���
      if(namuji==Integer.parseInt(acArray[inwon].getjumin().substring(13)))
      {
        // ���� ����
        // ���� ���� ���� ���� Ȯ��
        System.out.print("�� ���� ���¸� �����Ͻðڽ��ϱ� (YES : 1) OR (No : 2) ");
        n=sc.nextInt();
        System.out.print("�� �Ϲ� ���¸� �����Ͻðڽ��ϰ� (YES : 1) OR (No : 2) ");
        a = sc.nextInt();
 
       // ���� ���� �޼ҵ� ȣ��
        createAccount(n,a);

        // ���ݰ��¿� �Ϲݰ��� �Ѵ� �ȸ���ٸ� ����
        if(n==2 && a==2)
          return;

        // �ܾ� ���
        System.out.println("���Ϲ� �����ܾס�:"+acArray[inwon].getaccountBalance()+"��");
        System.out.println();
     }

    // �ֹι�ȣ�� ��ȿ���� ���� ���
     else
    {
         System.out.println("�ءء� ��ȿ���� ���� �ֹι�ȣ~!!! �ءء�");
       return;
    }
     }
     catch (NullPointerException e)
     {
        System.out.println("�ùٸ� ���ڸ� �Է����ּ��� ! " );
     }
      

   } // end openAccount

  
   // ���� ���� �޼ҵ�
   public void createAccount(int j,int k)
   {
       int c; 
      // ���ݰ��� ���ڸ� ���� ������ȣ 1111�� �ʱ�ȭ
       String a="1111";
      // �Ϲݰ��� ���ڸ� ���� ������ȣ 2222�� �ʱ�ȭ
       String b="2222";
       Random rd = new Random();
      
       acArray[inwon].setaccountBalance(0);        // ���� ���� �� �ܾ� �ʱ�ȭ

       if( j==1 && k==1)                     // ���� O �Ϲ� ���� O
       {
         
           // ���ݰ��¿� �Ϲݰ��¸� �����Լ��� ����Ͽ� ���¹�ȣ ����
         // ������ȣ ���ڸ� 4�ڸ��� ������ 10�ڸ� �����ϹǷ� 10�� �ݺ��Ͽ� ����
         for(int i=0; i<10; i++)
           {
            a+=Integer.toString(rd.nextInt(9));
            acArray[inwon].setsavingNum(a);

            b+=Integer.toString(rd.nextInt(9));
            acArray[inwon].setaccountNumber(b);
           }
        
           // ��� �޼ҵ� ȣ��
         moklok();      
         // ��й�ȣ ���� �޼ҵ� ȣ��
           createpassword();
         // ��� ���
         System.out.println();
           System.out.println(acArray[inwon].getname()+"���� ������ ���¹�ȣ�� : "+acArray[inwon].getsavingNum());
           System.out.printf("%s���� ���Ϲ� ���¹�ȣ�� : %s \n",acArray[inwon].getname(),acArray[inwon].getaccountNumber());

      }

      else if(j==1 && k==2)      //���� O �Ϲ� ���� X
      {
         
         // ���ݰ��¸� �����Լ� ����Ͽ� ���¹�ȣ ����
         for(int i=0; i<10; i++)
            {
            a+=Integer.toString(rd.nextInt(9));
            acArray[inwon].setsavingNum(a);
            }

            moklok();   
            createpassword();
         System.out.println();
            System.out.println(acArray[inwon].getname()+"���� ������ ���¹�ȣ��:"+acArray[inwon].getsavingNum());
      
      }

      else if(j==2 && k==1)      // ���� X �Ϲ� ���� O
      {
        
         // �Ϲݰ��¸� �����Լ� ����Ͽ� ���¹�ȣ ����
         for(int i=0; i<10; i++)
            {
              b+=Integer.toString(rd.nextInt(9));
              acArray[inwon].setaccountNumber(b);
            }
           
            createpassword();
            System.out.printf("%s���� ���Ϲ� ���¹�ȣ�� :%s\n",acArray[inwon].getname(),acArray[inwon].getaccountNumber());
      }

      else if(j==2 && k==2)     // ���� X �Ϲ� ���� X
         System.out.println("�ٽ� �̿����ּ��� ! ");
         
   } // end creatAccount

  // ��� �޼ҵ�
  public void moklok()      // j==1 �϶� ȣ��. ( ���� ��ϰ� ���� ���� ��� �޼ҵ� )
  {

        int c;                   // ����ڿ��� �Է¹��� ��ȣ�� ������ ����
        double interest=1;       // ���ڸ� 1�� �ʱ�ȭ
        int y=1;                 // ���� ��� �� �ʿ��� ������ 1�� �ʱ�ȭ
         
      System.out.println();
        System.out.println("���� ��ǰ ����� �����ϼ��� ");

        // ���ݻ�ǰ ����
      System.out.print("��1.��������(������:0.1%)-��� �Ⱓ 1�⡽ \n��2.�ֿ�����(������:0.2%)-��� �Ⱓ 2�⡽ \n��3.û������(������:0.3%)-��� �Ⱓ 3�⡽\n");
      System.out.print("�� ���Ͻô� ��ǰ�� ��ȣ�� �������ּ���. (1, 2, 3) : ");
        c=sc.nextInt();
      System.out.println();

        // ����ڰ� ������ ���ݻ�ǰ�� ����� ������ ���ݻ�ǰ�̸��� ����
      switch (c)
        {
          case 1:
            acArray[inwon].savingName="1.��������(������:0.1%)��� �Ⱓ 1��";
          break;
          case 2:
            acArray[inwon].savingName="2.�ֿ�����(������:0.2%)��� �Ⱓ 2��";
          break;
          case 3:
            acArray[inwon].savingName="3.û������(������:0.3%)��� �Ⱓ 3��";
          break;
          
        }

        // ������ �Ա��� �ݾ� �Է¹ޱ�
      // ���� �̸� �Է��ϸ� ��� �ݺ�
      do
        {
                  
             System.out.print("������ ���� �ݾ� �Է� (10000���̻�): ");
             acArray[inwon].setsavingBalance(sc.nextDouble());

             if(acArray[inwon].getsavingBalance()>=10000)
                 continue;
               
             System.out.println("���� �̻� �־��ּ��� !!");

        }while (acArray[inwon].getsavingBalance()<10000);
         
        // ����ڰ� ������ ��ǰ���� ���� ��� ����
      switch(c)            // �ܸ� (���ڿ� ���ڰ� ����)
     {
                      // 
               case 1:
               {
                   acArray[inwon].savingLastBalance=(acArray[inwon].getsavingBalance()*12)+(acArray[inwon].getsavingBalance()*(interest*0.1));
                   break;   
               }
               case 2:
               {
                   y=2;
                   acArray[inwon].savingLastBalance=(acArray[inwon].getsavingBalance()*24)+(acArray[inwon].getsavingBalance()*(interest*0.2));
                   break;
               }
               case 3:
               {
                   y=3;
                   acArray[inwon].savingLastBalance=(acArray[inwon].getsavingBalance()*36)+(acArray[inwon].getsavingBalance()*(interest*0.3));
                   break;
               }
                 
                   
        } //end switch

      //���ݰ��Գ�¥ - ���糯¥ ���\
      System.out.println();
        System.out.println("���ݰ��Գ�¥: " + ca.get(Calendar.YEAR) + "-" +(ca.get(Calendar.MONTH)+1)+ "-" + ca.get(Calendar.DATE));
            
        //����ڰ� ������ ��ǰ�� ���� ��� ���
      //1�� ��ǰ
      if(y==1)
        {
             //����⵵�� ����ϱ� ���� add�޼ҵ� ���
          ca.add(Calendar.YEAR,y);
          System.out.println("=============================================================================");
          //������ ���
             System.out.println(acArray[inwon].getname()+"�� ���� ������ : " + interest*0.1 +"%");
          //���ݸ���ݾ� ���
             System.out.println("�������� 1��� ���� ���� �ݾ� :"+(int)acArray[inwon].savingLastBalance+"��");
          //������ ���
             System.out.println("�������� ������ : "+ ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH)+1) + "-" + ca.get(Calendar.DATE));    
          System.out.println("=============================================================================");
         }
       //2�� ��ǰ
         else if(y==2)
         {
               //����⵵�� ����ϱ� ���� add�޼ҵ� ���
           ca.add(Calendar.YEAR,y);
           System.out.println("=============================================================================");
              System.out.println(acArray[inwon].getname()+"�� ���� ������ :"+ interest*0.2+"%");
              System.out.println("�ֿ����� 2��� ���� ���� �ݾ� :"+(int)acArray[inwon].savingLastBalance+"��");
              System.out.println("�ֿ����� ������ : "+ ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH)+1) + "-" + ca.get(Calendar.DATE));
           System.out.println("=============================================================================");
          }
        //3�� ��ǰ
          else if(y==3)
          {
               //����⵵�� ����ϱ� ���� add�޼ҵ� ���
           ca.add(Calendar.YEAR,y);
           System.out.println("=============================================================================");
              System.out.println(acArray[inwon].getname()+"�� ���� ������ : " + + interest*0.3+"%");
              System.out.println("û������ 3��� ���� ���� �ݾ� :"+(int)acArray[inwon].savingLastBalance+"��");
              System.out.println("û������ ������ : "+ ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH)+1) + "-" + ca.get(Calendar.DATE));
           System.out.println("=============================================================================");
          }
                  
  } //end moklok
               
  //��й�ȣ ���� �޼ҵ�
  public void createpassword()
  {
       //��й�ȣ ����
       do
       {
          System.out.println();
         System.out.println("���� ��й�ȣ ���� ����");
            System.out.print("�� (4�ڸ�)��й�ȣ�� �Է��ϼ��� : ");
            acArray[inwon].setpassword(sc.next());
               
       }
       while (acArray[inwon].getpassword().length() != 4);        //��й�ȣ�� 4�ڸ��� �ƴϸ� �ٽ� �Է� ��û

           
  } // end createpasword



    public void deleteAccount() 
    {
      //Account ac = new Account();

       int i,j;         //�ݺ����� ���� ����
       String account;  //����ڿ��� �Է¹��� ������ ���� ����
       Scanner sc = new Scanner(System.in);

           //������ ���¹�ȣ ����ڿ��� �Է¹ޱ�
         System.out.print("������ ���¹�ȣ�� �Է����ּ��� : ");
           account = sc.next();
      
      try
      {
           //�迭���� �ش� ���¹�ȣ �˻�
         for (i=0; i < inwon+1; i++) 
          {
               //����� ���¹�ȣ�� ����ڰ� �Է��� ���¹�ȣ�� ���ٸ� ����
            if (acArray[i].getaccountNumber().equals(account))
               {
                //���� ������ ���¹�ȣ�� �迭�� ������ ���� ���
               if(i==inwon)
                   inwon--;    //�迭�� ���� ���ҽ��Ѽ� ����
       
                    //������ ���¹�ȣ�� ������ ���� �ƴ� ���
               else
                    {
                  //�ش���°� ����ִ� �迭���� �������� ���� �迭���� ������ ��� �̵���Ų��.
                  for (j=i; j<inwon+1;j++ )
                  {
                     acArray[j]=acArray[j+1];
                     /*
                     acArray[j].setaccountNumber(acArray[j+1].getaccountNumber());
                     acArray[j].setname(acArray[j+1].getname());
                     acArray[j].setpassword(acArray[j+1].getpassword());
                     acArray[j].setaccountBalance(acArray[j+1].getaccountBalance());
                     acArray[j].setaccountNumber(acArray[j+1].getaccountNumber());
                     acArray[j].setjumin(acArray[j+1].getjumin());
                     acArray[j].setsavingNum(acArray[j+1].getsavingNum());
                     acArray[j].setsavingBalance(acArray[j+1].getsavingBalance());
                     */
                     
                  }
                  //��� ������ �̵���Ų ��, �ϳ��� ���ŵǾ����Ƿ� �迭�� ũ�⸦ 1 �ٿ��ش�.
                  inwon--;
                    }

               System.out.println(inwon);

               System.out.println("�����Ǿ����ϴ�.");
            System.out.println();
               }

               //���� ����� ���¹�ȣ�� ����ڰ� �Է��� ���¹�ȣ�� ���� �ʴٸ�
            else
               {
               //�迭�� ������ Ž���� �Ϸ�Ǿ��ٸ�
               if(i==inwon)
               {
                //�޽��� ���
                System.out.println("���¹�ȣ�� ��ġ���� �ʽ��ϴ�");
                return;
               }    
               }
              
            } //end for

      } //end try

      //NullPointerException �߻��ϸ� catch
     catch (NullPointerException e)
      {      
      }

  } // end deleteCount



  // ��/��� ���� & ���¹�ȣ(�̸�) ��ȸ �޼ҵ� ����
  public void input()            
  {
       Scanner sc = new Scanner(System.in);     

      // �ֿ� ���� ����
      int select;         // ����� ���� ����
      
      //�Ա�, ��� ����
     do
      {
         System.out.print(" �Ա�---(1) / ���---(2) : ");
         select = sc.nextInt();
      }
      while (select<1 || select>2);

      System.out.print(" ������ �����ԡ��� �Է����ּ���. : ");
      pname = sc.next();

      System.out.print(" ������ ������ ��ȣ���� �Է����ּ���(���ڸ� �Է�). : ");
      pAccountNum = sc.next();

      System.out.print(" ������ ����й�ȣ���� �Է����ּ���. : ");
      ppw = sc.next();

      if (select==1)                  // �Ա��� ����������
         inMoney();              // �Ա� �޼ҵ� ȣ��

      if (select==2)                  // ����� ����������
         outMoney();             // ��� �޼ҵ� ȣ��

   } //end input()

   // �Ա� �޼ҵ� ����
   public void inMoney()         
   {
    
      Scanner sc = new Scanner(System.in);
      System.out.println("���Ա� �޼ҵ� ó�����ۡ�");
      
      //�迭Ž��
     for (int i=0; i<inwon+1; i++)
      {
         if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw))) // ���¹�ȣ ��ġ ��or�� ��й�ȣ ��ġ
         {
            if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw)) // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ O
            {
             System.out.println("���¹�ȣ, ��й�ȣ�� ��ġ�մϴ�.");
        
             //��� ���
             System.out.println();
             System.out.println("==============================================================");
             System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
             System.out.println(" ���� �ܾ� ��ȸ : " + acArray[i].getaccountBalance());
             System.out.println("==============================================================");

             System.out.println();
             //�Աݱݾ� �Է¹ޱ�
             System.out.print(" �󸶸� �Ա� �Ͻðڽ��ϱ�? : ");
             inM = sc.nextInt();
        
             System.out.println(" �Ա� �ݾ� : " + inM);

             //�ܾ׿� �Աݱݾ��� ������Ų��
             a = acArray[i].getaccountBalance();
             a += inM;
             acArray[i].setaccountBalance(a);
        
             System.out.println("=================================================");
             System.out.println(" �Ա� �� �ݾ� : " + acArray[i].getaccountBalance());
             System.out.println(); 
             break;
            }

            if(!acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))// ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ O
            {
                 //�޽��� ���
             System.out.println("��й�ȣ�� ��ġ������, ���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
                 break;
            }

            if(acArray[i].getaccountNumber().equals(pAccountNum) && !acArray[i].getpassword().equals(ppw)) // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ X
         {
                 //�޽��� ���
             System.out.println("���¹�ȣ�� ��ġ������, ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
                 break;
            }
         } //end if

         else  // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ X
         {
                 
            if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)) && i==(acArray.length))                                                 // �ݺ����� ������ �迭���� ������ ���
            {
               System.out.println("��ġ�ϴ� ������ �����ϴ�.");        // ��ġ�ϴ� ������ ���ٰ� ����� �� ����.
            break;
            }

         } //end else
      } // end for
   } //end inMoney()

   
  // ��� �޼ҵ� ����
   public void outMoney()               
   {
      Scanner sc = new Scanner(System.in);  
      System.out.println("��� �޼ҵ� ó������");

      for (int i=0; i<acArray.length; i++)
      {
         if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)))  // ���¹�ȣ ��ġ ��or�� ��й�ȣ ��ġ
         {
            if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))  // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ O
            {
                 System.out.println("���¹�ȣ, ��й�ȣ�� ��ġ�մϴ�.");
      
                 //��� ���
             System.out.println();
                 System.out.println("===============================================");
                 System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                 System.out.println(" ���� �ܾ� ��ȸ : " + acArray[i].getaccountBalance()); 
                 System.out.println();

             //��ݱݾ� �Է¹ޱ�
                 System.out.print(" �󸶸� ��� �Ͻðڽ��ϱ�? : ");
                 outM = sc.nextInt();
               
                 //���� �ܾ��� ��ݱݾ׺��� ���ٸ�
             if (acArray[i].getaccountBalance()<outM)
                 {   
               System.out.println("��ݰ��ɱݾ��� �ѵ��ʰ� �Ǿ����ϴ�. �����մϴ�.");
                    System.out.println();
                    break;
                 }
      
                 System.out.println(" ��� �ݾ� : " + outM);
           
                 //��� �ݾ� ��������
             a-=outM;
                 acArray[i].setaccountBalance(a);
      
      
                 System.out.println("=================================================");
              System.out.println(" ��� �� �ݾ� : " + acArray[i].getaccountBalance());
      
                 break;
            }

            if(!acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw)) // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ O
            {
               System.out.println("��й�ȣ�� ��ġ������, ���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
               break;
            }

            if(acArray[i].getaccountNumber().equals(pAccountNum) && !acArray[i].getpassword().equals(ppw)) // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ X
            {
               System.out.println("���¹�ȣ�� ��ġ������, ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
               break;
            }
         }

         else  // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ X
         {
                                                 
             if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)) && i==(acArray.length))                                                 // �ݺ����� ������ �迭���� ������ ���
          {
              System.out.println("��ġ�ϴ� ������ �����ϴ�.");     // ��ġ�ϴ� ������ ���ٰ� ����� �� ����.
              break;
           }
         } //end else   
      }// end for
   }//end outMoney()

   
   // ���� ��ü �޼ҵ� ���� (Ÿ����ü, ������ü)
   public void sendmoney()
   {
      int i=0,j=0;      // �ݺ��� ������ ���� ���� ���� �� �ʱ�ȭ
      int sendm=0;      // �ԷµǴ� ��ü�ݾ��� ��Ƶ� ���� ���� �� �ʱ�ȭ

      Scanner sc = new Scanner(System.in);
      

      System.out.print("������ ������ �Է��ϼ��� : ");
      String customer_name = sc.next();

      System.out.print("������ ���¸� �Է��ϼ��� : ");
      String customer = sc.next();
   
      System.out.print("���� ������ ��й�ȣ�� �Է��ϼ��� : ");
      String customer_password = sc.next();
            

         
      for (i=0; i<acArray.length; i++)                                                               // �迭�� ���̸�ŭ(�� �� ��ŭ) �ݺ��� ����
      {
         if (acArray[i].getaccountNumber().equals(customer) || (acArray[i].getpassword().equals(customer_password)))    // ���¹�ȣ ��ġ ��or�� ��й�ȣ ��ġ
         {
            if(acArray[i].getaccountNumber().equals(customer) && acArray[i].getpassword().equals(customer_password))    // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ O
            {
               System.out.print("��ü�Ͻ� ���¹�ȣ�� �Է����ּ��� : ");
               String guest = sc.next();
               System.out.print("�󸶸� ��ü �Ͻðڽ��ϱ�? : ");
               sendm = sc.nextInt();
         
               if (acArray[i].getaccountBalance()<sendm+500)                                    // ���� �ܾ��� ��ü �ݾ׺��� ���� ���
               {
                  System.out.println("�ءءءء� ��ݰ��ɱݾ��� �ѵ��ʰ� �Ǿ����ϴ�. �ءءءء�");         // �ѵ� �ʰ� ��¹� ǥ��
                  break;
               }

               try
               { 
                  if (guest.length()!=14)      // Ÿ����ü
                  {
                     acArray[i].setaccountBalance(acArray[i].getaccountBalance()-sendm-500);            // ���� ���� �ܾ׿��� - ��ü �ݾ� - ������(500��)
                System.out.println("=============================================================================================================");
                     System.out.printf("%s�� %d�� ��ü�߽��ϴ�. \nŸ����ü ������� 500�� �Դϴ�. \n���� �ܾ��� %d�� �Դϴ�.\n",guest,sendm,acArray[i].getaccountBalance());
                  }
                  else                     // ���� ��ü
                  {
                     acArray[i].setaccountBalance(acArray[i].getaccountBalance()-sendm);
                System.out.println("=============================================================================================================");
                     System.out.printf("%s�� %d�� ��ü�߽��ϴ�. \n���� �ܾ��� %d�� �Դϴ�.\n",guest,sendm,acArray[i].getaccountBalance());

                     for (j=0; j<acArray.length+1; j++)
                     {
                        if (acArray[j].getaccountNumber().equals(guest))                           // �ݺ��� �����鼭 ��ü�Ǵ� ���¹�ȣ��, �� ������ ��ġ�ϰ� �Ǹ�
                     acArray[j].setaccountBalance((acArray[j].getaccountBalance())+sendm);         // ���� ���� �ܾ׿��� ��ü �ݾ��� �߰��� �ݾ����� ����.
                     }
                     System.out.printf("%s�� %d�� ��ü�߽��ϴ�. ���� �ܾ��� %d�� �Դϴ�.",guest,sendm,acArray[i].getaccountBalance());
                  }
               }
               catch (NullPointerException e)
               {
               }

               System.out.println("���¹�ȣ, ��й�ȣ ��ġO");
               break;
            }

            if(!acArray[i].getaccountNumber().equals(customer) && acArray[i].getpassword().equals(customer_password))   // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ O
            {
               System.out.println("��й�ȣ�� ��ġ������, ���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
               break;
            }

            if(acArray[i].getaccountNumber().equals(customer) && !acArray[i].getpassword().equals(customer_password))   // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ X
            {
               System.out.println("���¹�ȣ�� ��ġ������, ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
               break;
            }
         }

         else
       {
            if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)) && i==(acArray.length))  // �ݺ����� ������ �迭���� ������ ���
            {
               System.out.println("��ġ�ϴ� ������ �����ϴ�.");                // ��ġ�ϴ� ������ ���ٰ� ����� �� ����.
               break;
            }
         }
      }
   }

   // ������ ȯ���� ���� ȯ�� �޼ҵ� ����
   public void exchange()
   {
          
       
       int i;

      Scanner sc = new Scanner(System.in);      // Scanner Ŭ���� �ν��Ͻ� ����

      System.out.print(" ������ �����ԡ��� �Է����ּ���. : ");
      pname = sc.next();
      

      System.out.print(" ������ ������ ��ȣ���� �Է����ּ���(���ڸ� �Է�). : ");
      pAccountNum = sc.next();


      System.out.print(" ������ ����й�ȣ���� �Է����ּ���. : ");
      ppw = sc.next();

     try
     {
        for (i=0; i<acArray.length; i++)
        {
            if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ ��ġ ��or�� ��й�ȣ ��ġ
         {
               if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))   // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ O
               {
                  System.out.println("���¹�ȣ, ��й�ȣ ��ġO");        
                  System.out.println();
                  System.out.println("===============================================");
                  System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                  System.out.println(" ���� �ܾ� ��ȸ : " + acArray[i].getaccountBalance()); 
                  System.out.println();
                  System.out.print("1: �޷�, 2:����, 3:��ȭ, 4:����, 5:��\n");
              System.out.print("�� ���Ͻô� ȭ�� �������ּ���. : ");

         
                  int nums = sc.nextInt();         
                  int Krwon; // �ѱ���
          
   
           
                switch(nums)
                {
               case 1:   //��ȭ -> �޷� ȯ����
              
                      System.out.print("�� �ٲ� ��ȭ�ݾ��� �Է��ϼ��� : ");
                      Krwon = sc.nextInt();   
                      System.out.printf("ȯ���� �ݾ��� %.2f �޷��Դϴ�.\n",(double)Krwon/Ratedollar);
                  
               for (i=0; i<acArray.length; i++)
                  {
                     if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))   // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ O
                     {
                           System.out.println("���¹�ȣ, ��й�ȣ ��ġO");
                           System.out.println();
                           System.out.println("===============================================");
                           System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                          
                           // int a;
                           a-=Krwon;
                           acArray[i].setaccountBalance(a);
                           //acArray[i].getaccountBalance() -= Krwon;
                           System.out.println(" ȯ�� �� �ݾ� : " + acArray[i].getaccountBalance());
                     System.out.println();
                           
                     break;
                     }
                     
                  } // case1 end 

                           break;

               case 2:   //��ȭ -> ���� ȯ����
            
                  System.out.print("�� �ٲ� ��ȭ�ݾ��� �Է��ϼ��� : ");
                  Krwon = sc.nextInt();
                  System.out.printf("ȯ���� �ݾ��� %.2f �����Դϴ�.\n",(double)Krwon/RateEuro);
               
                   for (i=0; i<acArray.length; i++)
                   {
                      if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ, ��й�ȣ�� ��ġ�ϸ�
                      {
                         System.out.println("===============================================");
                         System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
               
                         //int a;
                         a -= Krwon;
                         acArray[i].setaccountBalance(a);
                  
                         //acArray[i].getaccountBalance() -= Krwon;
                         System.out.println(" ȯ�� �� �ݾ� : " + acArray[i].getaccountBalance());
                   System.out.println();
                         break;
                      }
                   } // case2 end 

                         break;
                


                   case 3:   //��ȭ -> ��ȭ ȯ����
             
                      System.out.print("�� �ٲ� ��ȭ�ݾ��� �Է��ϼ��� : ");
                      Krwon = sc.nextInt();
                      System.out.printf("ȯ���� �ݾ��� %.2f ��ȭ�Դϴ�.\n",(double)Krwon/RateEnhwa);
               
                   for (i=0; i<acArray.length; i++)
                   {
                      if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ, ��й�ȣ�� ��ġ�ϸ�
                      {
                         System.out.println("===============================================");
                         System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                
                         //int a;
                         a-=Krwon;
                         acArray[i].setaccountBalance(a);
                         //acArray[i].getaccountBalance() -= Krwon;
                         System.out.println(" ȯ�� �� �ݾ� : " + acArray[i].getaccountBalance());
                   System.out.println();
                         break;
                      }
                   } // case3 end 
                         
                   break;

                   case 4: //��ȭ -> ���� ȯ����
               
                      System.out.print("�� �ٲ� ��ȭ�ݾ��� �Է��ϼ��� : ");
                      Krwon = sc.nextInt();
                      System.out.printf("ȯ���� �ݾ��� %.2f �����Դϴ�.\n",(double)Krwon/RateWean);
               
                   for (i=0; i<acArray.length; i++)
                   {                 
                      if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ, ��й�ȣ�� ��ġ�ϸ�
                      {
                         System.out.println("===============================================");
                         System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                
                         //int a;
                         a -= Krwon;
                         acArray[i].setaccountBalance(a);
                         //acArray[i].getaccountBalance() -= Krwon;
                         System.out.println(" ȯ�� �� �ݾ� : " + acArray[i].getaccountBalance());
                   System.out.println();
                         break;
                      }
                   } // case4 end 

                         break;

                   case 5: //�ܱ� �� -> �ѱ������� �ٲܶ�!!!!
                  
                  System.out.print("������ ȭ�� ������ �Է��ϼ��� : 1: �޷�, 2:����, 3:��ȭ, 4:���� \n");
                 System.out.print("�� ���Ͻô� ȭ�� �������ּ���. : ");
                      int nums1 = sc.nextInt();
          
        
                 switch(nums1)
                   {
                      case 1: //�޷�->�� ���� �ٲܶ�
                      
                 System.out.print("�� ������ �޷��ݾ��� �Է��ϼ��� : ");
                      double ac1 = sc.nextDouble();
                      System.out.printf("ȯ���� �ݾ��� %s ���Դϴ�.\n",(int)(ac1 * Ratedollar));
                         
                     for (i=0; i<acArray.length; i++)
                         {   
                            if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ, ��й�ȣ�� ��ġ�ϸ�
                            {
                               System.out.println("===============================================");
                               System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                     
                               //int a;
                               a+=(int)(ac1 * Ratedollar);
                               acArray[i].setaccountBalance(a);
                               //acArray[i].getaccountBalance() += (int)(ac1 * 1200);
                               System.out.println(" ȯ�� �� �ݾ� : " + acArray[i].getaccountBalance());
                        System.out.println();
                               break;
                            }
                         }// case5 �� �׾ȿ� �ִ� case1�� �� --> �ܱ����� �ѱ������� ȯ���� �ܱ���==�޷��϶�
                           
                               break;


                      case 2:   //����->�� ���� �ٲܶ�

                      System.out.print("�� ������ ���αݾ��� �Է��ϼ��� : ");
                      double ac2 = sc.nextDouble();
                      System.out.printf("ȯ���� �ݾ��� %s ���Դϴ�.\n",(int)(ac2 * RateEuro));
                         for (i=0; i<acArray.length; i++)
                         { 
                            if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ, ��й�ȣ�� ��ġ�ϸ�
                            {
                               System.out.println("===============================================");
                               System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                           
                               //int a;
                               a += (int)(ac2 * RateEuro);
                               acArray[i].setaccountBalance(a);
                               //acArray[i].getaccountBalance() += (int)(ac2 * 2200);
                               System.out.println(" ȯ�� �� �ݾ� : " + acArray[i].getaccountBalance());
                        System.out.println();
                               break;
                            }
                         }// case5 �� �׾ȿ� �ִ� case1�� �� --> �ܱ����� �ѱ������� ȯ���� �ܱ���==�����϶�
                                 
                               break;
         
                      case 3:      //��ȭ->�� ���� �ٲܶ�

                      System.out.print("�� ������ ��ȭ�ݾ��� �Է��ϼ��� : ");
                      double ac3 = sc.nextDouble();
                      System.out.printf("ȯ���� �ݾ��� %s ���Դϴ�.\n",(int)(ac3 * RateEnhwa));
                         for (i=0; i<acArray.length; i++)
                         { 
                            if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ, ��й�ȣ�� ��ġ�ϸ�
                            {
                               System.out.println("===============================================");
                               System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                           
                              //int a;
                              a += (int)(ac3 * RateEnhwa);
                              acArray[i].setaccountBalance(a);
                              //acArray[i].getaccountBalance() += (int)(ac3 * 1120);
                              System.out.println(" ȯ�� �� �ݾ� : " + acArray[i].getaccountBalance());
                       System.out.println();
                              break;
                            }
                         }// case5 �� �׾ȿ� �ִ� case1�� �� --> �ܱ����� �ѱ������� ȯ���� �ܱ���==��ȭ�϶�
                                 
                              break;

                      case 4:      //����->�� ���� �ٲܶ�

                      System.out.print("�� ������ ���ȱݾ��� �Է��ϼ��� : ");
                      double ac4 = sc.nextDouble();
                      System.out.printf("ȯ���� �ݾ��� %s ���Դϴ�.\n",(int)(ac4 * RateWean));
                         for (i=0; i<acArray.length; i++)
                         {
                            if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ, ��й�ȣ�� ��ġ�ϸ�
                            {
                               System.out.println("===============================================");
                               System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
                           
                              //int a;
                              a+= (int)(ac4 * RateWean);
                              acArray[i].setaccountBalance(a);
                              //acArray[i].getaccountBalance() += (int)(ac4 * 1080);
                              System.out.println(" ȯ�� �� �ݾ� : " + acArray[i].getaccountBalance());
                       System.out.println();
                              break;
                            }
                         }// case5 �� �׾ȿ� �ִ� case1�� �� --> �ܱ����� �ѱ������� ȯ���� �ܱ���==�����϶�
                       
                              break;                     
                    } // case 5 �� �׾ȿ� case1,2,3,4 end�κ�

               }//���θ޴�4�� ȯ�������� �������ɽ� ������ �κ�
             
           }// ���¹�ȣ, ��й�ȣ ��ġ�� ȯ��ó���ǰ� ������ �κ�

         
            if(!acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))   // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ O
            {
               System.out.println("��й�ȣ�� ��ġ������, ���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
               break;
            }
               if(acArray[i].getaccountNumber().equals(pAccountNum) && !acArray[i].getpassword().equals(ppw))   // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ X
               {
                  System.out.println("���¹�ȣ�� ��ġ������, ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
                  break;
               }
           
       
        } //��й�ȣ OR ���¹�ȣ�� �ϳ��� ��ġ������ ������ �κ�!!!
               else                                                                  // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ X
               {
                    if (i==(acArray.length-1))                                                            // �ݺ����� ������ �迭���� ������ ���
                    {
                       System.out.println("��ġ�ϴ� ������ �����ϴ�.");                           // ��ġ�ϴ� ������ ���ٰ� ����� �� ����.
                       break ;
                    }
               }
       
        } //Ac.arraylength -> for�� ó���� ������ �κ�.

    }

         catch (NullPointerException e)
         {
   
         }
      
    
   }// end exchange()


   // �� �ܾ׿� ���� ����� ������ ���� �޼ҵ� ����
   public void point()   
   {
      int i;            // �ݺ����� ���� ���� i
      String pname;         // �Է¹��� ������ �ޱ� ���� ���ڿ� ����
      String pAccountNum;   // �Է¹��� ���� ��ȣ�� �ޱ� ���� ���ڿ� ����
      String ppw;         // �Է¹��� ��� ��ȣ�� �ޱ� ���� ���ڿ� ����

      System.out.print(" ������ �����ԡ��� �Է����ּ���. : ");
      pname = sc.next();
      
      System.out.print(" ������ ������ ��ȣ���� �Է����ּ���(���ڸ� �Է�). : ");
      pAccountNum = sc.next();

      System.out.print(" ������ ����й�ȣ���� �Է����ּ���. : ");
      ppw = sc.next();
   

      // ���Ȯ�� ó�� �κ� ����
      System.out.println("=========== ���Ȯ�� ���� ===========");

      for (i=0; i<inwon+1; i++)                                                                                       // 0��° ����� inwon ���� �ݺ��� ����
      {
     
         if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))   
       // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ O �� ���� �Է��� ������ �´� ȸ���� �ִ� ���

         {
            
            System.out.println("���¹�ȣ, ��й�ȣ ��ġO");
            System.out.println();
            System.out.println("===============================================");
             System.out.println(" �����ԡ� : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " ���� �����Դϴ�.");
            System.out.println(" ���� �ܾ� ��ȸ : " + acArray[i].getaccountBalance()); 
            System.out.println();

            /*
            *****��޳�����******
            �Ϲ� : ~ 5000000 
            VIP : ~ 50000000
            VVIP : ~ 500000000
            */

            if (acArray[i].getaccountBalance() >= 500000000)                                       // �ܾ��� 5�� �̻��� ��� ���� ��� : VVIP��
            {
               System.out.println("������ ����� VVIP �Դϴ�~!!!");
               break;
            }
            else if (acArray[i].getaccountBalance() >= 5000000 && acArray[i].getaccountBalance() < 500000000)   // �ܾ��� 500����~5�� �� ��� ���� ��� : VIP��
            {
               System.out.println("������ ����� VIP �Դϴ�~!!!");
               break;
            }
            else                                                                        // �ܾ��� 500���� ������ ��� ���� ��� : �Ϲݡ�
            {
               System.out.println("������ ����� �Ϲ� �Դϴ�~!!!");
               break;
            }
         }


         if(acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)))      // ���¹�ȣ ��ġ ��or�� ��й�ȣ ��ġ
         {
            if(!acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))    // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ O
            {
               System.out.println("��й�ȣ�� ��ġ������, ���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
               return;
            }
            if(acArray[i].getaccountNumber().equals(pAccountNum) && !acArray[i].getpassword().equals(ppw))    // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ X
            {
               System.out.println("���¹�ȣ�� ��ġ������, ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
               return;
            }
         }
      
         else                                                                          // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ X
         { 
            if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)) && i==(acArray.length)) 
         // �ݺ����� ������ �迭���� ������ ���

            {
           
               System.out.println("��ġ�ϴ� ������ �����ϴ�.");                                      // ��ġ�ϴ� ������ ���ٰ� ����� �� ����.
               break;
            }
         }
      }
   } // end point


  // ���� ��ȸ �޼ҵ�
   public void checkAccount() 
   {
      String inpw;
      String inac;
      Scanner sc = new Scanner(System.in);
      System.out.print("������ �����¹�ȣ���� �Է����ּ���. : ");
      inac = sc.next();
      System.out.print("������ ����й�ȣ���� �Է����ּ���. : ");
      inpw = sc.next();

     try                                                                                                       // acArray[i].getname() ���� NullPointerException �߻� 
     {
       for (int i=0; i<acArray.length; i++)
       {
          if (acArray[i].getaccountNumber().equals(inac) || (acArray[i].getpassword().equals(inpw)))         // ���¹�ȣ ��ġ ��or�� ��й�ȣ ��ġ
          {
            if (acArray[i].getaccountNumber().equals(inac) && acArray[i].getpassword().equals(inpw))      // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ
            {
                  System.out.println("==============================================================");
                  System.out.println("     ��    ��     : " + acArray[i].getname());
                  System.out.println("     ���¹�ȣ     : " + acArray[i].getaccountNumber());
                  System.out.println("     ��    ��     : " + acArray[i].getaccountBalance());
                  System.out.println(" ���Ե� ���� ��ǰ : " + acArray[i].savingName);
                  System.out.println("   ���ݰ��¹�ȣ   : " + acArray[i].getsavingNum());
                  System.out.println("     ��    ��     : " + acArray[i].getsavingBalance());
                  System.out.println("==============================================================");
                  break;
            }
            if(!acArray[i].getaccountNumber().equals(inac) && acArray[i].getpassword().equals(inpw))        // ���¹�ȣ ��ġ X ��and�� ��й�ȣ ��ġ O
            {
               System.out.println("�ءءءء� ��й�ȣ�� ��ġ������, ���¹�ȣ�� Ʋ�Ƚ��ϴ�. �ءءءء�");  // ��� ���� ��� �� Ž�� ����
               break;
            }
            if(acArray[i].getaccountNumber().equals(inac) && !acArray[i].getpassword().equals(inpw))        // ���¹�ȣ ��ġ O ��and�� ��й�ȣ ��ġ X
            {
               System.out.println("�ءءءء� ���¹�ȣ�� ��ġ������, ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ءءءء�");
               break;
            }
          }

          else
          {
            // System.out.println("Ž�����Դϴ�.");    // 0��° ����� �� �� ��ŭ ��ġ�ϴ� ���� ��� Ž���ϰ� �ִٰ� ������� ������.(Ȯ�ο�)


            if (acArray[i].getaccountNumber().equals(inac) || (acArray[i].getpassword().equals(inpw)) && i==(acArray.length))    // �ݺ����� ������ �迭���� ������ ���
            {

               System.out.println("�ءءءء� ��ġ�ϴ� ������ �����ϴ�. �ءءءء�");                                 // ��ġ�ϴ� ������ ���ٰ� ����� �� ����.
               break;

            } // end if
          } //end else
        }//end for
      }// end try

      catch (NullPointerException e)
      {
          System.out.println("�ءءءء� ������ �����ϴ�. �ٽ��ѹ� Ȯ�����ּ���. �ءءءء�");
      }
      
   } //end checkAccount

   public void owner()
   { 
      int sum=0;
      int smenu;
      int choice;
      int m= -1;
       String epickey="7897";
      
       System.out.println();
       System.out.println("-------------������ ��� �޴�------------------");
       System.out.println("���Ͻô� ������ ��ȣ�� �Է����ּ���.");

      System.out.print("1.��ü������ȸ   2.ȯ���� ����  3.���� �� �ܰ� ��ȸ : " );
       smenu=sc.nextInt();
      System.out.println();
      System.out.print("������ ��й�ȣ�� �Է��ϼ��� : ");
      String keyin=sc.next();

      try
      {
         if (smenu==2 && keyin.equals(epickey))
         {
            System.out.print("������ ȯ������ ȭ�� �������ּ��� :");
            System.out.print("1: �޷�, 2:����, 3:��ȭ, 4:���� \n");
            choice=sc.nextInt();
            switch (choice)
            {
                  case 1 : {System.out.print("�����Ͻ� �޷��� ȯ����? : "); Ratedollar=sc.nextDouble(); break;}
                  case 2 : {System.out.print("�����Ͻ� ������ ȯ����? : "); RateEuro=sc.nextDouble(); break;}
                  case 3 : {System.out.print("�����Ͻ� ��ȭ�� ȯ����? : "); RateEnhwa=sc.nextDouble(); break;}
                  case 4 : {System.out.print("�����Ͻ� ������ ȯ����? : "); RateWean=sc.nextDouble(); break;}
                 
           }
         }
      }
      catch (NullPointerException e)
      {
      }
      

       try
      {
            for (int i=0; i<inwon+1; i++)
            {
              if ((smenu==1 && keyin.equals(epickey) ) && inwon>m)
            {
                  
                    System.out.println();
                    System.out.println("�̸� :" + acArray[i].getname());
                    System.out.println("���¹�ȣ : " + acArray[i].getaccountNumber());
                    System.out.println("�ܾ� : " + acArray[i].getaccountBalance());
                    System.out.println("���Ե� ���� ��ǰ : " + acArray[i].savingName);
                    System.out.println("���� ���� : " + acArray[i].getsavingNum());
                    System.out.println("�ܾ� : " + acArray[i].getsavingBalance());
                    System.out.println("��й�ȣ : " + acArray[i].getpassword());
                    System.out.println();
                     
                    System.out.println("������ ��� �α��� ���� ! ");
                    break;
             }

          else if( (smenu==1 && keyin.equals(epickey) ) && inwon==m)
          {
                  System.out.println("���� ������ �����ϴ� ! " );
                  break;
          }

          if (smenu==3 && keyin.equals(epickey))
         {
               int result=acArray[i].getaccountBalance()+(int)acArray[i].getsavingBalance();
               sum+=result;

                if (i==inwon)
                {
                     System.out.printf("���� �� �ܰ�� %d �� �Դϴ�.\n",sum);
                }
               }
        } //end for
      if(!keyin.equals(epickey))
       {
             System.out.println("������ ��й�ȣ�� ��ġ���� �ʽ��ϴ� ! " );
       }
    }// end try
    catch (NullPointerException e)
    {
    }
  } //end owner()

   //main �޼ҵ�
   public static void main(String[] args)throws IOException
   {

      Scanner sc = new Scanner(System.in);
     
      //Account Ŭ���� ��� �ν��Ͻ� ����
     Account ac=new Account();
     //Manage2 Ŭ���� ��� �ν��Ͻ� ����
      Manage2 m = new Manage2();
     
      int n;            //����ڿ��� �Է¹��� ��ȣ ����         
     
    try
    {
       jump:
      do
      {
           System.out.println("<<<<<  �� �ȳ��ϼ���~ �ְ��� �����Դϴ�! ������ ���͵帱���?? ��  >>>>>");
           System.out.println();
           System.out.println("0�� : ����");
           System.out.println("1�� : ���°���");
           System.out.println("2�� : �����");
           System.out.println("3�� : ������ü");
           System.out.println("4�� : ȯ��");
           System.out.println("5�� : �����ȸ");
         System.out.println("6�� : �����ڸ��");
           System.out.println("7�� : ����");
         System.out.println();
           System.out.print("�� �ʿ��Ͻ� ���񽺹�ȣ�� �Է��ϼ��� : ");
           n = sc.nextInt();
         System.out.println();

          // ����ڰ� 0�� ���� ������ ���
        if (n==0)
            m.help();
          
        // ����ڰ� 1�� ���� ������ ������ ��� 
          if (n==1)
          {
            do
            {
               System.out.println("1�� : ���� ����");
               System.out.println("2�� : ���� ��ȸ");
               System.out.println("3�� : ���� ����");
               System.out.println("9�� : ����");
               System.out.println();
               System.out.print("�� �ʿ��Ͻ� ���񽺹�ȣ�� �Է��ϼ��� : ");
               n = sc.nextInt();
               System.out.println();

               //����ڰ� 1�� ���� ������ ������ ���
               if(n == 1)
               {
                  m.openAccount();
                  m.inwon++;
                  m.openAccount();
            
               }

               // ����ڰ� 2�� ���� ��ȸ�� ������ ���
               if(n == 2)
                   m.checkAccount();
               
               // ����ڰ� 3�� ���� ������ ������ ���
               if(n == 3)
                   m.deleteAccount();
               
               // ����ڰ� 9�� ���Ḧ ������ ���
               if(n == 9)
                  continue jump;    //�ʱ�ȭ������ ����

           }while(n!=9);

         
         } //end if
 
         // ����ڰ� 2�� ������ݡ� ������ ���
         if(n==2)
            m.input();
          
         // ����ڰ� 3�� ��������ü�� ������ ���
       if (n==3)
            m.sendmoney();

         //����ڰ� 4�� ��ȯ���� ������ ���
         if(n==4)
             m.exchange();
           
         //����ڰ� 5�� �������ȸ�� ������ ���
       if(n==5)
             m.point();

       // ����ڰ� 6�� �������� ��塻 ������ ���
       if(n==6)
          m.owner();
      

      }while(n!=7);

   }catch (Exception e)
    {
       System.out.println("�ùٸ� ��ȣ�� �Է����ּ��� !"); 
    }
     

}//end class Manage2
}