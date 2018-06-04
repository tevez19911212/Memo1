package memo1;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemoPG1 {

	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		System.out.println(dtf.format(now));

		Optional<String> result = getHeroName("tony");
		String heroName = result.orElse("I'm Batman!!!");
		System.out.println(heroName);

		Optional<String> result2 = getHeroName("bruce");
		String heroName2 = result2.orElse("I'm Batman!!!");
		System.out.println(heroName2);
	}

	private static Optional<String> getHeroName(String yourName) {
		if ("tony".equals(yourName)) {
			return Optional.of("I am Ironman");
		}

		return Optional.empty();
	}
}
