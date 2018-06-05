package memo1;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoPG1 {

	public static void main(String[] args) {
		// 現在時刻を取得してyyyy/mm/ddにフォーマット
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		System.out.println(dtf.format(now));

		Optional<String> result = getHeroName("tony");
		String heroName = result.orElse("I'm Batman!!!");
		System.out.println(heroName);

		Optional<String> result2 = getHeroName("bruce");
		String heroName2 = result2.orElse("I'm Batman!!!");
		System.out.println(heroName2);

		// streamAPI復習
		List<String> strList = Arrays.asList("Ironman", "Captain America", "Deadpool");
		strList.forEach(System.out::println);

		List<String> newList = strList.stream()
			.filter(s -> s.length() > 7)
			.map(s -> "(" + s + ")")
			.collect(Collectors.toList());
		newList.forEach(System.out::println);

		// Match
		boolean isAllMatch = strList.stream().allMatch(s -> s.length() > 7);
		boolean isAnyMatch = strList.stream().anyMatch(s -> s.length() > 7);
		boolean isNoneMatch = strList.stream().noneMatch(s -> s.length() > 7);

		// collect
		System.out.println( strList.stream().collect(Collectors.joining(",")) );
		System.out.println( strList.stream().mapToInt(s -> s.length()).sum());

		System.out.println();
	}

	private static Optional<String> getHeroName(String yourName) {
		if ("tony".equals(yourName)) {
			return Optional.of("I am Ironman");
		}

		return Optional.empty();
	}
}
