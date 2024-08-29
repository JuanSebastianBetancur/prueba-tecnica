package hotel.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Reservation {
    public static final Target FIELD_LOCATION = Target.the("field checkin").located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_LocationComboBox_I"));
    public static final Target FIELD_CHECK_IN = Target.the("field checkin").located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_CheckInDateEdit_I"));
    public static final Target FIELD_CHECK_OUT = Target.the("field checkout").located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_CheckOutDateEdit_I"));
    public static final Target FIELD_ROOMS = Target.the("field rooms").located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_RoomsComboBox_I"));
    public static final Target FIELD_ADULTS = Target.the("field adults").located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_AdultsSpinEdit_I"));
    public static final Target FIELD_CHILDRENS = Target.the("field childrens").located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_ChildrenSpinEdit_I"));
    public static final Target BUTTON_SEARCH_RESERVATION = Target.the("button search reservation").located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_SearchButton"));
    public static final Target CHECK_STAR_1 = Target.the("uncheck star 1").located(By.id("MainContentPlaceHolder_FilterFormLayout_OurRatingCheckBoxList_RB0"));
    public static final Target CHECK_STAR_2 = Target.the("uncheck star 2").located(By.id("MainContentPlaceHolder_FilterFormLayout_OurRatingCheckBoxList_RB1"));
    public static final Target BUTTON_APPLY_FILTERS = Target.the("button apply filters").located(By.id("MainContentPlaceHolder_FilterFormLayout_ApplyFilterButton"));
    public static final Target FIELD_RESERVATION_CONFIRMS = Target.the("field reservation confirms").located(By.xpath("//*[@id=\"form1\"]/div[3]/div[2]/div[4]/div[2]/h3"));
}
