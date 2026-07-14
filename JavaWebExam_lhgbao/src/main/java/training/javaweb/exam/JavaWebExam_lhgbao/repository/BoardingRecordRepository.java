package training.javaweb.exam.JavaWebExam_lhgbao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.mapper.BoardingRecordMapper;

@Repository
public class BoardingRecordRepository {
	@Autowired
	BoardingRecordMapper boardingRecordMapper;
	public int createBoardingRecord(BoardingRecordRequest request) {
		return boardingRecordMapper.createBoardingRecord(request);
	}
}
