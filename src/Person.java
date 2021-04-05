import com.citius.JsonElement;
import com.citius.JsonSerializable;

@JsonSerializable
public class Person {
//	@JsonElement(key="age")
	private int age;
	@JsonElement(key = "myname")
	private String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
//{
//	"name":"Pariwesh"
//}