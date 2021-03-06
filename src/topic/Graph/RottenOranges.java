/*===========================================Rotten Oranges
Given a matrix of integers A of size N x M consisting of 0, 1 or 2. Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.=============================================================*/
public class Solution {
    static class Ele 
	{ 
		int x = 0; 
		int y = 0; 
		Ele(int x,int y) 
		{ 
			this.x = x; 
			this.y = y; 
		} 
	} 
	
	  // function to check whether a cell is valid / invalid 
   	static boolean isValid(int i, int j) 
   	{ 
   		return (i >= 0 && j >= 0 && i < R && j < C); 
   	} 
	

	// Function to check whether the cell is delimiter 
	// which is (-1, -1) 
	static boolean isDelim(Ele temp) 
	{ 
		return (temp.x == -1 && temp.y == -1); 
	} 
	
	// Function to check whether there is still a fresh 
	// orange remaining 
	static boolean checkAll(int arr[][]) 
	{ 
	    int R = arr.length;
	    int C = arr[0].length;
		for (int i=0; i<R; i++) 
			for (int j=0; j<C; j++) 
				if (arr[i][j] == 1) 
					return true; 
		return false; 
	} 
	
	// This function finds if it is possible to rot all oranges or not. 
	// If possible, then it returns minimum time required to rot all, 
	// otherwise returns -1 
	static int solve(int arr[][]) 
	{ 
	    int R = arr.length;
	    int C = arr[0].length;
      // Create a queue of cells 
      Queue<Ele> Q=new LinkedList<>(); 
      Ele temp; 
      int ans = 0; 
      // Store all the cells having rotten orange in first time frame 
      for (int i=0; i < R; i++) 
        for (int j=0; j < C; j++) 
          if (arr[i][j] == 2) 
            Q.add(new Ele(i,j)); 

      // Separate these rotten oranges from the oranges which will rotten 
      // due the oranges in first time frame using delimiter which is (-1, -1) 
      Q.add(new Ele(-1,-1)); 

      // Process the grid while there are rotten oranges in the Queue 
      while(!Q.isEmpty()) 
      { 
        // This flag is used to determine whether even a single fresh 
        // orange gets rotten due to rotten oranges in the current time 
        // frame so we can increase the count of the required time. 
        boolean flag = false; 

        // Process all the rotten oranges in current time frame. 
        while(!isDelim(Q.peek())) 
        { 
          temp = Q.peek(); 

          // Check right adjacent cell that if it can be rotten 
          if(temp.x + 1 >= 0 && temp.x + 1 < R && temp.y >= 0 && temp.y < C && arr[temp.x+1][temp.y] == 1) 
          { 
            if(!flag) 
            { 
              // if this is the first orange to get rotten, increase 
              // count and set the flag. 
              ans++; 
              flag = true; 
            } 
            // Make the orange rotten 
            arr[temp.x+1][temp.y] = 2; 

            // push the adjacent orange to Queue 
            temp.x++; 
            Q.add(new Ele(temp.x,temp.y)); 

            // Move back to current cell 
            temp.x--; 
          } 

          // Check left adjacent cell that if it can be rotten 
          if (temp.x - 1 >= 0 && temp.x - 1 < R && temp.y >= 0 && temp.y < C && arr[temp.x-1][temp.y] == 1) 
          { 
              if (!flag) 
              { 
                ans++; 
                flag = true; 
              } 
              arr[temp.x-1][temp.y] = 2; 
              temp.x--; 
              Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue 
              temp.x++; 
          } 

          // Check top adjacent cell that if it can be rotten 
          if (temp.x >= 0 && temp.x < R && temp.y + 1 >= 0 && temp.y +1< C && arr[temp.x][temp.y+1] == 1) { 
              if(!flag) 
              { 
                ans++; 
                flag = true; 
              } 
              arr[temp.x][temp.y+1] = 2; 
              temp.y++; 
              Q.add(new Ele(temp.x,temp.y)); // Push this cell to Queue 
              temp.y--; 
            } 

          // Check bottom adjacent cell if it can be rotten 
          if (temp.x >= 0 && temp.x < R && temp.y - 1 >= 0 && temp.y -1< C && arr[temp.x][temp.y-1] == 1) 
          { 
              if (!flag) 
              { 
                ans++; 
                flag = true; 
              } 
              arr[temp.x][temp.y-1] = 2; 
              temp.y--; 
              Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue 
          } 
          Q.remove(); 

        } 
        // Pop the delimiter 
        Q.remove(); 

        // If oranges were rotten in current frame than separate the 
        // rotten oranges using delimiter for the next frame for processing. 
        if (!Q.isEmpty()) 
        { 
          Q.add(new Ele(-1,-1)); 
        } 

        // If Queue was empty than no rotten oranges left to process so exit 
      } 

      // Return -1 if all arranges could not rot, otherwise -1.s 
      return (checkAll(arr))? -1: ans; 

	} 
}
