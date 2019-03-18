package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.po.*;

public class SortMess {
	public static long getTimeDif(String time)throws ParseException{
		Date systime=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date oldtime=format.parse(time);
		long stvalue=systime.getTime();
		long otvalue=oldtime.getTime();
		long dif=stvalue-otvalue;
		return dif;
	}
	//����ʱ������
	 public static ArrayList<Mess> sortMessByTime(ArrayList<Mess>messlist, int low, int high) throws ParseException{
		 int mid = (low+high)/2;
	        if(low<high){
	            sortMessByTime(messlist,low,mid);
	            sortMessByTime(messlist,mid+1,high);
	            //���ҹ鲢
	            mergeMessByTime(messlist,low,mid,high);
	        }
	        return messlist;
	    }

	    // �������������й鲢Ϊһ����������(��·�鲢)
	 public static void mergeMessByTime(ArrayList<Mess>messlist, int low, int mid, int high) throws ParseException{
		 ArrayList<Mess>temp=new ArrayList<Mess>();
		 for(int i=0;i<high-low+1;i++){
			 Mess mess=new Mess();
			 temp.add(mess);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // �ѽ�С�������Ƶ���������
	        while(i<=mid && j<=high){
	        	Mess mi=messlist.get(i);
			    String timei=mi.getTime();
			    long vai=getTimeDif(timei);
			    Mess mj=messlist.get(j);
			    String timej=mj.getTime();
			    long vaj=getTimeDif(timej);
	            if(vai<vaj){
	            	temp.set(k++, messlist.get(i++));
	            }else{
	            	temp.set(k++, messlist.get(j++));
	            }
	        }
	        // �����ʣ������������� 
	        while(i<=mid){
	        	temp.set(k++, messlist.get(i++));
	        }
	        // ���ұ߱�ʣ�������������
	        while(j<=high){
	        	temp.set(k++, messlist.get(j++));
	        }
	        // ���������е�������nums����
	        for(int x=0;x<temp.size();x++){
	        	messlist.set(x+low, temp.get(x));
	        }
	    }
	 
	 
	 //���ջ�ӭ�̶�����
	 public static int getLikeNum(ArrayList<Mess>messlist,int i){
			Mess mess=messlist.get(i);
			int like=mess.getCollcount()+mess.getFavor();
			return like;
		}
	 
	 public static ArrayList<Mess> sortMessByLike(ArrayList<Mess>messlist, int low, int high){
		 int mid = (low+high)/2;
	        if(low<high){
	            sortMessByLike(messlist,low,mid);
	            sortMessByLike(messlist,mid+1,high);
	            //���ҹ鲢
	            mergeMessByLike(messlist,low,mid,high);
	        }
	        return messlist;
	    }

	    // �������������й鲢Ϊһ����������(��·�鲢)
	 public static void mergeMessByLike(ArrayList<Mess>messlist, int low, int mid, int high){
		 ArrayList<Mess>temp=new ArrayList<Mess>();
		 for(int i=0;i<high-low+1;i++){
			 Mess mess=new Mess();
			 temp.add(mess);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // �ѽ�С�������Ƶ���������
	        while(i<=mid && j<=high){
			    int vai=getLikeNum(messlist,i);
			    int vaj=getLikeNum(messlist,j);
	            if(vai<vaj){
	            	temp.set(k++, messlist.get(i++));
	            }else{
	            	temp.set(k++, messlist.get(j++));
	            }
	        }
	        // �����ʣ������������� 
	        while(i<=mid){
	        	temp.set(k++, messlist.get(i++));
	        }
	        // ���ұ߱�ʣ�������������
	        while(j<=high){
	        	temp.set(k++, messlist.get(j++));
	        }
	        // ���������е�������nums����
	        for(int x=0;x<temp.size();x++){
	        	messlist.set(x+low, temp.get(x));
	        }
	    }
	
	 //��������������� 
	 public static int getScanNum(ArrayList<Mess> messlist,int i){
		 Mess mess=messlist.get(i);
		 int scan=mess.getScan();
		 return scan;
	 }
	 public static ArrayList<Mess> sortMessByScan(ArrayList<Mess>messlist, int low, int high){
		 int mid = (low+high)/2;
	        if(low<high){
	            sortMessByScan(messlist,low,mid);
	            sortMessByScan(messlist,mid+1,high);
	            //���ҹ鲢
	            mergeMessByScan(messlist,low,mid,high);
	        }
	        return messlist;
	    }

	    // �������������й鲢Ϊһ����������(��·�鲢)
	 public static void mergeMessByScan(ArrayList<Mess>messlist, int low, int mid, int high){
		 ArrayList<Mess>temp=new ArrayList<Mess>();
		 for(int i=0;i<high-low+1;i++){
			 Mess mess=new Mess();
			 temp.add(mess);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // �ѽ�С�������Ƶ���������
	        while(i<=mid && j<=high){
			    int vai=getScanNum(messlist,i);
			    int vaj=getScanNum(messlist,j);
	            if(vai<vaj){
	            	temp.set(k++, messlist.get(i++));
	            }else{
	            	temp.set(k++, messlist.get(j++));
	            }
	        }
	        // �����ʣ������������� 
	        while(i<=mid){
	        	temp.set(k++, messlist.get(i++));
	        }
	        // ���ұ߱�ʣ�������������
	        while(j<=high){
	        	temp.set(k++, messlist.get(j++));
	        }
	        // ���������е�������nums����
	        for(int x=0;x<temp.size();x++){
	        	messlist.set(x+low, temp.get(x));
	        }
	    }

}
