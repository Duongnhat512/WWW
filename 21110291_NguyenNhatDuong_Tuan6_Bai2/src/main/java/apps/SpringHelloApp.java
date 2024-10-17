package apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import libs.Coach;

public class SpringHelloApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach tennisCoach = context.getBean("myTennisCoach", Coach.class);
		
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		
		Coach cricketCoach = context.getBean("myCricketCoach", Coach.class);
		
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
	}
}
