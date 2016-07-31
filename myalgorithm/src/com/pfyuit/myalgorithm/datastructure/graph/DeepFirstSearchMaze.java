package com.pfyuit.myalgorithm.datastructure.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author yupengfei
 */
public class DeepFirstSearchMaze {

	private static final char SYMBOL_TRAP = 'X';
	private static final char SYMBOL_CAN_WALK = '.';
	private static final String INPUT_FILE_PATH = "C:\\input.txt";

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File(INPUT_FILE_PATH);
		Scanner scanner = new Scanner(input);
		while (scanner.hasNextLine()) {
			processTestCase(scanner);
		}
		scanner.close();
	}

	private static void processTestCase(Scanner scanner) {
		String[] dimension = scanner.nextLine().trim().split(" ");
		int rowTotal = Integer.parseInt(dimension[0]);
		int columnTotal = Integer.parseInt(dimension[1]);
		Vertex[][] matrix = buildVertexMatrix(scanner, rowTotal, columnTotal);
		Map<Vertex, List<Vertex>> validAdjacencyList = buildVertexAdjacencyList(rowTotal, columnTotal, matrix);

		List<List<Vertex>> validPaths = new ArrayList<List<Vertex>>();
		List<Vertex> possiblePath = new ArrayList<Vertex>();
		Map<Vertex, Boolean> visitMap = initializeVisitMap(validAdjacencyList);
		Vertex source = matrix[0][0];
		Vertex destination = matrix[rowTotal - 1][columnTotal - 1];
		search(source, destination, validAdjacencyList, visitMap, possiblePath, validPaths);
		processResult(validPaths);
	}

	private static Vertex[][] buildVertexMatrix(Scanner scanner, int rowTotal, int columnTotal) {
		Vertex[][] matrix = new Vertex[rowTotal][columnTotal];
		int rowIndex = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			char[] symbols = line.toCharArray();
			for (int columnIndex = 0; columnIndex < symbols.length; columnIndex++) {
				char symbol = symbols[columnIndex];
				Vertex vertex = new Vertex();
				vertex.x = rowIndex;
				vertex.y = columnIndex;
				if (symbol != SYMBOL_TRAP && symbol != SYMBOL_CAN_WALK) {
					vertex.cost = Integer.parseInt(new String(new char[] { symbol }));
				}
				vertex.symbol = symbol;
				matrix[rowIndex][columnIndex] = vertex;
			}
			rowIndex++;
			if (rowIndex == rowTotal) {
				break;
			}
		}
		return matrix;
	}

	private static Map<Vertex, List<Vertex>> buildVertexAdjacencyList(int rowTotal, int columnTotal, Vertex[][] matrix) {
		Map<Vertex, List<Vertex>> vertexAdjMap = new HashMap<Vertex, List<Vertex>>(rowTotal * columnTotal);
		for (int i = 0; i < rowTotal; i++) {
			for (int j = 0; j < columnTotal; j++) {
				if (matrix[i][j].symbol == SYMBOL_TRAP) {
					continue;
				}
				vertexAdjMap.put(matrix[i][j], new ArrayList<Vertex>());
				int topIndex = i - 1;
				int bottomIndex = i + 1;
				int leftIndex = j - 1;
				int rightIndex = j + 1;
				if (topIndex >= 0 && topIndex <= rowTotal - 1) {
					if (matrix[topIndex][j].symbol != SYMBOL_TRAP) {
						vertexAdjMap.get(matrix[i][j]).add(matrix[topIndex][j]);
					}
				}
				if (bottomIndex >= 0 && bottomIndex <= rowTotal - 1) {
					if (matrix[bottomIndex][j].symbol != SYMBOL_TRAP) {
						vertexAdjMap.get(matrix[i][j]).add(matrix[bottomIndex][j]);
					}
				}
				if (leftIndex >= 0 && leftIndex <= columnTotal - 1) {
					if (matrix[i][leftIndex].symbol != SYMBOL_TRAP) {
						vertexAdjMap.get(matrix[i][j]).add(matrix[i][leftIndex]);
					}
				}
				if (rightIndex >= 0 && rightIndex <= columnTotal - 1) {
					if (matrix[i][rightIndex].symbol != SYMBOL_TRAP) {
						vertexAdjMap.get(matrix[i][j]).add(matrix[i][rightIndex]);
					}
				}
			}
		}
		return vertexAdjMap;
	}

	private static Map<Vertex, Boolean> initializeVisitMap(Map<Vertex, List<Vertex>> vertexAdjMap) {
		Map<Vertex, Boolean> visitMap = new HashMap<Vertex, Boolean>();
		for (Vertex vertex : vertexAdjMap.keySet()) {
			visitMap.put(vertex, Boolean.FALSE);
		}
		return visitMap;
	}

	private static void processResult(List<List<Vertex>> validPaths) {
		if (validPaths == null || validPaths.isEmpty()) {
			System.out.println("God please help our poor hero.");
			System.out.println("FINISH.");
		}
		List<Vertex> minCostPath = null;
		int minCost = Integer.MAX_VALUE;
		for (List<Vertex> path : validPaths) {
			int cost = path.size() - 1;
			for (Vertex v : path) {
				cost += v.cost;
			}
			if (cost < minCost) {
				minCost = cost;
				minCostPath = path;
			}
		}
		if (minCostPath != null) {
			System.out.println("It takes " + minCost + " seconds to reach the target position, let me show you the way.");
			for (int i = 0; i < minCostPath.size() - 1; i++) {
				System.out.println(minCostPath.get(i) + "=>" + minCostPath.get(i + 1));
			}
			System.out.println("FINISH.");
		}
	}

	private static void search(Vertex source, Vertex destination, Map<Vertex, List<Vertex>> validAdjacencyList, Map<Vertex, Boolean> visitMap,
			List<Vertex> possiblePath, List<List<Vertex>> validPaths) {
		setupSourceVertex(visitMap, source, possiblePath);
		if (source.equals(destination)) {
			List<Vertex> validPath = new ArrayList<Vertex>(possiblePath);
			validPaths.add(validPath);
		} else {
			for (Vertex neighbor : validAdjacencyList.get(source)) {
				if (visitMap.get(neighbor) == Boolean.FALSE) {
					search(neighbor, destination, validAdjacencyList, visitMap, possiblePath, validPaths);
				}
			}
		}
		removeSourceVertex(visitMap, source, possiblePath);
	}

	private static void setupSourceVertex(Map<Vertex, Boolean> visitMap, Vertex source, List<Vertex> possiblePath) {
		possiblePath.add(source);
		visitMap.put(source, Boolean.TRUE);
	}

	private static void removeSourceVertex(Map<Vertex, Boolean> visitMap, Vertex source, List<Vertex> possiblePath) {
		possiblePath.remove(possiblePath.size() - 1);
		visitMap.put(source, Boolean.FALSE);
	}

	public static class Vertex {

		public int x;
		public int y;
		public int cost = 0;
		public char symbol;

		public String toString() {
			return "(" + x + "," + y + ")";
		}

	}

}
