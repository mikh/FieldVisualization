package data_calculation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoad {
	public static int[][] load_2D_int_file(String filename, String delimiter){
		int[][] data = null;
		try{
			ArrayList<ArrayList<Integer>> data_arrayList = new ArrayList<ArrayList<Integer>>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			while((line = br.readLine()) != null){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				String[] parts = line.trim().split(delimiter);
				int ignore_col = 1, add = 1;
				for(int ii = 0; ii < parts.length; ii++){
					if(ii != ignore_col)
						temp.add(Integer.parseInt(parts[ii].trim()));
					if(ii == ignore_col){
						ignore_col += add;
						if(add == 1)
							add = 3;
						else
							add = 1;
					}
				}
				data_arrayList.add(temp);
			}
			
			data = new int[data_arrayList.size()][data_arrayList.get(0).size()];
			for(int ii = 0; ii < data_arrayList.size(); ii++){
				for(int jj = 0; jj < data_arrayList.get(ii).size(); jj++){
					data[ii][jj] = data_arrayList.get(ii).get(jj);
				}
			}
			br.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		return data;
	}
}
