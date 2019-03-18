package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.po.Comment;

public class SortCommTime {
	public SortCommTime(){
		
	}
	public static long getTimeDif(String time)throws ParseException{
		Date systime=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date oldtime=format.parse(time);
		long stvalue=systime.getTime();
		long otvalue=oldtime.getTime();
		long dif=stvalue-otvalue;
		return dif;
	}
	
	 public static ArrayList<Comment> sort(ArrayList<Comment>commlist, int low, int high) throws ParseException{
		 int mid = (low+high)/2;
	        if(low<high){
	            sort(commlist,low,mid);
	            sort(commlist,mid+1,high);
	            //���ҹ鲢
	            merge(commlist,low,mid,high);
	        }
	        return commlist;
	    }

	    // �������������й鲢Ϊһ����������(��·�鲢)
	 public static void merge(ArrayList<Comment>commlist, int low, int mid, int high) throws ParseException{
		 ArrayList<Comment>temp=new ArrayList<Comment>();
		 for(int i=0;i<high-low+1;i++){
			 Comment c=new Comment();
			 temp.add(c);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // �ѽ�С�������Ƶ���������
	        while(i<=mid && j<=high){
	        	Comment ci=commlist.get(i);
			    String timei=ci.getTime();
			    long vai=getTimeDif(timei);
			    Comment cj=commlist.get(j);
			    String timej=cj.getTime();
			    long vaj=getTimeDif(timej);
	            if(vai<vaj){
	            	temp.set(k++, commlist.get(i++));
	            }else{
	            	temp.set(k++, commlist.get(j++));
	            }
	        }
	        // �����ʣ������������� 
	        while(i<=mid){
	        	temp.set(k++, commlist.get(i++));
	        }
	        // ���ұ߱�ʣ�������������
	        while(j<=high){
	        	temp.set(k++, commlist.get(j++));
	        }
	        // ���������е�������nums����
	        for(int x=0;x<temp.size();x++){
	        	commlist.set(x+low, temp.get(x));
	        }
	    }

	

	/*public static void main(String[] args){
		TimeToInt ti=new TimeToInt();
		try{
			long dif=ti.getTimeDif("2018/06/07 20:00:26");
			System.out.print(dif);
		}
		catch(ParseException e){
			
		}
	}*/

}
