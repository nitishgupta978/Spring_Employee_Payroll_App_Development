package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

/**
 * @author :John,
 * date :03:06:2022
 *
 * UC1 for lombok
 */
public @Data class ResponseDTO {
    private String message;
    private Object data;
    /**
     *use @Data lombok Annotation it is combination of @code @Getter @Setter @RequiredArgsConstructor
     *
     * @ToString @EqualsAndHashCode and take the that method automatically no need to provide this
     * type of method  when we use @Data
     * @param message ,Create one ResponseDTO class for display only message and data on your user
     * @param data
     */
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    /**
     * create one constructor methode
     * @return message
     */

}
