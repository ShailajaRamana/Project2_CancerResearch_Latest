package learning.datascience.shailu.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhysicianByState {
    private String state;
    private long count;

    public PhysicianByState(String state, long count){
        this.state = state;
        this.count = count;
    }
}
