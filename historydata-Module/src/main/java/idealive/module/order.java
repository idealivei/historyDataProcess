package idealive.module;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class order {
    public int id;
    public String title;
    @JSONField(format="yyyy-MM-dd HH:mm:ss.SSS")
    public Date updateTime;
}
