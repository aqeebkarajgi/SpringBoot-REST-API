@Data
@Builder
@Jacksonized
@Document(collection = "users")
public class User {
    @Id
    String id;
    String name;
    int age;
}
