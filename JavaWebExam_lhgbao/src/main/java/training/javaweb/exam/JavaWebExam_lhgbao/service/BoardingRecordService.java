package training.javaweb.exam.JavaWebExam_lhgbao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.BoardingRecordRepository;

@Service
public class BoardingRecordService {
	@Autowired
	BoardingRecordRepository boardingRecordRepository;
	public int createBoardingRecord(BoardingRecordRequest request) {
		return boardingRecordRepository.createBoardingRecord(request);
	}
}
