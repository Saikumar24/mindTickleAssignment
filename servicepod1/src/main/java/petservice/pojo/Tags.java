package petservice.pojo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tags {
    public String name;
    public int id;
}
