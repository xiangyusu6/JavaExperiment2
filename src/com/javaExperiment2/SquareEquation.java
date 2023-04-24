package com.javaExperiment2;

public class SquareEquation {
    double a,b,c;
    public void setA(double a){
        this.a=a;
    }
    public void setB(double b){
        this.b=b;
    }
    public void setC(double c){
        this.c=c;
    }
    public double getRootOne()
    {
        double disk=calculateValidDisk();
        return (-b+Math.sqrt(disk))/(2*a);
    }
    public double getRootTwo(){
        double disk=calculateValidDisk();
        return (-b-Math.sqrt(disk))/(2*a);
    }
    private double calculateValidDisk()
    {
        if(a==0){
            throw new EquationException("不是二次方程",
                    EquationException.NONE_EQUATION);
        }
        double disk=b*b-4*a*c;
        if(disk<0)
        {throw new EquationException("没有实根",
                EquationException.NO_REAL_ROOT);
        }
        return disk;
    }
}
class EquationException extends RuntimeException{
    public static final int NONE_EQUATION=1;
    public static final int NO_REAL_ROOT=2;
    private int errorCode;
    public EquationException(String msg,int errerCode)
    {
        super(msg);
        this.errorCode=errorCode;
    }
    public int getErroeCode(){
        return errorCode;
    }
}