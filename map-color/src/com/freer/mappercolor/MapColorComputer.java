package com.freer.mappercolor;


public class MapColorComputer {
	
	/**
	 * 
	 * computer map color
	 * 
	 * @param colors
	 * @param regionsNumber
	 * @param adjacentMatrix
	 * @return
	 */
	public int[] computerColor(String[] colors, int regionsNumber, int[][] adjacentMatrix) {
		int[] regionsColor = new int[regionsNumber];
		regionsColor[0] = 0; //first region color
		int i = 1; // From the beginning of the second region to test the color
		int j = 0; // From the beginning of the first color to the back of the region to test the coloring
		int k = 0; // k is temporary variables
		while (i < regionsNumber)
			while (j < 4) {
				while (k < i && regionsColor[k] * adjacentMatrix[i][k] != j)
					// whether the Color is used
					k = k + 1;
				if (k < i) // is used，j+1
					j = j + 1;
				else {
					regionsColor[i] = j;
					i = i + 1;
					if (i > regionsNumber-1) // Meet all the conditions , exit the loop
						break;
				}
				if (j > 3) //When the four kinds of colors are not satisfied, back
				{
					k = 0;
					j = 0;
				}
			}
		return regionsColor;
		
		
		
	}

}
