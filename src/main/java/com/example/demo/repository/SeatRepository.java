package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Seat;

@Repository
public class SeatRepository {

    private final List<Seat> seats = new ArrayList<>();

    public SeatRepository() {
        // ✅ 1A〜10E（50席）を自動生成
        String[] cols = {"A", "B", "C", "D", "E"};
        for (int row = 1; row <= 10; row++) {
            for (String col : cols) {
                // 例：1A, 1B ... 10E
                String seatId = row + col;

                // ✅ 初期状態は全部 false（空席）
                seats.add(new Seat(seatId, false));
            }
        }

        // ✅ テスト的に一部だけ予約状態にしたい場合は下記例：
        // seats.get(2).setReserved(true); // 1Cを予約済みにする例
        // seats.get(10).setReserved(true);
    }

    public List<Seat> getAllSeats() {
        return seats;
    }
}

