package week16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

class data implements Comparable<data> {
	long data;
	int index;

	data(long data, int index) {
		this.data = data;
		this.index = index;
	}

	@Override
	public int compareTo(data o) {
		if (this.data > o.data)
			return 1;

		return -1;
	}
}

public class ���߿켱����ť_7662 {
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			int k = Integer.parseInt(br.readLine());

			PriorityQueue<data> maxheap = new PriorityQueue<data>(Collections.reverseOrder());
			PriorityQueue<data> minheap = new PriorityQueue<data>();

			visit = new boolean[k];
			int count_idx = 0;

			String temp[];
			for (int i = 0; i < k; i++) {
				temp = br.readLine().split(" ");
				// Insert
				if (temp[0].equals("I")) {
					data tdata = new data(Long.parseLong(temp[1]), count_idx++);
					maxheap.add(tdata);
					minheap.add(tdata);
				}
				// Delete data
				else {
					if (maxheap.isEmpty() || minheap.isEmpty()) {

						continue;
					}
					// �ִ밪 ����
					if (Integer.parseInt(temp[1]) == 1) {

						// �������� �����Ͱ� �ϳ��̰ų� �ߺ��� ���̸� ������ ��..?
						if (maxheap.peek().data == minheap.peek().data) {
							data tdata = maxheap.poll();
							minheap.poll();

							visit[tdata.index] = true; // ������ �����ʹ� �湮 ó��
						} else {
							data tdata = maxheap.poll();
							visit[tdata.index] = true; // ������ �����ʹ� �湮 ó��
						}

					} else {
						if (maxheap.peek().data == minheap.peek().data) {
							data tdata = maxheap.poll();
							minheap.poll();
							visit[tdata.index] = true; // ������ �����ʹ� �湮 ó��
						} else {
							data tdata = minheap.poll();
							visit[tdata.index] = true; // ������ �����ʹ� �湮 ó��

						}
					}
				}
			}
			if (maxheap.isEmpty() || minheap.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				while (true) {
					data tt = maxheap.poll();
					// �������� ������ �ִ��̶��
					if (!visit[tt.index]) {
						sb.append(tt.data + " ");
						break;
					}
				}

				while (true) {
					data tt = minheap.poll();
					// �������� ������ �ִ��̶��
					if (!visit[tt.index]) {
						sb.append(tt.data + "\n");
						break;
					}
				}
			}
			t--;
		}
		System.out.println(sb);

	}

	// ����ȭ.. �ð��ʰ�.. �ȳ���..
	public static void DongGiwha(PriorityQueue<Integer> base, PriorityQueue<Integer> copy) {
		copy.clear();

		copy = base;
//		Iterator<Integer> list = base.iterator();
//		
//		while(list.hasNext())
//			copy.add(list.next());
	}

}
