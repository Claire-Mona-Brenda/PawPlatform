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
	            //���ҹ鲢
	            mergeTopicByCommCount(topiclist,low,mid,high);
	        }
	        return topiclist;
	    }

	    // �������������й鲢Ϊһ����������(��·�鲢)
	 public static void mergeTopicByCommCount(ArrayList<Topic>topiclist, int low, int mid, int high){
		 ArrayList<Topic>temp=new ArrayList<Topic>();
		 for(int i=0;i<high-low+1;i++){
			 Topic topic=new Topic();
			 temp.add(topic);
		 }
	        int i= low;
	        int j = mid+1;
	        int k=0;
	        // �ѽ�С�������Ƶ���������
	        while(i<=mid && j<=high){
			    int vai=getTopicCommCount(topiclist,i);
			    int vaj=getTopicCommCount(topiclist,j);
	            if(vai<vaj){
	            	temp.set(k++, topiclist.get(j++));
	            }else{
	            	temp.set(k++, topiclist.get(i++));
	            }
	        }
	        // �����ʣ������������� 
	        while(i<=mid){
	        	temp.set(k++, topiclist.get(i++));
	        }
	        // ���ұ߱�ʣ�������������
	        while(j<=high){
	        	temp.set(k++, topiclist.get(j++));
	        }
	        // ���������е�������nums����
	        for(int x=0;x<temp.size();x++){
	        	topiclist.set(x+low, temp.get(x));
	        }
	    }

}
