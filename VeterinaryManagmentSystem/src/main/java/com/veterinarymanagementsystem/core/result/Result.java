package com.veterinarymanagementsystem.core.result;

import lombok.Getter;

@Getter
public class Result { // API yanıtlarını temsil etmek için kullanılan sonuç sınıfı
    private final boolean status;
    private final String message;
    private final String httpCode;

    // Kurucu metot: durum, mesaj ve HTTP kodunu alan ve Result nesnesi oluşturan metot
    public Result(boolean status, String message, String httpCode) {
        this.status = status;
        this.message = message;
        this.httpCode = httpCode;
    }
}
