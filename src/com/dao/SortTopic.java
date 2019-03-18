package com.dao;

import java.util.ArrayList;

import com.po.*;

public class SortTopic {
	public static int getTopicCommCount(ArrayList<Topic>topiclist, int i){
		Topic topic=topiclist.get(i);
		int commcount=topic.getCommcount();
		return commcount;
	}
	public static ArrayList<Topic> sortTopicByCommCount(ArrayList<Topic>topiclist, int low, int high){
		 int mid = (low+high)/2;
	        if(low<high){
	            sortTopicByCommCount(topiclist,low,mid);
	            sortTopicByCommCount(topiclist,mid+1,high);
	            //左右归并
	            mergeTopicByCommCount(topiclist,low,mid,high);
	        }
	        return topiclist;
	    }

	    // 将两个有序序列归并为一个有序序列(二路归并)
	 public static void mergeTopicByCommCount(ArrayList<Topic>topiclist, int low, int mid, int high){
		 ArrayList<Topic>temp=new ArrayList<Topic>();
		 for(int i=0;i<high-low+1;i++){
			 Topic topic=new Topic();
			 temp.add(topic);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // 把较小的数先移到新数组中
	        while(i<=mid && j<=high){
			    int vai=getTopicCommCount(topiclist,i);
			    int vaj=getTopicCommCount(topiclist,j);
	            if(vai<vaj){
	            	temp.set(k++, topiclist.get(j++));
	            }else{
	            	temp.set(k++, topiclist.get(i++));
	            }
	        }
	        // 把左边剩余的数移入数组 
	        while(i<=mid){
	        	temp.set(k++, topiclist.get(i++));
	        }
	        // 把右边边剩余的数移入数组
	        while(j<=high){
	        	temp.set(k++, topiclist.get(j++));
	        }
	        // 把新数组中的数覆盖nums数组
	        for(int x=0;x<temp.size();x++){
	        	topiclist.set(x+low, temp.get(x));
	        }
	    }

}
