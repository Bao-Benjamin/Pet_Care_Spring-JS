package training.javaweb.exam.JavaWebExam_lhgbao.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.BoardingRecordResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.AdminSetting;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.BoardingRecord;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Owner;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Pet;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.AdminSettingRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.BoardingRecordRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.OwnerRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.PetRepository;

@Service
public class BoardingRecordService {
	@Autowired
	BoardingRecordRepository boardingRecordRepository;
	@Autowired
	AdminSettingRepository adminSettingRepository ;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	PetRepository petRepository;
	public int createBoardingRecord(BoardingRecordRequest request) {
		AdminSetting adminSetting = adminSettingRepository.getAdminSetting();
		double baseFee = adminSetting.countBaseFee(request.getCheckInDate(), request.getExpectedCheckout());
		double totalFee = baseFee;
		return boardingRecordRepository.createBoardingRecord(request.getPetId(), request.getCheckInDate(), request.getExpectedCheckout(), baseFee, totalFee, request.getNotes());
	}

	public List<BoardingRecordResponse> getAllBoardingRecord() {
		List<BoardingRecordResponse> list = new ArrayList<>();
		for (BoardingRecord boardingRecord : boardingRecordRepository.getAllBoardingRecord()) {
			list.add(toBoardingRecordResponse(boardingRecord));
		}
		return list;
	}
	
	private BoardingRecordResponse toBoardingRecordResponse(BoardingRecord boardingRecord) {
		Pet pet = petRepository.getPetById(boardingRecord.getPetId()); 
		Owner owner = ownerRepository.getOwnerById(pet.getOwnerId());
		return new BoardingRecordResponse(pet.getName(),owner.getName(),boardingRecord.getCheckInDate(),boardingRecord.getActualCheckout(),boardingRecord.getTotalFee(), boardingRecord.getStatus());
	}
	private int checkout(int id) {
		AdminSetting adminSetting = adminSettingRepository.getAdminSetting();
		BoardingRecord boardingRecord = boardingRecordRepository.getBoardingRecordById(id);
		double lateFee = adminSetting.countLateFee(boardingRecord.getExpectedCheckout(), boardingRecord.getActualCheckout());
		double totalFee = lateFee + boardingRecord.getBaseFee();
		return boardingRecordRepository.checkout(lateFee, totalFee, id);
	}
}
