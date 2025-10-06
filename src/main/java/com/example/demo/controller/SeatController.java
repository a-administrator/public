package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Seat;
import com.example.demo.repository.SeatRepository;

import lombok.Data;
@Data
@Controller
public class SeatController {
	
	private final SeatRepository seatRepository;

    // コンストラクタでリポジトリを注入
    public SeatController(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @GetMapping("/seat")
    public String seatPage(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date,
            @RequestParam int people,
            Model model) {

        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("date", date);
        model.addAttribute("people", people);
        
     // リポジトリ呼び出し
        List<Seat> seats = seatRepository.getAllSeats();
        model.addAttribute("seats", seats);

        return "seat";  // seat.html に遷移
    }
    
    @PostMapping("/reserve")
    public String reserveSeats(@RequestParam List<String> seatIds) {
        // ※ 今のSeatRepositoryはメモリ管理なので、そのまま更新する

        List<Seat> seats = seatRepository.getAllSeats();
        for (Seat seat : seats) {
            if (seatIds.contains(seat.getSeatId())) {
                seat.setReserved(true);  // ✅ 仮予約状態に変更
            }
        }

        // ✅ 遷移先は仮（後で変更OK）
        return "redirect:/result";
    }
    @GetMapping("/result")
    public String resultPage(Model model) {
        // ✅ 予約後の座席一覧を表示したい場合（任意）
        List<Seat> seats = seatRepository.getAllSeats();
        model.addAttribute("seats", seats);

        return "result"; // → result.html を表示
    }



}
