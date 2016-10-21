package com.orangeandbronze.enlistment;

public class Section {

	private final String sectionId;
	private final Schedule schedule;
	private final Room room;
	
	public Section(String sectionId, Schedule schedule, Room room){

		if(!sectionId.matches("[A-Za-z0-9]+")){
			throw new IllegalArgumentException("Section ID must be alphanumeric. Was: " + sectionId);
		}
		
		if(room == null){
			throw new NullPointerException("Room cannot be null. Was: " + room);
		}
		
		if(schedule == null){
			throw new NullPointerException("Schedule cannot be null. Was: " + schedule);
		}
				
		this.sectionId = sectionId;
		this.schedule = schedule;
		this.room = room;
	}

	public Schedule getSchedule() {
		return schedule;
	}
	
	public Room getRoom() {
		return room;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", schedule=" + schedule + ", room=" + room + "]";

	}

	void checkForConflictWith(Section other){
		if(this.schedule.equals(other.schedule)){
			throw new ScheduleconflictException("This section has same schedule with other section");
			
		}
	}
	
}
