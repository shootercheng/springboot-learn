package cn.tellsea.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_user")
public class User implements Cloneable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String passwd;

    @Override
    public User clone() {
        User user = null;
        try {
             user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return user;
    }
}
