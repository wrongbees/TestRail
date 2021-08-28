package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    @Expose
    String name;
    @Expose
    String announcement;
    @Expose
    boolean announcement_visibility_state;
    @Expose
    int suite_mode;
    @Expose
    private boolean is_completed;


}
