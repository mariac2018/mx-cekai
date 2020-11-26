package builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User2 {
    private String userName;
    private String password;
    private Integer age;
    private String sex;
    private String size;
}
