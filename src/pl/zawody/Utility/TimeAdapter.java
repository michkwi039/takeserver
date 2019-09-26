package pl.zawody.Utility;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class TimeAdapter extends XmlAdapter<String, Time> {
    @Override
    public Time unmarshal(String v) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        long ms = sdf.parse(v).getTime();
        Time t = new Time(ms);

        return t;
    }

    @Override
    public String marshal(Time v) throws Exception {
        return v.toString();
    }
}
