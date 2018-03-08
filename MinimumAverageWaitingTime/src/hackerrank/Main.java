package hackerrank;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Job {
		int start = 0 , duration = 0;
	}
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    Job[] jobs = new Job[n];
	    for(int i=0;i<n;i++){
	    	jobs[i] = new Job();
	    	jobs[i].start = sc.nextInt();
	    	jobs[i].duration = sc.nextInt();
		}
		Arrays.sort(jobs ,(o1,o2)->(o1.start-o2.start));


		int waitingTime = 0;

		int serviceTime = jobs[0].start;
		for(int i=1;i<n;i++){
			waitingTime += serviceTime - jobs[i].start;
			serviceTime  += jobs[i].duration;

		}
		System.out.println(waitingTime);
    }
}
