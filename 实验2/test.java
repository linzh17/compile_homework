import java.io.*;
import java.util.Random;
public class test{
public static int selfRandom(int i){
Random rand=new Random();
int result=(int)(Math.random()*(i+1));
return result;
}
public static int A(){
    return 1;
    }
    public static int B(){
    int i;
    i=selfRandom(3);
    if(i==3)
    return 0;
    else return 1;
    }
    public static int C(int nowC,int [] bC){
    if(nowC==0)
    return 1;
    else return bC[nowC-1];
    }
    public static int D(int nowD,int [] bD){
    if(nowD==0)
    return 1;
    else {
    int j;
    j=selfRandom(9);
    if(j==9)
    return 0;
    else return bD[nowD-1];
    }
    }
    public static int E(int nowE,int [] bE){
    if(nowE==0)
    return 1;
    else {
    while(nowE>0) {
    nowE=nowE-1;
    if(bE[nowE]==0)
    {
    return 0;
    }
    }
    }
    return 1;
    }
    public static int Sorce(int pos,int I,int J){
    int sorceResult;
    sorceResult=0;
    if(I==0)
    {
    if(J==1)
    {
    if(pos==1)
    sorceResult=5;
    else sorceResult=0;
    }
    else sorceResult=1;
    }
    if(I==1)
    {
    if(J==0)
    {
    if(pos==1)
    sorceResult=0;
    else sorceResult=5;
    }
    else sorceResult=3;
    }
    return sorceResult;
    }
    public static void main(String []args){
     int [] a= new int [200];
     int [] b= new int [200];
    int sorceA;
    sorceA=0;
    int sorceB;
    sorceB=0;
    int sorceC;
    sorceC=0;
    int sorceD;
    sorceD=0;
    int sorceE;
    sorceE=0;
    int temp;
    int tempa;
    int tempb;
    int time;
    time=0;
    while(time<200) {
    tempa=A();
    a[time]=tempa;
    tempb=B();
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceA=sorceA+temp;
    temp=Sorce(0,tempa,tempb);
    sorceB=sorceB+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=A();
    a[time]=tempa;
    tempb=C(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceA=sorceA+temp;
    temp=Sorce(0,tempa,tempb);
    sorceC=sorceC+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=A();
    a[time]=tempa;
    tempb=D(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceA=sorceA+temp;
    temp=Sorce(0,tempa,tempb);
    sorceD=sorceD+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=A();
    a[time]=tempa;
    tempb=E(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceA=sorceA+temp;
    temp=Sorce(0,tempa,tempb);
    sorceE=sorceE+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=B();
    a[time]=tempa;
    tempb=C(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceB=sorceB+temp;
    temp=Sorce(0,tempa,tempb);
    sorceC=sorceC+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=B();
    a[time]=tempa;
    tempb=D(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceB=sorceB+temp;
    temp=Sorce(0,tempa,tempb);
    sorceD=sorceD+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=B();
    a[time]=tempa;
    tempb=E(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceB=sorceB+temp;
    temp=Sorce(0,tempa,tempb);
    sorceE=sorceE+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=C(time,b);
    a[time]=tempa;
    tempb=D(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceC=sorceC+temp;
    temp=Sorce(0,tempa,tempb);
    sorceD=sorceD+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=C(time,b);
    a[time]=tempa;
    tempb=E(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceC=sorceC+temp;
    temp=Sorce(0,tempa,tempb);
    sorceE=sorceE+temp;
    time=time+1;
    }
    time=0;
    while(time<200) {
    tempa=D(time,b);
    a[time]=tempa;
    tempb=E(time,a);
    b[time]=tempb;
    temp=Sorce(1,tempa,tempb);
    sorceD=sorceD+temp;
    temp=Sorce(0,tempa,tempb);
    sorceE=sorceE+temp;
    time=time+1;
    }
    System.out.println(sorceA);
    System.out.println(sorceB);
    System.out.println(sorceC);
    System.out.println(sorceD);
    System.out.println(sorceE);
    }
}