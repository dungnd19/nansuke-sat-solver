package solver.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import solver.nansukesolver.Cell;

public class Nansuke {
	private final Matrix mMatrix;
	private final String[] mListNumber;
	private final ArrayList<Integer> category=new ArrayList<Integer>();
	private final HashMap<Integer, ArrayList<int []>> listTypeNumber;
	private final HashMap<Integer, ArrayList<Cell[]>> listTypeCell;
	private int soBien;
	private int soMenhDe;
	public Nansuke(Matrix mMatrix,String[] mListNumner){
		this.mMatrix=mMatrix;
		this.mListNumber=mListNumner;
		listTypeNumber=getTypeNumber();
		listTypeCell=getTypeCell();
	}
	private HashMap<Integer, ArrayList<int []>> getTypeNumber(){
		HashMap<Integer, ArrayList<int []>> mHashMap=new HashMap<Integer,ArrayList<int []>>();
		for (String s : mListNumber) {
			int length = s.length();
			int[] arr = new int[length];
			for (int j = 0; j < length; j++) {
				int num = Integer.parseInt(s.substring(j, j + 1));
				arr[j] = num;
			}
			if (mHashMap.containsKey(length)) {
				ArrayList<int[]> mList = mHashMap.get(length);
				mList.add(arr);
			} else {
				ArrayList<int[]> mList = new ArrayList<int[]>();
				mList.add(arr);
				mHashMap.put(length, mList);
				category.add(length);

			}

		}
		Collections.sort(category);
		
		return mHashMap;
	}
	private HashMap<Integer, ArrayList<Cell[]>>   getTypeCell(){
		
		HashMap<Integer, ArrayList<Cell[]>> mHashMap=new HashMap<Integer, ArrayList<Cell[]>>();
		for (Integer integer : category) {
			mHashMap.put(integer, getListOfType(integer));
		}
		//printTypeCell();
		
		return mHashMap;
		
	}
	private ArrayList<Cell[]> getListOfType(int type){
		ArrayList<Cell[]> mList=new ArrayList<Cell[]>();
		for(int i=0;i<mMatrix.getRow();i++){
			int count=0;
			for(int j=0;j<mMatrix.getColumn();j++){
				if(count+1==type&&mMatrix.getColumn()-1==j&&mMatrix.get(i, j)==1){
					Cell [] arrCelliable=new Cell[type];
					int digit=0;
					int flag=type;
					int k=j;
					while(flag!=0){
						Cell mVariable=new Cell(i, k);
						arrCelliable[digit]=mVariable;
						digit++;
						k--;
						flag--;
					}
					mList.add(sortArrayCell(arrCelliable));
				}else{
					if((mMatrix.get(i, j)==0&&count==type)){
						count=0;
						
						Cell [] arrCelliable=new Cell[type];
						int digit=0;
						int flag=type;
						int k=j-1;
						while(flag!=0){
							Cell mVariable=new Cell(i, k);
							arrCelliable[digit]=mVariable;
							digit++;
							k--;
							flag--;
						}
						mList.add(sortArrayCell(arrCelliable));
					
					}else{
						if(mMatrix.get(i, j)==0){
							count=0;
						}else{
							count++;
						}
					}
				}
			}
		}
		for(int i=0;i<mMatrix.getColumn();i++){
			int count=0;
			for(int j=0;j<mMatrix.getRow();j++){
				if(count+1==type&&mMatrix.getRow()-1==j&&mMatrix.get(j, i)==1){
					Cell [] arrCelliable=new Cell[type];
					int digit=0;
					int flag=type;
					int k=j;
					while(flag!=0){
						Cell mVariable=new Cell(k, i);
						arrCelliable[digit]=mVariable;
						digit++;
						k--;
						flag--;
						System.out.println("gia tri cua k="+k+" "+i);
					}
					mList.add(sortArrayCell(arrCelliable));
				}else{
					if((mMatrix.get(j, i)==0&&count==type)){
						count=0;
						
						Cell [] arrCelliable=new Cell[type];
						int digit=0;
						int flag=type;
						int k=j-1;
						while(flag!=0){
							Cell mVariable=new Cell(k, i);
							arrCelliable[digit]=mVariable;
							digit++;
							k--;
							flag--;
							System.out.println("gia tri theo doc cua k="+k+" "+i);
						}
						mList.add(sortArrayCell(arrCelliable));
			
					}else{
						if(mMatrix.get(j, i)==0){
							count=0;
						}else{
							count++;
						}
					}
				}
				
			}
		}
		
		return mList;
	}
	public Matrix getMatrix(){
		return this.mMatrix;
	}
	public String[] getListNumber(){
		return this.mListNumber;
	}
	public ArrayList<Integer> getCategory(){
		return category;
	}
	public HashMap<Integer, ArrayList<int []>> getListTypeNumber(){
		return this.listTypeNumber;
	}
	public void printTypeCell(){
		for (Integer integer : category) {
			ArrayList<Cell[]> listVariable = listTypeCell.get(integer);
			System.out.println("so o loai " + integer);
			for (Cell[] mVariables : listVariable) {
				String s = "";
				for (int k = 0; k < mVariables.length; k++) {
					s = s + mVariables[k].toString();
				}
				System.out.println(s);
			}
		}
	}
	public void makeCNF(){
		soBien=0;
		soMenhDe=0;
		StringBuilder stringCNF= new StringBuilder();
		for (int typeNumber : category) {

			System.out.println("category: " + typeNumber);
			ArrayList<int[]> listNumber = listTypeNumber.get(typeNumber);
			ArrayList<Cell[]> listCell = listTypeCell.get(typeNumber);

			for (int j = 0; j < listCell.size(); j++) {
				Cell[] arrCell = listCell.get(j);
				int[] arrNumber = listNumber.get(j);
				//duyet moi vi tri nhan gia tri tu 1->9
				for (Cell cell : arrCell) {
					for (int k = 1; k < 10; k++) {
						//stringCNF=stringCNF+""+encode(arrCell[l],k)+" ";
						soBien++;
					}
					//	stringCNF=stringCNF+"0"+"\n";

				}

			}
			ArrayList<Integer> valuesPossible = new ArrayList<Integer>();
			for (int j = 1; j < 10; j++) {
				boolean flag1 = false;
				for (int[] ints : listNumber) {
					boolean flag2 = false;
					for (int l = 0; l < ints.length; l++) {
						if (j == ints[l]) {
							flag1 = true;
							flag2 = true;
							break;
						}
					}
					if (flag2) {
						break;
					}
				}
				if (flag1) {
					for (Integer integer : valuesPossible) {
						if (j == integer) {
							flag1 = false;
							break;
						}
					}
					if (flag1) {
						valuesPossible.add(j);
					}
				}
			}
			// gia tri ma 1 o co the nhan hoac khong 
			for (Cell[] arrCell : listCell) {
				for (Cell cell : arrCell) {
					for (Integer integer : valuesPossible) {
						stringCNF.append(encode(cell, integer)).append(" ");

					}
					stringCNF.append("0").append("\n");
					// moi o chi nhan 1 gia tri
					for (int l = 0; l < valuesPossible.size(); l++) {

						for (int n = l + 1; n < valuesPossible.size(); n++) {
							stringCNF.append("-").append(encode(cell, valuesPossible.get(l))).append(" -").append(encode(cell, valuesPossible.get(n))).append(" 0").append("\n");
						}
					}
					for (int l = 1; l < 10; l++) {
						boolean flag = true;
						for (Integer integer : valuesPossible) {
							if (l == integer) {
								flag = false;
							}
						}
						if (flag) {
							stringCNF.append("-").append(encode(cell, l)).append(" 0").append("\n");
						}
					}


				}
			}
			//keo theo 
			ArrayList<int[]> arrayOverlapNum = new ArrayList<int[]>();

			ArrayList<int[]> arrayNoOverlapNum = new ArrayList<int[]>();
			for (int j = 0; j < listNumber.size(); j++) {
				int[] arrNum = listNumber.get(j);
				boolean flag = true;
				for (int k1 = j - 1; k1 >= 0; k1--) {
					if (arrNum[0] == listNumber.get(k1)[0]) {
						flag = false;
					}
				}
				for (int k2 = j + 1; k2 < listNumber.size(); k2++) {
					if (arrNum[0] == listNumber.get(k2)[0]) {
						flag = false;
					}
				}

				if (!flag) {
					arrayOverlapNum.add(arrNum);
				} else {
					arrayNoOverlapNum.add(arrNum);
				}
			}
			/// no overlap
			for (Cell[] arrCell : listCell) {
				for (int[] arrNum : arrayNoOverlapNum) {
					for (int l = 1; l < arrNum.length; l++) {
						stringCNF.append("-").append(encode(arrCell[0], arrNum[0])).append(" ").append(encode(arrCell[l], arrNum[l])).append(" 0").append('\n');
					}

				}

				for (int k = 0; k < arrCell.length; k++) {
					for (int[] arrNum : listNumber) {
						stringCNF.append(encode(arrCell[k], arrNum[k])).append(" ");
					}
					stringCNF.append("0").append("\n");
				}
			}
			//////overlap

			ArrayList<Integer> arrValuePossible = new ArrayList<Integer>();
			for (int[] arrNum : arrayOverlapNum) {
				int v = arrNum[0];
				boolean flag = true;
				for (int num : arrValuePossible) {
					if (v == num) {
						flag = false;
						break;
					}
				}
				if (flag) {
					arrValuePossible.add(v);
				}
			}
			for (Cell[] arrCell : listCell) {
				for (Integer integer : arrValuePossible) {

					for (int n = 1; n < arrCell.length; n++) {
						stringCNF.append("-").append(encode(arrCell[0], integer)).append(" ");
						ArrayList<Integer> arrValuePossible2 = new ArrayList<Integer>();
						for (int l = 0; l < arrayOverlapNum.size(); l++) {
							int valueFirst = arrayOverlapNum.get(l)[0];
							int v = arrayOverlapNum.get(l)[n];
							boolean flag = true;
							for (int m = 0; m < arrValuePossible2.size(); m++) {
								int v1 = arrValuePossible2.get(m);
								if (v == v1) {
									flag = false;
									break;
								}
							}
							if (valueFirst != integer)
								flag = false;
							if (flag)
								arrValuePossible2.add(v);
						}
						for (Integer value : arrValuePossible2) {
							stringCNF.append(encode(arrCell[n], value)).append(" ");
						}
						stringCNF.append("0").append("\n");

					}
				}
			}
			/*for(int j=0;j<listCell.size();j++){
				Cell arrCell[]=listCell.get(j);
				for(int k=0;k<listNumber.size();k++){
					int arrNum[]=listNumber.get(k);
					for(int l=0;l<arrNum.length-1;l++){
						stringCNF=stringCNF+"-"+encode(arrCell[l], arrNum[l])+" ";
					}
					stringCNF=stringCNF+encode(arrCell[arrNum.length-1],arrNum[arrNum.length-1])+" 0"+"\n";
				}
			}*/


			//loai tru .
			for (int[] arrNum : listNumber) {
				for (int k = 0; k < listCell.size(); k++) {
					Cell[] arrCell1 = listCell.get(k);
					for (int l = k + 1; l < listCell.size(); l++) {
						Cell[] arrCell2 = listCell.get(l);
						for (int m = 0; m < arrCell1.length; m++) {
							stringCNF.append("-").append(encode(arrCell1[m], arrNum[m])).append(" ");
						}
						for (int m = 0; m < arrCell2.length; m++) {
							stringCNF.append("-").append(encode(arrCell2[m], arrNum[m])).append(" ");
						}
						stringCNF.append("0").append("\n");
					}
				}
			}

		}
		//dem so menh de va bien max.
		int clauseNum=0;
		int index = 0;
		while( index < stringCNF.length()) 
		{
			if(stringCNF.charAt(index) == '\n') clauseNum ++;
			index ++;
		}
		
		int x =mMatrix.getRow()-1;
		int y = mMatrix.getColumn()-1;
		boolean flag=false;
		for (;x >=0; x--) {
			for (; y >=0; y--) {
				if(mMatrix.get(x, y)!=0){
					flag=true;
					break;
				}
			}
			if(flag){
				break;
			}
			
		}
		soMenhDe=clauseNum;
		stringCNF.insert(0, "p cnf " + encode(new Cell(x, y), 9) + " " + clauseNum + "\n");
		//System.out.println(stringCNF);
		FileUtil.clearFile();
		FileUtil.writerFile(stringCNF.toString());
		System.out.println("xong gile cnf.");
		printTypeCell();
	}
	public String encode(Cell var, int number){
		int sizecol=mMatrix.getColumn();
		String s="";
		int i=var.getRow()*sizecol+var.getCol()+1;
		s=i+""+number;
			return s;
		
	}
	public Cell decode(String s){
		int sizeCol=mMatrix.getColumn();
		Cell cell;
		if(s.contains("-")){
	
			char ch=s.charAt(s.length()-1);
			int number=Integer.parseInt(String.valueOf(ch));
			String sub=s.substring(0, s.length()-1);
			int position=Math.abs(Integer.parseInt(sub))-1;
			int row =position/sizeCol;
			int col=position%sizeCol;
			cell=new Cell(row,col,number);
			cell.setTrue(false);
		}else{
		
			char ch=s.charAt(s.length()-1);
			int number=Integer.parseInt(String.valueOf(ch));
			String sub=s.substring(0, s.length()-1);
			int position=Integer.parseInt(sub)-1;
			int row =position/sizeCol;
			int col=position%sizeCol;
			cell=new Cell(row,col,number);
			cell.setTrue(true);
		}
		return cell;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return mMatrix.getRow()+ " x "+mMatrix.getColumn();
	}
	
	public Cell[] sortArrayCell(Cell[] arrCell){
		Cell[] arr=new Cell[arrCell.length];
		if(arrCell[0].getRow()==arrCell[1].getRow()){
			if(arrCell[0].getCol()>arrCell[1].getCol()){
				int length=arr.length;
				for(int i=0;i<arr.length;i++){
					arr[length-1]=arrCell[i];
					length--;
				}
			}
		}else{
			if(arrCell[0].getRow()>arrCell[1].getRow()){
				int length=arr.length;
				for(int i=0;i<arr.length;i++){
					arr[length-1]=arrCell[i];
					length--;
				}
			}
		}
		return arr;
	}
	public int getSoBien() {
		return soBien;
	}
	public void setSoBien(int soBien) {
		this.soBien = soBien;
	}
	public int getSoMenhDe() {
		return soMenhDe;
	}
	public void setSoMenhDe(int soMenhDe) {
		this.soMenhDe = soMenhDe;
	}
	
}
