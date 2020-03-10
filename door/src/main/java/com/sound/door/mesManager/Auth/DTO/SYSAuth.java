package com.sound.door.mesManager.Auth.DTO;

import lombok.Data;

@Data
public class SYSAuth {
    private String auth_code;
    private String auth_name;
    private String user_code;
    private String user_name;
    private String create_date;
    private String update_date;
    private int rec_count;
    private String keyword;
}
