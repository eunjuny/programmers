import java.util.Arrays;
import java.util.Comparator;
class Solution {
    private class Record{
		String file;
		String head;
		int number;
		
		public Record(String file, String head, int number) {
			super();
			this.file = file;
			this.head = head;
			this.number = number;
		}
		
		
	}
	
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        Record[] record = new Record[files.length];
        for (int i = 0; i < files.length; i++) {
			String[] hnt = find_hnt(files[i]);
			Record r = new Record(files[i], hnt[0], Integer.parseInt(hnt[1]));
			record[i] = r;
		}
        
        Arrays.sort(record, new Comparator<Record>() {
			@Override
			public int compare(Record o1, Record o2) {
				if (o1.head.equals(o2.head)) {
					return o1.number - o2.number;
				} else {
					return o1.head.compareTo(o2.head);
				}
			}
		});
        
        for (int i = 0; i < record.length; i++) {
			answer[i] = record[i].file;
		}
        
        return answer;
    }
    
    private String[] find_hnt(String str) {
		int[] hnt = new int[2];
		
		int i = 0;
		while(i < str.length() && (str.charAt(i) < '0' || str.charAt(i) > '9')) {
			i++;
		}
		hnt[0] = i;
		
		int j = i;
		int count = 0;
		while(j < str.length() && (str.charAt(j) >= '0' && str.charAt(j) <= '9')) {
			if (count == 5)
				break;
			j++;
			count++;
		}
		hnt[1] = j;
		
		String head = str.substring(0, hnt[0]);
		head = head.toLowerCase();
        String number = str.substring(hnt[0], hnt[1]);
        
        String[] shn = {head, number};
        
        return shn;
	}
}