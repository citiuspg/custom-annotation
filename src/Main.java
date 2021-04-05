import com.citius.Jsonconvertor;

public class Main {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Pariwesh");
		person.setAge(23);
		Jsonconvertor jsonconvertor = new Jsonconvertor();
		String personAsJsonString = jsonconvertor.convertToJson(person);
		System.out.println(personAsJsonString);
	}
}
