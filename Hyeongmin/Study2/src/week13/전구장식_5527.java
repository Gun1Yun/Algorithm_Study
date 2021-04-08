package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �������_5527 {
	static int originLamp[];
	static int Lamp[];
	
	static int result=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String temp[] = br.readLine().split(" ");
		
		originLamp = new int[n];
		Lamp = new int [n];
		for(int i=0; i<n;i++) {
			originLamp[i] = Integer.parseInt(temp[i]);
			Lamp[i] = Integer.parseInt(temp[i]);
		}
		/*--------------input-----------*/
		
		result = patternCheck(originLamp);
		
		//������
		for(int startPoint=0;startPoint<n;startPoint++) {
			//������
			for(int endPoint=0;endPoint<n;endPoint++) {
				changeLamp(startPoint, endPoint);
				int patterncount = patternCheck(Lamp);
				result = Math.max(result, patterncount);
				init();
			}
		}
		
		System.out.println(result);
	}
	
	//�ʱ�ȭ
	public static void init() {
		for(int i=0;i<originLamp.length;i++)
			Lamp[i] = originLamp[i];
	}
	
	//���� �ٲٱ�
	public static void changeLamp(int start, int end) {
		
		for(int i=start;i<=end;i++) {
			if(Lamp[i]==0)
				Lamp[i]=1;
			else
				Lamp[i]=0;
		}
	}
	
	//�������� ī��Ʈ
	public static int patternCheck(int temp[]) {
		int count=0;
		
		for(int i=0;i<temp.length-1;i++) {
			for(int j=i;j<temp.length-1;j++) {
				//���� ������ �ƴҶ�
				if(temp[j]==temp[j+1]) {
					count=Math.max(count, (j-i)+1);
					i++;
					continue;
				}
				//���� �����϶�
				else if(j==temp.length-1) {
					count=Math.max(count, (j-i)+1);
					i++;
				}
			}

		}
		return count;
	}
}
