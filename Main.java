package com.godofstockgod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	private static Boolean randomIsWin(double winRate)
	{
		Random rand=new Random();
		double value=rand.nextDouble();
		return value>winRate?false:true;
	}
	public static int longFailed(int n)
	{
		int me=n;
		int times=0;
		while(me>0)
		{
			if(randomIsWin(0.5))
			{
				me+=1;
			}else
			{
				me-=1;
			}
			times++;
		}
		return times;
	}
	public static int keli(double me,double you,double winRate,double payRate) throws Exception
	{
		double p=winRate;
		double q=1-winRate;
		double b=payRate;
		double f=(b*p-q)/b;
		if(f<0)
		{
			throw new Exception("Impossible");
		}
		int times=0;
		while(you>0)
		{
			double input=me*f;
			if(randomIsWin(winRate))
			{
				me+=input;
				you-=input;
			}else
			{
				me-=input;
				you+=input;
			}
			times++;
			if(me<=0)
			{
				throw new Exception("Unbelieveral");
			}
		}
		return times;
	}
	
	public static void demoKeli() throws Exception
	{

		int n=10000;
		//double[] variants=new double[]{0.999999999};
		//double[] variants=new double[]{0.55,0.6,0.65,0.7,0.75,0.8,0.85,0.9,0.95};
		double[] variants=new double[]{0.52,0.525,0.53,0.535,0.54,0.545,0.55,0.555,0.56,0.58,0.60,0.62,0.64,0.66,0.68,0.70,0.72,0.74,0.76,0.78,0.80,0.82,0.84,0.86,0.88,0.90,0.92,0.94,0.96,0.98};
		for(double var:variants)
		{
			double sum=0;
			for(int i=0;i<n;i++)
			{
				sum+=keli(1,1,var,1.0);
			}
			String msg=String.format("%.3f,%f", var,sum/n);
			System.out.println(msg);
		}
	}
	public static void demoLongFailed() throws Exception
	{

		int n=100;
		double sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=longFailed(1);
		}
		
		String msg=String.format("%f",sum/n);
		System.out.println(msg);
 
	}
	
	public boolean  isGood(List<Integer> list)
	{
		int sum=0;
		for(int i=0;i<list.size();i++)
		{
			sum+=list.get(i);
			if(sum*2-1==i)
			{
				if(i==list.size()-1)
				{
					return false;
				}
			}
		}
		 return true;
	}

	public boolean reset(List<Integer> list)
	{
		for(int i=0;i<list.size()/2;i++)
		{
			for(int j=list.size()-1;j>0;j--)
			{
			//	if(!canReset(i,list))
				{
					break;
				}
			}
		}

		return true;
	}
	
	public int fun(List<Integer> list)
	{
		int count=0;
		while(reset(list))
		{
			count++;
		}
		return count;
	}
	
	public static void demoFar()
	{

		int num=64;
		List<Integer> list=new ArrayList(num);
		for(int i=0;i<num/2;i++)
		{
			list.add(1);
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception
	{

		demoLongFailed();
		//demoKeli();

	}
}
