package br.com.bankaccountmanager.domain.dtos;

public class ResponseDto {
    String message;
    Boolean isError;

    public ResponseDto(String message, Boolean isError) {
        this.message = message;
        this.isError = isError;
    }

    public ResponseDto(String message) {
        this(message, false);
    }

    public String getMessage() {
        return message;
    }

    public Boolean getIsError() {
        return isError;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
