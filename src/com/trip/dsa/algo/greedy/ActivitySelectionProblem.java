package com.trip.dsa.algo.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ActivitySelectionProblem {

	public static void main(String[] args) 
	{
		List<Activity> activities = Arrays.asList(new Activity("A1", 0, 6),
										new Activity("A2", 3, 4),
										new Activity("A3", 1, 2),
										new Activity("A4", 5, 8),
										new Activity("A5", 5, 7),
										new Activity("A6", 8, 9));
		activitySelectionByGreedy(activities);
	}

	private static void activitySelectionByGreedy(List<Activity> activities)
	{
		//activities.stream().sorted().collect(arg0, arg1, arg2)
		//Collections.sort(activities);
		//Comparator< Activity> comp = (a1 ,a2) -> a1.compareTo(a2);
			
		List<Activity> list = activities.stream().sorted((a1 ,a2) -> a1.compareTo(a2)).collect(Collectors.toList());
		//print first activity as its finish time is minimum
		Activity previousAct = list.get(0);
		System.out.print(previousAct);
		for(int i =1; i<list.size(); i++)
		{
			Activity currentAct = list.get(i);
			if(currentAct.getStartTime() >= previousAct.finishTime)
			{
				System.out.print(currentAct);
				previousAct = currentAct;
			}
		}
	}

}

class Activity implements Comparable<Activity>
{
	private String name;
	int startTime;
	int finishTime;
	public Activity(String name, int startTime, int finishTime) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	public String getName() {
		return name;
	}
	public int getStartTime() {
		return startTime;
	}
	public int getFinishTime() {
		return finishTime;
	}
	@Override
	public String toString() {
		return " " + name +" " ;
	}
	@Override
	public int compareTo(Activity activity) {
		return this.finishTime - activity.finishTime;
	}
	
}