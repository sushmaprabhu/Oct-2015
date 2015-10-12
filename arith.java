import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class aithmetic {
	public static void main(String[] args) {                 
		Scanner input = new Scanner(System.in);
		int nt = Integer.parseInt(input.nextLine());
		String[] operationList = new String[nt];
			for(int i=0; i<nt; i++){
				operationList[i] = input.nextLine();
			}
			input.close();

			for(int i=0; i<nt; i++){
				String operation = operationList[i];
				String[] operands = operation.split("(?=[-+*])");
				BigInteger op1 = new BigInteger(operands[0]);
				String[] operand2 = operands[1].split("(?<=[-+*])");
				BigInteger op2 = new BigInteger(operand2[1]);
				BigInteger result = null;
				String operator = operand2[0];
				if(operator.equals("+")) result = op1.add(op2);
				else if(operator.equals("-")) result = op1.subtract(op2);
				else if(operator.equals("*")) result = op1.multiply(op2);	
				int bigSize;
				String str ="";
				int rSize = 0;
				Integer resSize = String.valueOf(result).length();
				if((String.valueOf(op2).length()+1)>resSize) {
					bigSize = String.valueOf(op2).length()+1;
					rSize = bigSize - resSize;
				}
				else bigSize = resSize;
				Integer op1Size = bigSize - String.valueOf(op1).length();
				Integer op2Size = bigSize - String.valueOf(op2).length()-1;
				 

				for (int j=0; j<op1Size; j++){
					str = str+" ";
				}
				str = str + op1;
				System.out.println(str);
				str="";
				for (int j=0;j<op2Size; j++){
					str = str+" ";
				}
				str = str + operator + op2;
				System.out.println(str);
				str="";
				if(operator.equals("-") || operator.equals("+")){
					for (int j=0;j<bigSize; j++){
						str = str+"-";
					}
					System.out.println(str);
					str="";
					for (int j=0;j<rSize; j++){
						str = str+" ";
					}
					str = str + result;
					System.out.println(str);
				}
				if(operator.equals("*")){
					int gns = String.valueOf(op1).length()>(String.valueOf(op2).length()+1)?String.valueOf(op1).length():(String.valueOf(op2).length()+1);
					int space = bigSize - gns;
					str="";
					for (int j=0;j<space; j++){
						str = str+" ";
					}
					for (int j=0;j<gns; j++){
						str = str+"-";
					}
					System.out.println(str);
					int num = String.valueOf(op2).length();
					BigInteger op2Temp = op2;
					List<Integer> list = new ArrayList<Integer>();
					BigInteger ten = new BigInteger("10");
					while (!op2Temp.equals(BigInteger.ZERO))
					{
					    list.add(0, op2Temp.mod(ten).intValue());
					    op2Temp = op2Temp.divide(ten);
					}
					int k=0;
					for(int j=num-1;j>=0; j--){
						String listS = String.valueOf(list.get(j));
						BigInteger mul = op1.multiply(new BigInteger(listS));
						Integer mulSize = String.valueOf(mul).length();
						space = bigSize - mulSize - k;
						k++;
						str = "";
						for (int l=0;l<space; l++){
							str = str+" ";
						}
						str = str + mul;
						System.out.println(str);						
					}
					str = "";
					for (int j=0;j<bigSize; j++){
						str = str+"-";
					}
					System.out.println(str);
					str="";
					for (int j=0;j<rSize; j++){
						str = str+" ";
					}
					str = str + result;
					System.out.println(str);
				}
			}
	}

}

