package com.pfyuit.myalgorithm.datastructure.graph;

/**
 * @author yupengfei
 */
public class Vertex {

	public int x;
	public int y;
	public int cost = 0;
	public char symbol;

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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

}