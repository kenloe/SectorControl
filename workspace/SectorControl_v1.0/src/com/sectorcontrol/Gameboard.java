package com.sectorcontrol;

import java.util.ArrayList;

public class Gameboard {
	
	// Fields
	private int boardWidth;
	private int boardLength;
	private ArrayList<ArrayList<Integer>> rowList = new ArrayList<ArrayList<Integer>>();
	
	// Constructors
	public Gameboard() {
		this.boardWidth = 0;
		this.boardLength = 0;
	}
	
	public Gameboard(int boardLength, int boardWidth) {
		this.boardLength = boardLength;
		this.boardWidth = boardWidth;
		int rows_columns = 0;
		int startingPoint = 0;	// board space #1's position in the 2d array
		int upperLeftCounter = 0;
		int lowerRightCounter = 0;
		int maxInsertIndex = 0;	// maximum number of spaces for a specific row
		boolean reachedLowerRight = false;
		boolean reachedUpperLeft = false;
		int boardSpaceNum = 1;
		
		// Calculate board space #1's position in the 2d array.
		startingPoint = (boardWidth / 2) - 1;
		
		// Calculate maxInsertIndex for first row.
		maxInsertIndex = 3 + startingPoint;
		
		// Calculate number of rows and columns needed in 2d ArrayList.
		// Includes row of 0's top and bottom and column of 0's left and right.
		rows_columns = ((boardLength + 1) / 2) + ((boardWidth -3) / 2) + 2;
		
		for (int i = 0; i < rows_columns; i++) {
			ArrayList<Integer> boardRow = new ArrayList<Integer>();
			if (i == 0 || i == (rows_columns - 1)) {
				for (int j = 0; j < rows_columns; j++) {
					boardRow.add(0);
				}
			} else {
				for (int j = 0; j < rows_columns; j++) {
					if (j < startingPoint || j >= maxInsertIndex) {
						boardRow.add(0);
					} else {
						boardRow.add(boardSpaceNum);
						boardSpaceNum++;
						if (j + 1 == rows_columns) {
							reachedLowerRight = true;
						}
					}
				}
				if (!reachedLowerRight) {
					maxInsertIndex++;
				}
				if (startingPoint > 1 && !reachedUpperLeft) {
					startingPoint--;
				}
				if (startingPoint == 1 && !reachedUpperLeft) {
					reachedUpperLeft = true;
				}
				if (reachedUpperLeft) {
					if (upperLeftCounter < 3) {
						upperLeftCounter++;
					} else {
						startingPoint++;
					}
				}
				if (maxInsertIndex == (rows_columns - 1) && reachedLowerRight == false) {
					reachedLowerRight = true;
				}
				if (reachedLowerRight) {
					lowerRightCounter++;
				}
				if (lowerRightCounter > 3) {
					maxInsertIndex--;
				}
			}
			rowList.add(boardRow);
		}
	}
	
	// Getters and Setters
	public void setBoardLength(int boardLength) {
		this.boardLength = boardLength;
	}
	
	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}
	
	public int getBoardLength() {
		return boardLength;
	}
	
	public int getBoardWidth() {
		return boardWidth;
	}
	
	public void printGameBoard() {
		for (int i = 0; i < rowList.size(); i++) {
			for (int j = 0; j < rowList.get(i).size(); j++) {
				if (rowList.get(i).get(j) < 1) {
					System.out.print("   ");
				} else if (rowList.get(i).get(j) < 10) {
					System.out.print("00");
					System.out.print(rowList.get(i).get(j));
				} else if (rowList.get(i).get(j) < 100) {
					System.out.print("0");
					System.out.print(rowList.get(i).get(j));
				} else {
					System.out.print(rowList.get(i).get(j));
				}
				System.out.print("  ");
			}
			System.out.print("\n\n");
		}
	}
}