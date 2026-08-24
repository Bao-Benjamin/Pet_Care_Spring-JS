package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

import java.time.LocalDate;

import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;

public class BoardingRecordResponse {
	private String petName;
	private String ownerName;
	private LocalDate checkin;
	private LocalDate autualDate;
	private Double totalFee;
	private BoardingStatus status;
	public BoardingRecordResponse() {
		super();
	}

	public BoardingRecordResponse(String petName, String ownerName, LocalDate checkin, LocalDate autualDate,
			double totalFee, BoardingStatus status) {
		super();
		this.petName = petName;
		this.ownerName = ownerName;
		this.checkin = checkin;
		this.autualDate = autualDate;
		this.totalFee = totalFee;
		this.status = status;
	}

	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getAutualDate() {
		return autualDate;
	}
	public void setAutualDate(LocalDate autualDate) {
		this.autualDate = autualDate;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public BoardingStatus getStatus() {
		return status;
	}
	public void setStatus(BoardingStatus status) {
		this.status = status;
	}
	
	
}
