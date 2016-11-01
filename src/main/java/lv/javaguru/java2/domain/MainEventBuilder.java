package lv.javaguru.java2.domain;

/**
 * Created by Mike on 11/1/2016.
 */
public class MainEventBuilder {

    private String mainEventInfo;
    private Long mainEventAddTime,
            mainEventStartTime,
            mainEventEndTime;

    private MainEventBuilder() {}

    public static MainEventBuilder createMainEvent() { return new MainEventBuilder(); }

    public MainEvent build() {
        MainEvent mainEvent = new MainEvent();
        mainEvent.setMainEventInfo(mainEventInfo);
        mainEvent.setMainEventAddTime(mainEventAddTime);
        mainEvent.setMainEventStartTime(mainEventStartTime);
        mainEvent.setMainEventEndTime(mainEventEndTime);
        return mainEvent;
    }

    public MainEventBuilder withMainEventInfo (String mainEventInfo,
                                           Long mainEventAddTime,
                                           Long mainEventStartTime,
                                           Long mainEventEndTime) {
        this.mainEventInfo = mainEventInfo;
        this.mainEventAddTime = mainEventAddTime;
        this.mainEventStartTime = mainEventStartTime;
        this.mainEventEndTime = mainEventEndTime;
        return this;
    }




}
