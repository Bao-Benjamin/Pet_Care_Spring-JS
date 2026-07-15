package training.javaweb.exam.JavaWebExam_lhgbao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.APIReponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.BoardingRecordResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.service.BoardingRecordService;

@RestController("/boarding-record")
public class BoardingRecordController {
	@Autowired
	BoardingRecordService boardingRecordService;
	@PostMapping("/admin")
	public ResponseEntity<APIReponse<Integer>> createBoardingRecord(@RequestBody BoardingRecordRequest request){
		return ResponseEntity.status(201).body(new APIReponse(201, "Created new boarding record successfully", boardingRecordService.createBoardingRecord(request)));
	}
	@GetMapping("/admin")
	public ResponseEntity<APIReponse<List<BoardingRecordResponse>>> createBoardingRecord(){
		return ResponseEntity.status(201).body(new APIReponse(200, "Created new boarding record successfully", boardingRecordService.getAllBoardingRecord()));
	}
}
