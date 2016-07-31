package com.pfyuit.myalgorithm.datastructure.graph;

import java.util.List;

/**
 * @author yupengfei
 */
public class PriorityQueueNode {

	public long data;
	public PriorityQueueNode leftChild;
	public PriorityQueueNode rightChild;
	public Vertex vertex;
	public List<Vertex> path;

	public PriorityQueueNode(long value) {
		data = value;
	}

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

	public PriorityQueueNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(PriorityQueueNode leftChild) {
		this.leftChild = leftChild;
	}

	public PriorityQueueNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(PriorityQueueNode rightChild) {
		this.rightChild = rightChild;
	}

	public List<Vertex> getPath() {
		return path;
	}

	public void setPath(List<Vertex> path) {
		this.path = path;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public String toString() {
		return "(" + vertex.x + "," + vertex.y + ")";
	}

}