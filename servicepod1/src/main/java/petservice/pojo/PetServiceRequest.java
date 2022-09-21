package petservice.pojo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PetServiceRequest {
    public int id;
    public Category category;
    public String name;
    public List<String> photoUrls;
    public List<Tags> tags;
    public String status;
}
