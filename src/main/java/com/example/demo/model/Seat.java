package com.example.demo.model;


public class Seat {


    private String seatId;   // 主キーとして使用（例：A-1, A-2）

    private boolean reserved; // true = 予約済み

    // ✅ JPA用のデフォルトコンストラクタ（絶対必要）
    public Seat() {
    }

    public Seat(String seatId, boolean reserved) {
        this.seatId = seatId;
        this.reserved = reserved;
    }

    public String getSeatId() {
        return seatId;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
