import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author lixiaobing
 * @date 2020-11-18 22:56
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    private List<Integer>              studentIds;
    private List<String>               studentNames;
    private List<Integer>              myClassIds;
    private List<String>               myClassNames;
    private List<Map<String, Integer>> studentOfClass;


}
