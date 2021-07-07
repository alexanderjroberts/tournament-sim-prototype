import java.util.*;
public class Tournament {

		static Person[] people;
	
		public static void main(String args[]) {
			
			initializeField(4);
			playRounds(1);
		}
		
		
		public static void play(Person a, Person b) {
			
			a.played++;
			b.played++;
			
			double i = Math.random();
			
			double threshold = 
					0.5
					+(1.0/Person.ivScalar)*(a.skill-b.skill)*	1.0
					+(1.0/Person.ivScalar)*(a.luck-b.luck)*		0.2
					;
			
			if(i<threshold) {
				a.wins++;
				b.losses++;		
			}
			else {
				a.losses++;
				b.wins++;
			}
			
				
		}
		
		public static void initializeField(int i) {
			
			people = new Person[i];
			
			for(int j=0;j<i;j++) {
				people[j] = new Person(j);
			}
		}
		
		public static void playRounds(int i) {
			List<Person> l = new ArrayList<Person>();
			for(int j=0;j<people.length;j++)
				l.add(people[j]);
			
			int c = 0;
			
			while(l.size()>1) {
				
				c++;
				
				for(int j=0;j<l.size();j++) {
					if(l.get(j).played >= i) {
						System.out.println("item "+l.get(j).id+"   removed on cycle "+c);
						l.remove(j);
					}	
				}
				
				if(l.size()<2)
					break;
			
				int a = (int)(Math.floor(Math.random()*l.size()));
				int b;
					
				do {
					b = (int)(Math.floor(Math.random()*l.size()));	
				}
				while(b==a);
				
				if(l.get(a).played < i && l.get(b).played < i)
					play(l.get(a),l.get(b));	
			}
			
			for(int j=0;j<l.size();j++) {	
				System.out.println("item "+l.get(j).id+"   removed on cycle "+c);		
			}
			
			System.out.println("end on cycle "+c);
			
			printResults(i);
			
		}

		public static void printResults(int i) {
			
			System.out.println("\n- - - "+i+" ROUNDS WITH "+people.length+" PARTICIPANTS - - -\n");
			
			Arrays.sort(people);
			
			for(Person p:people) {
				System.out.print("dude #"+p.id+":\t"+p.wins+"-"+p.losses+"  "+(p.played==i ? "" : p.played-i)+
						"  \tskill:"+String.format("%.0f",p.skill)+"  \tluck:"+String.format("%.0f",p.luck)+"\n");
			}
		}

}

