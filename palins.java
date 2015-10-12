import java.math.BigInteger;
import java.util.*;
class palins {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int nt = Integer.parseInt(input.nextLine());
		String[] result = new String[nt];
		for(int i=0; i<nt; i++){
			String kStrOld = input.nextLine();	
			kStrOld = kStrOld.replaceFirst("^0+(?!$)", "");
			int size,a ,b,j,k,sum = 0;
			BigInteger num = new BigInteger(kStrOld);
			num = num.add(new BigInteger("1"));
			String kStr = num.toString();
			OUTER:while(true){
				size = kStr.length();	
				a = size/2;
				b = a+1;
				if(a<size/2.0) {
					b++; 
					j = a; k = b;
				}
				else {
					j = a; k = b;
				}
				if(kStrOld.length()==1){
					result[i]=kStrOld;
					break OUTER;
				}
				if (Integer.parseInt(kStr.substring(j-1, j))==Integer.parseInt(kStr.substring(k-1, k))){
					INNER:while(j>=0 && k<size){
						if (Integer.parseInt(kStr.substring(j-1, j))==Integer.parseInt(kStr.substring(k-1, k))){
							k++; j--;
						}
						else break INNER;						
					}
					boolean found = new palins().checkPalindrome(size, kStr);
					if(found){
						result[i]=kStr;
						break OUTER;
					}
				}
				if (Integer.parseInt(kStr.substring(j-1, j))<Integer.parseInt(kStr.substring(k-1, k))){
					if(size/2.0>a && a==j){
						j=j+1;
					}
					IN:while (j>0){
						sum = Integer.parseInt(kStr.substring(j-1,j))+1;
						if(sum==10){
							String temp = kStr.substring(0, j-1)+ "0"+kStr.substring(j);
							j--;
							kStr = temp;
						}
						else {
							String temp = kStr.substring(0, j-1)+ sum +kStr.substring(j);
							kStr = temp;
							break IN;
						}		
						
					}
					if(sum==10) {
						String temp = "1" + kStr;
						kStr = temp;
					}
					String temp = kStr.substring(0,a);
					String temp1 = "";
					for(int m=temp.length()-1; m>=0; m--){
						temp1+=temp.substring(m,m+1);
					}
					kStr = kStr.substring(0,a)+kStr.substring(a,k-1)+temp1;
					boolean found = new palins().checkPalindrome(size, kStr);
					if(found){
						result[i]=kStr;
						break OUTER;
					}
					
				}
				if (Integer.parseInt(kStr.substring(j-1, j))>Integer.parseInt(kStr.substring(k-1, k))){
					String temp = "";
					temp += kStr.substring(0,j);
					String temp1 = "";
					for(int m=temp.length()-1; m>=0; m--){
						temp1+=temp.substring(m,m+1);
					}
					kStr = kStr.substring(0,a)+kStr.substring(a,k-1)+temp1;
					boolean found = new palins().checkPalindrome(size, kStr);
					if(found) {
						result[i]=kStr;
						break OUTER;
					}
					
				}
			}				
		}
		input.close();
		for(int l=0;l<result.length;l++){
			System.out.println(result[l]);
		}
	}
	public boolean checkPalindrome(int size,String str){
		int numSize = str.length();
		boolean found = true;
		for(int n=0; n<size/2; n++){
			String startDigit = (str+"").substring(n, n+1);
			String endDigit = (str+"").substring(numSize-1,numSize);
			if(!startDigit.equals(endDigit)){
				found = false;
				break;
			}						
			numSize--;
		}
		return found;
	}
}
