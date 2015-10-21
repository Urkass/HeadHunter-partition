import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class partition {

	public static void main(String[] args) {
		int data[] = new int[2];
		try {
			data = readFile();
		} catch (FileNotFoundException e){
			System.out.println("���� �� ������!");
			return;
		} catch (NumberFormatException | IOException e) {
			System.out.println("������������ ������ ����� � �����!");
			return;
		}
		int n=data[0], k=data[1];
		if (n>0 && k>0 && n<150 && k<150){
			//����: ������� �������� ��� ���������� ����� i � ���� ����� �� j ���������, ����� ����� ������� �� ���� ��������� ����� z.
			long[][][] array = new long[n + 1][k + 1][n + 1];
			array[0][0][0] = 1;
			for(int i = 1; i <= n; i++) 
	            for(int j = 1; j <= k; j++)  
	                for(int z = 0; z <= i; z++) 
	                    for(int p = 0; p <= z; p++)  
	                        array[i][j][z] += array[i - z][j - 1][p];
			int num = 0;
			for(int i = 0; i <= n; i++) 
	            num += array[n][k][i];
	        System.out.println("���������� ��������: " + num);
		}
		else{
			System.out.println("������� ������ �� ������������ �������!");
		}
		
	}
	public static int[] readFile() throws IOException, NumberFormatException, FileNotFoundException{
		int arr[] = new int[2];
		String data;
		File file=new File("data.txt");
		Scanner in = new Scanner(file);
		data = in.nextLine();
        in.close();
        String[] numbers = data.split(" ");
        for (int i=0; i<2; i++)
        	arr[i] = Integer.parseInt(numbers[i]);
		return arr;
	}
}
