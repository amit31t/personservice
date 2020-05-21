package com.trip.program.arrays;

import java.util.PriorityQueue;

/*
 * Prob- given n points in 2D space, find k closest points from the origin
 */
public class Prob_K_ClosestPointsFromOrigin 
{
	public static void main(String[] args) 
	{
		int[][] points = {{-2, 4}, {0, -2}, {-1, 0}, {3, 5}, {-2, -3}, {3, 2}};
		int k = 2;
		//k closest points from origin
		PriorityQueue<Point> result = findKClosestPointsFromOrigin(points, k);
		System.out.println("First "+k+ " points ");
		for(Point point : result)
			System.out.println(point.getX()+", "+point.getY());
	}

	private static PriorityQueue<Point> findKClosestPointsFromOrigin(int[][] points, int k) 
	{
		//Apply pythagoras theorem to get distance from origin c=sqrt(a2 + b2)
		Point [] dPoints = getDistanceFromOrigin(points);
		
		//soln1- use sorting and return first k points O(nlogn)
		//soln2 to use maxHeap and select first k distances
		PriorityQueue<Point> maxHeap = new PriorityQueue<>();
		for(int i = 0; i < k; i++) //initalize maxheap with first k points
			maxHeap.add(dPoints[i]);
		
		for(int i = k; i<points.length; i++)
		{
			if(maxHeap.peek().getDistace() > dPoints[i].getDistace())
			{
				maxHeap.remove();
				maxHeap.add(dPoints[i]);
			}		
		}
		
		return maxHeap;
	}

	private static Point[] getDistanceFromOrigin(int[][] points) 
	{
		Point [] dPoints = new Point[points.length];
		for(int i = 0; i<points.length; i++)
		{
			Point point = new Point();
			point.setX(points[i][0]); point.setY(points[i][1]);
			int c = (point.getX()*point.getX()) + (point.getY()*point.getY());
			point.setDistace(Math.sqrt(c));
			dPoints[i] = point;
		}
		return dPoints;
	}
	
	private static class Point implements Comparable<Point>
	{
		int x;
		int y;
		double distace;
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public double getDistace() {
			return distace;
		}
		public void setDistace(double distace) {
			this.distace = distace;
		}
		@Override
		public int compareTo(Point p) {
			return Double.valueOf(p.distace).compareTo(Double.valueOf(this.distace));
		}
		
	}
}

