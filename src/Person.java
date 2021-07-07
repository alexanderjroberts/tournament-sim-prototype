
public class Person implements Comparable<Person>{
		
		static int ivScalar = 100;
		int played = 0;
		int wins = 0;
		int losses = 0;
		double skill = 0.0;
		personality p = personality.none;
		double luck = 0.0;
		int id;
		
		enum personality{
			none, positive, negative;
		}
	
		public Person(int id){
			skill = Math.random()*ivScalar;
			luck = Math.random()*ivScalar;
			this.id = id;
			
			int i = (int)(Math.floor(Math.random()*5)+1);
			
			switch(i) {
				case 1: case 2: this.p = personality.positive; break;
				case 3: case 4:	this.p = personality.negative; break;
				default: this.p = personality.none; break;
			}
		}

		@Override
		public int compareTo(Person o) {
			
			double i = (o.wins-(o.skill*0.1*(1/ivScalar))-o.losses)-(this.wins-(this.skill*0.1*(1/ivScalar))-this.losses);
			
			return (int)(i*100000);
		}
}
