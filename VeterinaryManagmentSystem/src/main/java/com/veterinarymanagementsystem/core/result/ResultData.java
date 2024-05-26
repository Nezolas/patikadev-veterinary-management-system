package com.veterinarymanagementsystem.core.result;

public class ResultData <T> extends Result{ // API yanıtlarını temsil etmek için kullanılan sonuç sınıfı, veri içeren versiyonu
    private T data;  // Sonuç verisini temsil eden değişken

    // Kurucu metot: durum, mesaj, HTTP kodu ve veri alanını alarak ResultData nesnesi oluşturan metot
    public ResultData(boolean status, String message, String httpCode, T data) {
        super(status, message, httpCode);
        this.data = data;
    }
}
