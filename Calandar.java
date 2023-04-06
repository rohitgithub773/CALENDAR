import java.util.*;
class Calandar
{
    int day,mon,y,fdy;
    String m[]={"SATURDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
    int d[]={29,31,28,31,30,31,30,31,31,30,31,30,31};
    Scanner sc=new Scanner(System.in);
    void input()
    {

        System.out.println("ENTER DAY:");
        day=sc.nextInt();
        System.out.println("ENTER MONTH:");
        mon=sc.nextInt();
        System.out.println("ENTER YEAR");
        y=sc.nextInt();

    }

    void print(int fd)
    {
        System.out.print("SUN"+"\t"+"MON"+"\t"+"TUE"+"\t"+"WED"+"\t"+"THUR"+"\t"+"FRI"+"\t"+"SAT");
        System.out.println();
        for(int i=0;i<fd;i++)
            System.out.print("\t");
        for(int i=1;i<=d[mon];i++)
        {
            System.out.print(i+"\t");
            fd++;
            if(fd==7)
            {

                System.out.println();
                fd=0;
            }
        }

    }
    void main()
    {   
        System.out.println("CHOICES:");
        System.out.println("PRESS 1 FOR DESIRED DAY:");
        System.out.println("PRESS 2 FOR PRINTING CALANDER OF MONTH");
        System.out.println("PRESS 3 FOR PRINTING DESIRED DATE:");
        int choice=sc.nextInt();
        int res=0;

        switch(choice)
        {
            case 1:   input();
                res=firstday();
                System.out.println("DESIRED DAY ON GIVEN DATE :"+m[res]);
                break;
            case 2:System.out.println("ENTER MONTH:");
                mon=sc.nextInt();
                System.out.println("ENTER YEAR:");
                y=sc.nextInt();
                day=1;
                res=firstday();
                print(res);
                break;
            case 3:input();
                System.out.println("INPUT DATE:"+day+"/"+mon+"/"+y);
                System.out.println("ENTER NUMBER OF DAYS,TO PRODUCE DESIRED DATE:");
                int n=sc.nextInt();
                after(n);
                break;
            default:System.out.println("WRONG CHOICE:");
        }

    }

    int firstday()
    {

        int td=0;
        for(int i=1;i<y;i++)
        {

            if(i%4==0)
                td++;
            td=td+365;
        }
        int fd=td%7;
        System.out.println("FIRST DAY OF GIVEN YEAR:"+m[fd]);
        fdy=fd;
        if(y%4==0)
            d[2]=29;
        td=0;
        for(int i=1;i<mon;i++)
        {
            td=td+d[i];
        }
        td=td+day-1;
        fd=fd+td%7;
        if(fd>7)
            fd=fd%7; 
        return fd;

    }

    void after(int n)
    {
        int mo=mon;int c=-1;
        for(int i=1;i<=n;i++)
        {
            if(y%4==0)
                d[2]=29;
            else d[2]=28;
            day++;
            if(day>d[mo])
            {

                day=1;mo++;c++;
                if(mo==13)
                {
                    c++;
                    y++;
                    mo=1;
                }
            }
        }

        
        System.out.println("OUTPUT DATE:"+day+"/"+mo+"/"+y);
    }

}   

            
