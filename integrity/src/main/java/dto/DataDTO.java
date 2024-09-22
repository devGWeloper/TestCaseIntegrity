package dto;

import lombok.Data;

@Data
public class DataDTO {
    private Long id;
    private String event;
    private String user;
    private String manual;
    private String testContent;
}