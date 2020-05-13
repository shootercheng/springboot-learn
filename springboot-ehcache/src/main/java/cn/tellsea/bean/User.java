package cn.tellsea.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String password;
}
