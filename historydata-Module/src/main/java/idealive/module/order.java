package idealive.module;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class order {
    private int id;
    private String title;
    @JSONField(format="yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateTime;

    public order(String title, Date d){

        this.title = title;
        this.updateTime = d;
    }
}
