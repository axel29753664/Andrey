package lv.javaguru.java2.domain;

/**
 * Created by Mike on 11/1/2016.
 */
public class MainEvent {

    private Long mainEventId,
            mainEventAddTime,
            mainEventStartTime,
            mainEventEndTime;
    private String mainEventInfo;

    public Long getMainEventId() { return mainEventId; }

    public void setMainEventId(Long mainEventId) { this.mainEventId = mainEventId; }

    public Long getMainEventAddTime() { return mainEventAddTime; }

    public void setMainEventAddTime(Long mainEventAddTime) { this.mainEventAddTime = mainEventAddTime; }

    public Long getMainEventStartTime() { return mainEventStartTime; }

    public void setMainEventStartTime(Long mainEventStartTime) { this.mainEventStartTime = mainEventStartTime; }

    public Long getMainEventEndTime() { return mainEventEndTime; }

    public void setMainEventEndTime(Long mainEventEndTime) { this.mainEventEndTime = mainEventEndTime; }

    public String getMainEventInfo() { return mainEventInfo; }

    public void setMainEventInfo(String mainEventInfo) { this.mainEventInfo = mainEventInfo; }
}
