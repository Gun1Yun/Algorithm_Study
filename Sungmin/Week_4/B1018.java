import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class B1018 {
	static class Board{
		int countW;
		int countB;
		Board(){
			this.countB=0;
			this.countW=0;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
			String[] s = input.readLine().split(" ");
			int countW=0;
			int countB=0;
			int minCount;
			int x = Integer.valueOf(s[0]);
			int y = Integer.valueOf(s[1]);
			Board[][] array = new Board[x][y];
			for(int i=0;i<x;i++) {
				for(int i1=0;i1<y;i1++)
					array[i][i1]=new Board();
			}
			for(int i=0;i<x;i++) {
				String temp=input.readLine();
				//i%2=1�̸� �ι�° ĭ, 0�̸� ù��° ĭ
				//ó���� �Ͼ���� ������
				if(i%2==0) {
					for(int i1=0;i1<y;i1++) {
						if(i1%2==0) {
							if(temp.charAt(i1)=='B') array[i][i1].countW++;
							else if(temp.charAt(i1)=='W') array[i][i1].countB++;
						}
						else if(i1%2==1) {
							if(temp.charAt(i1)=='W') array[i][i1].countW++;
							else if(temp.charAt(i1)=='B') array[i][i1].countB++;
						}
					}
				}
				else {
					for(int i1=0;i1<y;i1++) {
						if(i1%2==0) {
							if(temp.charAt(i1)=='W') array[i][i1].countW++;
							else if(temp.charAt(i1)=='B') array[i][i1].countB++;
						}
						else if(i1%2==1) {
							if(temp.charAt(i1)=='B') array[i][i1].countW++;
							else if(temp.charAt(i1)=='W') array[i][i1].countB++;
						}
					}
				}
			}
			minCount=x*y;
			for(int i=0;i<=x-8;i++) {
				countW=0;
				countB=0;
				for(int i1=0;i1<=y-8;i1++) {
					for(int i2=0+i;i2<i+8;i2++) {
						for(int i3=0+i1;i3<i1+8;i3++) {
							countW+=array[i2][i3].countW;
							countB+=array[i2][i3].countB;
						}
					}
					if(minCount>countW)minCount=countW;
					else if(minCount>countB)minCount=countB;
				}
			}
			output.write(String.valueOf(minCount));
			output.flush();
			output.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}