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
	//按照时间排序
	 public static ArrayList<Mess> sortMessByTime(ArrayList<Mess>messlist, int low, int high) throws ParseException{
		 int mid = (low+high)/2;
	        if(low<high){
	            sortMessByTime(messlist,low,mid);
	            sortMessByTime(messlist,mid+1,high);
	            //左右归并
	            mergeMessByTime(messlist,low,mid,high);
	        }
	        return messlist;
	    }

	    // 将两个有序序列归并为一个有序序列(二路归并)
	 public static void mergeMessByTime(ArrayList<Mess>messlist, int low, int mid, int high) throws ParseException{
		 ArrayList<Mess>temp=new ArrayList<Mess>();
		 for(int i=0;i<high-low+1;i++){
			 Mess mess=new Mess();
			 temp.add(mess);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // 把较小的数先移到新数组中
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
	        // 把左边剩余的数移入数组 
	        while(i<=mid){
	        	temp.set(k++, messlist.get(i++));
	        }
	        // 把右边边剩余的数移入数组
	        while(j<=high){
	        	temp.set(k++, messlist.get(j++));
	        }
	        // 把新数组中的数覆盖nums数组
	        for(int x=0;x<temp.size();x++){
	        	messlist.set(x+low, temp.get(x));
	        }
	    }
	 
	 
	 //按照欢迎程度排序
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
	            //左右归并
	            mergeMessByLike(messlist,low,mid,high);
	        }
	        return messlist;
	    }

	    // 将两个有序序列归并为一个有序序列(二路归并)
	 public static void mergeMessByLike(ArrayList<Mess>messlist, int low, int mid, int high){
		 ArrayList<Mess>temp=new ArrayList<Mess>();
		 for(int i=0;i<high-low+1;i++){
			 Mess mess=new Mess();
			 temp.add(mess);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // 把较小的数先移到新数组中
	        while(i<=mid && j<=high){
			    int vai=getLikeNum(messlist,i);
			    int vaj=getLikeNum(messlist,j);
	            if(vai<vaj){
	            	temp.set(k++, messlist.get(i++));
	            }else{
	            	temp.set(k++, messlist.get(j++));
	            }
	        }
	        // 把左边剩余的数移入数组 
	        while(i<=mid){
	        	temp.set(k++, messlist.get(i++));
	        }
	        // 把右边边剩余的数移入数组
	        while(j<=high){
	        	temp.set(k++, messlist.get(j++));
	        }
	        // 把新数组中的数覆盖nums数组
	        for(int x=0;x<temp.size();x++){
	        	messlist.set(x+low, temp.get(x));
	        }
	    }
	
	 //按照浏览次数排序 
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
	            //左右归并
	            mergeMessByScan(messlist,low,mid,high);
	        }
	        return messlist;
	    }

	    // 将两个有序序列归并为一个有序序列(二路归并)
	 public static void mergeMessByScan(ArrayList<Mess>messlist, int low, int mid, int high){
		 ArrayList<Mess>temp=new ArrayList<Mess>();
		 for(int i=0;i<high-low+1;i++){
			 Mess mess=new Mess();
			 temp.add(mess);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // 把较小的数先移到新数组中
	        while(i<=mid && j<=high){
			    int vai=getScanNum(messlist,i);
			    int vaj=getScanNum(messlist,j);
	            if(vai<vaj){
	            	temp.set(k++, messlist.get(i++));
	            }else{
	            	temp.set(k++, messlist.get(j++));
	            }
	        }
	        // 把左边剩余的数移入数组 
	        while(i<=mid){
	        	temp.set(k++, messlist.get(i++));
	        }
	        // 把右边边剩余的数移入数组
	        while(j<=high){
	        	temp.set(k++, messlist.get(j++));
	        }
	        // 把新数组中的数覆盖nums数组
	        for(int x=0;x<temp.size();x++){
	        	messlist.set(x+low, temp.get(x));
	        }
	    }

}
