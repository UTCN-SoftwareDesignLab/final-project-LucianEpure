package service.schedule;

import dto.ActivityDto;
import dto.RegimentDto;
import dto.ScheduleReportDto;
import dto.SupplyDto;

public interface ScheduleReportService {



    ScheduleReportDto updateStats(ScheduleReportDto scheduleReport, ActivityDto activity, String type);

}
