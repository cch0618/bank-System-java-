import java.util.Scanner;
import java.util.Random;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Account // 계좌클래스
{
   // private → accountNumber, name, password, 
   private String accountNumber;         //계좌


   private String name;                  //사용자 이름
   private String password;              //계좌 비밀번호
   private int accountBalance;           //계좌잔액
   private String jumin;                 //주민등록번호
  
   String savingName;                    //적금이름
   private String savingNum;             //적금 계좌 
   private double savingBalance;         //적금 잔액
   double savingLastBalance;             //적금 만기잔액
   
   private int point;                    //제휴포인트

   int deposit;                          //입금
   int withdraw;                   //출금
   


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
   String pname;                  // 사용자가 입력한 이름이 저장될 변수
   String pAccountNum;            // 사용자가 입력한 계좌번호가 저장될 변수
   String ppw;                    // 사용자가 입력한 비밀번호가 저장될 변수
   int inM, outM;
   int a;
   int inwon;                
  

   
   // 도움말 메소드
   public void help()
   {
      System.out.println();
      System.out.println("          ■ 서비스 이용시간 ■");
      System.out.println("=========================================");
      System.out.println("             24시간 365일");
      System.out.println("( 00:00 ~ 00:30 사이에는 시스템 점검으로");
      System.out.println("         서비스 이용 불가합니다.");
      System.out.println();
      System.out.println("            ■ 이용안내 ■");
      System.out.println("=========================================");
      System.out.println("  1. 첫 화면에서 원하시는 버튼을 선택");
      System.out.println("  2. [ 계좌 (개설, 조회, 해지) 선택 ]");
      System.out.println("  3. [  항목에 따라 고객 정보 입력  ]");
      System.out.println();
      System.out.println("           ■ 출금 수수료 ■");
      System.out.println("=========================================");
      System.out.println("      동일 은행 이체시 : 수수료 없음.");
      System.out.println("      타행 은행 이체시 : 수수료 500원.");
      System.out.println();
      System.out.println("            ■ 유의사항 ■");
      System.out.println("=========================================");
      System.out.println(" ① 계좌 조회 & 입출금 & 계좌 이체 시,");
      System.out.println("    성함, 계좌번호, 비밀번호가 필요합니다.");
      System.out.println(" ② 인증되지 않은 센터에서 비밀번호 요구시");
      System.out.println("    고객센터로 반드시 문의 바랍니다.");
      System.out.println(" ③ 계좌번호, 비밀번호 분실 시");
      System.out.println("    고객센터로 문의 바랍니다.");
      System.out.println();
      System.out.println("           ■ 제휴서비스 ■");
      System.out.println("=========================================");
      System.out.println("    일반고객 : 보유 잔액 ~ 500만원");
      System.out.println(" vip 고객 : 보유 잔액 500만원 ~ 5000만원");
      System.out.println("    vvip 고객 : 보유 잔액 5000만원~5억");
      System.out.println();
      System.out.println("     ☏☎ 고객센터 : 02) 336 - 8546 ");
      System.out.println();
   }
      

    // 계좌 개설 메소드
   public void openAccount()
   { 

      // 주민등록번호 유효성 검사에 필요한 변수들
      int sum=0;
      int[] num = {2,3,4,5,6,7,0,8,9,2,3,4,5};
      int namuji;

      int n,a;   

      Scanner sc= new Scanner(System.in);

     // Account클래스 기반 인스턴스를 inwon크기 만큼 생성
      acArray[inwon] = new Account();
   
     try
     {
      // 이름 입력받기
      System.out.print("▶ 이름을 입력하세요: ");
      acArray[inwon].setname(sc.next());
       
      // 주민등록번호 입력받기
      System.out.print("▶ 주민등록번호를 입력하세요: ");
      acArray[inwon].setjumin(sc.next());

      // 주민등록번호 유효성 검사
      if(acArray[inwon].getjumin().length() != 14)
         System.out.println(">>입력 오류~!!!");
         
      for(int i=0; i<num.length;i++)
      {
         if(i==6)
            continue;
         sum += num[i] * Integer.parseInt(acArray[inwon].getjumin().substring(i,i+1));
      }   

      namuji = (11-sum%11)%10;

      // 주민등록번호가 유효한 경우
      if(namuji==Integer.parseInt(acArray[inwon].getjumin().substring(13)))
      {
        // 계좌 개설
        // 적금 계좌 생성 여부 확인
        System.out.print("▶ 적금 계좌를 생성하시겠습니까 (YES : 1) OR (No : 2) ");
        n=sc.nextInt();
        System.out.print("▶ 일반 계좌를 생성하시겠습니가 (YES : 1) OR (No : 2) ");
        a = sc.nextInt();
 
       // 계좌 생성 메소드 호출
        createAccount(n,a);

        // 적금계좌와 일반계좌 둘다 안만든다면 종료
        if(n==2 && a==2)
          return;

        // 잔액 출력
        System.out.println("【일반 계좌잔액】:"+acArray[inwon].getaccountBalance()+"원");
        System.out.println();
     }

    // 주민번호가 유효하지 않은 경우
     else
    {
         System.out.println("※※※ 유효하지 않은 주민번호~!!! ※※※");
       return;
    }
     }
     catch (NullPointerException e)
     {
        System.out.println("올바른 문자를 입력해주세요 ! " );
     }
      

   } // end openAccount

  
   // 계좌 생성 메소드
   public void createAccount(int j,int k)
   {
       int c; 
      // 적금계좌 앞자리 은행 고유번호 1111로 초기화
       String a="1111";
      // 일반계좌 앞자리 은행 고유번호 2222로 초기화
       String b="2222";
       Random rd = new Random();
      
       acArray[inwon].setaccountBalance(0);        // 계좌 생성 시 잔액 초기화

       if( j==1 && k==1)                     // 적금 O 일반 계좌 O
       {
         
           // 적금계좌와 일반계좌를 랜덤함수를 사용하여 계좌번호 생성
         // 고유번호 앞자리 4자리를 제외한 10자리 생성하므로 10번 반복하여 생성
         for(int i=0; i<10; i++)
           {
            a+=Integer.toString(rd.nextInt(9));
            acArray[inwon].setsavingNum(a);

            b+=Integer.toString(rd.nextInt(9));
            acArray[inwon].setaccountNumber(b);
           }
        
           // 목록 메소드 호출
         moklok();      
         // 비밀번호 설정 메소드 호출
           createpassword();
         // 결과 출력
         System.out.println();
           System.out.println(acArray[inwon].getname()+"님의 【적금 계좌번호】 : "+acArray[inwon].getsavingNum());
           System.out.printf("%s님의 【일반 계좌번호】 : %s \n",acArray[inwon].getname(),acArray[inwon].getaccountNumber());

      }

      else if(j==1 && k==2)      //적금 O 일반 계좌 X
      {
         
         // 적금계좌만 랜덤함수 사용하여 계좌번호 생성
         for(int i=0; i<10; i++)
            {
            a+=Integer.toString(rd.nextInt(9));
            acArray[inwon].setsavingNum(a);
            }

            moklok();   
            createpassword();
         System.out.println();
            System.out.println(acArray[inwon].getname()+"님의 【적금 계좌번호】:"+acArray[inwon].getsavingNum());
      
      }

      else if(j==2 && k==1)      // 적금 X 일반 계좌 O
      {
        
         // 일반계좌만 랜덤함수 사용하여 계좌번호 생성
         for(int i=0; i<10; i++)
            {
              b+=Integer.toString(rd.nextInt(9));
              acArray[inwon].setaccountNumber(b);
            }
           
            createpassword();
            System.out.printf("%s님의 【일반 계좌번호】 :%s\n",acArray[inwon].getname(),acArray[inwon].getaccountNumber());
      }

      else if(j==2 && k==2)     // 적금 X 일반 계좌 X
         System.out.println("다시 이용해주세요 ! ");
         
   } // end creatAccount

  // 목록 메소드
  public void moklok()      // j==1 일때 호출. ( 적금 목록과 적금 이율 계산 메소드 )
  {

        int c;                   // 사용자에게 입력받을 번호를 저장할 변수
        double interest=1;       // 이자를 1로 초기화
        int y=1;                 // 이자 계산 시 필요한 변수를 1로 초기화
         
      System.out.println();
        System.out.println("적금 상품 목록을 선택하세요 ");

        // 적금상품 선택
      System.out.print("【1.자유적금(이자율:0.1%)-계약 기간 1년】 \n【2.쌍용적금(이자율:0.2%)-계약 기간 2년】 \n【3.청춘적금(이자율:0.3%)-계약 기간 3년】\n");
      System.out.print("▶ 원하시는 상품을 번호로 선택해주세요. (1, 2, 3) : ");
        c=sc.nextInt();
      System.out.println();

        // 사용자가 선택한 적금상품을 사용자 정보의 적금상품이름에 저장
      switch (c)
        {
          case 1:
            acArray[inwon].savingName="1.자유적금(이자율:0.1%)계약 기간 1년";
          break;
          case 2:
            acArray[inwon].savingName="2.쌍용적금(이자율:0.2%)계약 기간 2년";
          break;
          case 3:
            acArray[inwon].savingName="3.청춘적금(이자율:0.3%)계약 기간 3년";
          break;
          
        }

        // 월마다 입금할 금액 입력받기
      // 만원 미만 입력하면 계속 반복
      do
        {
                  
             System.out.print("월마다 넣을 금액 입력 (10000원이상): ");
             acArray[inwon].setsavingBalance(sc.nextDouble());

             if(acArray[inwon].getsavingBalance()>=10000)
                 continue;
               
             System.out.println("만원 이상 넣어주세요 !!");

        }while (acArray[inwon].getsavingBalance()<10000);
         
        // 사용자가 선택한 상품별로 이자 계산 수식
      switch(c)            // 단리 (이자에 이자가 없음)
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

      //적금가입날짜 - 현재날짜 출력\
      System.out.println();
        System.out.println("적금가입날짜: " + ca.get(Calendar.YEAR) + "-" +(ca.get(Calendar.MONTH)+1)+ "-" + ca.get(Calendar.DATE));
            
        //사용자가 선택한 상품에 따른 결과 출력
      //1번 상품
      if(y==1)
        {
             //만기년도를 출력하기 위해 add메소드 사용
          ca.add(Calendar.YEAR,y);
          System.out.println("=============================================================================");
          //이자율 출력
             System.out.println(acArray[inwon].getname()+"의 적금 이자율 : " + interest*0.1 +"%");
          //적금만기금액 출력
             System.out.println("자유적금 1년뒤 적금 만기 금액 :"+(int)acArray[inwon].savingLastBalance+"원");
          //만기일 출력
             System.out.println("자유적금 만기일 : "+ ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH)+1) + "-" + ca.get(Calendar.DATE));    
          System.out.println("=============================================================================");
         }
       //2번 상품
         else if(y==2)
         {
               //만기년도를 출력하기 위해 add메소드 사용
           ca.add(Calendar.YEAR,y);
           System.out.println("=============================================================================");
              System.out.println(acArray[inwon].getname()+"의 적금 이자율 :"+ interest*0.2+"%");
              System.out.println("쌍용적금 2년뒤 적금 만기 금액 :"+(int)acArray[inwon].savingLastBalance+"원");
              System.out.println("쌍용적금 만기일 : "+ ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH)+1) + "-" + ca.get(Calendar.DATE));
           System.out.println("=============================================================================");
          }
        //3번 상품
          else if(y==3)
          {
               //만기년도를 출력하기 위해 add메소드 사용
           ca.add(Calendar.YEAR,y);
           System.out.println("=============================================================================");
              System.out.println(acArray[inwon].getname()+"의 적금 이자율 : " + + interest*0.3+"%");
              System.out.println("청춘적금 3년뒤 적금 만기 금액 :"+(int)acArray[inwon].savingLastBalance+"원");
              System.out.println("청춘적금 만기일 : "+ ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH)+1) + "-" + ca.get(Calendar.DATE));
           System.out.println("=============================================================================");
          }
                  
  } //end moklok
               
  //비밀번호 설정 메소드
  public void createpassword()
  {
       //비밀번호 설정
       do
       {
          System.out.println();
         System.out.println("■■■ 비밀번호 설정 ■■■");
            System.out.print("▶ (4자리)비밀번호를 입력하세요 : ");
            acArray[inwon].setpassword(sc.next());
               
       }
       while (acArray[inwon].getpassword().length() != 4);        //비밀번호가 4자리가 아니면 다시 입력 요청

           
  } // end createpasword



    public void deleteAccount() 
    {
      //Account ac = new Account();

       int i,j;         //반복문을 위한 변수
       String account;  //사용자에게 입력받을 해지할 계좌 저장
       Scanner sc = new Scanner(System.in);

           //해지할 계좌번호 사용자에게 입력받기
         System.out.print("해지할 계좌번호를 입력해주세요 : ");
           account = sc.next();
      
      try
      {
           //배열에서 해당 계좌번호 검색
         for (i=0; i < inwon+1; i++) 
          {
               //저장된 계좌번호와 사용자가 입력한 계좌번호가 같다면 해지
            if (acArray[i].getaccountNumber().equals(account))
               {
                //만약 해지할 계좌번호가 배열의 마지막 방일 경우
               if(i==inwon)
                   inwon--;    //배열의 수를 감소시켜서 제거
       
                    //해지할 계좌번호가 마지막 방이 아닐 경우
               else
                    {
                  //해당계좌가 들어있는 배열방을 기준으로 뒤의 배열들을 앞으로 모두 이동시킨다.
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
                  //모두 앞으로 이동시킨 후, 하나가 제거되었으므로 배열의 크기를 1 줄여준다.
                  inwon--;
                    }

               System.out.println(inwon);

               System.out.println("해지되었습니다.");
            System.out.println();
               }

               //만약 저장된 계좌번호가 사용자가 입력한 계좌번호와 같지 않다면
            else
               {
               //배열의 끝까지 탐색이 완료되었다면
               if(i==inwon)
               {
                //메시지 출력
                System.out.println("계좌번호가 일치하지 않습니다");
                return;
               }    
               }
              
            } //end for

      } //end try

      //NullPointerException 발생하면 catch
     catch (NullPointerException e)
      {      
      }

  } // end deleteCount



  // 입/출금 선택 & 계좌번호(이름) 조회 메소드 정의
  public void input()            
  {
       Scanner sc = new Scanner(System.in);     

      // 주요 변수 선언
      int select;         // 입출금 선택 변수
      
      //입금, 출금 선택
     do
      {
         System.out.print(" 입금---(1) / 출금---(2) : ");
         select = sc.nextInt();
      }
      while (select<1 || select>2);

      System.out.print(" 고객님의 【성함】을 입력해주세요. : ");
      pname = sc.next();

      System.out.print(" 고객님의 【계좌 번호】를 입력해주세요(숫자만 입력). : ");
      pAccountNum = sc.next();

      System.out.print(" 고객님의 【비밀번호】를 입력해주세요. : ");
      ppw = sc.next();

      if (select==1)                  // 입금을 선택했으면
         inMoney();              // 입금 메소드 호출

      if (select==2)                  // 출금을 선택했으면
         outMoney();             // 출금 메소드 호출

   } //end input()

   // 입금 메소드 정의
   public void inMoney()         
   {
    
      Scanner sc = new Scanner(System.in);
      System.out.println("【입금 메소드 처리시작】");
      
      //배열탐색
     for (int i=0; i<inwon+1; i++)
      {
         if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw))) // 계좌번호 일치 『or』 비밀번호 일치
         {
            if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw)) // 계좌번호 일치 O 『and』 비밀번호 일치 O
            {
             System.out.println("계좌번호, 비밀번호가 일치합니다.");
        
             //결과 출력
             System.out.println();
             System.out.println("==============================================================");
             System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
             System.out.println(" 현재 잔액 조회 : " + acArray[i].getaccountBalance());
             System.out.println("==============================================================");

             System.out.println();
             //입금금액 입력받기
             System.out.print(" 얼마를 입금 하시겠습니까? : ");
             inM = sc.nextInt();
        
             System.out.println(" 입금 금액 : " + inM);

             //잔액에 입금금액을 누적시킨다
             a = acArray[i].getaccountBalance();
             a += inM;
             acArray[i].setaccountBalance(a);
        
             System.out.println("=================================================");
             System.out.println(" 입금 후 금액 : " + acArray[i].getaccountBalance());
             System.out.println(); 
             break;
            }

            if(!acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))// 계좌번호 일치 X 『and』 비밀번호 일치 O
            {
                 //메시지 출력
             System.out.println("비밀번호는 일치하지만, 계좌번호가 틀렸습니다.");
                 break;
            }

            if(acArray[i].getaccountNumber().equals(pAccountNum) && !acArray[i].getpassword().equals(ppw)) // 계좌번호 일치 O 『and』 비밀번호 일치 X
         {
                 //메시지 출력
             System.out.println("계좌번호는 일치하지만, 비밀번호가 틀렸습니다.");
                 break;
            }
         } //end if

         else  // 계좌번호 일치 X 『and』 비밀번호 일치 X
         {
                 
            if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)) && i==(acArray.length))                                                 // 반복문이 마지막 배열까지 돌았을 경우
            {
               System.out.println("일치하는 정보가 없습니다.");        // 일치하는 정보가 없다고 출력한 후 종료.
            break;
            }

         } //end else
      } // end for
   } //end inMoney()

   
  // 출금 메소드 정의
   public void outMoney()               
   {
      Scanner sc = new Scanner(System.in);  
      System.out.println("출금 메소드 처리시작");

      for (int i=0; i<acArray.length; i++)
      {
         if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)))  // 계좌번호 일치 『or』 비밀번호 일치
         {
            if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))  // 계좌번호 일치 O 『and』 비밀번호 일치 O
            {
                 System.out.println("계좌번호, 비밀번호가 일치합니다.");
      
                 //결과 출력
             System.out.println();
                 System.out.println("===============================================");
                 System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                 System.out.println(" 현재 잔액 조회 : " + acArray[i].getaccountBalance()); 
                 System.out.println();

             //출금금액 입력받기
                 System.out.print(" 얼마를 출금 하시겠습니까? : ");
                 outM = sc.nextInt();
               
                 //만약 잔액이 출금금액보다 적다면
             if (acArray[i].getaccountBalance()<outM)
                 {   
               System.out.println("출금가능금액이 한도초과 되었습니다. 감사합니다.");
                    System.out.println();
                    break;
                 }
      
                 System.out.println(" 출금 금액 : " + outM);
           
                 //출금 금액 누적감소
             a-=outM;
                 acArray[i].setaccountBalance(a);
      
      
                 System.out.println("=================================================");
              System.out.println(" 출금 후 금액 : " + acArray[i].getaccountBalance());
      
                 break;
            }

            if(!acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw)) // 계좌번호 일치 X 『and』 비밀번호 일치 O
            {
               System.out.println("비밀번호는 일치하지만, 계좌번호가 틀렸습니다.");
               break;
            }

            if(acArray[i].getaccountNumber().equals(pAccountNum) && !acArray[i].getpassword().equals(ppw)) // 계좌번호 일치 O 『and』 비밀번호 일치 X
            {
               System.out.println("계좌번호는 일치하지만, 비밀번호가 틀렸습니다.");
               break;
            }
         }

         else  // 계좌번호 일치 X 『and』 비밀번호 일치 X
         {
                                                 
             if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)) && i==(acArray.length))                                                 // 반복문이 마지막 배열까지 돌았을 경우
          {
              System.out.println("일치하는 정보가 없습니다.");     // 일치하는 정보가 없다고 출력한 후 종료.
              break;
           }
         } //end else   
      }// end for
   }//end outMoney()

   
   // 계좌 이체 메소드 정의 (타행이체, 당행이체)
   public void sendmoney()
   {
      int i=0,j=0;      // 반복문 수행을 위한 변수 선언 및 초기화
      int sendm=0;      // 입력되는 이체금액을 담아둘 변수 선언 및 초기화

      Scanner sc = new Scanner(System.in);
      

      System.out.print("고객님의 성함을 입력하세요 : ");
      String customer_name = sc.next();

      System.out.print("고객님의 계좌를 입력하세요 : ");
      String customer = sc.next();
   
      System.out.print("고객님 계좌의 비밀번호를 입력하세요 : ");
      String customer_password = sc.next();
            

         
      for (i=0; i<acArray.length; i++)                                                               // 배열의 길이만큼(고객 수 만큼) 반복문 수행
      {
         if (acArray[i].getaccountNumber().equals(customer) || (acArray[i].getpassword().equals(customer_password)))    // 계좌번호 일치 『or』 비밀번호 일치
         {
            if(acArray[i].getaccountNumber().equals(customer) && acArray[i].getpassword().equals(customer_password))    // 계좌번호 일치 O 『and』 비밀번호 일치 O
            {
               System.out.print("이체하실 계좌번호를 입력해주세요 : ");
               String guest = sc.next();
               System.out.print("얼마를 이체 하시겠습니까? : ");
               sendm = sc.nextInt();
         
               if (acArray[i].getaccountBalance()<sendm+500)                                    // 보유 잔액이 이체 금액보다 적은 경우
               {
                  System.out.println("※※※※※ 출금가능금액이 한도초과 되었습니다. ※※※※※");         // 한도 초과 출력문 표시
                  break;
               }

               try
               { 
                  if (guest.length()!=14)      // 타행이체
                  {
                     acArray[i].setaccountBalance(acArray[i].getaccountBalance()-sendm-500);            // 현재 보유 잔액에서 - 이체 금액 - 수수료(500원)
                System.out.println("=============================================================================================================");
                     System.out.printf("%s에 %d원 이체했습니다. \n타행이체 수수료는 500원 입니다. \n남은 잔액은 %d원 입니다.\n",guest,sendm,acArray[i].getaccountBalance());
                  }
                  else                     // 당행 이체
                  {
                     acArray[i].setaccountBalance(acArray[i].getaccountBalance()-sendm);
                System.out.println("=============================================================================================================");
                     System.out.printf("%s에 %d원 이체했습니다. \n남은 잔액은 %d원 입니다.\n",guest,sendm,acArray[i].getaccountBalance());

                     for (j=0; j<acArray.length+1; j++)
                     {
                        if (acArray[j].getaccountNumber().equals(guest))                           // 반복문 돌리면서 이체되는 계좌번호와, 고객 정보가 일치하게 되면
                     acArray[j].setaccountBalance((acArray[j].getaccountBalance())+sendm);         // 현재 보유 잔액에서 이체 금액을 추가한 금액으로 저장.
                     }
                     System.out.printf("%s에 %d원 이체했습니다. 남은 잔액은 %d원 입니다.",guest,sendm,acArray[i].getaccountBalance());
                  }
               }
               catch (NullPointerException e)
               {
               }

               System.out.println("계좌번호, 비밀번호 일치O");
               break;
            }

            if(!acArray[i].getaccountNumber().equals(customer) && acArray[i].getpassword().equals(customer_password))   // 계좌번호 일치 X 『and』 비밀번호 일치 O
            {
               System.out.println("비밀번호는 일치하지만, 계좌번호가 틀렸습니다.");
               break;
            }

            if(acArray[i].getaccountNumber().equals(customer) && !acArray[i].getpassword().equals(customer_password))   // 계좌번호 일치 O 『and』 비밀번호 일치 X
            {
               System.out.println("계좌번호는 일치하지만, 비밀번호가 틀렸습니다.");
               break;
            }
         }

         else
       {
            if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)) && i==(acArray.length))  // 반복문이 마지막 배열까지 돌았을 경우
            {
               System.out.println("일치하는 정보가 없습니다.");                // 일치하는 정보가 없다고 출력한 후 종료.
               break;
            }
         }
      }
   }

   // 지정된 환율에 따른 환전 메소드 정의
   public void exchange()
   {
          
       
       int i;

      Scanner sc = new Scanner(System.in);      // Scanner 클래스 인스턴스 생성

      System.out.print(" 고객님의 【성함】을 입력해주세요. : ");
      pname = sc.next();
      

      System.out.print(" 고객님의 【계좌 번호】를 입력해주세요(숫자만 입력). : ");
      pAccountNum = sc.next();


      System.out.print(" 고객님의 【비밀번호】를 입력해주세요. : ");
      ppw = sc.next();

     try
     {
        for (i=0; i<acArray.length; i++)
        {
            if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)))      // 계좌번호 일치 『or』 비밀번호 일치
         {
               if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))   // 계좌번호 일치 O 『and』 비밀번호 일치 O
               {
                  System.out.println("계좌번호, 비밀번호 일치O");        
                  System.out.println();
                  System.out.println("===============================================");
                  System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                  System.out.println(" 현재 잔액 조회 : " + acArray[i].getaccountBalance()); 
                  System.out.println();
                  System.out.print("1: 달러, 2:유로, 3:엔화, 4:위안, 5:원\n");
              System.out.print("▶ 원하시는 화폐를 선택해주세요. : ");

         
                  int nums = sc.nextInt();         
                  int Krwon; // 한국돈
          
   
           
                switch(nums)
                {
               case 1:   //원화 -> 달러 환전시
              
                      System.out.print("▶ 바꿀 원화금액을 입력하세요 : ");
                      Krwon = sc.nextInt();   
                      System.out.printf("환전될 금액은 %.2f 달러입니다.\n",(double)Krwon/Ratedollar);
                  
               for (i=0; i<acArray.length; i++)
                  {
                     if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))   // 계좌번호 일치 O 『and』 비밀번호 일치 O
                     {
                           System.out.println("계좌번호, 비밀번호 일치O");
                           System.out.println();
                           System.out.println("===============================================");
                           System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                          
                           // int a;
                           a-=Krwon;
                           acArray[i].setaccountBalance(a);
                           //acArray[i].getaccountBalance() -= Krwon;
                           System.out.println(" 환전 후 금액 : " + acArray[i].getaccountBalance());
                     System.out.println();
                           
                     break;
                     }
                     
                  } // case1 end 

                           break;

               case 2:   //원화 -> 유로 환전시
            
                  System.out.print("▶ 바꿀 원화금액을 입력하세요 : ");
                  Krwon = sc.nextInt();
                  System.out.printf("환전될 금액은 %.2f 유로입니다.\n",(double)Krwon/RateEuro);
               
                   for (i=0; i<acArray.length; i++)
                   {
                      if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // 계좌번호, 비밀번호가 일치하면
                      {
                         System.out.println("===============================================");
                         System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
               
                         //int a;
                         a -= Krwon;
                         acArray[i].setaccountBalance(a);
                  
                         //acArray[i].getaccountBalance() -= Krwon;
                         System.out.println(" 환전 후 금액 : " + acArray[i].getaccountBalance());
                   System.out.println();
                         break;
                      }
                   } // case2 end 

                         break;
                


                   case 3:   //원화 -> 엔화 환전시
             
                      System.out.print("▶ 바꿀 원화금액을 입력하세요 : ");
                      Krwon = sc.nextInt();
                      System.out.printf("환전될 금액은 %.2f 엔화입니다.\n",(double)Krwon/RateEnhwa);
               
                   for (i=0; i<acArray.length; i++)
                   {
                      if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // 계좌번호, 비밀번호가 일치하면
                      {
                         System.out.println("===============================================");
                         System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                
                         //int a;
                         a-=Krwon;
                         acArray[i].setaccountBalance(a);
                         //acArray[i].getaccountBalance() -= Krwon;
                         System.out.println(" 환전 후 금액 : " + acArray[i].getaccountBalance());
                   System.out.println();
                         break;
                      }
                   } // case3 end 
                         
                   break;

                   case 4: //원화 -> 위안 환전시
               
                      System.out.print("▶ 바꿀 원화금액을 입력하세요 : ");
                      Krwon = sc.nextInt();
                      System.out.printf("환전될 금액은 %.2f 위안입니다.\n",(double)Krwon/RateWean);
               
                   for (i=0; i<acArray.length; i++)
                   {                 
                      if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // 계좌번호, 비밀번호가 일치하면
                      {
                         System.out.println("===============================================");
                         System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                
                         //int a;
                         a -= Krwon;
                         acArray[i].setaccountBalance(a);
                         //acArray[i].getaccountBalance() -= Krwon;
                         System.out.println(" 환전 후 금액 : " + acArray[i].getaccountBalance());
                   System.out.println();
                         break;
                      }
                   } // case4 end 

                         break;

                   case 5: //외국 돈 -> 한국돈으로 바꿀때!!!!
                  
                  System.out.print("갖고계신 화폐 종류를 입력하세요 : 1: 달러, 2:유로, 3:엔화, 4:위안 \n");
                 System.out.print("▶ 원하시는 화폐를 선택해주세요. : ");
                      int nums1 = sc.nextInt();
          
        
                 switch(nums1)
                   {
                      case 1: //달러->원 으로 바꿀때
                      
                 System.out.print("▶ 갖고계신 달러금액을 입력하세요 : ");
                      double ac1 = sc.nextDouble();
                      System.out.printf("환전될 금액은 %s 원입니다.\n",(int)(ac1 * Ratedollar));
                         
                     for (i=0; i<acArray.length; i++)
                         {   
                            if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // 계좌번호, 비밀번호가 일치하면
                            {
                               System.out.println("===============================================");
                               System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                     
                               //int a;
                               a+=(int)(ac1 * Ratedollar);
                               acArray[i].setaccountBalance(a);
                               //acArray[i].getaccountBalance() += (int)(ac1 * 1200);
                               System.out.println(" 환전 후 금액 : " + acArray[i].getaccountBalance());
                        System.out.println();
                               break;
                            }
                         }// case5 시 그안에 있는 case1일 때 --> 외국돈을 한국돈으로 환전시 외국돈==달러일때
                           
                               break;


                      case 2:   //유로->원 으로 바꿀때

                      System.out.print("▶ 갖고계신 유로금액을 입력하세요 : ");
                      double ac2 = sc.nextDouble();
                      System.out.printf("환전될 금액은 %s 원입니다.\n",(int)(ac2 * RateEuro));
                         for (i=0; i<acArray.length; i++)
                         { 
                            if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // 계좌번호, 비밀번호가 일치하면
                            {
                               System.out.println("===============================================");
                               System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                           
                               //int a;
                               a += (int)(ac2 * RateEuro);
                               acArray[i].setaccountBalance(a);
                               //acArray[i].getaccountBalance() += (int)(ac2 * 2200);
                               System.out.println(" 환전 후 금액 : " + acArray[i].getaccountBalance());
                        System.out.println();
                               break;
                            }
                         }// case5 시 그안에 있는 case1일 때 --> 외국돈을 한국돈으로 환전시 외국돈==유로일때
                                 
                               break;
         
                      case 3:      //엔화->원 으로 바꿀때

                      System.out.print("▶ 갖고계신 엔화금액을 입력하세요 : ");
                      double ac3 = sc.nextDouble();
                      System.out.printf("환전될 금액은 %s 원입니다.\n",(int)(ac3 * RateEnhwa));
                         for (i=0; i<acArray.length; i++)
                         { 
                            if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // 계좌번호, 비밀번호가 일치하면
                            {
                               System.out.println("===============================================");
                               System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                           
                              //int a;
                              a += (int)(ac3 * RateEnhwa);
                              acArray[i].setaccountBalance(a);
                              //acArray[i].getaccountBalance() += (int)(ac3 * 1120);
                              System.out.println(" 환전 후 금액 : " + acArray[i].getaccountBalance());
                       System.out.println();
                              break;
                            }
                         }// case5 시 그안에 있는 case1일 때 --> 외국돈을 한국돈으로 환전시 외국돈==엔화일때
                                 
                              break;

                      case 4:      //위안->원 으로 바꿀때

                      System.out.print("▶ 갖고계신 위안금액을 입력하세요 : ");
                      double ac4 = sc.nextDouble();
                      System.out.printf("환전될 금액은 %s 원입니다.\n",(int)(ac4 * RateWean));
                         for (i=0; i<acArray.length; i++)
                         {
                            if ((acArray[i].getaccountNumber().equals(pAccountNum))&&(acArray[i].getpassword().equals(ppw)))      // 계좌번호, 비밀번호가 일치하면
                            {
                               System.out.println("===============================================");
                               System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
                           
                              //int a;
                              a+= (int)(ac4 * RateWean);
                              acArray[i].setaccountBalance(a);
                              //acArray[i].getaccountBalance() += (int)(ac4 * 1080);
                              System.out.println(" 환전 후 금액 : " + acArray[i].getaccountBalance());
                       System.out.println();
                              break;
                            }
                         }// case5 시 그안에 있는 case1일 때 --> 외국돈을 한국돈으로 환전시 외국돈==위안일때
                       
                              break;                     
                    } // case 5 시 그안에 case1,2,3,4 end부분

               }//메인메뉴4번 환전누르고 마무리될시 끝나는 부분
             
           }// 계좌번호, 비밀번호 일치시 환전처리되고 끝나는 부분

         
            if(!acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))   // 계좌번호 일치 X 『and』 비밀번호 일치 O
            {
               System.out.println("비밀번호는 일치하지만, 계좌번호가 틀렸습니다.");
               break;
            }
               if(acArray[i].getaccountNumber().equals(pAccountNum) && !acArray[i].getpassword().equals(ppw))   // 계좌번호 일치 O 『and』 비밀번호 일치 X
               {
                  System.out.println("계좌번호는 일치하지만, 비밀번호가 틀렸습니다.");
                  break;
               }
           
       
        } //비밀번호 OR 계좌번호중 하나만 일치햇을때 끝나는 부분!!!
               else                                                                  // 계좌번호 일치 X 『and』 비밀번호 일치 X
               {
                    if (i==(acArray.length-1))                                                            // 반복문이 마지막 배열까지 돌았을 경우
                    {
                       System.out.println("일치하는 정보가 없습니다.");                           // 일치하는 정보가 없다고 출력한 후 종료.
                       break ;
                    }
               }
       
        } //Ac.arraylength -> for문 처리후 끝나는 부분.

    }

         catch (NullPointerException e)
         {
   
         }
      
    
   }// end exchange()


   // 고객 잔액에 따른 등급을 나누기 위한 메소드 정의
   public void point()   
   {
      int i;            // 반복문을 위한 변수 i
      String pname;         // 입력받은 성함을 받기 위한 문자열 변수
      String pAccountNum;   // 입력받은 계좌 번호를 받기 위한 문자열 변수
      String ppw;         // 입력받은 비밀 번호를 받기 위한 문자열 변수

      System.out.print(" 고객님의 【성함】을 입력해주세요. : ");
      pname = sc.next();
      
      System.out.print(" 고객님의 【계좌 번호】를 입력해주세요(숫자만 입력). : ");
      pAccountNum = sc.next();

      System.out.print(" 고객님의 【비밀번호】를 입력해주세요. : ");
      ppw = sc.next();
   

      // 등급확인 처리 부분 시작
      System.out.println("=========== 등급확인 시작 ===========");

      for (i=0; i<inwon+1; i++)                                                                                       // 0번째 방부터 inwon 까지 반복문 수행
      {
     
         if(acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))   
       // 계좌번호 일치 O 『and』 비밀번호 일치 O → 고객이 입력한 정보에 맞는 회원이 있는 경우

         {
            
            System.out.println("계좌번호, 비밀번호 일치O");
            System.out.println();
            System.out.println("===============================================");
             System.out.println(" 【성함】 : " + acArray[i].getname() + "\t" + acArray[i].getaccountNumber() + " 님의 계좌입니다.");
            System.out.println(" 현재 잔액 조회 : " + acArray[i].getaccountBalance()); 
            System.out.println();

            /*
            *****등급나누기******
            일반 : ~ 5000000 
            VIP : ~ 50000000
            VVIP : ~ 500000000
            */

            if (acArray[i].getaccountBalance() >= 500000000)                                       // 잔액이 5억 이상인 경우 【고객 등급 : VVIP】
            {
               System.out.println("고객님의 등급은 VVIP 입니다~!!!");
               break;
            }
            else if (acArray[i].getaccountBalance() >= 5000000 && acArray[i].getaccountBalance() < 500000000)   // 잔액이 500만원~5억 인 경우 【고객 등급 : VIP】
            {
               System.out.println("고객님의 등급은 VIP 입니다~!!!");
               break;
            }
            else                                                                        // 잔액이 500만원 이하인 경우 【고객 등급 : 일반】
            {
               System.out.println("고객님의 등급은 일반 입니다~!!!");
               break;
            }
         }


         if(acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)))      // 계좌번호 일치 『or』 비밀번호 일치
         {
            if(!acArray[i].getaccountNumber().equals(pAccountNum) && acArray[i].getpassword().equals(ppw))    // 계좌번호 일치 X 『and』 비밀번호 일치 O
            {
               System.out.println("비밀번호는 일치하지만, 계좌번호가 틀렸습니다.");
               return;
            }
            if(acArray[i].getaccountNumber().equals(pAccountNum) && !acArray[i].getpassword().equals(ppw))    // 계좌번호 일치 O 『and』 비밀번호 일치 X
            {
               System.out.println("계좌번호는 일치하지만, 비밀번호가 틀렸습니다.");
               return;
            }
         }
      
         else                                                                          // 계좌번호 일치 X 『and』 비밀번호 일치 X
         { 
            if (acArray[i].getaccountNumber().equals(pAccountNum) || (acArray[i].getpassword().equals(ppw)) && i==(acArray.length)) 
         // 반복문이 마지막 배열까지 돌았을 경우

            {
           
               System.out.println("일치하는 정보가 없습니다.");                                      // 일치하는 정보가 없다고 출력한 후 종료.
               break;
            }
         }
      }
   } // end point


  // 계좌 조회 메소드
   public void checkAccount() 
   {
      String inpw;
      String inac;
      Scanner sc = new Scanner(System.in);
      System.out.print("고객님의 【계좌번호】을 입력해주세요. : ");
      inac = sc.next();
      System.out.print("고객님의 【비밀번호】을 입력해주세요. : ");
      inpw = sc.next();

     try                                                                                                       // acArray[i].getname() 부터 NullPointerException 발생 
     {
       for (int i=0; i<acArray.length; i++)
       {
          if (acArray[i].getaccountNumber().equals(inac) || (acArray[i].getpassword().equals(inpw)))         // 계좌번호 일치 『or』 비밀번호 일치
          {
            if (acArray[i].getaccountNumber().equals(inac) && acArray[i].getpassword().equals(inpw))      // 계좌번호 일치 O 『and』 비밀번호 일치
            {
                  System.out.println("==============================================================");
                  System.out.println("     이    름     : " + acArray[i].getname());
                  System.out.println("     계좌번호     : " + acArray[i].getaccountNumber());
                  System.out.println("     잔    액     : " + acArray[i].getaccountBalance());
                  System.out.println(" 가입된 적금 상품 : " + acArray[i].savingName);
                  System.out.println("   적금계좌번호   : " + acArray[i].getsavingNum());
                  System.out.println("     잔    액     : " + acArray[i].getsavingBalance());
                  System.out.println("==============================================================");
                  break;
            }
            if(!acArray[i].getaccountNumber().equals(inac) && acArray[i].getpassword().equals(inpw))        // 계좌번호 일치 X 『and』 비밀번호 일치 O
            {
               System.out.println("※※※※※ 비밀번호는 일치하지만, 계좌번호가 틀렸습니다. ※※※※※");  // 경고 문자 출력 후 탐색 종료
               break;
            }
            if(acArray[i].getaccountNumber().equals(inac) && !acArray[i].getpassword().equals(inpw))        // 계좌번호 일치 O 『and』 비밀번호 일치 X
            {
               System.out.println("※※※※※ 계좌번호는 일치하지만, 비밀번호가 틀렸습니다. ※※※※※");
               break;
            }
          }

          else
          {
            // System.out.println("탐색중입니다.");    // 0번째 방부터 고객 수 만큼 일치하는 정보 계속 탐색하고 있다고 출력으로 보여줌.(확인용)


            if (acArray[i].getaccountNumber().equals(inac) || (acArray[i].getpassword().equals(inpw)) && i==(acArray.length))    // 반복문이 마지막 배열까지 돌았을 경우
            {

               System.out.println("※※※※※ 일치하는 정보가 없습니다. ※※※※※");                                 // 일치하는 정보가 없다고 출력한 후 종료.
               break;

            } // end if
          } //end else
        }//end for
      }// end try

      catch (NullPointerException e)
      {
          System.out.println("※※※※※ 정보가 없습니다. 다시한번 확인해주세요. ※※※※※");
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
       System.out.println("-------------관리자 모드 메뉴------------------");
       System.out.println("원하시는 서비스의 번호를 입력해주세요.");

      System.out.print("1.전체계좌조회   2.환율값 변경  3.은행 총 잔고 조회 : " );
       smenu=sc.nextInt();
      System.out.println();
      System.out.print("관리자 비밀번호를 입력하세요 : ");
      String keyin=sc.next();

      try
      {
         if (smenu==2 && keyin.equals(epickey))
         {
            System.out.print("변경할 환율값의 화폐를 선택해주세요 :");
            System.out.print("1: 달러, 2:유로, 3:엔화, 4:위안 \n");
            choice=sc.nextInt();
            switch (choice)
            {
                  case 1 : {System.out.print("변경하실 달러의 환율은? : "); Ratedollar=sc.nextDouble(); break;}
                  case 2 : {System.out.print("변경하실 유로의 환율은? : "); RateEuro=sc.nextDouble(); break;}
                  case 3 : {System.out.print("변경하실 엔화의 환율은? : "); RateEnhwa=sc.nextDouble(); break;}
                  case 4 : {System.out.print("변경하실 위안의 환율은? : "); RateWean=sc.nextDouble(); break;}
                 
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
                    System.out.println("이름 :" + acArray[i].getname());
                    System.out.println("계좌번호 : " + acArray[i].getaccountNumber());
                    System.out.println("잔액 : " + acArray[i].getaccountBalance());
                    System.out.println("가입된 적금 상품 : " + acArray[i].savingName);
                    System.out.println("적금 계좌 : " + acArray[i].getsavingNum());
                    System.out.println("잔액 : " + acArray[i].getsavingBalance());
                    System.out.println("비밀번호 : " + acArray[i].getpassword());
                    System.out.println();
                     
                    System.out.println("관리자 모드 로그인 성공 ! ");
                    break;
             }

          else if( (smenu==1 && keyin.equals(epickey) ) && inwon==m)
          {
                  System.out.println("계좌 정보가 없습니다 ! " );
                  break;
          }

          if (smenu==3 && keyin.equals(epickey))
         {
               int result=acArray[i].getaccountBalance()+(int)acArray[i].getsavingBalance();
               sum+=result;

                if (i==inwon)
                {
                     System.out.printf("은행 총 잔고는 %d 원 입니다.\n",sum);
                }
               }
        } //end for
      if(!keyin.equals(epickey))
       {
             System.out.println("관리자 비밀번호가 일치하지 않습니다 ! " );
       }
    }// end try
    catch (NullPointerException e)
    {
    }
  } //end owner()

   //main 메소드
   public static void main(String[] args)throws IOException
   {

      Scanner sc = new Scanner(System.in);
     
      //Account 클래스 기반 인스턴스 생성
     Account ac=new Account();
     //Manage2 클래스 기반 인스턴스 생성
      Manage2 m = new Manage2();
     
      int n;            //사용자에게 입력받을 번호 저장         
     
    try
    {
       jump:
      do
      {
           System.out.println("<<<<<  ♥ 안녕하세요~ 쌍강교 은행입니다! 무엇을 도와드릴까요?? ♥  >>>>>");
           System.out.println();
           System.out.println("0번 : 도움말");
           System.out.println("1번 : 계좌관리");
           System.out.println("2번 : 입출금");
           System.out.println("3번 : 계좌이체");
           System.out.println("4번 : 환전");
           System.out.println("5번 : 등급조회");
         System.out.println("6번 : 관리자모드");
           System.out.println("7번 : 종료");
         System.out.println();
           System.out.print("● 필요하신 서비스번호를 입력하세요 : ");
           n = sc.nextInt();
         System.out.println();

          // 사용자가 0번 도움말 눌렀을 경우
        if (n==0)
            m.help();
          
        // 사용자가 1번 계좌 관리를 눌렀을 경우 
          if (n==1)
          {
            do
            {
               System.out.println("1번 : 계좌 개설");
               System.out.println("2번 : 계좌 조회");
               System.out.println("3번 : 계좌 해지");
               System.out.println("9번 : 종료");
               System.out.println();
               System.out.print("● 필요하신 서비스번호를 입력하세요 : ");
               n = sc.nextInt();
               System.out.println();

               //사용자가 1번 계좌 개설을 눌렀을 경우
               if(n == 1)
               {
                  m.openAccount();
                  m.inwon++;
                  m.openAccount();
            
               }

               // 사용자가 2번 계좌 조회를 눌렀을 경우
               if(n == 2)
                   m.checkAccount();
               
               // 사용자가 3번 계좌 해지를 눌렀을 경우
               if(n == 3)
                   m.deleteAccount();
               
               // 사용자가 9번 종료를 눌렀을 경우
               if(n == 9)
                  continue jump;    //초기화면으로 점프

           }while(n!=9);

         
         } //end if
 
         // 사용자가 2번 『입출금』 눌렀을 경우
         if(n==2)
            m.input();
          
         // 사용자가 3번 『계좌이체』 눌렀을 경우
       if (n==3)
            m.sendmoney();

         //사용자가 4번 『환전』 눌렀을 경우
         if(n==4)
             m.exchange();
           
         //사용자가 5번 『등급조회』 눌렀을 경우
       if(n==5)
             m.point();

       // 사용자가 6번 『관리자 모드』 눌렀을 경우
       if(n==6)
          m.owner();
      

      }while(n!=7);

   }catch (Exception e)
    {
       System.out.println("올바른 번호를 입력해주세요 !"); 
    }
     

}//end class Manage2
}