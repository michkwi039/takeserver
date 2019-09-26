package pl.zawody.Utility;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter<String, Date> {
    @Override
    public Date unmarshal(String v) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        long ms = sdf.parse(v).getTime();
        Date t = new Date(ms);

        return t;
    }

    @Override
    public String marshal(Date v) throws Exception {
        return v.toString();
    }
}
